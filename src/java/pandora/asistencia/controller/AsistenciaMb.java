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
import pandora.asistencia.dao.AsistenciaDao;
import pandora.asistencia.entity.Asistencia;

/**
 *
 * @author Ricardo
 */

@ManagedBean
@RequestScoped
public class AsistenciaMb implements Serializable {

    private int idUsuario;
    private Asistencia asistencia;
    private AsistenciaDao dao;
    private List<Asistencia> listaAsistencia;

    public AsistenciaMb() {
        asistencia = new Asistencia();
        listaAsistencia = new ArrayList();
        dao = new AsistenciaDao(Asistencia.class);
    }

    public void grabar() {
        dao.persistAsistencia(asistencia, idUsuario);
    }

    public void eliminar() {
        dao.remove(asistencia);
    }

    public void actualizar() throws SQLException {
        AsistenciaDao.updateJDBC(idUsuario);
    }
    
    public String validarIngreso(int idUsuario) {
        Asistencia asistencia = dao.validarIngreso(idUsuario);
        System.out.println(asistencia);
        if (asistencia != null) {
            return "ingresoRegistrado?faces-redirect=true";
        } else {
            return "marcarIngreso?faces-redirect=true";
        }
    }
    
    public String validarSalida(int idUsuario) {
        Asistencia asistencia = dao.validarIngreso(idUsuario);
        System.out.println(asistencia);
        if (asistencia != null) {
            return "salidaRegistrado?faces-redirect=true";
        } else {
            return "marcarSalida?faces-redirect=true";
        }
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Asistencia getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Asistencia asistencia) {
        this.asistencia = asistencia;
    }

    public List<Asistencia> getListaAsistencia() {
        return listaAsistencia;
    }

    public void setListaAsistencia(List<Asistencia> listaAsistencia) {
        this.listaAsistencia = listaAsistencia;
    }

}
