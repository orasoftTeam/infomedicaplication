/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.facade;

import com.infomedic.entity.TblDepartamento;
import com.infomedic.entity.TblPais;
import com.infomedic.forms.DepartamentoForm;
import com.infomedic.forms.PaisForm;
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
 * @author LAP
 */
@Stateless
public class DepartamentoFacade extends AbstractFacade<TblDepartamento, DepartamentoForm> {

    @PersistenceContext(unitName = "infomedicPU")
    private EntityManager em;
    
    private @Getter @Setter TblPais pais;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartamentoFacade() {
        super(TblDepartamento.class);
    }

    public boolean agregarDepto(DepartamentoForm df) {
        boolean flag = true;
        try {
            if (df == null) {
                flag = false;
            } else if (df.getCoddepartamento() == null) {
                TblDepartamento depto = new TblDepartamento();
                depto.setCodpais(pais);
                depto.setNombredepartamento(df.getNombredepartamento().toUpperCase());
                create(depto);
                //flag = false;
            } else {
                TblDepartamento depto = find(new Integer(df.getCoddepartamento()));
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
