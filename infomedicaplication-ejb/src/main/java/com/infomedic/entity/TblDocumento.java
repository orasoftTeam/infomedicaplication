/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LAP
 */
@Entity
@Table(name = "TBL_DOCUMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDocumento.findAll", query = "SELECT t FROM TblDocumento t"),
    @NamedQuery(name = "TblDocumento.findByIddocumento", query = "SELECT t FROM TblDocumento t WHERE t.iddocumento = :iddocumento"),
    @NamedQuery(name = "TblDocumento.findByNombredocumento", query = "SELECT t FROM TblDocumento t WHERE t.nombredocumento = :nombredocumento"),
    @NamedQuery(name = "TblDocumento.findByRutaarchivo", query = "SELECT t FROM TblDocumento t WHERE t.rutaarchivo = :rutaarchivo"),
    @NamedQuery(name = "TblDocumento.findByFechadocumento", query = "SELECT t FROM TblDocumento t WHERE t.fechadocumento = :fechadocumento"),
    @NamedQuery(name = "TblDocumento.findByExtensiondocumento", query = "SELECT t FROM TblDocumento t WHERE t.extensiondocumento = :extensiondocumento")})
public class TblDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDDOCUMENTO")
    private BigDecimal iddocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "NOMBREDOCUMENTO")
    private String nombredocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "RUTAARCHIVO")
    private String rutaarchivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHADOCUMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechadocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EXTENSIONDOCUMENTO")
    private String extensiondocumento;
    @JoinColumn(name = "IDCONSULTA", referencedColumnName = "IDCONSULTA")
    @ManyToOne(optional = false)
    private TblConsulta idconsulta;

    public TblDocumento() {
    }

    public TblDocumento(BigDecimal iddocumento) {
        this.iddocumento = iddocumento;
    }

    public TblDocumento(BigDecimal iddocumento, String nombredocumento, String rutaarchivo, Date fechadocumento, String extensiondocumento) {
        this.iddocumento = iddocumento;
        this.nombredocumento = nombredocumento;
        this.rutaarchivo = rutaarchivo;
        this.fechadocumento = fechadocumento;
        this.extensiondocumento = extensiondocumento;
    }

    public BigDecimal getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(BigDecimal iddocumento) {
        this.iddocumento = iddocumento;
    }

    public String getNombredocumento() {
        return nombredocumento;
    }

    public void setNombredocumento(String nombredocumento) {
        this.nombredocumento = nombredocumento;
    }

    public String getRutaarchivo() {
        return rutaarchivo;
    }

    public void setRutaarchivo(String rutaarchivo) {
        this.rutaarchivo = rutaarchivo;
    }

    public Date getFechadocumento() {
        return fechadocumento;
    }

    public void setFechadocumento(Date fechadocumento) {
        this.fechadocumento = fechadocumento;
    }

    public String getExtensiondocumento() {
        return extensiondocumento;
    }

    public void setExtensiondocumento(String extensiondocumento) {
        this.extensiondocumento = extensiondocumento;
    }

    public TblConsulta getIdconsulta() {
        return idconsulta;
    }

    public void setIdconsulta(TblConsulta idconsulta) {
        this.idconsulta = idconsulta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddocumento != null ? iddocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDocumento)) {
            return false;
        }
        TblDocumento other = (TblDocumento) object;
        if ((this.iddocumento == null && other.iddocumento != null) || (this.iddocumento != null && !this.iddocumento.equals(other.iddocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infomedic.entity.TblDocumento[ iddocumento=" + iddocumento + " ]";
    }
    
}
