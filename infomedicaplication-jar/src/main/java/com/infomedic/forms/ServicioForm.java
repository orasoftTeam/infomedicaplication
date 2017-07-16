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
 * @author talkcity
 */
public class ServicioForm {
    private @Getter @Setter String idservicio;
    private  @Getter @Setter String nombreservicio;
    private @Getter @Setter  String requisitos;

    public ServicioForm(String idservicio, String nombreservicio, String requisitos) {
        this.idservicio = idservicio;
        this.nombreservicio = nombreservicio;
        this.requisitos = requisitos;
    }
    
    public ServicioForm(){
        
    }
    
    
    
}
