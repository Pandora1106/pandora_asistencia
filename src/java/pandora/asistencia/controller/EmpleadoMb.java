/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandora.asistencia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.event.ActionEvent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import pandora.asistencia.dao.EmpleadoDao;
import pandora.asistencia.entity.Empleado;

/**
 *
 * @author Ricardo
 */
@ManagedBean
@RequestScoped
public class EmpleadoMb implements Serializable {

    private int nroDocumento;
    private String nombres;
    private String apePaterno;
    private String apeMaterno;
    private String password;
    private boolean estado;
    private int tipoDocumento;
    private Date fecIniContrato;
    private Date fecFinContrato;
    private double salario;
    private String moneda;
    private String nroTelefonico;
    private String celular;
    private String direccion;
    private String cargo;
    private Empleado empleado;
    private EmpleadoDao dao;
    private List<Empleado> listaEmpleados;
    
    private boolean visible = false;
    private int busqueda;

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
            nombres = emp.getNombres();
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

    public void getList(ActionEvent event) {
        setVisible(true);
        listaEmpleados = new ArrayList<>();
        listaEmpleados = dao.findAll();
    }

    public int getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(int nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFecIniContrato() {
        return fecIniContrato;
    }

    public void setFecIniContrato(Date fecIniContrato) {
        this.fecIniContrato = fecIniContrato;
    }

    public Date getFecFinContrato() {
        return fecFinContrato;
    }

    public void setFecFinContrato(Date fecFinContrato) {
        this.fecFinContrato = fecFinContrato;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getNroTelefonico() {
        return nroTelefonico;
    }

    public void setNroTelefonico(String nroTelefonico) {
        this.nroTelefonico = nroTelefonico;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Empleado> getListaEmpleados() {
        setVisible(true);
        switch(busqueda){
            case 1:
                listaEmpleados = new ArrayList();
                listaEmpleados = dao.findByNroDocumento(nroDocumento);
        }        
        listaEmpleados = dao.findAll();
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(int busqueda) {
        this.busqueda = busqueda;
    }

}