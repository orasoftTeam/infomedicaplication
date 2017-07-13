/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.facade;



import com.infomedic.entity.TblTiposervicio;
import com.infomedic.forms.TipoServicioForm;
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
 * @author talkcity
 */

@Stateless
public class TipoServicioFacade extends AbstractFacade<TblTiposervicio, TipoServicioForm>{
    @PersistenceContext(unitName = "infomedicPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoServicioFacade() {
        super(TblTiposervicio.class);
    }
    
    public boolean agregarTipoServicio(TipoServicioForm tsf){
        boolean flag = true;
        try {
            if (tsf == null) {
                flag = false;
            }else if (tsf.getIdtiposervicio() == null) {
                TblTiposervicio tiposervicio = new TblTiposervicio();
                tiposervicio.setNombretiposervicio(tsf.getNombretiposervicio().toUpperCase());
                create(tiposervicio);
            }else{
                TblTiposervicio tiposerv = find(new BigDecimal(tsf.getIdtiposervicio()));
                tiposerv.setNombretiposervicio(tsf.getNombretiposervicio().toUpperCase());
                edit(tiposerv);
            }
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
    
    public List<TipoServicioForm> obtenerTipoServicio(){
        List<TblTiposervicio> listaTmp;
        List<TipoServicioForm> listaTmpForm;
        try {
            listaTmp = findAll();
            if (listaTmp.isEmpty()) {
                listaTmpForm = new ArrayList<TipoServicioForm>();
            }else{
                listaTmpForm = entityToDtoList(listaTmp, new TipoServicioForm());
            }
        } catch (Exception e) {
            listaTmpForm = new ArrayList<TipoServicioForm>();
        }
        
        return listaTmpForm;
    }
}
