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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LAP
 */
@Entity
@Table(name = "TBL_TELEFONOXEMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTelefonoxempleado.findAll", query = "SELECT t FROM TblTelefonoxempleado t"),
    @NamedQuery(name = "TblTelefonoxempleado.findByIdtelefonoxempleado", query = "SELECT t FROM TblTelefonoxempleado t WHERE t.idtelefonoxempleado = :idtelefonoxempleado"),
    @NamedQuery(name = "TblTelefonoxempleado.findByIdtipoxtelefono", query = "SELECT t FROM TblTelefonoxempleado t WHERE t.idtipoxtelefono = :idtipoxtelefono"),
    @NamedQuery(name = "TblTelefonoxempleado.findByNumerotelefono", query = "SELECT t FROM TblTelefonoxempleado t WHERE t.numerotelefono = :numerotelefono")})
public class TblTelefonoxempleado implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "TELEFONOEMPLEADO_SEQ")
    @SequenceGenerator(name = "TELEFONOEMPLEADO_SEQ", sequenceName = "SQE_IDTELXEMP", allocationSize = 1)
    @Column(name = "IDTELEFONOXEMPLEADO")
    private BigDecimal idtelefonoxempleado;
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "IDTIPOXTELEFONO")
    private BigInteger idtipoxtelefono;
   // @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 15)
    @Column(name = "NUMEROTELEFONO")
    private String numerotelefono;
    @JoinColumn(name = "IDEMPLEADO", referencedColumnName = "IDEMPLEADO")
    @ManyToOne(optional = false)
    private TblEmpleado idempleado;

    public TblTelefonoxempleado() {
    }

    public TblTelefonoxempleado(BigDecimal idtelefonoxempleado) {
        this.idtelefonoxempleado = idtelefonoxempleado;
    }

    public TblTelefonoxempleado(BigDecimal idtelefonoxempleado, BigInteger idtipoxtelefono, String numerotelefono) {
        this.idtelefonoxempleado = idtelefonoxempleado;
        this.idtipoxtelefono = idtipoxtelefono;
        this.numerotelefono = numerotelefono;
    }

    public BigDecimal getIdtelefonoxempleado() {
        return idtelefonoxempleado;
    }

    public void setIdtelefonoxempleado(BigDecimal idtelefonoxempleado) {
        this.idtelefonoxempleado = idtelefonoxempleado;
    }

    public BigInteger getIdtipoxtelefono() {
        return idtipoxtelefono;
    }

    public void setIdtipoxtelefono(BigInteger idtipoxtelefono) {
        this.idtipoxtelefono = idtipoxtelefono;
    }

    public String getNumerotelefono() {
        return numerotelefono;
    }

    public void setNumerotelefono(String numerotelefono) {
        this.numerotelefono = numerotelefono;
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
        hash += (idtelefonoxempleado != null ? idtelefonoxempleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTelefonoxempleado)) {
            return false;
        }
        TblTelefonoxempleado other = (TblTelefonoxempleado) object;
        if ((this.idtelefonoxempleado == null && other.idtelefonoxempleado != null) || (this.idtelefonoxempleado != null && !this.idtelefonoxempleado.equals(other.idtelefonoxempleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.pruebainsert.TblTelefonoxempleado[ idtelefonoxempleado=" + idtelefonoxempleado + " ]";
    }
    
}
