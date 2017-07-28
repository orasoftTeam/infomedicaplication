/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.facade;

import com.infomedic.entity.TblEmpleado;
import com.infomedic.entity.TblFormacionsuperior;
import com.infomedic.entity.TblTelefonoxempleado;
import com.infomedic.forms.FormacionProfesionalForm;
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
public class FormacionEmpleadoFacade extends AbstractFacade<TblFormacionsuperior, FormacionProfesionalForm>{
    @PersistenceContext(unitName = "infomedicPU")
    private EntityManager em;
    
    private @Getter @Setter TblEmpleado empleado;

    public FormacionEmpleadoFacade() {
        super(TblFormacionsuperior.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

     public boolean agregarFormacion(List<FormacionProfesionalForm> lista){
        Query q= getEntityManager().createNativeQuery("select * from tbl_formacionsuperior where idempleado=?", TblFormacionsuperior.class);
        q.setParameter(1, (empleado.getIdempleado()));
        boolean flag=true;
        actualizarLista(q.getResultList(), lista);
        try{
        for(FormacionProfesionalForm obj: lista){
            if(obj.getIdformaaca()==null){
                TblFormacionsuperior femp= new TblFormacionsuperior();
                femp.setIdempleado(empleado);
                femp.setInstitucionestudio(obj.getInstitucionestudio());
                femp.setConceptoestudio(obj.getConceptoestudio());
                femp.setAnioestudio(obj.getAnioestudio());
                create(femp);
            }
            else{
               TblFormacionsuperior femp = find(new BigDecimal(obj.getIdformaaca()));
                femp.setIdempleado(empleado);
                femp.setInstitucionestudio(obj.getInstitucionestudio());
                femp.setConceptoestudio(obj.getConceptoestudio());
                femp.setAnioestudio(obj.getAnioestudio());
                edit(femp);
            }
        }
        }catch(Exception ex){
            flag=false;
        }
       return flag;         
    }
     
    public List<FormacionProfesionalForm> findByIdEmp(String id){
        Query q= getEntityManager().createNativeQuery("select * from tbl_formacionsuperior where idempleado=?", TblFormacionsuperior.class);
        q.setParameter(1, new BigDecimal(id));
        List<TblFormacionsuperior> lisForm= q.getResultList();
        List<FormacionProfesionalForm> listaTelForm;
        try {
            if(lisForm.isEmpty()) {
                listaTelForm = new ArrayList<FormacionProfesionalForm>();
            } else {
                listaTelForm = this.entityToDtoList(lisForm, new FormacionProfesionalForm());
            }
        } catch(Exception ex) {
           listaTelForm =  new ArrayList<FormacionProfesionalForm>();
        }
        
        return listaTelForm;
    }
    
    public void actualizarLista(List<TblFormacionsuperior> listaEmp, List<FormacionProfesionalForm> lista){
        if(lista.isEmpty() && listaEmp!=null){
            for(TblFormacionsuperior obj: listaEmp){
                remove(obj);
            }
        }
        else{
             for(TblFormacionsuperior obj: listaEmp){
                 if(!isEliminar(obj.getIdformaaca().toString(), lista))
                        remove(obj);
            }
        }
    }
    
    public boolean isEliminar(String idTel, List<FormacionProfesionalForm> lista){
        boolean flag=false;
        for(FormacionProfesionalForm obj: lista){
            if(idTel.equals(obj.getIdformaaca())){
                flag=true;
            }
        }
        return flag;
    }
}
