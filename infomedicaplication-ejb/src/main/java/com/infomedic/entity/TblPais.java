/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "tbl_pais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPais.findAll", query = "SELECT t FROM TblPais t"),
    @NamedQuery(name = "TblPais.findByCodpais", query = "SELECT t FROM TblPais t WHERE t.codpais = :codpais"),
    @NamedQuery(name = "TblPais.findByNombrepais", query = "SELECT t FROM TblPais t WHERE t.nombrepais = :nombrepais")})
public class TblPais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "PAIS_SEQ")
    @SequenceGenerator(name = "PAIS_SEQ", sequenceName = "SQE_IDPAIS", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "codpais")
    private Integer codpais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombrepais")
    private String nombrepais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codpais")
    private List<TblDepartamento> tblDepartamentoList;

    public TblPais() {
    }

    public TblPais(Integer codpais) {
        this.codpais = codpais;
    }

    public TblPais(Integer codpais, String nombrepais) {
        this.codpais = codpais;
        this.nombrepais = nombrepais;
    }

    public Integer getCodpais() {
        return codpais;
    }

    public void setCodpais(Integer codpais) {
        this.codpais = codpais;
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
        hash += (codpais != null ? codpais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPais)) {
            return false;
        }
        TblPais other = (TblPais) object;
        if ((this.codpais == null && other.codpais != null) || (this.codpais != null && !this.codpais.equals(other.codpais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infomedic.entity.TblPais[ codpais=" + codpais + " ]";
    }
    
}
