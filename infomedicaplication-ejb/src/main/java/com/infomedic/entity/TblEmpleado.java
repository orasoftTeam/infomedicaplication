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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LAP
 */
@Entity
@Table(name = "TBL_EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblEmpleado.findAll", query = "SELECT t FROM TblEmpleado t"),
    @NamedQuery(name = "TblEmpleado.findByIdempleado", query = "SELECT t FROM TblEmpleado t WHERE t.idempleado = :idempleado"),
    @NamedQuery(name = "TblEmpleado.findByNombreempleado", query = "SELECT t FROM TblEmpleado t WHERE t.nombreempleado = :nombreempleado"),
    @NamedQuery(name = "TblEmpleado.findByApellidoempleado", query = "SELECT t FROM TblEmpleado t WHERE t.apellidoempleado = :apellidoempleado"),
    @NamedQuery(name = "TblEmpleado.findByDuiempleado", query = "SELECT t FROM TblEmpleado t WHERE t.duiempleado = :duiempleado"),
    @NamedQuery(name = "TblEmpleado.findByNitempleado", query = "SELECT t FROM TblEmpleado t WHERE t.nitempleado = :nitempleado"),
    @NamedQuery(name = "TblEmpleado.findByNumeroisssempleado", query = "SELECT t FROM TblEmpleado t WHERE t.numeroisssempleado = :numeroisssempleado"),
    @NamedQuery(name = "TblEmpleado.findByDireccionempleado", query = "SELECT t FROM TblEmpleado t WHERE t.direccionempleado = :direccionempleado"),
    @NamedQuery(name = "TblEmpleado.findByFechanacimientoempleado", query = "SELECT t FROM TblEmpleado t WHERE t.fechanacimientoempleado = :fechanacimientoempleado"),
    @NamedQuery(name = "TblEmpleado.findByGeneroempleado", query = "SELECT t FROM TblEmpleado t WHERE t.generoempleado = :generoempleado"),
    @NamedQuery(name = "TblEmpleado.findByEstadoempleado", query = "SELECT t FROM TblEmpleado t WHERE t.estadoempleado = :estadoempleado"),
    @NamedQuery(name = "TblEmpleado.findByFechainicio", query = "SELECT t FROM TblEmpleado t WHERE t.fechainicio = :fechainicio"),
    @NamedQuery(name = "TblEmpleado.findByFechafin", query = "SELECT t FROM TblEmpleado t WHERE t.fechafin = :fechafin")})
public class TblEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDEMPLEADO")
    private BigDecimal idempleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBREEMPLEADO")
    private String nombreempleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "APELLIDOEMPLEADO")
    private String apellidoempleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "DUIEMPLEADO")
    private String duiempleado;
    @Size(max = 17)
    @Column(name = "NITEMPLEADO")
    private String nitempleado;
    @Size(max = 9)
    @Column(name = "NUMEROISSSEMPLEADO")
    private String numeroisssempleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DIRECCIONEMPLEADO")
    private String direccionempleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHANACIMIENTOEMPLEADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechanacimientoempleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GENEROEMPLEADO")
    private Character generoempleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADOEMPLEADO")
    private Character estadoempleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAINICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainicio;
    @Lob
    @Column(name = "DESCRIPCIONEMPLEADO")
    private String descripcionempleado;
    @Column(name = "FECHAFIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idempleado")
    private List<TblEmpleadoxservicio> tblEmpleadoxservicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idempleado")
    private List<TblGalerriaxempleado> tblGalerriaxempleadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idempleado")
    private List<TblTelefonoxempleado> tblTelefonoxempleadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idempleado")
    private List<TblExplaboemple> tblExplaboempleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idempleado")
    private List<TblEmpleadoxespecialidad> tblEmpleadoxespecialidadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idempleado")
    private List<TblConsulta> tblConsultaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idempleado")
    private List<TblCita> tblCitaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idempleado")
    private List<TblFormacionsuperior> tblFormacionsuperiorList;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "IDUSUARIO")
    @ManyToOne(optional = false)
    private TblUsuario idusuario;
    @JoinColumn(name = "IDTIPOEMPLEADO", referencedColumnName = "IDTIPOEMPLEADO")
    @ManyToOne(optional = false)
    private TblTipoempleado idtipoempleado;
    @JoinColumn(name = "IDMUNICIPIO", referencedColumnName = "IDMUNICIPIO")
    @ManyToOne(optional = false)
    private TblMunicipio idmunicipio;
    @JoinColumn(name = "IDCONSULTORIO", referencedColumnName = "IDCONSULTORIO")
    @ManyToOne(optional = false)
    private TblConsultorio idconsultorio;

    public TblEmpleado() {
    }

    public TblEmpleado(BigDecimal idempleado) {
        this.idempleado = idempleado;
    }

    public TblEmpleado(BigDecimal idempleado, String nombreempleado, String apellidoempleado, String duiempleado, String direccionempleado, Date fechanacimientoempleado, Character generoempleado, Character estadoempleado, Date fechainicio) {
        this.idempleado = idempleado;
        this.nombreempleado = nombreempleado;
        this.apellidoempleado = apellidoempleado;
        this.duiempleado = duiempleado;
        this.direccionempleado = direccionempleado;
        this.fechanacimientoempleado = fechanacimientoempleado;
        this.generoempleado = generoempleado;
        this.estadoempleado = estadoempleado;
        this.fechainicio = fechainicio;
    }

    public BigDecimal getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(BigDecimal idempleado) {
        this.idempleado = idempleado;
    }

    public String getNombreempleado() {
        return nombreempleado;
    }

    public void setNombreempleado(String nombreempleado) {
        this.nombreempleado = nombreempleado;
    }

    public String getApellidoempleado() {
        return apellidoempleado;
    }

    public void setApellidoempleado(String apellidoempleado) {
        this.apellidoempleado = apellidoempleado;
    }

    public String getDuiempleado() {
        return duiempleado;
    }

    public void setDuiempleado(String duiempleado) {
        this.duiempleado = duiempleado;
    }

    public String getNitempleado() {
        return nitempleado;
    }

    public void setNitempleado(String nitempleado) {
        this.nitempleado = nitempleado;
    }

    public String getNumeroisssempleado() {
        return numeroisssempleado;
    }

    public void setNumeroisssempleado(String numeroisssempleado) {
        this.numeroisssempleado = numeroisssempleado;
    }

    public String getDireccionempleado() {
        return direccionempleado;
    }

    public void setDireccionempleado(String direccionempleado) {
        this.direccionempleado = direccionempleado;
    }

    public Date getFechanacimientoempleado() {
        return fechanacimientoempleado;
    }

    public void setFechanacimientoempleado(Date fechanacimientoempleado) {
        this.fechanacimientoempleado = fechanacimientoempleado;
    }

    public Character getGeneroempleado() {
        return generoempleado;
    }

    public void setGeneroempleado(Character generoempleado) {
        this.generoempleado = generoempleado;
    }

    public Character getEstadoempleado() {
        return estadoempleado;
    }

    public void setEstadoempleado(Character estadoempleado) {
        this.estadoempleado = estadoempleado;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getDescripcionempleado() {
        return descripcionempleado;
    }

    public void setDescripcionempleado(String descripcionempleado) {
        this.descripcionempleado = descripcionempleado;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    @XmlTransient
    public List<TblEmpleadoxservicio> getTblEmpleadoxservicioList() {
        return tblEmpleadoxservicioList;
    }

    public void setTblEmpleadoxservicioList(List<TblEmpleadoxservicio> tblEmpleadoxservicioList) {
        this.tblEmpleadoxservicioList = tblEmpleadoxservicioList;
    }

    @XmlTransient
    public List<TblGalerriaxempleado> getTblGalerriaxempleadoList() {
        return tblGalerriaxempleadoList;
    }

    public void setTblGalerriaxempleadoList(List<TblGalerriaxempleado> tblGalerriaxempleadoList) {
        this.tblGalerriaxempleadoList = tblGalerriaxempleadoList;
    }

    @XmlTransient
    public List<TblTelefonoxempleado> getTblTelefonoxempleadoList() {
        return tblTelefonoxempleadoList;
    }

    public void setTblTelefonoxempleadoList(List<TblTelefonoxempleado> tblTelefonoxempleadoList) {
        this.tblTelefonoxempleadoList = tblTelefonoxempleadoList;
    }

    @XmlTransient
    public List<TblExplaboemple> getTblExplaboempleList() {
        return tblExplaboempleList;
    }

    public void setTblExplaboempleList(List<TblExplaboemple> tblExplaboempleList) {
        this.tblExplaboempleList = tblExplaboempleList;
    }

    @XmlTransient
    public List<TblEmpleadoxespecialidad> getTblEmpleadoxespecialidadList() {
        return tblEmpleadoxespecialidadList;
    }

    public void setTblEmpleadoxespecialidadList(List<TblEmpleadoxespecialidad> tblEmpleadoxespecialidadList) {
        this.tblEmpleadoxespecialidadList = tblEmpleadoxespecialidadList;
    }

    @XmlTransient
    public List<TblConsulta> getTblConsultaList() {
        return tblConsultaList;
    }

    public void setTblConsultaList(List<TblConsulta> tblConsultaList) {
        this.tblConsultaList = tblConsultaList;
    }

    @XmlTransient
    public List<TblCita> getTblCitaList() {
        return tblCitaList;
    }

    public void setTblCitaList(List<TblCita> tblCitaList) {
        this.tblCitaList = tblCitaList;
    }

    @XmlTransient
    public List<TblFormacionsuperior> getTblFormacionsuperiorList() {
        return tblFormacionsuperiorList;
    }

    public void setTblFormacionsuperiorList(List<TblFormacionsuperior> tblFormacionsuperiorList) {
        this.tblFormacionsuperiorList = tblFormacionsuperiorList;
    }

    public TblUsuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(TblUsuario idusuario) {
        this.idusuario = idusuario;
    }

    public TblTipoempleado getIdtipoempleado() {
        return idtipoempleado;
    }

    public void setIdtipoempleado(TblTipoempleado idtipoempleado) {
        this.idtipoempleado = idtipoempleado;
    }

    public TblMunicipio getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(TblMunicipio idmunicipio) {
        this.idmunicipio = idmunicipio;
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
        hash += (idempleado != null ? idempleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblEmpleado)) {
            return false;
        }
        TblEmpleado other = (TblEmpleado) object;
        if ((this.idempleado == null && other.idempleado != null) || (this.idempleado != null && !this.idempleado.equals(other.idempleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infomedic.entity.TblEmpleado[ idempleado=" + idempleado + " ]";
    }
    
}
