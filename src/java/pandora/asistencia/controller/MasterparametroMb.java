/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandora.asistencia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import pandora.asistencia.dao.MasterparametroDao;
import pandora.asistencia.entity.Masterparametro;

/**
 *
 * @author Ricardo
 */

@ManagedBean
@RequestScoped
public class MasterparametroMb implements Serializable{
    
    private String descripcion;
    private Masterparametro tipoDato;
    private MasterparametroDao dao;
    private List<Masterparametro> listaTipodatos;

    public MasterparametroMb() {
        tipoDato = new Masterparametro();
        listaTipodatos = new ArrayList();
        dao = new MasterparametroDao(Masterparametro.class);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Masterparametro getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(Masterparametro tipoDato) {
        this.tipoDato = tipoDato;
    }

    public List<Masterparametro> getListaTipodatos() {
        return listaTipodatos;
    }

    public void setListaTipodatos(List<Masterparametro> listaTipodatos) {
        this.listaTipodatos = listaTipodatos;
    }    
    
}