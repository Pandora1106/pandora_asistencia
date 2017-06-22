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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByNroDocumento", query = "SELECT e FROM Empleado e WHERE e.nroDocumento = :nroDocumento")
    , @NamedQuery(name = "Empleado.findByNombres", query = "SELECT e FROM Empleado e WHERE e.nombres = :nombres")
    , @NamedQuery(name = "Empleado.findByApePaterno", query = "SELECT e FROM Empleado e WHERE e.apePaterno = :apePaterno")
    , @NamedQuery(name = "Empleado.findByApeMaterno", query = "SELECT e FROM Empleado e WHERE e.apeMaterno = :apeMaterno")
    , @NamedQuery(name = "Empleado.findByPassword", query = "SELECT e FROM Empleado e WHERE e.password = :password")
    , @NamedQuery(name = "Empleado.findByEstado", query = "SELECT e FROM Empleado e WHERE e.estado = :estado")
    , @NamedQuery(name = "Empleado.findByFecIniContrato", query = "SELECT e FROM Empleado e WHERE e.fecIniContrato = :fecIniContrato")
    , @NamedQuery(name = "Empleado.findByFecFinContrato", query = "SELECT e FROM Empleado e WHERE e.fecFinContrato = :fecFinContrato")
    , @NamedQuery(name = "Empleado.findBySalario", query = "SELECT e FROM Empleado e WHERE e.salario = :salario")
    , @NamedQuery(name = "Empleado.findByMoneda", query = "SELECT e FROM Empleado e WHERE e.moneda = :moneda")
    , @NamedQuery(name = "Empleado.findByNroTelefonico", query = "SELECT e FROM Empleado e WHERE e.nroTelefonico = :nroTelefonico")
    , @NamedQuery(name = "Empleado.findByCelular", query = "SELECT e FROM Empleado e WHERE e.celular = :celular")
    , @NamedQuery(name = "Empleado.findByDireccion", query = "SELECT e FROM Empleado e WHERE e.direccion = :direccion")
    , @NamedQuery(name = "Empleado.findByCargo", query = "SELECT e FROM Empleado e WHERE e.cargo = :cargo")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nroDocumento")
    private Integer nroDocumento;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apePaterno")
    private String apePaterno;
    @Basic(optional = false)
    @Column(name = "apeMaterno")
    private String apeMaterno;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @Column(name = "fecIniContrato")
    private String fecIniContrato;
    @Column(name = "fecFinContrato")
    private String fecFinContrato;
    @Column(name = "salario")
    private String salario;
    @Column(name = "moneda")
    private String moneda;
    @Column(name = "nroTelefonico")
    private String nroTelefonico;
    @Column(name = "celular")
    private String celular;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "cargo")
    private String cargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nroDocumento")
    private List<Asistencia> asistenciaList;
    @JoinColumn(name = "idTipoDato", referencedColumnName = "idTipoDato")
    @ManyToOne(optional = false)
    private Tipodato idTipoDato;

    public Empleado() {
    }

    public Empleado(Integer nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public Empleado(Integer nroDocumento, String nombres, String apePaterno, String apeMaterno, String password, boolean estado, String fecIniContrato) {
        this.nroDocumento = nroDocumento;
        this.nombres = nombres;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.password = password;
        this.estado = estado;
        this.fecIniContrato = fecIniContrato;
    }

    public Integer getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(Integer nroDocumento) {
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

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getFecIniContrato() {
        return fecIniContrato;
    }

    public void setFecIniContrato(String fecIniContrato) {
        this.fecIniContrato = fecIniContrato;
    }

    public String getFecFinContrato() {
        return fecFinContrato;
    }

    public void setFecFinContrato(String fecFinContrato) {
        this.fecFinContrato = fecFinContrato;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
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

    @XmlTransient
    public List<Asistencia> getAsistenciaList() {
        return asistenciaList;
    }

    public void setAsistenciaList(List<Asistencia> asistenciaList) {
        this.asistenciaList = asistenciaList;
    }

    public Tipodato getIdTipoDato() {
        return idTipoDato;
    }

    public void setIdTipoDato(Tipodato idTipoDato) {
        this.idTipoDato = idTipoDato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroDocumento != null ? nroDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.nroDocumento == null && other.nroDocumento != null) || (this.nroDocumento != null && !this.nroDocumento.equals(other.nroDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pandora.asistencia.entity.Empleado[ nroDocumento=" + nroDocumento + " ]";
    }
    
}
