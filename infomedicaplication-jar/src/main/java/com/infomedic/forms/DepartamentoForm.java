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

public  class DepartamentoForm {
    private @Setter @Getter String iddepartamento;
    private @Setter @Getter  String nombredepartamento;

    public DepartamentoForm(String iddepartamento, String nombredepartamento) {
        this.iddepartamento = iddepartamento;
        this.nombredepartamento = nombredepartamento;
    }
    public DepartamentoForm(){
        
    }
    
}
