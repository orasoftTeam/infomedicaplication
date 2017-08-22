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
 * @author dell
 */
public class UsuarioForm {
    
    private @Getter @Setter String idusuario;
    private @Getter @Setter String nombreusuario;
    private @Getter @Setter String contrausuario;
    private @Getter @Setter String correousuario;
    private @Getter @Setter String fechacreacion;
    private @Getter @Setter String estadousuario;
    private @Getter @Setter String fechafinusuario;

    public UsuarioForm() {
    }
    
    
}
