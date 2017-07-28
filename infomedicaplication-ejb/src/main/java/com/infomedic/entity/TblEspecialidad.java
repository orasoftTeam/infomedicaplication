/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "TBL_ESPECIALIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblEspecialidad.findAll", query = "SELECT t FROM TblEspecialidad t"),
    @NamedQuery(name = "TblEspecialidad.findByIdespecialidad", query = "SELECT t FROM TblEspecialidad t WHERE t.idespecialidad = :idespecialidad"),
    @NamedQuery(name = "TblEspecialidad.findByIdempleado", query = "SELECT t FROM TblEspecialidad t WHERE t.idempleado = :idempleado"),
    @NamedQuery(name = "TblEspecialidad.findByNombreespecialidad", query = "SELECT t FROM TblEspecialidad t WHERE t.nombreespecialidad = :nombreespecialidad")})
public class TblEspecialidad implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "ESPECIALIDAD_SEQ")
    @SequenceGenerator(name = "ESPECIALIDAD_SEQ", sequenceName = "SQE_IDESPECIALIDAD", allocationSize = 1)
    @Column(name = "IDESPECIALIDAD")
    private BigDecimal idespecialidad;
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "IDEMPLEADO")
    private BigInteger idempleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBREESPECIALIDAD")
    private String nombreespecialidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idespecialidad")
    private List<TblEmpleadoxespecialidad> tblEmpleadoxespecialidadList;

    public TblEspecialidad() {
    }

    public TblEspecialidad(BigDecimal idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

    public TblEspecialidad(BigDecimal idespecialidad, BigInteger idempleado, String nombreespecialidad) {
        this.idespecialidad = idespecialidad;
        this.idempleado = idempleado;
        this.nombreespecialidad = nombreespecialidad;
    }

    public BigDecimal getIdespecialidad() {
        return idespecialidad;
    }

    public void setIdespecialidad(BigDecimal idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

    public BigInteger getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(BigInteger idempleado) {
        this.idempleado = idempleado;
    }

    public String getNombreespecialidad() {
        return nombreespecialidad;
    }

    public void setNombreespecialidad(String nombreespecialidad) {
        this.nombreespecialidad = nombreespecialidad;
    }

    @XmlTransient
    public List<TblEmpleadoxespecialidad> getTblEmpleadoxespecialidadList() {
        return tblEmpleadoxespecialidadList;
    }

    public void setTblEmpleadoxespecialidadList(List<TblEmpleadoxespecialidad> tblEmpleadoxespecialidadList) {
        this.tblEmpleadoxespecialidadList = tblEmpleadoxespecialidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idespecialidad != null ? idespecialidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblEspecialidad)) {
            return false;
        }
        TblEspecialidad other = (TblEspecialidad) object;
        if ((this.idespecialidad == null && other.idespecialidad != null) || (this.idespecialidad != null && !this.idespecialidad.equals(other.idespecialidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.pruebainsert.TblEspecialidad[ idespecialidad=" + idespecialidad + " ]";
    }
    
}
