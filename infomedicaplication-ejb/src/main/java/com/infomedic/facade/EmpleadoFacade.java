/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.facade;

import com.infomedic.entity.TblEmpleado;
import com.infomedic.entity.TblTipoempleado;
import com.infomedic.forms.EmpleadoForm;
import com.infomedic.forms.EspecialidadForm;
import com.infomedic.utily.facade.AbstractFacade;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LAP
 */
@Stateless
public class EmpleadoFacade extends AbstractFacade<TblEmpleado, EmpleadoForm> {

    @PersistenceContext(unitName = "infomedicPU")
    private EntityManager em;
    
    private @Getter @Setter TblEmpleado empleado;
    
    private @Getter @Setter TblTipoempleado tipoEmpleado;

    public EmpleadoFacade() {
        super(TblEmpleado.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<EmpleadoForm> obtenerEmpleados() {
        Query q= getEntityManager().createNativeQuery("select * from tbl_empleado where estadoempleado='A'", TblEmpleado.class);
        List<TblEmpleado> listaTmpEmp;
        List<EmpleadoForm> listaTmpEmpForm;
        
        try {
            listaTmpEmp = q.getResultList();
            if(listaTmpEmp.isEmpty()) {
                listaTmpEmpForm = new ArrayList<EmpleadoForm>();
            } else {
                listaTmpEmpForm = this.entityToDtoList(listaTmpEmp, new EmpleadoForm());
            }
        } catch(Exception ex) {
           listaTmpEmpForm =  new ArrayList<EmpleadoForm>();
        }
        
        return listaTmpEmpForm;
    }

    public boolean agregarEmpleado(EmpleadoForm empf) {
        
        boolean flag = true;
        try {
            if (empf == null) {
                flag = false;
            } else if (empf.getIdempleado() == null) {
                TblEmpleado emp = new TblEmpleado();
                emp=setValores(emp, empf);
                create(emp);
                setEmpleado(buscarEmpleado(emp.getDuiempleado(), emp.getNitempleado()));
                /*
                espec.setNombreespecialidad(espForm.getNombreEspecialidad().toUpperCase());
                this.create(espec);
                 */
            } else {
                TblEmpleado emp= buscarEmpleado(empf.getDuiempleado(), empf.getNitempleado());
                emp=setValores(emp, empf);
                edit(emp);
                setEmpleado(emp);
                /*
                TblEspecialidad spec = find(new BigDecimal(espForm.getIdEspecialidad()));
                spec.setNombreespecialidad(espForm.getNombreEspecialidad().toUpperCase());
                this.edit(spec);
                 */
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            flag = false;
        }

        return flag;
    }

    public TblEmpleado setValores(TblEmpleado entity, EmpleadoForm dto) {
        entity.setNombreempleado(dto.getNombreempleado().toUpperCase());
        entity.setApellidoempleado(dto.getApellidoempleado().toUpperCase());
        entity.setDuiempleado(dto.getDuiempleado());
        entity.setNitempleado(dto.getNitempleado());
        entity.setIdtipoempleado(tipoEmpleado);
        //Cambiar despues el id del usuario
        entity.setIdusuario(BigInteger.ONE);
        entity.setDescripcionempleado(dto.getDescripcionempleado());
        entity.setDireccionempleado(dto.getDireccionempleado());
        entity.setGeneroempleado(dto.getGeneroempleado().toUpperCase().charAt(0));
        entity.setEstadoempleado('A');
        //Cambiar despues el id de la compania
        entity.setIdcompany(BigInteger.ONE);
        entity.setNumeroisssempleado("");
        entity.setFechanacimientoempleado(convertirFecha(dto.getFechanacimientoempleado()));
        entity.setFechainicio(convertirFecha(dto.getFechainicio()));
        return entity;
    }
    public TblEmpleado buscarEmpleado(String dui, String nit){
        Query q= getEntityManager().createNativeQuery("select * from tbl_empleado where duiempleado=?", TblEmpleado.class);
        q.setParameter(1, dui);
        //q.setParameter(2, nit);
        List<TblEmpleado> temp= q.getResultList();
        return temp.isEmpty()?new TblEmpleado():temp.get(0);
    }

    public java.sql.Date convertirFecha(String fecha) {
        java.sql.Date fechasql = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date parsed = format.parse(fecha);
            fechasql = new java.sql.Date(parsed.getTime());
        } catch (ParseException ext) {

        }
        return fechasql;
    }

}
