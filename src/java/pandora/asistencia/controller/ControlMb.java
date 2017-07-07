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
import javax.faces.bean.RequestScoped;
import pandora.asistencia.dao.ControlDao;
import pandora.asistencia.entity.Control;
import pandora.asistencia.entity.Parametro;

/**
 *
 * @author Ricardo
 */


@ManagedBean
@RequestScoped
public class ControlMb implements Serializable{
    
    private int idHorario;
    private String empresa;
    private String proyecto;
    private int horas;
    private int actividad;
    private String detalle;
    private Control control;
    private ControlDao dao;    
    private List<Parametro> listaActividad;
    private List<Parametro> listaProblema;
    private List<Control> listaControles;
    
    private static final String DATO3 = "actividad";
    private static final String DATO4 = "problema";

    public ControlMb() {
        control = new Control();
        listaControles = new ArrayList();
        dao = new ControlDao(Control.class);
    }
    
    public void grabar() {
        dao.create(control);
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

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getActividad() {
        return actividad;
    }

    public void setActividad(int actividad) {
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
        listaActividad = dao.getListaDatoJDBC(DATO3);
        return listaActividad;
    }

    public void setListaActividad(List<Parametro> listaActividad) {
        this.listaActividad = listaActividad;
    }

    public List<Parametro> getListaProblema() throws SQLException {
        listaProblema = new ArrayList();
        listaProblema = dao.getListaDatoJDBC(DATO4);
        return listaProblema;
    }

    public void setListaProblema(List<Parametro> listaProblema) {
        this.listaProblema = listaProblema;
    }
    
}