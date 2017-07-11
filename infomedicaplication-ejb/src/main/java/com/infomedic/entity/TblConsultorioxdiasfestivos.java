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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LAP
 */
@Entity
@Table(name = "TBL_CONSULTORIOXDIASFESTIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblConsultorioxdiasfestivos.findAll", query = "SELECT t FROM TblConsultorioxdiasfestivos t"),
    @NamedQuery(name = "TblConsultorioxdiasfestivos.findByIdconsultorioxdiafestivos", query = "SELECT t FROM TblConsultorioxdiasfestivos t WHERE t.idconsultorioxdiafestivos = :idconsultorioxdiafestivos")})
public class TblConsultorioxdiasfestivos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCONSULTORIOXDIAFESTIVOS")
    private BigDecimal idconsultorioxdiafestivos;
    @JoinColumn(name = "IDDIAFESTIVOS", referencedColumnName = "IDDIAFESTIVOS")
    @ManyToOne(optional = false)
    private TblDiasfestivos iddiafestivos;
    @JoinColumn(name = "IDCONSULTORIO", referencedColumnName = "IDCONSULTORIO")
    @ManyToOne(optional = false)
    private TblConsultorio idconsultorio;

    public TblConsultorioxdiasfestivos() {
    }

    public TblConsultorioxdiasfestivos(BigDecimal idconsultorioxdiafestivos) {
        this.idconsultorioxdiafestivos = idconsultorioxdiafestivos;
    }

    public BigDecimal getIdconsultorioxdiafestivos() {
        return idconsultorioxdiafestivos;
    }

    public void setIdconsultorioxdiafestivos(BigDecimal idconsultorioxdiafestivos) {
        this.idconsultorioxdiafestivos = idconsultorioxdiafestivos;
    }

    public TblDiasfestivos getIddiafestivos() {
        return iddiafestivos;
    }

    public void setIddiafestivos(TblDiasfestivos iddiafestivos) {
        this.iddiafestivos = iddiafestivos;
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
        hash += (idconsultorioxdiafestivos != null ? idconsultorioxdiafestivos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblConsultorioxdiasfestivos)) {
            return false;
        }
        TblConsultorioxdiasfestivos other = (TblConsultorioxdiasfestivos) object;
        if ((this.idconsultorioxdiafestivos == null && other.idconsultorioxdiafestivos != null) || (this.idconsultorioxdiafestivos != null && !this.idconsultorioxdiafestivos.equals(other.idconsultorioxdiafestivos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infomedic.entity.TblConsultorioxdiasfestivos[ idconsultorioxdiafestivos=" + idconsultorioxdiafestivos + " ]";
    }
    
}
