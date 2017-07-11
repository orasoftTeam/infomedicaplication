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
@Table(name = "TBL_GALERIAXCONSULTORIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblGaleriaxconsultorio.findAll", query = "SELECT t FROM TblGaleriaxconsultorio t"),
    @NamedQuery(name = "TblGaleriaxconsultorio.findByIdgaleconsul", query = "SELECT t FROM TblGaleriaxconsultorio t WHERE t.idgaleconsul = :idgaleconsul"),
    @NamedQuery(name = "TblGaleriaxconsultorio.findByRutafotoconsultorio", query = "SELECT t FROM TblGaleriaxconsultorio t WHERE t.rutafotoconsultorio = :rutafotoconsultorio")})
public class TblGaleriaxconsultorio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDGALECONSUL")
    private BigDecimal idgaleconsul;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "RUTAFOTOCONSULTORIO")
    private String rutafotoconsultorio;
    @JoinColumn(name = "IDCONSULTORIO", referencedColumnName = "IDCONSULTORIO")
    @ManyToOne(optional = false)
    private TblConsultorio idconsultorio;

    public TblGaleriaxconsultorio() {
    }

    public TblGaleriaxconsultorio(BigDecimal idgaleconsul) {
        this.idgaleconsul = idgaleconsul;
    }

    public TblGaleriaxconsultorio(BigDecimal idgaleconsul, String rutafotoconsultorio) {
        this.idgaleconsul = idgaleconsul;
        this.rutafotoconsultorio = rutafotoconsultorio;
    }

    public BigDecimal getIdgaleconsul() {
        return idgaleconsul;
    }

    public void setIdgaleconsul(BigDecimal idgaleconsul) {
        this.idgaleconsul = idgaleconsul;
    }

    public String getRutafotoconsultorio() {
        return rutafotoconsultorio;
    }

    public void setRutafotoconsultorio(String rutafotoconsultorio) {
        this.rutafotoconsultorio = rutafotoconsultorio;
    }

    public TblConsultorio getIdconsultorio() {
        return idconsultorio;
    }

    public void setIdconsultorio(TblConsultorio idconsultorio) {
        this.idconsultorio = idconsultorio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgaleconsul != null ? idgaleconsul.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblGaleriaxconsultorio)) {
            return false;
        }
        TblGaleriaxconsultorio other = (TblGaleriaxconsultorio) object;
        if ((this.idgaleconsul == null && other.idgaleconsul != null) || (this.idgaleconsul != null && !this.idgaleconsul.equals(other.idgaleconsul))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infomedic.entity.TblGaleriaxconsultorio[ idgaleconsul=" + idgaleconsul + " ]";
    }
    
}
