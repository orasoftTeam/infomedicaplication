/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.entity;

import com.infomedic.forms.UserForm;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LAP
 */
@Entity
@Table(name = "TBL_FORMACIONSUPERIOR")

@SqlResultSetMapping(
        name = "UserMapping",
        classes = @ConstructorResult(
                targetClass = UserForm.class,
                columns = {
                    @ColumnResult(name = "idusuario", type = String.class),
                    @ColumnResult(name = "nombre", type = String.class),
                    @ColumnResult(name = "pass", type = String.class),
                @ColumnResult(name = "email", type = String.class),
                @ColumnResult(name = "nombrecompany", type = String.class),
                @ColumnResult(name = "idcompany", type = String.class),
                @ColumnResult(name = "idrol", type = String.class)}))

@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblFormacionsuperior.findAll", query = "SELECT t FROM TblFormacionsuperior t"),
    @NamedQuery(name = "TblFormacionsuperior.findByIdformaaca", query = "SELECT t FROM TblFormacionsuperior t WHERE t.idformaaca = :idformaaca"),
    @NamedQuery(name = "TblFormacionsuperior.findByConceptoestudio", query = "SELECT t FROM TblFormacionsuperior t WHERE t.conceptoestudio = :conceptoestudio"),
    @NamedQuery(name = "TblFormacionsuperior.findByInstitucionestudio", query = "SELECT t FROM TblFormacionsuperior t WHERE t.institucionestudio = :institucionestudio"),
    @NamedQuery(name = "TblFormacionsuperior.findByAnioestudio", query = "SELECT t FROM TblFormacionsuperior t WHERE t.anioestudio = :anioestudio")})
public class TblFormacionsuperior implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDFORMAACA")
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "EMPFORMACION_SEQ")
    @SequenceGenerator(name = "EMPFORMACION_SEQ", sequenceName = "SQE_IDFORMACIONEMP", allocationSize = 1)
    private BigDecimal idformaaca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CONCEPTOESTUDIO")
    private String conceptoestudio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "INSTITUCIONESTUDIO")
    private String institucionestudio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ANIOESTUDIO")
    private String anioestudio;
    @JoinColumn(name = "IDEMPLEADO", referencedColumnName = "IDEMPLEADO")
    @ManyToOne(optional = false)
    private TblEmpleado idempleado;

    public TblFormacionsuperior() {
    }

    public TblFormacionsuperior(BigDecimal idformaaca) {
        this.idformaaca = idformaaca;
    }

    public TblFormacionsuperior(BigDecimal idformaaca, String conceptoestudio, String institucionestudio, String anioestudio) {
        this.idformaaca = idformaaca;
        this.conceptoestudio = conceptoestudio;
        this.institucionestudio = institucionestudio;
        this.anioestudio = anioestudio;
    }

    public BigDecimal getIdformaaca() {
        return idformaaca;
    }

    public void setIdformaaca(BigDecimal idformaaca) {
        this.idformaaca = idformaaca;
    }

    public String getConceptoestudio() {
        return conceptoestudio;
    }

    public void setConceptoestudio(String conceptoestudio) {
        this.conceptoestudio = conceptoestudio;
    }

    public String getInstitucionestudio() {
        return institucionestudio;
    }

    public void setInstitucionestudio(String institucionestudio) {
        this.institucionestudio = institucionestudio;
    }

    public String getAnioestudio() {
        return anioestudio;
    }

    public void setAnioestudio(String anioestudio) {
        this.anioestudio = anioestudio;
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
        hash += (idformaaca != null ? idformaaca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblFormacionsuperior)) {
            return false;
        }
        TblFormacionsuperior other = (TblFormacionsuperior) object;
        if ((this.idformaaca == null && other.idformaaca != null) || (this.idformaaca != null && !this.idformaaca.equals(other.idformaaca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.pruebainsert.TblFormacionsuperior[ idformaaca=" + idformaaca + " ]";
    }
    
}
