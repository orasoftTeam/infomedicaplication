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
@Table(name = "TBL_TIPOEMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTipoempleado.findAll", query = "SELECT t FROM TblTipoempleado t"),
    @NamedQuery(name = "TblTipoempleado.findByIdtipoempleado", query = "SELECT t FROM TblTipoempleado t WHERE t.idtipoempleado = :idtipoempleado"),
    @NamedQuery(name = "TblTipoempleado.findByNombretipo", query = "SELECT t FROM TblTipoempleado t WHERE t.nombretipo = :nombretipo")})
public class TblTipoempleado implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "TIPOEMPLEADO_SEQ")
    @SequenceGenerator(name = "TIPOEMPLEADO_SEQ", sequenceName = "sqe_idtipoemp", allocationSize = 1)
    @Column(name = "IDTIPOEMPLEADO")
    private BigDecimal idtipoempleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRETIPO")
    private String nombretipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoempleado")
    private List<TblEmpleado> tblEmpleadoList;

    public TblTipoempleado() {
    }

    public TblTipoempleado(BigDecimal idtipoempleado) {
        this.idtipoempleado = idtipoempleado;
    }

    public TblTipoempleado(BigDecimal idtipoempleado, String nombretipo) {
        this.idtipoempleado = idtipoempleado;
        this.nombretipo = nombretipo;
    }

    public BigDecimal getIdtipoempleado() {
        return idtipoempleado;
    }

    public void setIdtipoempleado(BigDecimal idtipoempleado) {
        this.idtipoempleado = idtipoempleado;
    }

    public String getNombretipo() {
        return nombretipo;
    }

    public void setNombretipo(String nombretipo) {
        this.nombretipo = nombretipo;
    }

    @XmlTransient
    public List<TblEmpleado> getTblEmpleadoList() {
        return tblEmpleadoList;
    }

    public void setTblEmpleadoList(List<TblEmpleado> tblEmpleadoList) {
        this.tblEmpleadoList = tblEmpleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoempleado != null ? idtipoempleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTipoempleado)) {
            return false;
        }
        TblTipoempleado other = (TblTipoempleado) object;
        if ((this.idtipoempleado == null && other.idtipoempleado != null) || (this.idtipoempleado != null && !this.idtipoempleado.equals(other.idtipoempleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infomedic.entity.TblTipoempleado[ idtipoempleado=" + idtipoempleado + " ]";
    }
    
}
