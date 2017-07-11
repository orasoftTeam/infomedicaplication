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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "TBL_DIASFESTIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDiasfestivos.findAll", query = "SELECT t FROM TblDiasfestivos t"),
    @NamedQuery(name = "TblDiasfestivos.findByIddiafestivos", query = "SELECT t FROM TblDiasfestivos t WHERE t.iddiafestivos = :iddiafestivos"),
    @NamedQuery(name = "TblDiasfestivos.findByNombrediafestivos", query = "SELECT t FROM TblDiasfestivos t WHERE t.nombrediafestivos = :nombrediafestivos")})
public class TblDiasfestivos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDDIAFESTIVOS")
    private BigDecimal iddiafestivos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBREDIAFESTIVOS")
    private String nombrediafestivos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddiafestivos")
    private List<TblConsultorioxdiasfestivos> tblConsultorioxdiasfestivosList;

    public TblDiasfestivos() {
    }

    public TblDiasfestivos(BigDecimal iddiafestivos) {
        this.iddiafestivos = iddiafestivos;
    }

    public TblDiasfestivos(BigDecimal iddiafestivos, String nombrediafestivos) {
        this.iddiafestivos = iddiafestivos;
        this.nombrediafestivos = nombrediafestivos;
    }

    public BigDecimal getIddiafestivos() {
        return iddiafestivos;
    }

    public void setIddiafestivos(BigDecimal iddiafestivos) {
        this.iddiafestivos = iddiafestivos;
    }

    public String getNombrediafestivos() {
        return nombrediafestivos;
    }

    public void setNombrediafestivos(String nombrediafestivos) {
        this.nombrediafestivos = nombrediafestivos;
    }

    @XmlTransient
    public List<TblConsultorioxdiasfestivos> getTblConsultorioxdiasfestivosList() {
        return tblConsultorioxdiasfestivosList;
    }

    public void setTblConsultorioxdiasfestivosList(List<TblConsultorioxdiasfestivos> tblConsultorioxdiasfestivosList) {
        this.tblConsultorioxdiasfestivosList = tblConsultorioxdiasfestivosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddiafestivos != null ? iddiafestivos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDiasfestivos)) {
            return false;
        }
        TblDiasfestivos other = (TblDiasfestivos) object;
        if ((this.iddiafestivos == null && other.iddiafestivos != null) || (this.iddiafestivos != null && !this.iddiafestivos.equals(other.iddiafestivos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infomedic.entity.TblDiasfestivos[ iddiafestivos=" + iddiafestivos + " ]";
    }
    
}
