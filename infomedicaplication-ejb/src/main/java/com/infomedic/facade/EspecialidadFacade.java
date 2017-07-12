/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.facade;

import com.infomedic.entity.TblEspecialidad;
import com.infomedic.utily.facade.AbstractFacade;
import com.infomedic.forms.EspecialidadForm;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author talkcity
 */
@Stateless
public class EspecialidadFacade extends AbstractFacade<TblEspecialidad, EspecialidadForm> {

    @PersistenceContext(unitName = "infomedicPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EspecialidadFacade() {
        super(TblEspecialidad.class);
    }
    
    public boolean agregarEspecialidad(EspecialidadForm espForm) {
        boolean flag = true;
        try {
            if(espForm == null) {
                flag = false;
            } else if(espForm.getIdEspecialidad() == null ) {
                TblEspecialidad espec = new TblEspecialidad();
                espec.setNombreespecialidad(espForm.getNombreEspecialidad().toUpperCase());
                this.create(espec);
            } else {
                TblEspecialidad spec = find(new BigDecimal(espForm.getIdEspecialidad()));
                spec.setNombreespecialidad(espForm.getNombreEspecialidad());
                this.edit(spec);
            }
        } catch(Exception ex) {
            flag = false;
        }
        
        return flag;
    }
    
    public List<EspecialidadForm> obtenerEspecialidades() {
        List<TblEspecialidad> listaTmpEspec;
        List<EspecialidadForm> listaTmpEspecForm;
        
        try {
            listaTmpEspec = this.findAll();
            if(listaTmpEspec.isEmpty()) {
                listaTmpEspecForm = new ArrayList<EspecialidadForm>();
            } else {
                listaTmpEspecForm = this.entityToDtoList(listaTmpEspec, new EspecialidadForm());
            }
        } catch(Exception ex) {
           listaTmpEspecForm =  new ArrayList<EspecialidadForm>();
        }
        
        return listaTmpEspecForm;
    }
    
    
}
