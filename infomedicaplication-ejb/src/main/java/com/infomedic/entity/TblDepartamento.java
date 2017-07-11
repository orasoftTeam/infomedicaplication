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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDepartamento.findAll", query = "SELECT t FROM TblDepartamento t"),
    @NamedQuery(name = "TblDepartamento.findByCoddepartamento", query = "SELECT t FROM TblDepartamento t WHERE t.coddepartamento = :coddepartamento"),
    @NamedQuery(name = "TblDepartamento.findByNombredepartamento", query = "SELECT t FROM TblDepartamento t WHERE t.nombredepartamento = :nombredepartamento")})
public class TblDepartamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "DEPTO_SEQ")
    @SequenceGenerator(name = "DEPTO_SEQ", sequenceName = "SQE_DEPARTAMENTO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "coddepartamento")
    private Integer coddepartamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombredepartamento")
    private String nombredepartamento;
    @JoinColumn(name = "codpais", referencedColumnName = "codpais")
    @ManyToOne(optional = false)
    private TblPais codpais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coddepartamento")
    private List<TblMunicipio> tblMunicipioList;

    public TblDepartamento() {
    }

    public TblDepartamento(Integer coddepartamento) {
        this.coddepartamento = coddepartamento;
    }

    public TblDepartamento(Integer coddepartamento, String nombredepartamento) {
        this.coddepartamento = coddepartamento;
        this.nombredepartamento = nombredepartamento;
    }

    public Integer getCoddepartamento() {
        return coddepartamento;
    }

    public void setCoddepartamento(Integer coddepartamento) {
        this.coddepartamento = coddepartamento;
    }

    public String getNombredepartamento() {
        return nombredepartamento;
    }

    public void setNombredepartamento(String nombredepartamento) {
        this.nombredepartamento = nombredepartamento;
    }

    public TblPais getCodpais() {
        return codpais;
    }

    public void setCodpais(TblPais codpais) {
        this.codpais = codpais;
    }

    @XmlTransient
    public List<TblMunicipio> getTblMunicipioList() {
        return tblMunicipioList;
    }

    public void setTblMunicipioList(List<TblMunicipio> tblMunicipioList) {
        this.tblMunicipioList = tblMunicipioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coddepartamento != null ? coddepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDepartamento)) {
            return false;
        }
        TblDepartamento other = (TblDepartamento) object;
        if ((this.coddepartamento == null && other.coddepartamento != null) || (this.coddepartamento != null && !this.coddepartamento.equals(other.coddepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infomedic.entity.TblDepartamento[ coddepartamento=" + coddepartamento + " ]";
    }
    
}
