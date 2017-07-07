/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandora.asistencia.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "masterparametro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Masterparametro.findAll", query = "SELECT m FROM Masterparametro m")
    , @NamedQuery(name = "Masterparametro.findByIdMasterParametro", query = "SELECT m FROM Masterparametro m WHERE m.idMasterParametro = :idMasterParametro")
    , @NamedQuery(name = "Masterparametro.findByDescripcion", query = "SELECT m FROM Masterparametro m WHERE m.descripcion = :descripcion")})
public class Masterparametro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMasterParametro")
    private Integer idMasterParametro;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMasterParametro")
    private List<Parametro> parametroList;

    public Masterparametro() {
    }

    public Masterparametro(Integer idMasterParametro) {
        this.idMasterParametro = idMasterParametro;
    }

    public Masterparametro(Integer idMasterParametro, String descripcion) {
        this.idMasterParametro = idMasterParametro;
        this.descripcion = descripcion;
    }

    public Integer getIdMasterParametro() {
        return idMasterParametro;
    }

    public void setIdMasterParametro(Integer idMasterParametro) {
        this.idMasterParametro = idMasterParametro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Parametro> getParametroList() {
        return parametroList;
    }

    public void setParametroList(List<Parametro> parametroList) {
        this.parametroList = parametroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMasterParametro != null ? idMasterParametro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Masterparametro)) {
            return false;
        }
        Masterparametro other = (Masterparametro) object;
        if ((this.idMasterParametro == null && other.idMasterParametro != null) || (this.idMasterParametro != null && !this.idMasterParametro.equals(other.idMasterParametro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pandora.asistencia.entity.Masterparametro[ idMasterParametro=" + idMasterParametro + " ]";
    }
    
}
