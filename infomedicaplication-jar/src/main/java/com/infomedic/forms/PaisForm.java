/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.forms;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;



/**
 *
 * @author LAP
 */
public  class PaisForm {
    private @Setter @Getter  String idpais;
    private @Setter @Getter  String nombrepais;

    public PaisForm(String idpais, String nombrepais) {
        this.idpais = idpais;
        this.nombrepais = nombrepais;
    }
    
    public PaisForm(){
        
    }
    
    
   
}

