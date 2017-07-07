/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandora.asistencia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import pandora.asistencia.dao.ParametroDao;
import pandora.asistencia.entity.Parametro;
import pandora.asistencia.entity.Masterparametro;

/**
 *
 * @author Ricardo
 */

public class ParametroMb implements Serializable{
    
    private String dato;
    private Masterparametro tipoDato;
    private Parametro parametro;
    private ParametroDao dao;
    private List<Parametro> listaParametros;

    public ParametroMb() {
        tipoDato = new Masterparametro();
        listaParametros = new ArrayList();
        dao = new ParametroDao(Parametro.class);
    }   

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Masterparametro getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(Masterparametro tipoDato) {
        this.tipoDato = tipoDato;
    }

    public Parametro getParametro() {
        return parametro;
    }

    public void setParametro(Parametro parametro) {
        this.parametro = parametro;
    }

    public List<Parametro> getListaParametros() {
        return listaParametros;
    }

    public void setListaParametros(List<Parametro> listaParametros) {
        this.listaParametros = listaParametros;
    }
    
}