/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandora.asistencia.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "tipodato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodato.findAll", query = "SELECT t FROM Tipodato t")
    , @NamedQuery(name = "Tipodato.findByIdTipoDato", query = "SELECT t FROM Tipodato t WHERE t.idTipoDato = :idTipoDato")
    , @NamedQuery(name = "Tipodato.findByDescripcion", query = "SELECT t FROM Tipodato t WHERE t.descripcion = :descripcion")})
public class Tipodato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoDato")
    private Integer idTipoDato;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;

    public Tipodato() {
    }

    public Tipodato(Integer idTipoDato) {
        this.idTipoDato = idTipoDato;
    }

    public Tipodato(Integer idTipoDato, String descripcion) {
        this.idTipoDato = idTipoDato;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoDato() {
        return idTipoDato;
    }

    public void setIdTipoDato(Integer idTipoDato) {
        this.idTipoDato = idTipoDato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDato != null ? idTipoDato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipodato)) {
            return false;
        }
        Tipodato other = (Tipodato) object;
        if ((this.idTipoDato == null && other.idTipoDato != null) || (this.idTipoDato != null && !this.idTipoDato.equals(other.idTipoDato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pandora.asistencia.entity.Tipodato[ idTipoDato=" + idTipoDato + " ]";
    }
    
}
