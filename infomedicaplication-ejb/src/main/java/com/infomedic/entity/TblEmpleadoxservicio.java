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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LAP
 */
@Entity
@Table(name = "TBL_EMPLEADOXSERVICIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblEmpleadoxservicio.findAll", query = "SELECT t FROM TblEmpleadoxservicio t"),
    @NamedQuery(name = "TblEmpleadoxservicio.findByIdempleadoxservicio", query = "SELECT t FROM TblEmpleadoxservicio t WHERE t.idempleadoxservicio = :idempleadoxservicio"),
    @NamedQuery(name = "TblEmpleadoxservicio.findByFechainicio", query = "SELECT t FROM TblEmpleadoxservicio t WHERE t.fechainicio = :fechainicio"),
    @NamedQuery(name = "TblEmpleadoxservicio.findByFechafin", query = "SELECT t FROM TblEmpleadoxservicio t WHERE t.fechafin = :fechafin"),
    @NamedQuery(name = "TblEmpleadoxservicio.findByEstadoservicio", query = "SELECT t FROM TblEmpleadoxservicio t WHERE t.estadoservicio = :estadoservicio")})
public class TblEmpleadoxservicio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDEMPLEADOXSERVICIO")
    private BigDecimal idempleadoxservicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAINICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainicio;
    @Column(name = "FECHAFIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADOSERVICIO")
    private Character estadoservicio;
    @JoinColumn(name = "IDSERVICIO", referencedColumnName = "IDSERVICIO")
    @ManyToOne(optional = false)
    private TblServicios idservicio;
    @JoinColumn(name = "IDEMPLEADO", referencedColumnName = "IDEMPLEADO")
    @ManyToOne(optional = false)
    private TblEmpleado idempleado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idempleadoxservicio")
    private List<TblHorarioxempleadoxservicio> tblHorarioxempleadoxservicioList;

    public TblEmpleadoxservicio() {
    }

    public TblEmpleadoxservicio(BigDecimal idempleadoxservicio) {
        this.idempleadoxservicio = idempleadoxservicio;
    }

    public TblEmpleadoxservicio(BigDecimal idempleadoxservicio, Date fechainicio, Character estadoservicio) {
        this.idempleadoxservicio = idempleadoxservicio;
        this.fechainicio = fechainicio;
        this.estadoservicio = estadoservicio;
    }

    public BigDecimal getIdempleadoxservicio() {
        return idempleadoxservicio;
    }

    public void setIdempleadoxservicio(BigDecimal idempleadoxservicio) {
        this.idempleadoxservicio = idempleadoxservicio;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public Character getEstadoservicio() {
        return estadoservicio;
    }

    public void setEstadoservicio(Character estadoservicio) {
        this.estadoservicio = estadoservicio;
    }

    public TblServicios getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(TblServicios idservicio) {
        this.idservicio = idservicio;
    }

    public TblEmpleado getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(TblEmpleado idempleado) {
        this.idempleado = idempleado;
    }

    @XmlTransient
    public List<TblHorarioxempleadoxservicio> getTblHorarioxempleadoxservicioList() {
        return tblHorarioxempleadoxservicioList;
    }

    public void setTblHorarioxempleadoxservicioList(List<TblHorarioxempleadoxservicio> tblHorarioxempleadoxservicioList) {
        this.tblHorarioxempleadoxservicioList = tblHorarioxempleadoxservicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idempleadoxservicio != null ? idempleadoxservicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblEmpleadoxservicio)) {
            return false;
        }
        TblEmpleadoxservicio other = (TblEmpleadoxservicio) object;
        if ((this.idempleadoxservicio == null && other.idempleadoxservicio != null) || (this.idempleadoxservicio != null && !this.idempleadoxservicio.equals(other.idempleadoxservicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infomedic.entity.TblEmpleadoxservicio[ idempleadoxservicio=" + idempleadoxservicio + " ]";
    }
    
}
