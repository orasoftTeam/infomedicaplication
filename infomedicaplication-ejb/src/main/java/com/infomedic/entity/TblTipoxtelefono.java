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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
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
@Table(name = "TBL_TIPOXTELEFONO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTipoxtelefono.findAll", query = "SELECT t FROM TblTipoxtelefono t"),
    @NamedQuery(name = "TblTipoxtelefono.findByIdtipoxtelefono", query = "SELECT t FROM TblTipoxtelefono t WHERE t.idtipoxtelefono = :idtipoxtelefono"),
    @NamedQuery(name = "TblTipoxtelefono.findByNombretipo", query = "SELECT t FROM TblTipoxtelefono t WHERE t.nombretipo = :nombretipo")})
public class TblTipoxtelefono implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPOTEL_SEQ")
    @SequenceGenerator(name = "TIPOTEL_SEQ", sequenceName = "SQE_IDTIPOTEL", allocationSize = 1)
    @Column(name = "IDTIPOXTELEFONO")
    private BigDecimal idtipoxtelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRETIPO")
    private String nombretipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoxtelefono")
    private List<TblTelefonoxconsultorio> tblTelefonoxconsultorioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoxtelefono")
    private List<TblTelefonoxempleado> tblTelefonoxempleadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoxtelefono")
    private List<TblTelefonoxpaciente> tblTelefonoxpacienteList;

    public TblTipoxtelefono() {
    }

    public TblTipoxtelefono(BigDecimal idtipoxtelefono) {
        this.idtipoxtelefono = idtipoxtelefono;
    }

    public TblTipoxtelefono(BigDecimal idtipoxtelefono, String nombretipo) {
        this.idtipoxtelefono = idtipoxtelefono;
        this.nombretipo = nombretipo;
    }

    public BigDecimal getIdtipoxtelefono() {
        return idtipoxtelefono;
    }

    public void setIdtipoxtelefono(BigDecimal idtipoxtelefono) {
        this.idtipoxtelefono = idtipoxtelefono;
    }

    public String getNombretipo() {
        return nombretipo;
    }

    public void setNombretipo(String nombretipo) {
        this.nombretipo = nombretipo;
    }

    @XmlTransient
    public List<TblTelefonoxconsultorio> getTblTelefonoxconsultorioList() {
        return tblTelefonoxconsultorioList;
    }

    public void setTblTelefonoxconsultorioList(List<TblTelefonoxconsultorio> tblTelefonoxconsultorioList) {
        this.tblTelefonoxconsultorioList = tblTelefonoxconsultorioList;
    }

    @XmlTransient
    public List<TblTelefonoxempleado> getTblTelefonoxempleadoList() {
        return tblTelefonoxempleadoList;
    }

    public void setTblTelefonoxempleadoList(List<TblTelefonoxempleado> tblTelefonoxempleadoList) {
        this.tblTelefonoxempleadoList = tblTelefonoxempleadoList;
    }

    @XmlTransient
    public List<TblTelefonoxpaciente> getTblTelefonoxpacienteList() {
        return tblTelefonoxpacienteList;
    }

    public void setTblTelefonoxpacienteList(List<TblTelefonoxpaciente> tblTelefonoxpacienteList) {
        this.tblTelefonoxpacienteList = tblTelefonoxpacienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoxtelefono != null ? idtipoxtelefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTipoxtelefono)) {
            return false;
        }
        TblTipoxtelefono other = (TblTipoxtelefono) object;
        if ((this.idtipoxtelefono == null && other.idtipoxtelefono != null) || (this.idtipoxtelefono != null && !this.idtipoxtelefono.equals(other.idtipoxtelefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infomedic.entity.TblTipoxtelefono[ idtipoxtelefono=" + idtipoxtelefono + " ]";
    }
    
}
