/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.facade;


import com.infomedic.forms.ServicioForm;

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
public class ServicioFacade  {

    @PersistenceContext(unitName = "infomedicPU")
    private EntityManager em;



    public EntityManager getEntityManager() {
        return em;
    }

    public ServicioFacade() {
    }
    
     public List<ServicioForm> obtenerServicios(){
         
        String sql= "select TO_CHAR(idservicio) idservicio, nombreservicio, requisitos from tbl_servicio";
        Query q= getEntityManager().createNativeQuery(sql,"ServicioMapping");
        List<ServicioForm> list=(List<ServicioForm>) (q.getResultList().isEmpty()? new ArrayList<ServicioForm>(): q.getResultList());
        /*
        String sql="select c.CUSTOMER_ID as id_cliente, c.\"NAME\" as nombre_cliente, p.DESCRIPTION as producto \n" +
                " from customer as c, product_code as pc, product as p \n" +
                "where c.DISCOUNT_CODE=pc.DISCOUNT_CODE and pc.PROD_CODE=p.PRODUCT_CODE";
        Query q= em.createNativeQuery(sql, "JoinMapping");
        List<JoinResultClass> list=(List<JoinResultClass>) (q.getResultList().isEmpty()? new ArrayList<JoinResultClass>(): q.getResultList());
        */
        return list;
    }
     
    public List<ServicioForm> findByTipoServicio(String idTipo){
        Query q= getEntityManager().createNativeQuery("select idservicio, nombreservicio, requisitos from tbl_servicio where idtiposervicio=?", "ServicioMapping");
        q.setParameter(1, new BigDecimal(idTipo));
        List<ServicioForm> listTmp= (List<ServicioForm>) q.getResultList();
        listTmp= (listTmp.isEmpty()? new ArrayList<ServicioForm>(): listTmp);
        return listTmp;
        //return entityToDtoList(listTmp, new DepartamentoForm());
    }
    
    public List<ServicioForm> findById(String idServicio){
        Query q= getEntityManager().createNativeQuery("select idservicio, nombreservicio, requisitos from tbl_servicio where idservicio=?", "ServicioMapping");
        q.setParameter(1, new BigDecimal(idServicio));
        List<ServicioForm> listTmp= (List<ServicioForm>) q.getResultList();
        listTmp= (listTmp.isEmpty()? new ArrayList<ServicioForm>(): listTmp);
        return listTmp;
        //return entityToDtoList(listTmp, new DepartamentoForm());
    }

    /*
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
    */
}
