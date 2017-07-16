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
public class MunicipioForm {
    private @Getter @Setter String idmunicipio;
    private @Getter @Setter String nombremunicipio;

    public MunicipioForm(String idmunicipio, String nombremunicipio) {
        this.idmunicipio = idmunicipio;
        this.nombremunicipio = nombremunicipio;
    }
    
    public MunicipioForm(){
        
    }
    
    
}
