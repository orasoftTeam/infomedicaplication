/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LAP
 */
@Entity
@Table(name = "TBL_EXPEDIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblExpediente.findAll", query = "SELECT t FROM TblExpediente t"),
    @NamedQuery(name = "TblExpediente.findByIdexpediente", query = "SELECT t FROM TblExpediente t WHERE t.idexpediente = :idexpediente"),
    @NamedQuery(name = "TblExpediente.findByFechadecreacion", query = "SELECT t FROM TblExpediente t WHERE t.fechadecreacion = :fechadecreacion"),
    @NamedQuery(name = "TblExpediente.findByEstadoexpediente", query = "SELECT t FROM TblExpediente t WHERE t.estadoexpediente = :estadoexpediente")})
public class TblExpediente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDEXPEDIENTE")
    private BigDecimal idexpediente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHADECREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechadecreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADOEXPEDIENTE")
    private Character estadoexpediente;
    @JoinColumn(name = "IDPACIENTE", referencedColumnName = "IDPACIENTE")
    @ManyToOne(optional = false)
    private TblPaciente idpaciente;
    @JoinColumn(name = "IDCONSULTORIO", referencedColumnName = "IDCONSULTORIO")
    @ManyToOne(optional = false)
    private TblConsultorio idconsultorio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idexpediente")
    private List<TblConsulta> tblConsultaList;

    public TblExpediente() {
    }

    public TblExpediente(BigDecimal idexpediente) {
        this.idexpediente = idexpediente;
    }

    public TblExpediente(BigDecimal idexpediente, Date fechadecreacion, Character estadoexpediente) {
        this.idexpediente = idexpediente;
        this.fechadecreacion = fechadecreacion;
        this.estadoexpediente = estadoexpediente;
    }

    public BigDecimal getIdexpediente() {
        return idexpediente;
    }

    public void setIdexpediente(BigDecimal idexpediente) {
        this.idexpediente = idexpediente;
    }

    public Date getFechadecreacion() {
        return fechadecreacion;
    }

    public void setFechadecreacion(Date fechadecreacion) {
        this.fechadecreacion = fechadecreacion;
    }

    public Character getEstadoexpediente() {
        return estadoexpediente;
    }

    public void setEstadoexpediente(Character estadoexpediente) {
        this.estadoexpediente = estadoexpediente;
    }

    public TblPaciente getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(TblPaciente idpaciente) {
        this.idpaciente = idpaciente;
    }

    public TblConsultorio getIdconsultorio() {
        return idconsultorio;
    }

    public void setIdconsultorio(TblConsultorio idconsultorio) {
        this.idconsultorio = idconsultorio;
    }

    @XmlTransient
    public List<TblConsulta> getTblConsultaList() {
        return tblConsultaList;
    }

    public void setTblConsultaList(List<TblConsulta> tblConsultaList) {
        this.tblConsultaList = tblConsultaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexpediente != null ? idexpediente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblExpediente)) {
            return false;
        }
        TblExpediente other = (TblExpediente) object;
        if ((this.idexpediente == null && other.idexpediente != null) || (this.idexpediente != null && !this.idexpediente.equals(other.idexpediente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infomedic.entity.TblExpediente[ idexpediente=" + idexpediente + " ]";
    }
    
}
