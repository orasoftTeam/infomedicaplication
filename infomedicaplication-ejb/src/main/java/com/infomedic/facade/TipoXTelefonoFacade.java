/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.facade;


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
public class TipoXTelefonoFacade {
    @PersistenceContext(unitName = "infomedicPU")
    private EntityManager em;
    
    public EntityManager getEntityManager() {
        return this.em;
    }
    
    public TipoXTelefonoFacade() {
    }
    /*
    public boolean agregarTipoTelefono(TipoXTelefonoForm telForm) {
        boolean flag = true;
        try {
            if(telForm == null) {
                flag = false;
            } else if(telForm.getIdTipoXTelefono() == null) {
                TblTipoxtelefono tipoTel = new TblTipoxtelefono();
                tipoTel.setNombretipo(telForm.getNombreTipo().toUpperCase());
                this.create(tipoTel);
            } else {
                TblTipoxtelefono tipoTel = this.find(new BigDecimal(telForm.getIdTipoXTelefono()));
                tipoTel.setNombretipo(telForm.getNombreTipo().toUpperCase());
                this.edit(tipoTel);
            }
        } catch(Exception ex) {
            flag = false;
        }
        
        return flag;
    }
    
    public List<TipoXTelefonoForm> obtenerTiposTelefono() {
        List<TipoXTelefonoForm> listForm;
        List<TblTipoxtelefono> listEntity;
        
        try {
            listEntity = this.findAll();
            if(listEntity.isEmpty()) {
                listForm = new ArrayList<TipoXTelefonoForm>();
            } else {
                listForm = this.entityToDtoList(listEntity, new TipoXTelefonoForm());
            }
        } catch(Exception ex) {
            listForm = new ArrayList<TipoXTelefonoForm>();
        }
        
        return listForm;
    }
    */
    
}
