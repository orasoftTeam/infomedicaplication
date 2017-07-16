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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TBL_MUNICIPIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblMunicipio.findAll", query = "SELECT t FROM TblMunicipio t"),
    @NamedQuery(name = "TblMunicipio.findByIdmunicipio", query = "SELECT t FROM TblMunicipio t WHERE t.idmunicipio = :idmunicipio"),
    @NamedQuery(name = "TblMunicipio.findByNombremunicipio", query = "SELECT t FROM TblMunicipio t WHERE t.nombremunicipio = :nombremunicipio")})
public class TblMunicipio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "MUNICIPIO_SEQ")
    @SequenceGenerator(name = "MUNICIPIO_SEQ", sequenceName = "SQE_IDMUNICIPIO", allocationSize = 1)
    @Column(name = "IDMUNICIPIO")
    private BigDecimal idmunicipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBREMUNICIPIO")
    private String nombremunicipio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmunicipio")
    private List<TblConsultorio> tblConsultorioList;
    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmunicipio")
    private List<TblPaciente> tblPacienteList;
*/
    @JoinColumn(name = "IDDEPARTAMENTO", referencedColumnName = "IDDEPARTAMENTO")
    @ManyToOne(optional = false)
    private TblDepartamento iddepartamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmunicipio")
    private List<TblEmpleado> tblEmpleadoList;

    public TblMunicipio() {
    }

    public TblMunicipio(BigDecimal idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public TblMunicipio(BigDecimal idmunicipio, String nombremunicipio) {
        this.idmunicipio = idmunicipio;
        this.nombremunicipio = nombremunicipio;
    }

    public BigDecimal getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(BigDecimal idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getNombremunicipio() {
        return nombremunicipio;
    }

    public void setNombremunicipio(String nombremunicipio) {
        this.nombremunicipio = nombremunicipio;
    }

    @XmlTransient
    public List<TblConsultorio> getTblConsultorioList() {
        return tblConsultorioList;
    }

    public void setTblConsultorioList(List<TblConsultorio> tblConsultorioList) {
        this.tblConsultorioList = tblConsultorioList;
    }
/*
    @XmlTransient
    public List<TblPaciente> getTblPacienteList() {
        return tblPacienteList;
    }

    public void setTblPacienteList(List<TblPaciente> tblPacienteList) {
        this.tblPacienteList = tblPacienteList;
    }
*/
    public TblDepartamento getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(TblDepartamento iddepartamento) {
        this.iddepartamento = iddepartamento;
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
        hash += (idmunicipio != null ? idmunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMunicipio)) {
            return false;
        }
        TblMunicipio other = (TblMunicipio) object;
        if ((this.idmunicipio == null && other.idmunicipio != null) || (this.idmunicipio != null && !this.idmunicipio.equals(other.idmunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infomedic.entity.TblMunicipio[ idmunicipio=" + idmunicipio + " ]";
    }
    
}
