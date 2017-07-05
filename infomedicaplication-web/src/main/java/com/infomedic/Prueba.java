/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.infomedic.BeanPrueba;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author LAP
 */
@ManagedBean(name = "pruebaBean")
@SessionScoped
public class Prueba {
    
    @EJB
    BeanPrueba bp;
    
    ///DepartamentoManagedBean
    // DepartamentoForm deptoForm= new DepartamentoForm();
    
    @PostConstruct
    public void init(){
        bp.mostrarMensaje();
    }
    
    public String getMensaje(){
        return "mensaje";
    }


    
}
