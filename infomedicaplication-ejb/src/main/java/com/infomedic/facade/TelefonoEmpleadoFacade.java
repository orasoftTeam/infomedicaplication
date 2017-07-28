/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.facade;

import com.infomedic.entity.TblEmpleado;
import com.infomedic.entity.TblTelefonoxempleado;
import com.infomedic.forms.TelefonoXEmpleadoForm;
import com.infomedic.utily.facade.AbstractFacade;
import java.math.BigDecimal;
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
public class TelefonoEmpleadoFacade extends AbstractFacade<TblTelefonoxempleado, TelefonoXEmpleadoForm>{
    @PersistenceContext(unitName = "infomedicPU")
    private EntityManager em;
    
    private @Getter @Setter TblEmpleado empleado;

    public TelefonoEmpleadoFacade() {
        super(TblTelefonoxempleado.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 
    
    public boolean agregarTelefonoEmpleado(List<TelefonoXEmpleadoForm> lista){
        Query q= getEntityManager().createNativeQuery("select * from tbl_telefonoxempleado where idempleado=?", TblTelefonoxempleado.class);
        q.setParameter(1, (empleado.getIdempleado()));
        boolean flag=true;
        actualizarLista(q.getResultList(), lista);
        try{
        for(TelefonoXEmpleadoForm obj: lista){
            if(obj.getIdtelefonoxempleado()==null){
                TblTelefonoxempleado txe= new TblTelefonoxempleado();
                txe.setIdempleado(empleado);
                txe.setNumerotelefono(obj.getNumerotelefono());
                create(txe);
                
            }
            else{
               TblTelefonoxempleado txe = find(new BigDecimal(obj.getIdtelefonoxempleado()));
               txe.setNumerotelefono(obj.getNumerotelefono());
                edit(txe);
            }
        }
        }catch(Exception ex){
            flag=false;
        }
       return flag;         
    }
    
    public List<TelefonoXEmpleadoForm> findByIdEmp(String id){
        Query q= getEntityManager().createNativeQuery("select * from tbl_telefonoxempleado where idempleado=?", TblTelefonoxempleado.class);
        q.setParameter(1, new BigDecimal(id));
        List<TblTelefonoxempleado> lisTel= q.getResultList();
        List<TelefonoXEmpleadoForm> listaTelForm;
        try {
            if(lisTel.isEmpty()) {
                listaTelForm = new ArrayList<TelefonoXEmpleadoForm>();
            } else {
                listaTelForm = this.entityToDtoList(lisTel, new TelefonoXEmpleadoForm());
            }
        } catch(Exception ex) {
           listaTelForm =  new ArrayList<TelefonoXEmpleadoForm>();
        }
        
        return listaTelForm;
    }
    
    
    public void actualizarLista(List<TblTelefonoxempleado> listaEmp, List<TelefonoXEmpleadoForm> lista){
        if(lista.isEmpty() && listaEmp!=null){
            for(TblTelefonoxempleado obj: listaEmp){
                remove(obj);
            }
        }
        else{
             for(TblTelefonoxempleado obj: listaEmp){
                 if(!isEliminar(obj.getNumerotelefono(), lista))
                        remove(obj);
            }
        }
    }
    
    public boolean isEliminar(String idTel, List<TelefonoXEmpleadoForm> lista){
        boolean flag=false;
        for(TelefonoXEmpleadoForm obj: lista){
            if(idTel.equals(obj.getNumerotelefono())){
                flag=true;
            }
        }
        return flag;
    }
}
