/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LAP
 */
@Entity
@Table(name = "TBL_PAIS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPais.findAll", query = "SELECT t FROM TblPais t"),
    @NamedQuery(name = "TblPais.findByIdpais", query = "SELECT t FROM TblPais t WHERE t.idpais = :idpais"),
    @NamedQuery(name = "TblPais.findByNombrepais", query = "SELECT t FROM TblPais t WHERE t.nombrepais = :nombrepais")})
public class TblPais implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "PAIS_SEQ")
    @SequenceGenerator(name = "PAIS_SEQ", sequenceName = "SQE_IDPAIS", allocationSize = 1)
    @Column(name = "IDPAIS")
    private BigDecimal idpais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBREPAIS")
    private String nombrepais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpais")
    private List<TblDepartamento> tblDepartamentoList;

    public TblPais() {
    }

    public TblPais(BigDecimal idpais) {
        this.idpais = idpais;
    }

    public TblPais(BigDecimal idpais, String nombrepais) {
        this.idpais = idpais;
        this.nombrepais = nombrepais;
    }

    public BigDecimal getIdpais() {
        return idpais;
    }

    public void setIdpais(BigDecimal idpais) {
        this.idpais = idpais;
    }

    public String getNombrepais() {
        return nombrepais;
    }

    public void setNombrepais(String nombrepais) {
        this.nombrepais = nombrepais;
    }

    @XmlTransient
    public List<TblDepartamento> getTblDepartamentoList() {
        return tblDepartamentoList;
    }

    public void setTblDepartamentoList(List<TblDepartamento> tblDepartamentoList) {
        this.tblDepartamentoList = tblDepartamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpais != null ? idpais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPais)) {
            return false;
        }
        TblPais other = (TblPais) object;
        if ((this.idpais == null && other.idpais != null) || (this.idpais != null && !this.idpais.equals(other.idpais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infomedic.entity.TblPais[ idpais=" + idpais + " ]";
    }
    
}
