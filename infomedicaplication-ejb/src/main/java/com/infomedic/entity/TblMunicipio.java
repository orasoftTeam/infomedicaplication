/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.entity;

import java.io.Serializable;
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
@Table(name = "tbl_municipio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblMunicipio.findAll", query = "SELECT t FROM TblMunicipio t"),
    @NamedQuery(name = "TblMunicipio.findByCodmunicipio", query = "SELECT t FROM TblMunicipio t WHERE t.codmunicipio = :codmunicipio"),
    @NamedQuery(name = "TblMunicipio.findByNombremunicipio", query = "SELECT t FROM TblMunicipio t WHERE t.nombremunicipio = :nombremunicipio")})
public class TblMunicipio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "MUNICIPIO_SEQ")
    @SequenceGenerator(name = "MUNICIPIO_SEQ", sequenceName = "SQE_IDMUNICIPIO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "codmunicipio")
    private Integer codmunicipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombremunicipio")
    private String nombremunicipio;
    @JoinColumn(name = "coddepartamento", referencedColumnName = "coddepartamento")
    @ManyToOne(optional = false)
    private TblDepartamento coddepartamento;

    public TblMunicipio() {
    }

    public TblMunicipio(Integer codmunicipio) {
        this.codmunicipio = codmunicipio;
    }

    public TblMunicipio(Integer codmunicipio, String nombremunicipio) {
        this.codmunicipio = codmunicipio;
        this.nombremunicipio = nombremunicipio;
    }

    public Integer getCodmunicipio() {
        return codmunicipio;
    }

    public void setCodmunicipio(Integer codmunicipio) {
        this.codmunicipio = codmunicipio;
    }

    public String getNombremunicipio() {
        return nombremunicipio;
    }

    public void setNombremunicipio(String nombremunicipio) {
        this.nombremunicipio = nombremunicipio;
    }

    public TblDepartamento getCoddepartamento() {
        return coddepartamento;
    }

    public void setCoddepartamento(TblDepartamento coddepartamento) {
        this.coddepartamento = coddepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmunicipio != null ? codmunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMunicipio)) {
            return false;
        }
        TblMunicipio other = (TblMunicipio) object;
        if ((this.codmunicipio == null && other.codmunicipio != null) || (this.codmunicipio != null && !this.codmunicipio.equals(other.codmunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infomedic.entity.TblMunicipio[ codmunicipio=" + codmunicipio + " ]";
    }
    
}
