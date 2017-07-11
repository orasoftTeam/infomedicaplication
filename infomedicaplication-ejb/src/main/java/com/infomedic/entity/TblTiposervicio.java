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
@Table(name = "TBL_TIPOSERVICIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTiposervicio.findAll", query = "SELECT t FROM TblTiposervicio t"),
    @NamedQuery(name = "TblTiposervicio.findByIdtiposervicio", query = "SELECT t FROM TblTiposervicio t WHERE t.idtiposervicio = :idtiposervicio"),
    @NamedQuery(name = "TblTiposervicio.findByNombretiposervicio", query = "SELECT t FROM TblTiposervicio t WHERE t.nombretiposervicio = :nombretiposervicio")})
public class TblTiposervicio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTIPOSERVICIO")
    private BigDecimal idtiposervicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRETIPOSERVICIO")
    private String nombretiposervicio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtiposervicio")
    private List<TblServicios> tblServiciosList;

    public TblTiposervicio() {
    }

    public TblTiposervicio(BigDecimal idtiposervicio) {
        this.idtiposervicio = idtiposervicio;
    }

    public TblTiposervicio(BigDecimal idtiposervicio, String nombretiposervicio) {
        this.idtiposervicio = idtiposervicio;
        this.nombretiposervicio = nombretiposervicio;
    }

    public BigDecimal getIdtiposervicio() {
        return idtiposervicio;
    }

    public void setIdtiposervicio(BigDecimal idtiposervicio) {
        this.idtiposervicio = idtiposervicio;
    }

    public String getNombretiposervicio() {
        return nombretiposervicio;
    }

    public void setNombretiposervicio(String nombretiposervicio) {
        this.nombretiposervicio = nombretiposervicio;
    }

    @XmlTransient
    public List<TblServicios> getTblServiciosList() {
        return tblServiciosList;
    }

    public void setTblServiciosList(List<TblServicios> tblServiciosList) {
        this.tblServiciosList = tblServiciosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtiposervicio != null ? idtiposervicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTiposervicio)) {
            return false;
        }
        TblTiposervicio other = (TblTiposervicio) object;
        if ((this.idtiposervicio == null && other.idtiposervicio != null) || (this.idtiposervicio != null && !this.idtiposervicio.equals(other.idtiposervicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infomedic.entity.TblTiposervicio[ idtiposervicio=" + idtiposervicio + " ]";
    }
    
}
