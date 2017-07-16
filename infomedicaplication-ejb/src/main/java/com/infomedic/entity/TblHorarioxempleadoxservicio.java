/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LAP
 */
@Entity
@Table(name = "TBL_HORARIOXEMPLEADOXSERVICIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblHorarioxempleadoxservicio.findAll", query = "SELECT t FROM TblHorarioxempleadoxservicio t"),
    @NamedQuery(name = "TblHorarioxempleadoxservicio.findByIdhorarioxempleadoxservicio", query = "SELECT t FROM TblHorarioxempleadoxservicio t WHERE t.idhorarioxempleadoxservicio = :idhorarioxempleadoxservicio"),
    @NamedQuery(name = "TblHorarioxempleadoxservicio.findByDia", query = "SELECT t FROM TblHorarioxempleadoxservicio t WHERE t.dia = :dia"),
    @NamedQuery(name = "TblHorarioxempleadoxservicio.findByHorainicio", query = "SELECT t FROM TblHorarioxempleadoxservicio t WHERE t.horainicio = :horainicio"),
    @NamedQuery(name = "TblHorarioxempleadoxservicio.findByHorafin", query = "SELECT t FROM TblHorarioxempleadoxservicio t WHERE t.horafin = :horafin")})
public class TblHorarioxempleadoxservicio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDHORARIOXEMPLEADOXSERVICIO")
    private BigDecimal idhorarioxempleadoxservicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIA")
    private BigInteger dia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORAINICIO")
    private BigInteger horainicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORAFIN")
    private BigInteger horafin;
    @JoinColumn(name = "IDEMPLEADOXSERVICIO", referencedColumnName = "IDEMPLEADOXSERVICIO")
    @ManyToOne(optional = false)
    private TblEmpleadoxservicio idempleadoxservicio;

    public TblHorarioxempleadoxservicio() {
    }

    public TblHorarioxempleadoxservicio(BigDecimal idhorarioxempleadoxservicio) {
        this.idhorarioxempleadoxservicio = idhorarioxempleadoxservicio;
    }

    public TblHorarioxempleadoxservicio(BigDecimal idhorarioxempleadoxservicio, BigInteger dia, BigInteger horainicio, BigInteger horafin) {
        this.idhorarioxempleadoxservicio = idhorarioxempleadoxservicio;
        this.dia = dia;
        this.horainicio = horainicio;
        this.horafin = horafin;
    }

    public BigDecimal getIdhorarioxempleadoxservicio() {
        return idhorarioxempleadoxservicio;
    }

    public void setIdhorarioxempleadoxservicio(BigDecimal idhorarioxempleadoxservicio) {
        this.idhorarioxempleadoxservicio = idhorarioxempleadoxservicio;
    }

    public BigInteger getDia() {
        return dia;
    }

    public void setDia(BigInteger dia) {
        this.dia = dia;
    }

    public BigInteger getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(BigInteger horainicio) {
        this.horainicio = horainicio;
    }

    public BigInteger getHorafin() {
        return horafin;
    }

    public void setHorafin(BigInteger horafin) {
        this.horafin = horafin;
    }

    public TblEmpleadoxservicio getIdempleadoxservicio() {
        return idempleadoxservicio;
    }

    public void setIdempleadoxservicio(TblEmpleadoxservicio idempleadoxservicio) {
        this.idempleadoxservicio = idempleadoxservicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhorarioxempleadoxservicio != null ? idhorarioxempleadoxservicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblHorarioxempleadoxservicio)) {
            return false;
        }
        TblHorarioxempleadoxservicio other = (TblHorarioxempleadoxservicio) object;
        if ((this.idhorarioxempleadoxservicio == null && other.idhorarioxempleadoxservicio != null) || (this.idhorarioxempleadoxservicio != null && !this.idhorarioxempleadoxservicio.equals(other.idhorarioxempleadoxservicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.pruebainsert.TblHorarioxempleadoxservicio[ idhorarioxempleadoxservicio=" + idhorarioxempleadoxservicio + " ]";
    }
    
}
