/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.facade;


import com.infomedic.forms.PaisForm;
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
public class PaisFacade  {

    @PersistenceContext(unitName = "infomedicPU")
    private EntityManager em;

    
    public EntityManager getEntityManager() {
        return em;
    }

    public PaisFacade() {
        
    }
    
      public List<PaisForm> obtenerPaises(){
         
        String sql= "select TO_CHAR(idpais) as idpais, nombrepais from tbl_pais";
        Query q= getEntityManager().createNativeQuery(sql,"PaisMapping");
        List<PaisForm> list=(List<PaisForm>) (q.getResultList().isEmpty()? new ArrayList<PaisForm>(): q.getResultList());
        /*
        String sql="select c.CUSTOMER_ID as id_cliente, c.\"NAME\" as nombre_cliente, p.DESCRIPTION as producto \n" +
                " from customer as c, product_code as pc, product as p \n" +
                "where c.DISCOUNT_CODE=pc.DISCOUNT_CODE and pc.PROD_CODE=p.PRODUCT_CODE";
        Query q= em.createNativeQuery(sql, "JoinMapping");
        List<JoinResultClass> list=(List<JoinResultClass>) (q.getResultList().isEmpty()? new ArrayList<JoinResultClass>(): q.getResultList());
        */
        return list;
    }
     
    
    public List<PaisForm> findById(String idPais){
        Query q= getEntityManager().createNativeQuery("select idpais, nombrepais from tbl_pais where idpais=?", "PaisMapping");
        q.setParameter(1, new BigDecimal(idPais));
        List<PaisForm> listTmp= (List<PaisForm>) q.getResultList();
        listTmp= (listTmp.isEmpty()? new ArrayList<PaisForm>(): listTmp);
        return listTmp;
        //return entityToDtoList(listTmp, new DepartamentoForm());
    }

    /*
    public boolean agregarPais(PaisForm pf) {
        boolean flag = true;
        try {
            if (pf == null) {
                flag = false;
            } else if (pf.getIdpais()== null) {
                TblPais pais = new TblPais();
                pais.setNombrepais(pf.getNombrepais().toUpperCase());
                create(pais);
                //flag = false;
            } else {
                TblPais pais = find(new BigDecimal(pf.getIdpais()));
                pais.setNombrepais(pf.getNombrepais().toUpperCase());
                edit(pais);
                //getEntityManager().merge(pais);
                // create(pais);
            }
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public List<PaisForm> obtenerPaises() {
        List<TblPais> listaTmp;
        List<PaisForm> listaTmpForm;
        try {
            listaTmp = findAll();
            if (listaTmp.isEmpty()) {
                listaTmpForm = new ArrayList<PaisForm>();
            } else {
                listaTmpForm = entityToDtoList(listaTmp, new PaisForm());
            }
        } catch (Exception e) {
            listaTmpForm = new ArrayList<PaisForm>();
        }
        return listaTmpForm;

    }
    
    
    /*
    
    public void buscarPaisPorId(PaisForm pf){
        find(new BigDecimal(pf.getCodpais()));
    }
    
    public void buscarPais(PaisForm pf){
        /*
        Query q=  getEntityManager().createNativeQuery("select * from tbl_pais where codPais=?", TblPais.class);
        q.setParameter(1, pf.getCodpais());
        List<TblPais> temp= q.getResultList();
        temp =temp.isEmpty()? new ArrayList<TblPais>(): temp;
        PaisForm t= entityToDto(temp.get(0), pf);
        System.err.println(t.getNombrepais());
        
        
        traerTodos();
    }
    
    public void traerTodos(){
        Query q=  getEntityManager().createNativeQuery("select * from tbl_pais", TblPais.class);
        //q.setParameter(1, pf.getCodpais());
        List<TblPais> temp= q.getResultList();
        temp =temp.isEmpty()? new ArrayList<TblPais>(): temp;
        List<PaisForm> listaP= entityToDtoList(temp, new PaisForm());
        System.err.println("----------------------------");
        for(PaisForm v: listaP){
            System.err.println(v.getCodpais() +"-------" + v.getNombrepais());
        }
        System.err.println("----------------------------");
        //PaisForm t= entityToDto(temp.get(0), pf);
        //System.err.println(t.getNombrepais());      
    }
     */
}
