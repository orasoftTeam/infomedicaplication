/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.facade;

import com.infomedic.entity.TblServicios;
import com.infomedic.entity.TblTiposervicio;
import com.infomedic.forms.ServicioForm;
import com.infomedic.forms.TipoServicioForm;
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
 * @author talkcity
 */
@Stateless
public class ServicioFacade extends AbstractFacade<TblServicios, ServicioForm> {

    @PersistenceContext(unitName = "infomedicPU")
    private EntityManager em;

    private @Getter @Setter TblTiposervicio tipoServicio;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServicioFacade() {
        super(TblServicios.class);
    }

    public boolean agregarSrv(ServicioForm sv) {
        boolean flag = true;
        try {
            if (sv == null) {
                flag = false;
            } else if (sv.getIdservicio() == null) {
                TblServicios servicio = new TblServicios();
                servicio.setIdtiposervicio(tipoServicio);
                servicio.setNombreservicio(sv.getNombreservicio().toUpperCase());
                servicio.setRequisitos(sv.getRequisitos().toUpperCase());
                create(servicio);
                //flag = false;
            } else {
                TblServicios servicio = find(new BigDecimal(sv.getIdservicio()));
                servicio.setNombreservicio(sv.getNombreservicio().toUpperCase());
                servicio.setRequisitos(sv.getRequisitos().toUpperCase());
                edit(servicio);
                //getEntityManager().merge(pais);
                // create(pais);
            }
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public List<ServicioForm> obtenerServicios() {
        List<TblServicios> listaTmp;
        List<ServicioForm> listaTmpForm;
        try {
            listaTmp = findAll();
            if (listaTmp.isEmpty()) {
                listaTmpForm = new ArrayList<ServicioForm>();
            } else {
                listaTmpForm = entityToDtoList(listaTmp, new ServicioForm());
            }
        } catch (Exception e) {
            listaTmpForm = new ArrayList<ServicioForm>();
        }
        return listaTmpForm;

    }

    public List<ServicioForm> findById(String idTipoServicio) {
        Query q = getEntityManager().createNativeQuery("select * from tbl_servicios where idtiposervicio=?", TblServicios.class);
        q.setParameter(1, new BigDecimal(idTipoServicio));
        List<TblServicios> listTmp = q.getResultList();
        listTmp = listTmp.isEmpty() ? new ArrayList<TblServicios>() : listTmp;
        return entityToDtoList(listTmp, new ServicioForm());
    }
}
