/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LAP
 */
@Entity
@Table(name = "TBL_EXPLABOEMPLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblExplaboemple.findAll", query = "SELECT t FROM TblExplaboemple t"),
    @NamedQuery(name = "TblExplaboemple.findByIdexpelaboemple", query = "SELECT t FROM TblExplaboemple t WHERE t.idexpelaboemple = :idexpelaboemple"),
    @NamedQuery(name = "TblExplaboemple.findByCargoexpempleado", query = "SELECT t FROM TblExplaboemple t WHERE t.cargoexpempleado = :cargoexpempleado"),
    @NamedQuery(name = "TblExplaboemple.findByNombreexpelaboral", query = "SELECT t FROM TblExplaboemple t WHERE t.nombreexpelaboral = :nombreexpelaboral"),
    @NamedQuery(name = "TblExplaboemple.findByAnioiniexper", query = "SELECT t FROM TblExplaboemple t WHERE t.anioiniexper = :anioiniexper"),
    @NamedQuery(name = "TblExplaboemple.findByAniofinexper", query = "SELECT t FROM TblExplaboemple t WHERE t.aniofinexper = :aniofinexper"),
    @NamedQuery(name = "TblExplaboemple.findByDepexplaboral", query = "SELECT t FROM TblExplaboemple t WHERE t.depexplaboral = :depexplaboral"),
    @NamedQuery(name = "TblExplaboemple.findByMunexplaboral", query = "SELECT t FROM TblExplaboemple t WHERE t.munexplaboral = :munexplaboral"),
    @NamedQuery(name = "TblExplaboemple.findByPaisexplaboral", query = "SELECT t FROM TblExplaboemple t WHERE t.paisexplaboral = :paisexplaboral")})
public class TblExplaboemple implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDEXPELABOEMPLE")
    private BigDecimal idexpelaboemple;
    @Size(max = 50)
    @Column(name = "CARGOEXPEMPLEADO")
    private String cargoexpempleado;
    @Size(max = 255)
    @Column(name = "NOMBREEXPELABORAL")
    private String nombreexpelaboral;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ANIOINIEXPER")
    private String anioiniexper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ANIOFINEXPER")
    private String aniofinexper;
    @Size(max = 25)
    @Column(name = "DEPEXPLABORAL")
    private String depexplaboral;
    @Size(max = 25)
    @Column(name = "MUNEXPLABORAL")
    private String munexplaboral;
    @Size(max = 25)
    @Column(name = "PAISEXPLABORAL")
    private String paisexplaboral;
    @JoinColumn(name = "IDEMPLEADO", referencedColumnName = "IDEMPLEADO")
    @ManyToOne(optional = false)
    private TblEmpleado idempleado;

    public TblExplaboemple() {
    }

    public TblExplaboemple(BigDecimal idexpelaboemple) {
        this.idexpelaboemple = idexpelaboemple;
    }

    public TblExplaboemple(BigDecimal idexpelaboemple, String anioiniexper, String aniofinexper) {
        this.idexpelaboemple = idexpelaboemple;
        this.anioiniexper = anioiniexper;
        this.aniofinexper = aniofinexper;
    }

    public BigDecimal getIdexpelaboemple() {
        return idexpelaboemple;
    }

    public void setIdexpelaboemple(BigDecimal idexpelaboemple) {
        this.idexpelaboemple = idexpelaboemple;
    }

    public String getCargoexpempleado() {
        return cargoexpempleado;
    }

    public void setCargoexpempleado(String cargoexpempleado) {
        this.cargoexpempleado = cargoexpempleado;
    }

    public String getNombreexpelaboral() {
        return nombreexpelaboral;
    }

    public void setNombreexpelaboral(String nombreexpelaboral) {
        this.nombreexpelaboral = nombreexpelaboral;
    }

    public String getAnioiniexper() {
        return anioiniexper;
    }

    public void setAnioiniexper(String anioiniexper) {
        this.anioiniexper = anioiniexper;
    }

    public String getAniofinexper() {
        return aniofinexper;
    }

    public void setAniofinexper(String aniofinexper) {
        this.aniofinexper = aniofinexper;
    }

    public String getDepexplaboral() {
        return depexplaboral;
    }

    public void setDepexplaboral(String depexplaboral) {
        this.depexplaboral = depexplaboral;
    }

    public String getMunexplaboral() {
        return munexplaboral;
    }

    public void setMunexplaboral(String munexplaboral) {
        this.munexplaboral = munexplaboral;
    }

    public String getPaisexplaboral() {
        return paisexplaboral;
    }

    public void setPaisexplaboral(String paisexplaboral) {
        this.paisexplaboral = paisexplaboral;
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
        hash += (idexpelaboemple != null ? idexpelaboemple.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblExplaboemple)) {
            return false;
        }
        TblExplaboemple other = (TblExplaboemple) object;
        if ((this.idexpelaboemple == null && other.idexpelaboemple != null) || (this.idexpelaboemple != null && !this.idexpelaboemple.equals(other.idexpelaboemple))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infomedic.entity.TblExplaboemple[ idexpelaboemple=" + idexpelaboemple + " ]";
    }
    
}
