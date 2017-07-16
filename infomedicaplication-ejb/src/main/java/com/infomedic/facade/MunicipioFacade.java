/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.facade;

import com.infomedic.forms.DepartamentoForm;
import com.infomedic.forms.MunicipioForm;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author LAP
 */
@Stateless
public class MunicipioFacade {
     @PersistenceContext(unitName = "infomedicPU")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }
    
    public MunicipioFacade(){
        
    }
     public List<MunicipioForm> obtenerMunicipios(){
         
        String sql= "select TO_CHAR(idmunicipio) as idmunicipio, nombremunicipio from tbl_municipio";
        Query q= getEntityManager().createNativeQuery(sql,"MunicipioMapping");
        List<MunicipioForm> list=(List<MunicipioForm>) (q.getResultList().isEmpty()? new ArrayList<MunicipioForm>(): q.getResultList());
        /*
        String sql="select c.CUSTOMER_ID as id_cliente, c.\"NAME\" as nombre_cliente, p.DESCRIPTION as producto \n" +
                " from customer as c, product_code as pc, product as p \n" +
                "where c.DISCOUNT_CODE=pc.DISCOUNT_CODE and pc.PROD_CODE=p.PRODUCT_CODE";
        Query q= em.createNativeQuery(sql, "JoinMapping");
        List<JoinResultClass> list=(List<JoinResultClass>) (q.getResultList().isEmpty()? new ArrayList<JoinResultClass>(): q.getResultList());
        */
        return list;
    }
     
    public List<MunicipioForm> findByDepto(String idDepto){
        Query q= getEntityManager().createNativeQuery("select idmunicipio, nombremunicipio from tbl_municipio where iddepartamento=?", "MunicipioMapping");
        q.setParameter(1, new BigDecimal(idDepto));
        List<MunicipioForm> listTmp= (List<MunicipioForm>) q.getResultList();
        listTmp= (listTmp.isEmpty()? new ArrayList<MunicipioForm>(): listTmp);
        return listTmp;
        //return entityToDtoList(listTmp, new DepartamentoForm());
    }
    
    public List<MunicipioForm> findById(String idMunicipio){
        Query q= getEntityManager().createNativeQuery("select idmunicipio, nombremunicipio from tbl_municipio where idmunicipio=?", "MunicipioMapping");
        q.setParameter(1, new BigDecimal(idMunicipio));
        List<MunicipioForm> listTmp= (List<MunicipioForm>) q.getResultList();
        listTmp= (listTmp.isEmpty()? new ArrayList<MunicipioForm>(): listTmp);
        return listTmp;
        //return entityToDtoList(listTmp, new DepartamentoForm());
    }
}
