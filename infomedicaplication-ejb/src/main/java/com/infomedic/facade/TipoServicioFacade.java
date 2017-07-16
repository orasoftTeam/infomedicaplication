/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.facade;




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
public class TipoServicioFacade {
    @PersistenceContext(unitName = "infomedicPU")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    public TipoServicioFacade() {
    }
    
   
      public List<TipoServicioForm> obtenerTiposServicio(){
         
        String sql= "select TO_CHAR(idtiposervicio) as idtiposervicio, nombretiposervicio from tbl_tiposervicio";
        Query q= getEntityManager().createNativeQuery(sql,"TipoServicioMapping");
        List<TipoServicioForm> list=(List<TipoServicioForm>) (q.getResultList().isEmpty()? new ArrayList<TipoServicioForm>(): q.getResultList());
        /*
        String sql="select c.CUSTOMER_ID as id_cliente, c.\"NAME\" as nombre_cliente, p.DESCRIPTION as producto \n" +
                " from customer as c, product_code as pc, product as p \n" +
                "where c.DISCOUNT_CODE=pc.DISCOUNT_CODE and pc.PROD_CODE=p.PRODUCT_CODE";
        Query q= em.createNativeQuery(sql, "JoinMapping");
        List<JoinResultClass> list=(List<JoinResultClass>) (q.getResultList().isEmpty()? new ArrayList<JoinResultClass>(): q.getResultList());
        */
        return list;
    }
     
    
    public List<TipoServicioForm> findById(String idTipo){
        Query q= getEntityManager().createNativeQuery("select TO_CHAR(idtiposervicio) as idtiposervicio, nombretiposervicio from tbl_tiposervicio where idtiposervicio=?", "TipoServicioMapping");
        q.setParameter(1, new BigDecimal(idTipo));
        List<TipoServicioForm> listTmp= (List<TipoServicioForm>) q.getResultList();
        listTmp= (listTmp.isEmpty()? new ArrayList<TipoServicioForm>(): listTmp);
        return listTmp;
        //return entityToDtoList(listTmp, new DepartamentoForm());
    }
    
    /*
    
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

        */
}
