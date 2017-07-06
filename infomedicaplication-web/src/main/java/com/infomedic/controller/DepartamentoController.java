/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.controller;

import com.github.adminfaces.template.config.AdminConfig;
import com.infomedic.forms.DepartamentoForms;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LAP
 */

@ManagedBean (name = "deptoController")
@ViewScoped
public class DepartamentoController {
    private  DepartamentoForms df = new DepartamentoForms();

    
    public DepartamentoController(){ 
        
    }

    public void pruebaController(){
        System.err.println("------------------------------------");
        System.err.println(getDf().getNombre());
    }
    
    
    public DepartamentoForms getDf() {
        return df;
    }

    public void setDf(DepartamentoForms df) {
        this.df = df;
    }  
    
    
}
