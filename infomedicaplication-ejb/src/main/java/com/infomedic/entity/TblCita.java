/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LAP
 */
@Entity
@Table(name = "TBL_CITA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCita.findAll", query = "SELECT t FROM TblCita t"),
    @NamedQuery(name = "TblCita.findByIdcita", query = "SELECT t FROM TblCita t WHERE t.idcita = :idcita"),
    @NamedQuery(name = "TblCita.findByFechacita", query = "SELECT t FROM TblCita t WHERE t.fechacita = :fechacita"),
    @NamedQuery(name = "TblCita.findByAsuntocita", query = "SELECT t FROM TblCita t WHERE t.asuntocita = :asuntocita"),
    @NamedQuery(name = "TblCita.findByHoracita", query = "SELECT t FROM TblCita t WHERE t.horacita = :horacita"),
    @NamedQuery(name = "TblCita.findByMotivocancelacion", query = "SELECT t FROM TblCita t WHERE t.motivocancelacion = :motivocancelacion"),
    @NamedQuery(name = "TblCita.findByEstadocita", query = "SELECT t FROM TblCita t WHERE t.estadocita = :estadocita")})
public class TblCita implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCITA")
    private BigDecimal idcita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHACITA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacita;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ASUNTOCITA")
    private String asuntocita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORACITA")
    private BigInteger horacita;
    @Size(max = 255)
    @Column(name = "MOTIVOCANCELACION")
    private String motivocancelacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADOCITA")
    private Character estadocita;
    @JoinColumn(name = "IDPACIENTE", referencedColumnName = "IDPACIENTE")
    @ManyToOne(optional = false)
    private TblPaciente idpaciente;
    @JoinColumn(name = "IDEMPLEADO", referencedColumnName = "IDEMPLEADO")
    @ManyToOne(optional = false)
    private TblEmpleado idempleado;
    @JoinColumn(name = "IDCONSULTORIO", referencedColumnName = "IDCONSULTORIO")
    @ManyToOne(optional = false)
    private TblConsultorio idconsultorio;

    public TblCita() {
    }

    public TblCita(BigDecimal idcita) {
        this.idcita = idcita;
    }

    public TblCita(BigDecimal idcita, Date fechacita, String asuntocita, BigInteger horacita, Character estadocita) {
        this.idcita = idcita;
        this.fechacita = fechacita;
        this.asuntocita = asuntocita;
        this.horacita = horacita;
        this.estadocita = estadocita;
    }

    public BigDecimal getIdcita() {
        return idcita;
    }

    public void setIdcita(BigDecimal idcita) {
        this.idcita = idcita;
    }

    public Date getFechacita() {
        return fechacita;
    }

    public void setFechacita(Date fechacita) {
        this.fechacita = fechacita;
    }

    public String getAsuntocita() {
        return asuntocita;
    }

    public void setAsuntocita(String asuntocita) {
        this.asuntocita = asuntocita;
    }

    public BigInteger getHoracita() {
        return horacita;
    }

    public void setHoracita(BigInteger horacita) {
        this.horacita = horacita;
    }

    public String getMotivocancelacion() {
        return motivocancelacion;
    }

    public void setMotivocancelacion(String motivocancelacion) {
        this.motivocancelacion = motivocancelacion;
    }

    public Character getEstadocita() {
        return estadocita;
    }

    public void setEstadocita(Character estadocita) {
        this.estadocita = estadocita;
    }

    public TblPaciente getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(TblPaciente idpaciente) {
        this.idpaciente = idpaciente;
    }

    public TblEmpleado getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(TblEmpleado idempleado) {
        this.idempleado = idempleado;
    }

    public TblConsultorio getIdconsultorio() {
        return idconsultorio;
    }

    public void setIdconsultorio(TblConsultorio idconsultorio) {
        this.idconsultorio = idconsultorio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcita != null ? idcita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCita)) {
            return false;
        }
        TblCita other = (TblCita) object;
        if ((this.idcita == null && other.idcita != null) || (this.idcita != null && !this.idcita.equals(other.idcita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infomedic.entity.TblCita[ idcita=" + idcita + " ]";
    }
    
}
