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
@Table(name = "TBL_TELEFONOXCONSULTORIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTelefonoxconsultorio.findAll", query = "SELECT t FROM TblTelefonoxconsultorio t"),
    @NamedQuery(name = "TblTelefonoxconsultorio.findByIdtelefonoxconsultorio", query = "SELECT t FROM TblTelefonoxconsultorio t WHERE t.idtelefonoxconsultorio = :idtelefonoxconsultorio"),
    @NamedQuery(name = "TblTelefonoxconsultorio.findByNumerotelefono", query = "SELECT t FROM TblTelefonoxconsultorio t WHERE t.numerotelefono = :numerotelefono")})
public class TblTelefonoxconsultorio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTELEFONOXCONSULTORIO")
    private BigDecimal idtelefonoxconsultorio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NUMEROTELEFONO")
    private String numerotelefono;
    @JoinColumn(name = "IDTIPOXTELEFONO", referencedColumnName = "IDTIPOXTELEFONO")
    @ManyToOne(optional = false)
    private TblTipoxtelefono idtipoxtelefono;
    @JoinColumn(name = "IDCONSULTORIO", referencedColumnName = "IDCONSULTORIO")
    @ManyToOne(optional = false)
    private TblConsultorio idconsultorio;

    public TblTelefonoxconsultorio() {
    }

    public TblTelefonoxconsultorio(BigDecimal idtelefonoxconsultorio) {
        this.idtelefonoxconsultorio = idtelefonoxconsultorio;
    }

    public TblTelefonoxconsultorio(BigDecimal idtelefonoxconsultorio, String numerotelefono) {
        this.idtelefonoxconsultorio = idtelefonoxconsultorio;
        this.numerotelefono = numerotelefono;
    }

    public BigDecimal getIdtelefonoxconsultorio() {
        return idtelefonoxconsultorio;
    }

    public void setIdtelefonoxconsultorio(BigDecimal idtelefonoxconsultorio) {
        this.idtelefonoxconsultorio = idtelefonoxconsultorio;
    }

    public String getNumerotelefono() {
        return numerotelefono;
    }

    public void setNumerotelefono(String numerotelefono) {
        this.numerotelefono = numerotelefono;
    }

    public TblTipoxtelefono getIdtipoxtelefono() {
        return idtipoxtelefono;
    }

    public void setIdtipoxtelefono(TblTipoxtelefono idtipoxtelefono) {
        this.idtipoxtelefono = idtipoxtelefono;
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
        hash += (idtelefonoxconsultorio != null ? idtelefonoxconsultorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTelefonoxconsultorio)) {
            return false;
        }
        TblTelefonoxconsultorio other = (TblTelefonoxconsultorio) object;
        if ((this.idtelefonoxconsultorio == null && other.idtelefonoxconsultorio != null) || (this.idtelefonoxconsultorio != null && !this.idtelefonoxconsultorio.equals(other.idtelefonoxconsultorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infomedic.entity.TblTelefonoxconsultorio[ idtelefonoxconsultorio=" + idtelefonoxconsultorio + " ]";
    }
    
}
