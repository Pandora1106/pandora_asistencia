/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandora.asistencia.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ricardo
 */

@Entity
@Table(name = "asistencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asistencia.findAll", query = "SELECT a FROM Asistencia a")
    , @NamedQuery(name = "Asistencia.findByIdAsistencia", query = "SELECT a FROM Asistencia a WHERE a.idAsistencia = :idAsistencia")
    , @NamedQuery(name = "Asistencia.findByHoraIngreso", query = "SELECT a FROM Asistencia a WHERE a.horaIngreso = :horaIngreso")
    , @NamedQuery(name = "Asistencia.findByHoraSalida", query = "SELECT a FROM Asistencia a WHERE a.horaSalida = :horaSalida")})
public class Asistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAsistencia")
    private Integer idAsistencia;
    @Basic(optional = false)
    @Column(name = "horaIngreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaIngreso;
    @Column(name = "horaSalida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaSalida;
    @JoinColumn(name = "nroDocumento", referencedColumnName = "nroDocumento")
    @ManyToOne(optional = false)
    private Empleado nroDocumento;

    public Asistencia() {
    }

    public Asistencia(Integer idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public Asistencia(Integer idAsistencia, Date horaIngreso) {
        this.idAsistencia = idAsistencia;
        this.horaIngreso = horaIngreso;
    }

    public Integer getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(Integer idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public Date getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(Date horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Empleado getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(Empleado nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsistencia != null ? idAsistencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asistencia)) {
            return false;
        }
        Asistencia other = (Asistencia) object;
        if ((this.idAsistencia == null && other.idAsistencia != null) || (this.idAsistencia != null && !this.idAsistencia.equals(other.idAsistencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pandora.asistencia.entity.Asistencia[ idAsistencia=" + idAsistencia + " ]";
    }
    
}
