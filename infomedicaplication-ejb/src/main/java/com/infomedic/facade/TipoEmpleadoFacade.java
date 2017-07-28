/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.facade;

import com.infomedic.entity.TblTipoempleado;
import com.infomedic.forms.TipoEmpleadoForm;
import com.infomedic.utily.facade.AbstractFacade;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dell
 */
@Stateless
public class TipoEmpleadoFacade extends AbstractFacade<TblTipoempleado, TipoEmpleadoForm> {

    @PersistenceContext(unitName = "infomedicPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    TipoEmpleadoFacade() {
        super(TblTipoempleado.class);
    }    
    
    public boolean agregarTipoEmpleado(TipoEmpleadoForm tef) {
        boolean flag = true;
        try {
            if (tef == null) {
                flag = false;
            } else if (tef.getIdtipoempleado() == null) {
                TblTipoempleado tipoEmpleado = new TblTipoempleado();
                tipoEmpleado.setNombretipo(tef.getNombretipo().toUpperCase());
                create(tipoEmpleado);
            } else {
                TblTipoempleado tipoEmpleado = find(new BigDecimal(tef.getIdtipoempleado()));
                tipoEmpleado.setNombretipo(tef.getNombretipo().toUpperCase());
                edit(tipoEmpleado);
            }
        } catch (Exception e) {
            flag = false;
        }
        
        return flag;
    }
    
    public List<TipoEmpleadoForm> obtenerTiposEmpleado() {
        List<TblTipoempleado> listaTmp;
        List<TipoEmpleadoForm> listaTmpForm;
        try {
            listaTmp = findAll();
            if (listaTmp.isEmpty()) {
                listaTmpForm = new ArrayList<TipoEmpleadoForm>();
            } else {
                listaTmpForm = entityToDtoList(listaTmp, new TipoEmpleadoForm());
            }
        } catch (Exception e) {
            listaTmpForm = new ArrayList<TipoEmpleadoForm>();
        }
        return listaTmpForm;
        
    }
    
    public List<TipoEmpleadoForm> findByIdEmpleado(String id) {
        Query q = getEntityManager().createNativeQuery("select te.* from tbl_tipoempleado  te, tbl_empleado  emp where emp.idempleado=? and emp.idtipoempleado=te.idtipoempleado", TblTipoempleado.class);
        q.setParameter(1, new BigDecimal(id));
        List<TblTipoempleado> listaTmp;
        List<TipoEmpleadoForm> listaTmpForm;
        try {
            listaTmp = q.getResultList();
            if (listaTmp.isEmpty()) {
                listaTmpForm = new ArrayList<TipoEmpleadoForm>();
            } else {
                listaTmpForm = entityToDtoList(listaTmp, new TipoEmpleadoForm());
            }
        } catch (Exception e) {
            listaTmpForm = new ArrayList<TipoEmpleadoForm>();
        }
        return listaTmpForm;
        
    }
}
