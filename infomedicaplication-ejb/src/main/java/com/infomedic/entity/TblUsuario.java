/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LAP
 */
@Entity
@Table(name = "TBL_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblUsuario.findAll", query = "SELECT t FROM TblUsuario t"),
    @NamedQuery(name = "TblUsuario.findByIdusuario", query = "SELECT t FROM TblUsuario t WHERE t.idusuario = :idusuario"),
    @NamedQuery(name = "TblUsuario.findByNombreusuario", query = "SELECT t FROM TblUsuario t WHERE t.nombreusuario = :nombreusuario"),
    @NamedQuery(name = "TblUsuario.findByContrausuario", query = "SELECT t FROM TblUsuario t WHERE t.contrausuario = :contrausuario"),
    @NamedQuery(name = "TblUsuario.findByNombrecompletousuario", query = "SELECT t FROM TblUsuario t WHERE t.nombrecompletousuario = :nombrecompletousuario"),
    @NamedQuery(name = "TblUsuario.findByCorreousuario", query = "SELECT t FROM TblUsuario t WHERE t.correousuario = :correousuario"),
    @NamedQuery(name = "TblUsuario.findByCelularusuario", query = "SELECT t FROM TblUsuario t WHERE t.celularusuario = :celularusuario"),
    @NamedQuery(name = "TblUsuario.findByFechacreacion", query = "SELECT t FROM TblUsuario t WHERE t.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "TblUsuario.findByEstadousuario", query = "SELECT t FROM TblUsuario t WHERE t.estadousuario = :estadousuario"),
    @NamedQuery(name = "TblUsuario.findByFechafinusuario", query = "SELECT t FROM TblUsuario t WHERE t.fechafinusuario = :fechafinusuario")})
public class TblUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDUSUARIO")
    private BigDecimal idusuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBREUSUARIO")
    private String nombreusuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "CONTRAUSUARIO")
    private String contrausuario;
    @Size(max = 100)
    @Column(name = "NOMBRECOMPLETOUSUARIO")
    private String nombrecompletousuario;
    @Size(max = 100)
    @Column(name = "CORREOUSUARIO")
    private String correousuario;
    @Size(max = 15)
    @Column(name = "CELULARUSUARIO")
    private String celularusuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHACREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADOUSUARIO")
    private Character estadousuario;
    @Column(name = "FECHAFINUSUARIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafinusuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private List<TblPaciente> tblPacienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private List<TblRolusuario> tblRolusuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private List<TblEmpleado> tblEmpleadoList;

    public TblUsuario() {
    }

    public TblUsuario(BigDecimal idusuario) {
        this.idusuario = idusuario;
    }

    public TblUsuario(BigDecimal idusuario, String nombreusuario, String contrausuario, Date fechacreacion, Character estadousuario) {
        this.idusuario = idusuario;
        this.nombreusuario = nombreusuario;
        this.contrausuario = contrausuario;
        this.fechacreacion = fechacreacion;
        this.estadousuario = estadousuario;
    }

    public BigDecimal getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(BigDecimal idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getContrausuario() {
        return contrausuario;
    }

    public void setContrausuario(String contrausuario) {
        this.contrausuario = contrausuario;
    }

    public String getNombrecompletousuario() {
        return nombrecompletousuario;
    }

    public void setNombrecompletousuario(String nombrecompletousuario) {
        this.nombrecompletousuario = nombrecompletousuario;
    }

    public String getCorreousuario() {
        return correousuario;
    }

    public void setCorreousuario(String correousuario) {
        this.correousuario = correousuario;
    }

    public String getCelularusuario() {
        return celularusuario;
    }

    public void setCelularusuario(String celularusuario) {
        this.celularusuario = celularusuario;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Character getEstadousuario() {
        return estadousuario;
    }

    public void setEstadousuario(Character estadousuario) {
        this.estadousuario = estadousuario;
    }

    public Date getFechafinusuario() {
        return fechafinusuario;
    }

    public void setFechafinusuario(Date fechafinusuario) {
        this.fechafinusuario = fechafinusuario;
    }

    @XmlTransient
    public List<TblPaciente> getTblPacienteList() {
        return tblPacienteList;
    }

    public void setTblPacienteList(List<TblPaciente> tblPacienteList) {
        this.tblPacienteList = tblPacienteList;
    }

    @XmlTransient
    public List<TblRolusuario> getTblRolusuarioList() {
        return tblRolusuarioList;
    }

    public void setTblRolusuarioList(List<TblRolusuario> tblRolusuarioList) {
        this.tblRolusuarioList = tblRolusuarioList;
    }

    @XmlTransient
    public List<TblEmpleado> getTblEmpleadoList() {
        return tblEmpleadoList;
    }

    public void setTblEmpleadoList(List<TblEmpleado> tblEmpleadoList) {
        this.tblEmpleadoList = tblEmpleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblUsuario)) {
            return false;
        }
        TblUsuario other = (TblUsuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infomedic.entity.TblUsuario[ idusuario=" + idusuario + " ]";
    }
    
}
