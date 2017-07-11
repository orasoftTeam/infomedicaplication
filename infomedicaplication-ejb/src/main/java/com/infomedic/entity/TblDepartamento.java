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
@Table(name = "TBL_DEPARTAMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDepartamento.findAll", query = "SELECT t FROM TblDepartamento t"),
    @NamedQuery(name = "TblDepartamento.findByIddepartamento", query = "SELECT t FROM TblDepartamento t WHERE t.iddepartamento = :iddepartamento"),
    @NamedQuery(name = "TblDepartamento.findByNombredepartamento", query = "SELECT t FROM TblDepartamento t WHERE t.nombredepartamento = :nombredepartamento")})
public class TblDepartamento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "DEPTO_SEQ")
    @SequenceGenerator(name = "DEPTO_SEQ", sequenceName = "SQE_CODDEPARTAMENTO", allocationSize = 1)
    @Column(name = "IDDEPARTAMENTO")
    private BigDecimal iddepartamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBREDEPARTAMENTO")
    private String nombredepartamento;
    @JoinColumn(name = "IDPAIS", referencedColumnName = "IDPAIS")
    @ManyToOne(optional = false)
    private TblPais idpais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddepartamento")
    private List<TblMunicipio> tblMunicipioList;

    public TblDepartamento() {
    }

    public TblDepartamento(BigDecimal iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public TblDepartamento(BigDecimal iddepartamento, String nombredepartamento) {
        this.iddepartamento = iddepartamento;
        this.nombredepartamento = nombredepartamento;
    }

    public BigDecimal getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(BigDecimal iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public String getNombredepartamento() {
        return nombredepartamento;
    }

    public void setNombredepartamento(String nombredepartamento) {
        this.nombredepartamento = nombredepartamento;
    }

    public TblPais getIdpais() {
        return idpais;
    }

    public void setIdpais(TblPais idpais) {
        this.idpais = idpais;
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
        hash += (iddepartamento != null ? iddepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDepartamento)) {
            return false;
        }
        TblDepartamento other = (TblDepartamento) object;
        if ((this.iddepartamento == null && other.iddepartamento != null) || (this.iddepartamento != null && !this.iddepartamento.equals(other.iddepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infomedic.entity.TblDepartamento[ iddepartamento=" + iddepartamento + " ]";
    }
    
}
