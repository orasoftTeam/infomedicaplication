/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.entity;

import com.infomedic.forms.PaisForm;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
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
@Table(name = "TBL_CONSULTA")

@SqlResultSetMapping(
        name = "PaisMapping",
        classes = @ConstructorResult(
                targetClass = PaisForm.class,
                columns = {
                    @ColumnResult(name = "idpais", type = String.class),
                    @ColumnResult(name = "nombrepais", type = String.class)/*,
                    @ColumnResult(name = "producto", type = String.class)*/}))

@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblConsulta.findAll", query = "SELECT t FROM TblConsulta t"),
    @NamedQuery(name = "TblConsulta.findByIdconsulta", query = "SELECT t FROM TblConsulta t WHERE t.idconsulta = :idconsulta"),
    @NamedQuery(name = "TblConsulta.findByFechaconsulta", query = "SELECT t FROM TblConsulta t WHERE t.fechaconsulta = :fechaconsulta"),
    @NamedQuery(name = "TblConsulta.findByHoraconsulta", query = "SELECT t FROM TblConsulta t WHERE t.horaconsulta = :horaconsulta"),
    @NamedQuery(name = "TblConsulta.findByPesopaciente", query = "SELECT t FROM TblConsulta t WHERE t.pesopaciente = :pesopaciente"),
    @NamedQuery(name = "TblConsulta.findByAlturapaciente", query = "SELECT t FROM TblConsulta t WHERE t.alturapaciente = :alturapaciente"),
    @NamedQuery(name = "TblConsulta.findByTemperaturapaciente", query = "SELECT t FROM TblConsulta t WHERE t.temperaturapaciente = :temperaturapaciente"),
    @NamedQuery(name = "TblConsulta.findByPresionpaciente", query = "SELECT t FROM TblConsulta t WHERE t.presionpaciente = :presionpaciente"),
    @NamedQuery(name = "TblConsulta.findByAzucarpaciente", query = "SELECT t FROM TblConsulta t WHERE t.azucarpaciente = :azucarpaciente")})
public class TblConsulta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCONSULTA")
    private BigDecimal idconsulta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHACONSULTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaconsulta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORACONSULTA")
    private BigInteger horaconsulta;
    @Size(max = 10)
    @Column(name = "PESOPACIENTE")
    private String pesopaciente;
    @Size(max = 10)
    @Column(name = "ALTURAPACIENTE")
    private String alturapaciente;
    @Size(max = 10)
    @Column(name = "TEMPERATURAPACIENTE")
    private String temperaturapaciente;
    @Size(max = 10)
    @Column(name = "PRESIONPACIENTE")
    private String presionpaciente;
    @Size(max = 10)
    @Column(name = "AZUCARPACIENTE")
    private String azucarpaciente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idconsulta")
    private List<TblResultado> tblResultadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idconsulta")
    private List<TblDocumento> tblDocumentoList;
    @JoinColumn(name = "IDEXPEDIENTE", referencedColumnName = "IDEXPEDIENTE")
    @ManyToOne(optional = false)
    private TblExpediente idexpediente;
    @JoinColumn(name = "IDEMPLEADO", referencedColumnName = "IDEMPLEADO")
    @ManyToOne(optional = false)
    private TblEmpleado idempleado;

    public TblConsulta() {
    }

    public TblConsulta(BigDecimal idconsulta) {
        this.idconsulta = idconsulta;
    }

    public TblConsulta(BigDecimal idconsulta, Date fechaconsulta, BigInteger horaconsulta) {
        this.idconsulta = idconsulta;
        this.fechaconsulta = fechaconsulta;
        this.horaconsulta = horaconsulta;
    }

    public BigDecimal getIdconsulta() {
        return idconsulta;
    }

    public void setIdconsulta(BigDecimal idconsulta) {
        this.idconsulta = idconsulta;
    }

    public Date getFechaconsulta() {
        return fechaconsulta;
    }

    public void setFechaconsulta(Date fechaconsulta) {
        this.fechaconsulta = fechaconsulta;
    }

    public BigInteger getHoraconsulta() {
        return horaconsulta;
    }

    public void setHoraconsulta(BigInteger horaconsulta) {
        this.horaconsulta = horaconsulta;
    }

    public String getPesopaciente() {
        return pesopaciente;
    }

    public void setPesopaciente(String pesopaciente) {
        this.pesopaciente = pesopaciente;
    }

    public String getAlturapaciente() {
        return alturapaciente;
    }

    public void setAlturapaciente(String alturapaciente) {
        this.alturapaciente = alturapaciente;
    }

    public String getTemperaturapaciente() {
        return temperaturapaciente;
    }

    public void setTemperaturapaciente(String temperaturapaciente) {
        this.temperaturapaciente = temperaturapaciente;
    }

    public String getPresionpaciente() {
        return presionpaciente;
    }

    public void setPresionpaciente(String presionpaciente) {
        this.presionpaciente = presionpaciente;
    }

    public String getAzucarpaciente() {
        return azucarpaciente;
    }

    public void setAzucarpaciente(String azucarpaciente) {
        this.azucarpaciente = azucarpaciente;
    }

    @XmlTransient
    public List<TblResultado> getTblResultadoList() {
        return tblResultadoList;
    }

    public void setTblResultadoList(List<TblResultado> tblResultadoList) {
        this.tblResultadoList = tblResultadoList;
    }

    @XmlTransient
    public List<TblDocumento> getTblDocumentoList() {
        return tblDocumentoList;
    }

    public void setTblDocumentoList(List<TblDocumento> tblDocumentoList) {
        this.tblDocumentoList = tblDocumentoList;
    }

    public TblExpediente getIdexpediente() {
        return idexpediente;
    }

    public void setIdexpediente(TblExpediente idexpediente) {
        this.idexpediente = idexpediente;
    }

    public TblEmpleado getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(TblEmpleado idempleado) {
        this.idempleado = idempleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconsulta != null ? idconsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblConsulta)) {
            return false;
        }
        TblConsulta other = (TblConsulta) object;
        if ((this.idconsulta == null && other.idconsulta != null) || (this.idconsulta != null && !this.idconsulta.equals(other.idconsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.pruebainsert.TblConsulta[ idconsulta=" + idconsulta + " ]";
    }
    
}
