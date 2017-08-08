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
@Table(name = "TBL_TELEFONOXPACIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTelefonoxpaciente.findAll", query = "SELECT t FROM TblTelefonoxpaciente t"),
    @NamedQuery(name = "TblTelefonoxpaciente.findByIdtelefonoxpaciente", query = "SELECT t FROM TblTelefonoxpaciente t WHERE t.idtelefonoxpaciente = :idtelefonoxpaciente"),
    @NamedQuery(name = "TblTelefonoxpaciente.findByIdtipoxtelefono", query = "SELECT t FROM TblTelefonoxpaciente t WHERE t.idtipoxtelefono = :idtipoxtelefono"),
    @NamedQuery(name = "TblTelefonoxpaciente.findByNumerotelefono", query = "SELECT t FROM TblTelefonoxpaciente t WHERE t.numerotelefono = :numerotelefono")})
public class TblTelefonoxpaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "TELXPAC_SEQ")
    @SequenceGenerator(name = "TELXPAC_SEQ", sequenceName = "sqe_idtelxpac", allocationSize = 1)
    @Column(name = "IDTELEFONOXPACIENTE")
    private BigDecimal idtelefonoxpaciente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTIPOXTELEFONO")
    private BigInteger idtipoxtelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NUMEROTELEFONO")
    private String numerotelefono;
    @JoinColumn(name = "IDPACIENTE", referencedColumnName = "IDPACIENTE")
    @ManyToOne(optional = false)
    private TblPaciente idpaciente;

    public TblTelefonoxpaciente() {
    }

    public TblTelefonoxpaciente(BigDecimal idtelefonoxpaciente) {
        this.idtelefonoxpaciente = idtelefonoxpaciente;
    }

    public TblTelefonoxpaciente(BigDecimal idtelefonoxpaciente, BigInteger idtipoxtelefono, String numerotelefono) {
        this.idtelefonoxpaciente = idtelefonoxpaciente;
        this.idtipoxtelefono = idtipoxtelefono;
        this.numerotelefono = numerotelefono;
    }

    public BigDecimal getIdtelefonoxpaciente() {
        return idtelefonoxpaciente;
    }

    public void setIdtelefonoxpaciente(BigDecimal idtelefonoxpaciente) {
        this.idtelefonoxpaciente = idtelefonoxpaciente;
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

    public TblPaciente getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(TblPaciente idpaciente) {
        this.idpaciente = idpaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtelefonoxpaciente != null ? idtelefonoxpaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTelefonoxpaciente)) {
            return false;
        }
        TblTelefonoxpaciente other = (TblTelefonoxpaciente) object;
        if ((this.idtelefonoxpaciente == null && other.idtelefonoxpaciente != null) || (this.idtelefonoxpaciente != null && !this.idtelefonoxpaciente.equals(other.idtelefonoxpaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.pruebainsert.TblTelefonoxpaciente[ idtelefonoxpaciente=" + idtelefonoxpaciente + " ]";
    }
    
}
