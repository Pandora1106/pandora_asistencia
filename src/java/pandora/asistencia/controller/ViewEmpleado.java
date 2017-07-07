/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandora.asistencia.controller;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import pandora.asistencia.dao.EmpleadoDao;
import pandora.asistencia.entity.Empleado;

/**
 *
 * @author Ricardo
 */

@ManagedBean
@ViewScoped
public class ViewEmpleado implements Serializable{

    /**
     * Creates a new instance of ViewEmpleado
     */
    
    private Empleado empleado;
    
    @EJB
    private EmpleadoDao dao;
    
    public ViewEmpleado() {
        dao = new EmpleadoDao(Empleado.class);
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
}