/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandora.asistencia.controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pandora.asistencia.dao.ControlDao;
import pandora.asistencia.entity.Control;
import pandora.asistencia.entity.Parametro;
import pandora.asistencia.util.Constantes;

/**
 *
 * @author Ricardo
 */

@ManagedBean
@RequestScoped
public class ControlMb implements Serializable {

    private int idHorario;
    private String empresa;
    private String proyecto;
    private Integer horas;
    private Integer actividad;
    private String detalle;
    private Control control;
    private ControlDao dao;
    private List<Parametro> listaActividad;
    private List<Parametro> listaProblema;
    private List<Control> listaControles;    

    public ControlMb() {
        control = new Control();
        listaControles = new ArrayList();
        dao = new ControlDao(Control.class);
    }

    public void grabar() throws SQLException {
        dao.persistControl(control, nroDocumentoC);
        clear();
    }

    public void eliminar() {
        dao.remove(control);
    }

    public void actualizar() {
        dao.edit(control);
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public Control getControl() {
        return control;
    }

    public void setControl(Control control) {
        this.control = control;
    }

    public List<Control> getListaControles() {
        return listaControles;
    }

    public void setListaControles(List<Control> listaControles) {
        this.listaControles = listaControles;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public Integer getActividad() {
        return actividad;
    }

    public void setActividad(Integer actividad) {
        this.actividad = actividad;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public List<Parametro> getListaActividad() throws SQLException {
        listaActividad = new ArrayList();
        listaActividad = dao.getListaDatoJDBC(Constantes.ACTIVIDAD);
        return listaActividad;
    }

    public void setListaActividad(List<Parametro> listaActividad) {
        this.listaActividad = listaActividad;
    }

    public List<Parametro> getListaProblema() throws SQLException {
        listaProblema = new ArrayList();
        listaProblema = dao.getListaDatoJDBC(Constantes.PROBLEMA);
        return listaProblema;
    }

    public void setListaProblema(List<Parametro> listaProblema) {
        this.listaProblema = listaProblema;
    }       

    @ManagedProperty(value="#{empleadoMb.nroDocumento}")
    private Integer nroDocumentoC;
    
    public void setNroDocumentoC(Integer nroDocumentoC) {
        this.nroDocumentoC = nroDocumentoC;
    }    

    public Integer getNroDocumentoC() {
        return nroDocumentoC;
    }
    
    public void clear(){
        setEmpresa(null);
        setProyecto(null);
        setHoras(null);
        setActividad(0);
        setDetalle(null);
    }
    
}