/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandora.asistencia.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import pandora.asistencia.dao.EmpleadoDao;
import pandora.asistencia.entity.Empleado;

/**
 *
 * @author Ricardo
 */

@ManagedBean
@RequestScoped
public class EmpleadoConverter implements Converter{

    /**
     * Creates a new instance of EmpleadoConverter
     */
    
    private EmpleadoDao dao;
    
    public EmpleadoConverter() {
        dao = new EmpleadoDao(Empleado.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            Integer id = Integer.valueOf(value);
            return dao.find(id);
        } catch (NumberFormatException e) {
            throw new ConverterException("The value is not a valid Employee ID: " + value, e);
        }
    }

    @Override    
    public String getAsString(FacesContext context, UIComponent component, Object value) {        
        if (value == null) {
            return "";
        }

        if (value instanceof Empleado) {
            Integer id = ((Empleado) value).getNroDocumento();
            return (id != null) ? String.valueOf(id) : null;
        } else {
            throw new ConverterException("The value is not a valid Employee instance: " + value);
        }
    }
    
}
