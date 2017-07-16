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
@Table(name = "TBL_GALERRIAXEMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblGalerriaxempleado.findAll", query = "SELECT t FROM TblGalerriaxempleado t"),
    @NamedQuery(name = "TblGalerriaxempleado.findByIdgaleempleado", query = "SELECT t FROM TblGalerriaxempleado t WHERE t.idgaleempleado = :idgaleempleado"),
    @NamedQuery(name = "TblGalerriaxempleado.findByRutafotoempleado", query = "SELECT t FROM TblGalerriaxempleado t WHERE t.rutafotoempleado = :rutafotoempleado")})
public class TblGalerriaxempleado implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDGALEEMPLEADO")
    private BigDecimal idgaleempleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "RUTAFOTOEMPLEADO")
    private String rutafotoempleado;
    @JoinColumn(name = "IDEMPLEADO", referencedColumnName = "IDEMPLEADO")
    @ManyToOne(optional = false)
    private TblEmpleado idempleado;

    public TblGalerriaxempleado() {
    }

    public TblGalerriaxempleado(BigDecimal idgaleempleado) {
        this.idgaleempleado = idgaleempleado;
    }

    public TblGalerriaxempleado(BigDecimal idgaleempleado, String rutafotoempleado) {
        this.idgaleempleado = idgaleempleado;
        this.rutafotoempleado = rutafotoempleado;
    }

    public BigDecimal getIdgaleempleado() {
        return idgaleempleado;
    }

    public void setIdgaleempleado(BigDecimal idgaleempleado) {
        this.idgaleempleado = idgaleempleado;
    }

    public String getRutafotoempleado() {
        return rutafotoempleado;
    }

    public void setRutafotoempleado(String rutafotoempleado) {
        this.rutafotoempleado = rutafotoempleado;
    }

    public TblEmpleado getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(TblEmpleado idempleado) {
        this.idempleado = idempleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgaleempleado != null ? idgaleempleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblGalerriaxempleado)) {
            return false;
        }
        TblGalerriaxempleado other = (TblGalerriaxempleado) object;
        if ((this.idgaleempleado == null && other.idgaleempleado != null) || (this.idgaleempleado != null && !this.idgaleempleado.equals(other.idgaleempleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.pruebainsert.TblGalerriaxempleado[ idgaleempleado=" + idgaleempleado + " ]";
    }
    
}
