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
public  class TipoServicioForm {
    private @Getter @Setter String idtiposervicio;
    private @Getter @Setter String nombretiposervicio;
    
    public TipoServicioForm(){
        
    }

    public TipoServicioForm(String idtiposervicio, String nombretiposervicio) {
        this.idtiposervicio = idtiposervicio;
        this.nombretiposervicio = nombretiposervicio;
    }
    
    
}
