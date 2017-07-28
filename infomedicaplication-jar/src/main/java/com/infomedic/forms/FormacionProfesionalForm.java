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
public class FormacionProfesionalForm {
    private @Getter @Setter String idformaaca;
    private @Getter @Setter String idempleado;
    private @Getter @Setter String conceptoestudio;
    private @Getter @Setter String institucionestudio;
    private @Getter @Setter String anioestudio;
    
    private @Setter String formacion;
    
    
    
    public String getFormacion(){
        String cad="";
        cad= institucionestudio +",   "+conceptoestudio+",   "+anioestudio;
        return cad;
    }
    
    
    /*
    public String getCompletar(){
        return "";
    }
    
    public void setCompletar(String cad){
        if(cad!=null){
            String[] temp= cad.split(",");
            institucionestudio=temp[0].trim();
            conceptoestudio=temp[1].trim();
            anioestudio=temp[2].trim();
        }
    }
    */
}
