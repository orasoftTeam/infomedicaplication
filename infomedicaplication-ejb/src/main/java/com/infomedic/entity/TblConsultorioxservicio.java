/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LAP
 */
@Entity
@Table(name = "TBL_CONSULTORIOXSERVICIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblConsultorioxservicio.findAll", query = "SELECT t FROM TblConsultorioxservicio t"),
    @NamedQuery(name = "TblConsultorioxservicio.findByIdconsultorioxservicio", query = "SELECT t FROM TblConsultorioxservicio t WHERE t.idconsultorioxservicio = :idconsultorioxservicio"),
    @NamedQuery(name = "TblConsultorioxservicio.findByPrecioconsxservicio", query = "SELECT t FROM TblConsultorioxservicio t WHERE t.precioconsxservicio = :precioconsxservicio"),
    @NamedQuery(name = "TblConsultorioxservicio.findByHorarioconsxservicio", query = "SELECT t FROM TblConsultorioxservicio t WHERE t.horarioconsxservicio = :horarioconsxservicio"),
    @NamedQuery(name = "TblConsultorioxservicio.findByEstadoservicio", query = "SELECT t FROM TblConsultorioxservicio t WHERE t.estadoservicio = :estadoservicio")})
public class TblConsultorioxservicio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCONSULTORIOXSERVICIO")
    private BigDecimal idconsultorioxservicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIOCONSXSERVICIO")
    private BigDecimal precioconsxservicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "HORARIOCONSXSERVICIO")
    private String horarioconsxservicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADOSERVICIO")
    private Character estadoservicio;
    @JoinColumn(name = "IDSERVICIO", referencedColumnName = "IDSERVICIO")
    @ManyToOne(optional = false)
    private TblServicios idservicio;
    @JoinColumn(name = "IDCONSULTORIO", referencedColumnName = "IDCONSULTORIO")
    @ManyToOne(optional = false)
    private TblConsultorio idconsultorio;

    public TblConsultorioxservicio() {
    }

    public TblConsultorioxservicio(BigDecimal idconsultorioxservicio) {
        this.idconsultorioxservicio = idconsultorioxservicio;
    }

    public TblConsultorioxservicio(BigDecimal idconsultorioxservicio, BigDecimal precioconsxservicio, String horarioconsxservicio, Character estadoservicio) {
        this.idconsultorioxservicio = idconsultorioxservicio;
        this.precioconsxservicio = precioconsxservicio;
        this.horarioconsxservicio = horarioconsxservicio;
        this.estadoservicio = estadoservicio;
    }

    public BigDecimal getIdconsultorioxservicio() {
        return idconsultorioxservicio;
    }

    public void setIdconsultorioxservicio(BigDecimal idconsultorioxservicio) {
        this.idconsultorioxservicio = idconsultorioxservicio;
    }

    public BigDecimal getPrecioconsxservicio() {
        return precioconsxservicio;
    }

    public void setPrecioconsxservicio(BigDecimal precioconsxservicio) {
        this.precioconsxservicio = precioconsxservicio;
    }

    public String getHorarioconsxservicio() {
        return horarioconsxservicio;
    }

    public void setHorarioconsxservicio(String horarioconsxservicio) {
        this.horarioconsxservicio = horarioconsxservicio;
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

    public TblConsultorio getIdconsultorio() {
        return idconsultorio;
    }

    public void setIdconsultorio(TblConsultorio idconsultorio) {
        this.idconsultorio = idconsultorio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconsultorioxservicio != null ? idconsultorioxservicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblConsultorioxservicio)) {
            return false;
        }
        TblConsultorioxservicio other = (TblConsultorioxservicio) object;
        if ((this.idconsultorioxservicio == null && other.idconsultorioxservicio != null) || (this.idconsultorioxservicio != null && !this.idconsultorioxservicio.equals(other.idconsultorioxservicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infomedic.entity.TblConsultorioxservicio[ idconsultorioxservicio=" + idconsultorioxservicio + " ]";
    }
    
}
