/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
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
@Table(name = "TBL_PACIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPaciente.findAll", query = "SELECT t FROM TblPaciente t"),
    @NamedQuery(name = "TblPaciente.findByIdpaciente", query = "SELECT t FROM TblPaciente t WHERE t.idpaciente = :idpaciente"),
    @NamedQuery(name = "TblPaciente.findByIdusuario", query = "SELECT t FROM TblPaciente t WHERE t.idusuario = :idusuario"),
    @NamedQuery(name = "TblPaciente.findByNombrepaciente", query = "SELECT t FROM TblPaciente t WHERE t.nombrepaciente = :nombrepaciente"),
    @NamedQuery(name = "TblPaciente.findByApellidospaciente", query = "SELECT t FROM TblPaciente t WHERE t.apellidospaciente = :apellidospaciente"),
    @NamedQuery(name = "TblPaciente.findByDireccionpaciente", query = "SELECT t FROM TblPaciente t WHERE t.direccionpaciente = :direccionpaciente"),
    @NamedQuery(name = "TblPaciente.findByFechanacimientopaciente", query = "SELECT t FROM TblPaciente t WHERE t.fechanacimientopaciente = :fechanacimientopaciente"),
    @NamedQuery(name = "TblPaciente.findByGeneropaciente", query = "SELECT t FROM TblPaciente t WHERE t.generopaciente = :generopaciente"),
    @NamedQuery(name = "TblPaciente.findByEstadocivilpaciente", query = "SELECT t FROM TblPaciente t WHERE t.estadocivilpaciente = :estadocivilpaciente"),
    @NamedQuery(name = "TblPaciente.findByNombrepadrepaciente", query = "SELECT t FROM TblPaciente t WHERE t.nombrepadrepaciente = :nombrepadrepaciente"),
    @NamedQuery(name = "TblPaciente.findByNombremadrepaciente", query = "SELECT t FROM TblPaciente t WHERE t.nombremadrepaciente = :nombremadrepaciente"),
    @NamedQuery(name = "TblPaciente.findByNombreparejapaciente", query = "SELECT t FROM TblPaciente t WHERE t.nombreparejapaciente = :nombreparejapaciente"),
    @NamedQuery(name = "TblPaciente.findByOcupacionpaciente", query = "SELECT t FROM TblPaciente t WHERE t.ocupacionpaciente = :ocupacionpaciente"),
    @NamedQuery(name = "TblPaciente.findByCorreopaciente", query = "SELECT t FROM TblPaciente t WHERE t.correopaciente = :correopaciente"),
    @NamedQuery(name = "TblPaciente.findByNumissspaciente", query = "SELECT t FROM TblPaciente t WHERE t.numissspaciente = :numissspaciente"),
    @NamedQuery(name = "TblPaciente.findByLugarnacimientopaciente", query = "SELECT t FROM TblPaciente t WHERE t.lugarnacimientopaciente = :lugarnacimientopaciente"),
    @NamedQuery(name = "TblPaciente.findByNumeroduipaciente", query = "SELECT t FROM TblPaciente t WHERE t.numeroduipaciente = :numeroduipaciente"),
    @NamedQuery(name = "TblPaciente.findByEstadopaciente", query = "SELECT t FROM TblPaciente t WHERE t.estadopaciente = :estadopaciente"),
    @NamedQuery(name = "TblPaciente.findByNombreresponsable", query = "SELECT t FROM TblPaciente t WHERE t.nombreresponsable = :nombreresponsable")})
public class TblPaciente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "PACIENTE_SEQ")
    @SequenceGenerator(name = "PACIENTE_SEQ", sequenceName = "sqe_idpaciente", allocationSize = 1)
    @Column(name = "IDPACIENTE")
    private BigDecimal idpaciente;
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "IDUSUARIO")
    private BigInteger idusuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBREPACIENTE")
    private String nombrepaciente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "APELLIDOSPACIENTE")
    private String apellidospaciente;
    //@Basic(optional = false)
    //@NotNull
   // @Size(min = 0, max = 255)
    @Column(name = "DIRECCIONPACIENTE")
    private String direccionpaciente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHANACIMIENTOPACIENTE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechanacimientopaciente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GENEROPACIENTE")
    private Character generopaciente;
    @Size(max = 15)
    @Column(name = "ESTADOCIVILPACIENTE")
    private String estadocivilpaciente;
    @Size(max = 100)
    @Column(name = "NOMBREPADREPACIENTE")
    private String nombrepadrepaciente;
    @Size(max = 100)
    @Column(name = "NOMBREMADREPACIENTE")
    private String nombremadrepaciente;
    @Size(max = 100)
    @Column(name = "NOMBREPAREJAPACIENTE")
    private String nombreparejapaciente;
    //@Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 50)
    @Column(name = "OCUPACIONPACIENTE")
    private String ocupacionpaciente;
    @Size(max = 70)
    @Column(name = "CORREOPACIENTE")
    private String correopaciente;
    @Size(max = 9)
    @Column(name = "NUMISSSPACIENTE")
    private String numissspaciente;
    //@Basic(optional = false)
    //@NotNull
   // @Size(min = 1, max = 255)
    @Column(name = "LUGARNACIMIENTOPACIENTE")
    private String lugarnacimientopaciente;
    @Size(max = 10)
    @Column(name = "NUMERODUIPACIENTE")
    private String numeroduipaciente;
    //@Basic(optional = false)
    //@NotNull
    
    @Column(name = "ESTADOPACIENTE")
    private Character estadopaciente;
    @Size(max = 100)
    @Column(name = "NOMBRERESPONSABLE")
    private String nombreresponsable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpaciente")
    private List<TblExpediente> tblExpedienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpaciente")
    private List<TblTelefonoxpaciente> tblTelefonoxpacienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpaciente")
    private List<TblCita> tblCitaList;

    public TblPaciente() {
    }

    public TblPaciente(BigDecimal idpaciente) {
        this.idpaciente = idpaciente;
    }

    public TblPaciente(BigDecimal idpaciente, BigInteger idusuario, String nombrepaciente, String apellidospaciente, String direccionpaciente, Date fechanacimientopaciente, Character generopaciente, String ocupacionpaciente, String lugarnacimientopaciente, Character estadopaciente) {
        this.idpaciente = idpaciente;
        this.idusuario = idusuario;
        this.nombrepaciente = nombrepaciente;
        this.apellidospaciente = apellidospaciente;
        this.direccionpaciente = direccionpaciente;
        this.fechanacimientopaciente = fechanacimientopaciente;
        this.generopaciente = generopaciente;
        this.ocupacionpaciente = ocupacionpaciente;
        this.lugarnacimientopaciente = lugarnacimientopaciente;
        this.estadopaciente = estadopaciente;
    }

    public BigDecimal getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(BigDecimal idpaciente) {
        this.idpaciente = idpaciente;
    }

    public BigInteger getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(BigInteger idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombrepaciente() {
        return nombrepaciente;
    }

    public void setNombrepaciente(String nombrepaciente) {
        this.nombrepaciente = nombrepaciente;
    }

    public String getApellidospaciente() {
        return apellidospaciente;
    }

    public void setApellidospaciente(String apellidospaciente) {
        this.apellidospaciente = apellidospaciente;
    }

    public String getDireccionpaciente() {
        return direccionpaciente;
    }

    public void setDireccionpaciente(String direccionpaciente) {
        this.direccionpaciente = direccionpaciente;
    }

    public Date getFechanacimientopaciente() {
        return fechanacimientopaciente;
    }

    public void setFechanacimientopaciente(Date fechanacimientopaciente) {
        this.fechanacimientopaciente = fechanacimientopaciente;
    }

    public Character getGeneropaciente() {
        return generopaciente;
    }

    public void setGeneropaciente(Character generopaciente) {
        this.generopaciente = generopaciente;
    }

    public String getEstadocivilpaciente() {
        return estadocivilpaciente;
    }

    public void setEstadocivilpaciente(String estadocivilpaciente) {
        this.estadocivilpaciente = estadocivilpaciente;
    }

    public String getNombrepadrepaciente() {
        return nombrepadrepaciente;
    }

    public void setNombrepadrepaciente(String nombrepadrepaciente) {
        this.nombrepadrepaciente = nombrepadrepaciente;
    }

    public String getNombremadrepaciente() {
        return nombremadrepaciente;
    }

    public void setNombremadrepaciente(String nombremadrepaciente) {
        this.nombremadrepaciente = nombremadrepaciente;
    }

    public String getNombreparejapaciente() {
        return nombreparejapaciente;
    }

    public void setNombreparejapaciente(String nombreparejapaciente) {
        this.nombreparejapaciente = nombreparejapaciente;
    }

    public String getOcupacionpaciente() {
        return ocupacionpaciente;
    }

    public void setOcupacionpaciente(String ocupacionpaciente) {
        this.ocupacionpaciente = ocupacionpaciente;
    }

    public String getCorreopaciente() {
        return correopaciente;
    }

    public void setCorreopaciente(String correopaciente) {
        this.correopaciente = correopaciente;
    }

    public String getNumissspaciente() {
        return numissspaciente;
    }

    public void setNumissspaciente(String numissspaciente) {
        this.numissspaciente = numissspaciente;
    }

    public String getLugarnacimientopaciente() {
        return lugarnacimientopaciente;
    }

    public void setLugarnacimientopaciente(String lugarnacimientopaciente) {
        this.lugarnacimientopaciente = lugarnacimientopaciente;
    }

    public String getNumeroduipaciente() {
        return numeroduipaciente;
    }

    public void setNumeroduipaciente(String numeroduipaciente) {
        this.numeroduipaciente = numeroduipaciente;
    }

    public Character getEstadopaciente() {
        return estadopaciente;
    }

    public void setEstadopaciente(Character estadopaciente) {
        this.estadopaciente = estadopaciente;
    }

    public String getNombreresponsable() {
        return nombreresponsable;
    }

    public void setNombreresponsable(String nombreresponsable) {
        this.nombreresponsable = nombreresponsable;
    }

    @XmlTransient
    public List<TblExpediente> getTblExpedienteList() {
        return tblExpedienteList;
    }

    public void setTblExpedienteList(List<TblExpediente> tblExpedienteList) {
        this.tblExpedienteList = tblExpedienteList;
    }

    @XmlTransient
    public List<TblTelefonoxpaciente> getTblTelefonoxpacienteList() {
        return tblTelefonoxpacienteList;
    }

    public void setTblTelefonoxpacienteList(List<TblTelefonoxpaciente> tblTelefonoxpacienteList) {
        this.tblTelefonoxpacienteList = tblTelefonoxpacienteList;
    }

    @XmlTransient
    public List<TblCita> getTblCitaList() {
        return tblCitaList;
    }

    public void setTblCitaList(List<TblCita> tblCitaList) {
        this.tblCitaList = tblCitaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpaciente != null ? idpaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPaciente)) {
            return false;
        }
        TblPaciente other = (TblPaciente) object;
        if ((this.idpaciente == null && other.idpaciente != null) || (this.idpaciente != null && !this.idpaciente.equals(other.idpaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.pruebainsert.TblPaciente[ idpaciente=" + idpaciente + " ]";
    }
    
}
