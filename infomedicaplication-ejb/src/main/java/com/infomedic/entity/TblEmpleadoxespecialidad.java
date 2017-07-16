/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.entity;

import com.infomedic.forms.PaisForm;
import com.infomedic.forms.TipoServicioForm;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author LAP
 */
@Entity
@Table(name = "TBL_EMPLEADOXESPECIALIDAD")

@SqlResultSetMapping(
        name = "TipoServicioMapping",
        classes = @ConstructorResult(
                targetClass = TipoServicioForm.class,
                columns = {
                    @ColumnResult(name = "idtiposervicio", type = String.class),
                    @ColumnResult(name = "nombretiposervicio", type = String.class)/*,
                    @ColumnResult(name = "producto", type = String.class)*/}))


@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblEmpleadoxespecialidad.findAll", query = "SELECT t FROM TblEmpleadoxespecialidad t"),
    @NamedQuery(name = "TblEmpleadoxespecialidad.findByIdempleadoxespecialidad", query = "SELECT t FROM TblEmpleadoxespecialidad t WHERE t.idempleadoxespecialidad = :idempleadoxespecialidad")})
public class TblEmpleadoxespecialidad implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDEMPLEADOXESPECIALIDAD")
    private BigDecimal idempleadoxespecialidad;
    @JoinColumn(name = "IDESPECIALIDAD", referencedColumnName = "IDESPECIALIDAD")
    @ManyToOne(optional = false)
    private TblEspecialidad idespecialidad;
    @JoinColumn(name = "IDEMPLEADO", referencedColumnName = "IDEMPLEADO")
    @ManyToOne(optional = false)
    private TblEmpleado idempleado;

    public TblEmpleadoxespecialidad() {
    }

    public TblEmpleadoxespecialidad(BigDecimal idempleadoxespecialidad) {
        this.idempleadoxespecialidad = idempleadoxespecialidad;
    }

    public BigDecimal getIdempleadoxespecialidad() {
        return idempleadoxespecialidad;
    }

    public void setIdempleadoxespecialidad(BigDecimal idempleadoxespecialidad) {
        this.idempleadoxespecialidad = idempleadoxespecialidad;
    }

    public TblEspecialidad getIdespecialidad() {
        return idespecialidad;
    }

    public void setIdespecialidad(TblEspecialidad idespecialidad) {
        this.idespecialidad = idespecialidad;
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
        hash += (idempleadoxespecialidad != null ? idempleadoxespecialidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblEmpleadoxespecialidad)) {
            return false;
        }
        TblEmpleadoxespecialidad other = (TblEmpleadoxespecialidad) object;
        if ((this.idempleadoxespecialidad == null && other.idempleadoxespecialidad != null) || (this.idempleadoxespecialidad != null && !this.idempleadoxespecialidad.equals(other.idempleadoxespecialidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.admin.pruebainsert.TblEmpleadoxespecialidad[ idempleadoxespecialidad=" + idempleadoxespecialidad + " ]";
    }
    
}
