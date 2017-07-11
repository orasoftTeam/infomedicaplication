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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TBL_SERVICIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblServicios.findAll", query = "SELECT t FROM TblServicios t"),
    @NamedQuery(name = "TblServicios.findByIdservicio", query = "SELECT t FROM TblServicios t WHERE t.idservicio = :idservicio"),
    @NamedQuery(name = "TblServicios.findByNombreservicio", query = "SELECT t FROM TblServicios t WHERE t.nombreservicio = :nombreservicio"),
    @NamedQuery(name = "TblServicios.findByRequisitos", query = "SELECT t FROM TblServicios t WHERE t.requisitos = :requisitos")})
public class TblServicios implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSERVICIO")
    private BigDecimal idservicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRESERVICIO")
    private String nombreservicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "REQUISITOS")
    private String requisitos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idservicio")
    private List<TblEmpleadoxservicio> tblEmpleadoxservicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idservicio")
    private List<TblConsultorioxservicio> tblConsultorioxservicioList;
    @JoinColumn(name = "IDTIPOSERVICIO", referencedColumnName = "IDTIPOSERVICIO")
    @ManyToOne(optional = false)
    private TblTiposervicio idtiposervicio;

    public TblServicios() {
    }

    public TblServicios(BigDecimal idservicio) {
        this.idservicio = idservicio;
    }

    public TblServicios(BigDecimal idservicio, String nombreservicio, String requisitos) {
        this.idservicio = idservicio;
        this.nombreservicio = nombreservicio;
        this.requisitos = requisitos;
    }

    public BigDecimal getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(BigDecimal idservicio) {
        this.idservicio = idservicio;
    }

    public String getNombreservicio() {
        return nombreservicio;
    }

    public void setNombreservicio(String nombreservicio) {
        this.nombreservicio = nombreservicio;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    @XmlTransient
    public List<TblEmpleadoxservicio> getTblEmpleadoxservicioList() {
        return tblEmpleadoxservicioList;
    }

    public void setTblEmpleadoxservicioList(List<TblEmpleadoxservicio> tblEmpleadoxservicioList) {
        this.tblEmpleadoxservicioList = tblEmpleadoxservicioList;
    }

    @XmlTransient
    public List<TblConsultorioxservicio> getTblConsultorioxservicioList() {
        return tblConsultorioxservicioList;
    }

    public void setTblConsultorioxservicioList(List<TblConsultorioxservicio> tblConsultorioxservicioList) {
        this.tblConsultorioxservicioList = tblConsultorioxservicioList;
    }

    public TblTiposervicio getIdtiposervicio() {
        return idtiposervicio;
    }

    public void setIdtiposervicio(TblTiposervicio idtiposervicio) {
        this.idtiposervicio = idtiposervicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idservicio != null ? idservicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblServicios)) {
            return false;
        }
        TblServicios other = (TblServicios) object;
        if ((this.idservicio == null && other.idservicio != null) || (this.idservicio != null && !this.idservicio.equals(other.idservicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infomedic.entity.TblServicios[ idservicio=" + idservicio + " ]";
    }
    
}
