/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.forms;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LAP
 */
public class UserForm {
    private @Getter @Setter String idusuario;
    private @Getter @Setter String nombre;
    private @Getter @Setter String pass;
    private @Getter @Setter String email;
    private @Getter @Setter String nombrecompany;
    private @Getter @Setter String idcompany;
    private @Getter @Setter String idrol;
    
    public UserForm(){
        
    }
    
    public UserForm(String idusuario, String nombre, String pass, String email, String nombrecompany, String idcompany, String idrol){
       this.idusuario= idusuario;
       this.nombre= nombre;
       this.pass= pass;
       this.email= email;
       this.nombrecompany= nombrecompany;
       this.idcompany= idcompany;
       this.idrol= idrol;
    }
}
