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
public class MenuForm {
    private @Getter @Setter String nivel;
    private @Getter @Setter String desaplic;
    private @Getter @Setter String secuencia;
    private @Getter @Setter String codaplic;
    private @Getter @Setter String opcion;
    private @Getter @Setter String indforma;
    private @Getter @Setter String codmodulo;

    public MenuForm(String nivel, String desaplic, String secuencia, String codaplic, String opcion, String indforma, String codmodulo) {
        this.nivel = nivel;
        this.desaplic = desaplic;
        this.secuencia = secuencia;
        this.codaplic = codaplic;
        this.opcion = opcion;
        this.indforma = indforma;
        this.codmodulo = codmodulo;
    }
    
    public MenuForm(){
        
    }
    
}
