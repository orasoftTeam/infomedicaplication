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
@Table(name = "TBL_RUBRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblRubro.findAll", query = "SELECT t FROM TblRubro t"),
    @NamedQuery(name = "TblRubro.findByIdrubro", query = "SELECT t FROM TblRubro t WHERE t.idrubro = :idrubro"),
    @NamedQuery(name = "TblRubro.findByNombrerubro", query = "SELECT t FROM TblRubro t WHERE t.nombrerubro = :nombrerubro")})
public class TblRubro implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "RUBRO_SEQ")
    @SequenceGenerator(name = "RUBRO_SEQ", sequenceName = "sqe_idrubro", allocationSize = 1)
    @Column(name = "IDRUBRO")
    private BigDecimal idrubro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRERUBRO")
    private String nombrerubro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrubro")
    private List<TblConsultorio> tblConsultorioList;

    public TblRubro() {
    }

    public TblRubro(BigDecimal idrubro) {
        this.idrubro = idrubro;
    }

    public TblRubro(BigDecimal idrubro, String nombrerubro) {
        this.idrubro = idrubro;
        this.nombrerubro = nombrerubro;
    }

    public BigDecimal getIdrubro() {
        return idrubro;
    }

    public void setIdrubro(BigDecimal idrubro) {
        this.idrubro = idrubro;
    }

    public String getNombrerubro() {
        return nombrerubro;
    }

    public void setNombrerubro(String nombrerubro) {
        this.nombrerubro = nombrerubro;
    }

    @XmlTransient
    public List<TblConsultorio> getTblConsultorioList() {
        return tblConsultorioList;
    }

    public void setTblConsultorioList(List<TblConsultorio> tblConsultorioList) {
        this.tblConsultorioList = tblConsultorioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrubro != null ? idrubro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblRubro)) {
            return false;
        }
        TblRubro other = (TblRubro) object;
        if ((this.idrubro == null && other.idrubro != null) || (this.idrubro != null && !this.idrubro.equals(other.idrubro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infomedic.entity.TblRubro[ idrubro=" + idrubro + " ]";
    }
    
}
