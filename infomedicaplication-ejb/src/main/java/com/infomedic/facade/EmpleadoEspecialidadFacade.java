/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.facade;

import com.infomedic.entity.TblEmpleado;
import com.infomedic.entity.TblEmpleadoxespecialidad;
import com.infomedic.entity.TblEspecialidad;
import com.infomedic.forms.GenericForm;
import com.infomedic.utily.facade.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LAP
 */
@Stateless
public class EmpleadoEspecialidadFacade extends AbstractFacade<TblEmpleadoxespecialidad, GenericForm> {

    @PersistenceContext(unitName = "infomedicPU")
    private EntityManager em;
    
    private @Getter @Setter TblEspecialidad especialidad;
    private @Getter @Setter TblEmpleado empleado;

    public EmpleadoEspecialidadFacade() {
        super(TblEmpleadoxespecialidad.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public boolean agregarEmpleadoEspecialidad(){
        boolean flag=true;
        try{
            List<TblEmpleadoxespecialidad> esp= empleado.getTblEmpleadoxespecialidadList();
           if(esp!=null && !esp.isEmpty()) {
               TblEmpleadoxespecialidad obj= esp.get(0);
               obj.setIdespecialidad(especialidad);
               edit(obj);
           }
           else{
              TblEmpleadoxespecialidad obj= new TblEmpleadoxespecialidad();
              obj.setIdempleado(empleado);
              obj.setIdespecialidad(especialidad);
               create(obj);
           }
        }
        catch(Exception ex){
            //getEntityManager().getTransaction().rollback();
            flag=false;
        }
        return flag;
    }
}
