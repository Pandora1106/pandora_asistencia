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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "control")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Control.findAll", query = "SELECT c FROM Control c")
    , @NamedQuery(name = "Control.findByIdControl", query = "SELECT c FROM Control c WHERE c.idControl = :idControl")
    , @NamedQuery(name = "Control.findByEmpresa", query = "SELECT c FROM Control c WHERE c.empresa = :empresa")
    , @NamedQuery(name = "Control.findByProyecto", query = "SELECT c FROM Control c WHERE c.proyecto = :proyecto")
    , @NamedQuery(name = "Control.findByHoras", query = "SELECT c FROM Control c WHERE c.horas = :horas")
    , @NamedQuery(name = "Control.findByControl", query = "SELECT c FROM Control c WHERE c.control = :control")
    , @NamedQuery(name = "Control.findByDetalle", query = "SELECT c FROM Control c WHERE c.detalle = :detalle")})
public class Control implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idControl")
    private Integer idControl;
    @Basic(optional = false)
    @Column(name = "empresa")
    private String empresa;
    @Basic(optional = false)
    @Column(name = "proyecto")
    private String proyecto;
    @Basic(optional = false)
    @Column(name = "horas")
    private Integer horas;
    @Basic(optional = false)
    @Column(name = "control")
    private int control;
    @Basic(optional = false)
    @Column(name = "detalle")
    private String detalle;
    @JoinColumn(name = "idHorario", referencedColumnName = "idHorario")
    @ManyToOne(optional = false)
    private Horario idHorario;

    public Control() {
    }

    public Control(Integer idControl) {
        this.idControl = idControl;
    }

    public Control(Integer idControl, String empresa, String proyecto, Integer horas, int control, String detalle) {
        this.idControl = idControl;
        this.empresa = empresa;
        this.proyecto = proyecto;
        this.horas = horas;
        this.control = control;
        this.detalle = detalle;
    }

    public Integer getIdControl() {
        return idControl;
    }

    public void setIdControl(Integer idControl) {
        this.idControl = idControl;
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

    public int getControl() {
        return control;
    }

    public void setControl(int control) {
        this.control = control;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Horario getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Horario idHorario) {
        this.idHorario = idHorario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idControl != null ? idControl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Control)) {
            return false;
        }
        Control other = (Control) object;
        if ((this.idControl == null && other.idControl != null) || (this.idControl != null && !this.idControl.equals(other.idControl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pandora.asistencia.entity.Control[ idControl=" + idControl + " ]";
    }
    
}
