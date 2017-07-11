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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "TBL_CONSULTORIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblConsultorio.findAll", query = "SELECT t FROM TblConsultorio t"),
    @NamedQuery(name = "TblConsultorio.findByIdconsultorio", query = "SELECT t FROM TblConsultorio t WHERE t.idconsultorio = :idconsultorio"),
    @NamedQuery(name = "TblConsultorio.findByNombreconsultorio", query = "SELECT t FROM TblConsultorio t WHERE t.nombreconsultorio = :nombreconsultorio"),
    @NamedQuery(name = "TblConsultorio.findByDireccionconsultorio", query = "SELECT t FROM TblConsultorio t WHERE t.direccionconsultorio = :direccionconsultorio"),
    @NamedQuery(name = "TblConsultorio.findByCorreoconsultorio", query = "SELECT t FROM TblConsultorio t WHERE t.correoconsultorio = :correoconsultorio"),
    @NamedQuery(name = "TblConsultorio.findByPaginaweb", query = "SELECT t FROM TblConsultorio t WHERE t.paginaweb = :paginaweb"),
    @NamedQuery(name = "TblConsultorio.findByNivelconsultorio", query = "SELECT t FROM TblConsultorio t WHERE t.nivelconsultorio = :nivelconsultorio"),
    @NamedQuery(name = "TblConsultorio.findByNumeroconsultorio", query = "SELECT t FROM TblConsultorio t WHERE t.numeroconsultorio = :numeroconsultorio"),
    @NamedQuery(name = "TblConsultorio.findByRutalogoconsultorio", query = "SELECT t FROM TblConsultorio t WHERE t.rutalogoconsultorio = :rutalogoconsultorio"),
    @NamedQuery(name = "TblConsultorio.findByLatitudconsultorio", query = "SELECT t FROM TblConsultorio t WHERE t.latitudconsultorio = :latitudconsultorio"),
    @NamedQuery(name = "TblConsultorio.findByLongitudconsultorio", query = "SELECT t FROM TblConsultorio t WHERE t.longitudconsultorio = :longitudconsultorio"),
    @NamedQuery(name = "TblConsultorio.findByDiainicioconsultorio", query = "SELECT t FROM TblConsultorio t WHERE t.diainicioconsultorio = :diainicioconsultorio"),
    @NamedQuery(name = "TblConsultorio.findByDiafinconsultorio", query = "SELECT t FROM TblConsultorio t WHERE t.diafinconsultorio = :diafinconsultorio"),
    @NamedQuery(name = "TblConsultorio.findByHorainicioconsultorio", query = "SELECT t FROM TblConsultorio t WHERE t.horainicioconsultorio = :horainicioconsultorio"),
    @NamedQuery(name = "TblConsultorio.findByHorafinconsultorio", query = "SELECT t FROM TblConsultorio t WHERE t.horafinconsultorio = :horafinconsultorio"),
    @NamedQuery(name = "TblConsultorio.findByHorainicio2consultorio", query = "SELECT t FROM TblConsultorio t WHERE t.horainicio2consultorio = :horainicio2consultorio"),
    @NamedQuery(name = "TblConsultorio.findByHorafin2consultorio", query = "SELECT t FROM TblConsultorio t WHERE t.horafin2consultorio = :horafin2consultorio"),
    @NamedQuery(name = "TblConsultorio.findByEstadoconsultorio", query = "SELECT t FROM TblConsultorio t WHERE t.estadoconsultorio = :estadoconsultorio")})
public class TblConsultorio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCONSULTORIO")
    private BigDecimal idconsultorio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRECONSULTORIO")
    private String nombreconsultorio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DIRECCIONCONSULTORIO")
    private String direccionconsultorio;
    @Size(max = 100)
    @Column(name = "CORREOCONSULTORIO")
    private String correoconsultorio;
    @Size(max = 100)
    @Column(name = "PAGINAWEB")
    private String paginaweb;
    @Column(name = "NIVELCONSULTORIO")
    private BigInteger nivelconsultorio;
    @Size(max = 5)
    @Column(name = "NUMEROCONSULTORIO")
    private String numeroconsultorio;
    @Size(max = 255)
    @Column(name = "RUTALOGOCONSULTORIO")
    private String rutalogoconsultorio;
    @Column(name = "LATITUDCONSULTORIO")
    private BigDecimal latitudconsultorio;
    @Column(name = "LONGITUDCONSULTORIO")
    private BigDecimal longitudconsultorio;
    @Column(name = "DIAINICIOCONSULTORIO")
    private BigInteger diainicioconsultorio;
    @Column(name = "DIAFINCONSULTORIO")
    private BigInteger diafinconsultorio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORAINICIOCONSULTORIO")
    private BigInteger horainicioconsultorio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORAFINCONSULTORIO")
    private BigInteger horafinconsultorio;
    @Column(name = "HORAINICIO2CONSULTORIO")
    private BigInteger horainicio2consultorio;
    @Column(name = "HORAFIN2CONSULTORIO")
    private BigInteger horafin2consultorio;
    @Column(name = "ESTADOCONSULTORIO")
    private Character estadoconsultorio;
    @Lob
    @Column(name = "VISIONCONSULTORIO")
    private String visionconsultorio;
    @Lob
    @Column(name = "MISIONCONSULTORIO")
    private String misionconsultorio;
    @Lob
    @Column(name = "DESCRIPCIONCONSULTORIO")
    private String descripcionconsultorio;
    @JoinColumn(name = "IDRUBRO", referencedColumnName = "IDRUBRO")
    @ManyToOne(optional = false)
    private TblRubro idrubro;
    @JoinColumn(name = "IDMUNICIPIO", referencedColumnName = "IDMUNICIPIO")
    @ManyToOne(optional = false)
    private TblMunicipio idmunicipio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idconsultorio")
    private List<TblTelefonoxconsultorio> tblTelefonoxconsultorioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idconsultorio")
    private List<TblConsultorioxservicio> tblConsultorioxservicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idconsultorio")
    private List<TblExpediente> tblExpedienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idconsultorio")
    private List<TblConsultorioxdiasfestivos> tblConsultorioxdiasfestivosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idconsultorio")
    private List<TblGaleriaxconsultorio> tblGaleriaxconsultorioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idconsultorio")
    private List<TblCita> tblCitaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idconsultorio")
    private List<TblEmpleado> tblEmpleadoList;

    public TblConsultorio() {
    }

    public TblConsultorio(BigDecimal idconsultorio) {
        this.idconsultorio = idconsultorio;
    }

    public TblConsultorio(BigDecimal idconsultorio, String nombreconsultorio, String direccionconsultorio, BigInteger horainicioconsultorio, BigInteger horafinconsultorio) {
        this.idconsultorio = idconsultorio;
        this.nombreconsultorio = nombreconsultorio;
        this.direccionconsultorio = direccionconsultorio;
        this.horainicioconsultorio = horainicioconsultorio;
        this.horafinconsultorio = horafinconsultorio;
    }

    public BigDecimal getIdconsultorio() {
        return idconsultorio;
    }

    public void setIdconsultorio(BigDecimal idconsultorio) {
        this.idconsultorio = idconsultorio;
    }

    public String getNombreconsultorio() {
        return nombreconsultorio;
    }

    public void setNombreconsultorio(String nombreconsultorio) {
        this.nombreconsultorio = nombreconsultorio;
    }

    public String getDireccionconsultorio() {
        return direccionconsultorio;
    }

    public void setDireccionconsultorio(String direccionconsultorio) {
        this.direccionconsultorio = direccionconsultorio;
    }

    public String getCorreoconsultorio() {
        return correoconsultorio;
    }

    public void setCorreoconsultorio(String correoconsultorio) {
        this.correoconsultorio = correoconsultorio;
    }

    public String getPaginaweb() {
        return paginaweb;
    }

    public void setPaginaweb(String paginaweb) {
        this.paginaweb = paginaweb;
    }

    public BigInteger getNivelconsultorio() {
        return nivelconsultorio;
    }

    public void setNivelconsultorio(BigInteger nivelconsultorio) {
        this.nivelconsultorio = nivelconsultorio;
    }

    public String getNumeroconsultorio() {
        return numeroconsultorio;
    }

    public void setNumeroconsultorio(String numeroconsultorio) {
        this.numeroconsultorio = numeroconsultorio;
    }

    public String getRutalogoconsultorio() {
        return rutalogoconsultorio;
    }

    public void setRutalogoconsultorio(String rutalogoconsultorio) {
        this.rutalogoconsultorio = rutalogoconsultorio;
    }

    public BigDecimal getLatitudconsultorio() {
        return latitudconsultorio;
    }

    public void setLatitudconsultorio(BigDecimal latitudconsultorio) {
        this.latitudconsultorio = latitudconsultorio;
    }

    public BigDecimal getLongitudconsultorio() {
        return longitudconsultorio;
    }

    public void setLongitudconsultorio(BigDecimal longitudconsultorio) {
        this.longitudconsultorio = longitudconsultorio;
    }

    public BigInteger getDiainicioconsultorio() {
        return diainicioconsultorio;
    }

    public void setDiainicioconsultorio(BigInteger diainicioconsultorio) {
        this.diainicioconsultorio = diainicioconsultorio;
    }

    public BigInteger getDiafinconsultorio() {
        return diafinconsultorio;
    }

    public void setDiafinconsultorio(BigInteger diafinconsultorio) {
        this.diafinconsultorio = diafinconsultorio;
    }

    public BigInteger getHorainicioconsultorio() {
        return horainicioconsultorio;
    }

    public void setHorainicioconsultorio(BigInteger horainicioconsultorio) {
        this.horainicioconsultorio = horainicioconsultorio;
    }

    public BigInteger getHorafinconsultorio() {
        return horafinconsultorio;
    }

    public void setHorafinconsultorio(BigInteger horafinconsultorio) {
        this.horafinconsultorio = horafinconsultorio;
    }

    public BigInteger getHorainicio2consultorio() {
        return horainicio2consultorio;
    }

    public void setHorainicio2consultorio(BigInteger horainicio2consultorio) {
        this.horainicio2consultorio = horainicio2consultorio;
    }

    public BigInteger getHorafin2consultorio() {
        return horafin2consultorio;
    }

    public void setHorafin2consultorio(BigInteger horafin2consultorio) {
        this.horafin2consultorio = horafin2consultorio;
    }

    public Character getEstadoconsultorio() {
        return estadoconsultorio;
    }

    public void setEstadoconsultorio(Character estadoconsultorio) {
        this.estadoconsultorio = estadoconsultorio;
    }

    public String getVisionconsultorio() {
        return visionconsultorio;
    }

    public void setVisionconsultorio(String visionconsultorio) {
        this.visionconsultorio = visionconsultorio;
    }

    public String getMisionconsultorio() {
        return misionconsultorio;
    }

    public void setMisionconsultorio(String misionconsultorio) {
        this.misionconsultorio = misionconsultorio;
    }

    public String getDescripcionconsultorio() {
        return descripcionconsultorio;
    }

    public void setDescripcionconsultorio(String descripcionconsultorio) {
        this.descripcionconsultorio = descripcionconsultorio;
    }

    public TblRubro getIdrubro() {
        return idrubro;
    }

    public void setIdrubro(TblRubro idrubro) {
        this.idrubro = idrubro;
    }

    public TblMunicipio getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(TblMunicipio idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    @XmlTransient
    public List<TblTelefonoxconsultorio> getTblTelefonoxconsultorioList() {
        return tblTelefonoxconsultorioList;
    }

    public void setTblTelefonoxconsultorioList(List<TblTelefonoxconsultorio> tblTelefonoxconsultorioList) {
        this.tblTelefonoxconsultorioList = tblTelefonoxconsultorioList;
    }

    @XmlTransient
    public List<TblConsultorioxservicio> getTblConsultorioxservicioList() {
        return tblConsultorioxservicioList;
    }

    public void setTblConsultorioxservicioList(List<TblConsultorioxservicio> tblConsultorioxservicioList) {
        this.tblConsultorioxservicioList = tblConsultorioxservicioList;
    }

    @XmlTransient
    public List<TblExpediente> getTblExpedienteList() {
        return tblExpedienteList;
    }

    public void setTblExpedienteList(List<TblExpediente> tblExpedienteList) {
        this.tblExpedienteList = tblExpedienteList;
    }

    @XmlTransient
    public List<TblConsultorioxdiasfestivos> getTblConsultorioxdiasfestivosList() {
        return tblConsultorioxdiasfestivosList;
    }

    public void setTblConsultorioxdiasfestivosList(List<TblConsultorioxdiasfestivos> tblConsultorioxdiasfestivosList) {
        this.tblConsultorioxdiasfestivosList = tblConsultorioxdiasfestivosList;
    }

    @XmlTransient
    public List<TblGaleriaxconsultorio> getTblGaleriaxconsultorioList() {
        return tblGaleriaxconsultorioList;
    }

    public void setTblGaleriaxconsultorioList(List<TblGaleriaxconsultorio> tblGaleriaxconsultorioList) {
        this.tblGaleriaxconsultorioList = tblGaleriaxconsultorioList;
    }

    @XmlTransient
    public List<TblCita> getTblCitaList() {
        return tblCitaList;
    }

    public void setTblCitaList(List<TblCita> tblCitaList) {
        this.tblCitaList = tblCitaList;
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
        hash += (idconsultorio != null ? idconsultorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblConsultorio)) {
            return false;
        }
        TblConsultorio other = (TblConsultorio) object;
        if ((this.idconsultorio == null && other.idconsultorio != null) || (this.idconsultorio != null && !this.idconsultorio.equals(other.idconsultorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infomedic.entity.TblConsultorio[ idconsultorio=" + idconsultorio + " ]";
    }
    
}
