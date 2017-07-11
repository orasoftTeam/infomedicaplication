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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LAP
 */
@Entity
@Table(name = "TBL_RESULTADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblResultado.findAll", query = "SELECT t FROM TblResultado t"),
    @NamedQuery(name = "TblResultado.findByIdresultado", query = "SELECT t FROM TblResultado t WHERE t.idresultado = :idresultado"),
    @NamedQuery(name = "TblResultado.findByFechacreacionresultado", query = "SELECT t FROM TblResultado t WHERE t.fechacreacionresultado = :fechacreacionresultado")})
public class TblResultado implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDRESULTADO")
    private BigDecimal idresultado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHACREACIONRESULTADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacionresultado;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "DESCRIPCIONRESULTADO")
    private String descripcionresultado;
    @JoinColumn(name = "IDCONSULTA", referencedColumnName = "IDCONSULTA")
    @ManyToOne(optional = false)
    private TblConsulta idconsulta;

    public TblResultado() {
    }

    public TblResultado(BigDecimal idresultado) {
        this.idresultado = idresultado;
    }

    public TblResultado(BigDecimal idresultado, Date fechacreacionresultado, String descripcionresultado) {
        this.idresultado = idresultado;
        this.fechacreacionresultado = fechacreacionresultado;
        this.descripcionresultado = descripcionresultado;
    }

    public BigDecimal getIdresultado() {
        return idresultado;
    }

    public void setIdresultado(BigDecimal idresultado) {
        this.idresultado = idresultado;
    }

    public Date getFechacreacionresultado() {
        return fechacreacionresultado;
    }

    public void setFechacreacionresultado(Date fechacreacionresultado) {
        this.fechacreacionresultado = fechacreacionresultado;
    }

    public String getDescripcionresultado() {
        return descripcionresultado;
    }

    public void setDescripcionresultado(String descripcionresultado) {
        this.descripcionresultado = descripcionresultado;
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
        hash += (idresultado != null ? idresultado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblResultado)) {
            return false;
        }
        TblResultado other = (TblResultado) object;
        if ((this.idresultado == null && other.idresultado != null) || (this.idresultado != null && !this.idresultado.equals(other.idresultado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infomedic.entity.TblResultado[ idresultado=" + idresultado + " ]";
    }
    
}
