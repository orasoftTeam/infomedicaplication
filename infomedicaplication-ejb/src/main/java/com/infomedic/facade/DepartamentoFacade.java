/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.facade;


/*
import com.infomedic.entity.TblDepartamento;
import com.infomedic.entity.TblPais;

*/
import com.infomedic.forms.DepartamentoForm;
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
public class DepartamentoFacade {

    @PersistenceContext(unitName = "infomedicPU")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    public DepartamentoFacade() {
        
    }
    
     public List<DepartamentoForm> obtenerDepartamentos(){
         
        String sql= "select TO_CHAR(iddepartamento) as iddepartamento, nombredepartamento from tbl_departamento";
        Query q= getEntityManager().createNativeQuery(sql,"DepartamentoMapping");
        List<DepartamentoForm> list=(List<DepartamentoForm>) (q.getResultList().isEmpty()? new ArrayList<DepartamentoForm>(): q.getResultList());
        /*
        String sql="select c.CUSTOMER_ID as id_cliente, c.\"NAME\" as nombre_cliente, p.DESCRIPTION as producto \n" +
                " from customer as c, product_code as pc, product as p \n" +
                "where c.DISCOUNT_CODE=pc.DISCOUNT_CODE and pc.PROD_CODE=p.PRODUCT_CODE";
        Query q= em.createNativeQuery(sql, "JoinMapping");
        List<JoinResultClass> list=(List<JoinResultClass>) (q.getResultList().isEmpty()? new ArrayList<JoinResultClass>(): q.getResultList());
        */
        return list;
    }
     
    public List<DepartamentoForm> findByPais(String idPais){
        Query q= getEntityManager().createNativeQuery("select iddepartamento, nombredepartamento from tbl_departamento where idpais=?", "DepartamentoMapping");
        q.setParameter(1, new BigDecimal(idPais));
        List<DepartamentoForm> listTmp= (List<DepartamentoForm>) q.getResultList();
        listTmp= (listTmp.isEmpty()? new ArrayList<DepartamentoForm>(): listTmp);
        return listTmp;
        //return entityToDtoList(listTmp, new DepartamentoForm());
    }
    
    public List<DepartamentoForm> findById(String idDepto){
        Query q= getEntityManager().createNativeQuery("select iddepartamento, nombredepartamento from tbl_departamento where iddepartamento=?", "DepartamentoMapping");
        q.setParameter(1, new BigDecimal(idDepto));
        List<DepartamentoForm> listTmp= (List<DepartamentoForm>) q.getResultList();
        listTmp= (listTmp.isEmpty()? new ArrayList<DepartamentoForm>(): listTmp);
        return listTmp;
        //return entityToDtoList(listTmp, new DepartamentoForm());
    }

    
    /*
    public boolean agregarDepto(DepartamentoForm df) {
        boolean flag = true;
        try {
            if (df == null) {
                flag = false;
            } else if (df.getIddepartamento()== null) {
                TblDepartamento depto = new TblDepartamento();
                depto.setIdpais(pais);
                depto.setNombredepartamento(df.getNombredepartamento().toUpperCase());
                create(depto);
                //flag = false;
            } else {
                TblDepartamento depto = find(new BigDecimal(df.getIddepartamento()));
                depto.setNombredepartamento(df.getNombredepartamento().toUpperCase());
                edit(depto);
                //getEntityManager().merge(pais);
                // create(pais);
            }
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
    */
    
    /*
    public List<DepartamentoForm> obtenerDepartamentos() {
        List<TblDepartamento> listaTmp;
        List<DepartamentoForm> listaTmpForm;
        try {
            listaTmp = findAll();
            if (listaTmp.isEmpty()) {
                listaTmpForm = new ArrayList<DepartamentoForm>();
            } else {
                listaTmpForm = entityToDtoList(listaTmp, new DepartamentoForm());
            }
        } catch (Exception e) {
            listaTmpForm = new ArrayList<DepartamentoForm>();
        }
        return listaTmpForm;

    }

    */
    
    /*
    
    public List<DepartamentoForm> findById(String idPais){
        Query q= getEntityManager().createNativeQuery("select * from tbl_departamento where idpais=?", TblDepartamento.class);
        q.setParameter(1, new BigDecimal(idPais));
        List<TblDepartamento> listTmp= q.getResultList();
        listTmp= listTmp.isEmpty()? new ArrayList<TblDepartamento>(): listTmp;
        return entityToDtoList(listTmp, new DepartamentoForm());
    }

    */
}
