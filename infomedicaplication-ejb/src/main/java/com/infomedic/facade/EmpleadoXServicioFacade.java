/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.facade;

import com.infomedic.entity.TblEmpleado;
import com.infomedic.entity.TblEmpleadoxservicio;
import com.infomedic.forms.EmpleadoServicioForm;
import com.infomedic.utily.facade.AbstractFacade;
import java.math.BigInteger;
import java.util.ArrayList;
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
public class EmpleadoXServicioFacade extends AbstractFacade<TblEmpleadoxservicio, EmpleadoServicioForm>{
    @PersistenceContext(unitName = "infomedicPU")
    private EntityManager em;
    
    private @Getter @Setter TblEmpleado empleado;
    
    public EmpleadoXServicioFacade(){
        super(TblEmpleadoxservicio.class);
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public boolean agregarServicioEmp(EmpleadoServicioForm serv) {
        
        boolean flag = true;
        try {
            if (serv == null) {
                flag = false;
            } else if (serv.getIdempleadoxservicio() == null) {
                TblEmpleadoxservicio empServ= new TblEmpleadoxservicio();
                empServ.setIdempleado(empleado);
                empServ.setIdservicio(new BigInteger(serv.getIdservicio()));
                empServ.setEstadoservicio('A');
                create(empServ);
                /*
                espec.setNombreespecialidad(espForm.getNombreEspecialidad().toUpperCase());
                this.create(espec);
                 */
            } else {
                TblEmpleadoxservicio empServ= findById(serv.getIdempleadoxservicio());
                empServ.setIdempleado(empleado);
                empServ.setIdservicio(new BigInteger(serv.getIdservicio()));
                empServ.setEstadoservicio('I');
                //empServ.setEstadoservicio(serv.getEstadoservicio().charAt(0));
                edit(empServ);
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
    
    public List<EmpleadoServicioForm> getAll() {
        List<TblEmpleadoxservicio> listaTmpEmpServ;
        List<EmpleadoServicioForm> listaTmpEmpServForm;
        
        try {
            listaTmpEmpServ = findByIdEmp(empleado.getIdempleado().toString());
            if(listaTmpEmpServ.isEmpty()) {
                listaTmpEmpServForm = new ArrayList<EmpleadoServicioForm>();
            } else {
                listaTmpEmpServForm = this.entityToDtoList(listaTmpEmpServ, new EmpleadoServicioForm());
            }
        } catch(Exception ex) {
           listaTmpEmpServForm =  new ArrayList<EmpleadoServicioForm>();
        }
        
        return listaTmpEmpServForm;
    }
    
    public List<EmpleadoServicioForm> getByIdEmpServ(String idempleado, String idservicio) {
        List<TblEmpleadoxservicio> listaTmpEmpServ;
        List<EmpleadoServicioForm> listaTmpEmpServForm;
        
        try {
            listaTmpEmpServ = findByIdEmpServ(idempleado, idservicio);
            if(listaTmpEmpServ.isEmpty()) {
                listaTmpEmpServForm = new ArrayList<EmpleadoServicioForm>();
            } else {
                listaTmpEmpServForm = this.entityToDtoList(listaTmpEmpServ, new EmpleadoServicioForm());
            }
        } catch(Exception ex) {
           listaTmpEmpServForm =  new ArrayList<EmpleadoServicioForm>();
        }
        
        return listaTmpEmpServForm;
    }
    
    public TblEmpleadoxservicio findById(String idempleadoxservicio){
        Query q= getEntityManager().createNativeQuery("select * from tbl_empleadoxservicio where idempleadoxservicio=? and estadoservicio='A'", TblEmpleadoxservicio.class);
        q.setParameter(1, idempleadoxservicio);
        //q.setParameter(2, nit);
        List<TblEmpleadoxservicio> temp= q.getResultList();
        return temp.isEmpty()?new TblEmpleadoxservicio():temp.get(0);
    }
    
    public List<TblEmpleadoxservicio> findByIdEmp(String idempleado){
        Query q= getEntityManager().createNativeQuery("select * from tbl_empleadoxservicio where idempleado=? and estadoservicio='A'", TblEmpleadoxservicio.class);
        q.setParameter(1, idempleado);
        //q.setParameter(2, nit);
        List<TblEmpleadoxservicio> temp= q.getResultList();
        return temp.isEmpty()?new ArrayList<TblEmpleadoxservicio>():temp;
    }
    
    public List<TblEmpleadoxservicio> findByIdEmpServ(String idempleado, String idservicio){
        Query q= getEntityManager().createNativeQuery("select * from tbl_empleadoxservicio where idempleado=? and idservicio=? and estadoservicio='A'", TblEmpleadoxservicio.class);
        q.setParameter(1, idempleado);
        q.setParameter(2, idservicio);
        //q.setParameter(2, nit);
        List<TblEmpleadoxservicio> temp= q.getResultList();
        return temp.isEmpty()?new ArrayList<TblEmpleadoxservicio>():temp;
    }
}
