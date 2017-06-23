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
import pandora.asistencia.dao.TipodatoDao;
import pandora.asistencia.entity.Tipodato;

/**
 *
 * @author Ricardo
 */

@ManagedBean
@RequestScoped
public class TipodatoMb implements Serializable{
    
    private String descripcion;
    private Tipodato tipoDato;
    private TipodatoDao dao;
    private List<Tipodato> listaTipodatos;

    public TipodatoMb() {
        tipoDato = new Tipodato();
        listaTipodatos = new ArrayList();
        dao = new TipodatoDao(Tipodato.class);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tipodato getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(Tipodato tipoDato) {
        this.tipoDato = tipoDato;
    }

    public List<Tipodato> getListaTipodatos() {
        return listaTipodatos;
    }

    public void setListaTipodatos(List<Tipodato> listaTipodatos) {
        this.listaTipodatos = listaTipodatos;
    }    
    
}