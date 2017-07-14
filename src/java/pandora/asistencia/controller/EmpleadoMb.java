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
//import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import pandora.asistencia.dao.EmpleadoDao;
import pandora.asistencia.entity.Empleado;
import pandora.asistencia.entity.Parametro;
import pandora.asistencia.util.Constantes;

/**
 *
 * @author Ricardo
 */

@ManagedBean
@SessionScoped
public class EmpleadoMb implements Serializable {

    private Integer nroDocumento;
    private String password;
    private String buscarByNombre;
    private boolean visible = false;//useless by now
    private String nombreCompleto;
    private int radioValue;
    private int cbValue;
    private List<Parametro> listaTipoDoc;
    private List<Parametro> listaEstado;
    private Integer buscarByNro;
    private Empleado empleado;
    private EmpleadoDao dao;
    private List<Empleado> listaEmpleados;

    public EmpleadoMb() {
        empleado = new Empleado();
        listaEmpleados = new ArrayList();
        dao = new EmpleadoDao(Empleado.class);
    }

    public void grabar() {
        dao.create(empleado);
    }

    public void eliminar() {
        dao.remove(empleado);
    }

    public void actualizar() {
        dao.edit(empleado);
    }

    public String validar() {
        Empleado emp = dao.validar(nroDocumento, password);
        if (emp != null) {
            nombreCompleto = emp.getNombres() + " " + emp.getApePaterno() + " " + emp.getApeMaterno();
            nroDocumento = emp.getNroDocumento();
            return "principal";
        } else {
            return "index";
        }
    }

    public String doSalir() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        req.getSession(true).invalidate();
        return "index";
    }   

    public Integer getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(Integer nroDocumento) {
        this.nroDocumento = nroDocumento;
    }   

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Empleado> getListaEmpleados() throws SQLException {     
        setVisible(true);        
        return listaEmpleados;
    }
    
    //testing by now
    public void radioValueChanged() throws SQLException {        
        listaEmpleados = new ArrayList();
        listaEmpleados = dao.searchEmployee(empleado);
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public List<Parametro> getListaTipoDoc() throws SQLException {
        listaTipoDoc = new ArrayList();
        listaTipoDoc = dao.getListaDatoJDBC(Constantes.TIPODOC);
        return listaTipoDoc;
    }

    public void setListaTipoDoc(List<Parametro> listaTipoDoc) {
        this.listaTipoDoc = listaTipoDoc;
    }

    public List<Parametro> getListaEstado() throws SQLException {
        listaEstado = new ArrayList();
        listaEstado = dao.getListaDatoJDBC(Constantes.ESTADO);
        return listaEstado;
    }

    public void setListaEstado(List<Parametro> listaEstado) {
        this.listaEstado = listaEstado;
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Empleado Selecionado", ((Empleado) event.getObject()).getNombres());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Empleado Deselecionado", ((Empleado) event.getObject()).getNombres());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public int getRadioValue() {
        return radioValue;
    }

    public void setRadioValue(int radioValue) {
        this.radioValue = radioValue;
    }

    public String goToEmployee(int nroDocumento) {
        return "datosEmpleado?faces-redirect=true&pageId=" + nroDocumento;
    }

    public Integer getBuscarByNro() {
        return buscarByNro;
    }

    public void setBuscarByNro(Integer buscarByNro) {
        System.out.println(buscarByNro);
        this.buscarByNro = buscarByNro;
    }
    
    public void clearValues(){
        setBuscarByNro(null);
    }

    public String getBuscarByNombre() {
        return buscarByNombre;
    }

    public void setBuscarByNombre(String buscarByNombre) {
        this.buscarByNombre = buscarByNombre;
    }

    public int getCbValue() {
        return cbValue;
    }

    public void setCbValue(int cbValue) {
        this.cbValue = cbValue;
    }
    
}