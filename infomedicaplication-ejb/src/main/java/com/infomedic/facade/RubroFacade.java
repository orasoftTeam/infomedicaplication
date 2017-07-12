/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.facade;

import com.infomedic.entity.TblRubro;
import com.infomedic.forms.RubroForm;
import com.infomedic.utily.facade.AbstractFacade;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dell
 */
@Stateless
public class RubroFacade extends AbstractFacade<TblRubro, RubroForm>{
    
    @PersistenceContext(unitName = "infomedicPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager(){
    return em;
    }
    
    public RubroFacade(){
    super(TblRubro.class);
    }
    
    public boolean agregarRubro(RubroForm rf){
    boolean flag = true;
        try {
            if (rf == null) {
                flag = false;
            }else if (rf.getIdrubro() == null) {
                TblRubro rubro = new TblRubro();
                rubro.setNombrerubro(rf.getNombrerubro().toUpperCase());
                create(rubro);
            } else {
             TblRubro rubro = find(new BigDecimal(rf.getIdrubro()));
             rubro.setNombrerubro(rf.getNombrerubro().toUpperCase());
             edit(rubro);
            }
            
        } catch (Exception e) {
            flag = false;
        }
    
    
    return flag;
    }
    
    public List<RubroForm> obtenerRubros(){
    List<TblRubro> listaTmp;
    List<RubroForm> listaTmpForm;
        try {
            listaTmp = findAll();
            if (listaTmp.isEmpty()) {
                listaTmpForm = new ArrayList<RubroForm>();
            } else {
               listaTmpForm = entityToDtoList(listaTmp, new RubroForm());
            }
            
        } catch (Exception e) {
            listaTmpForm = new ArrayList<RubroForm>();
        }
      return listaTmpForm;
    }
}
