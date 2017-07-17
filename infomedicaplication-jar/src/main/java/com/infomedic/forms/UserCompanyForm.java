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
public class UserCompanyForm {
    private @Getter @Setter String idcompany;
    private @Getter @Setter String idusuario;
    private @Getter @Setter String company;
    private @Getter @Setter String nombreusuario;
    private @Getter @Setter String passwd;

    public UserCompanyForm(String idcompany, String idusuario, String company, String nombreusuario, String passwd) {
        this.idcompany = idcompany;
        this.idusuario = idusuario;
        this.company = company;
        this.nombreusuario = nombreusuario;
        this.passwd = passwd;
    }
    
    
}
