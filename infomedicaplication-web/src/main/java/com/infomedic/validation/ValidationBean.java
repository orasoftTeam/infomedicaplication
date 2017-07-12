/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.validation;

import java.util.ResourceBundle;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author LAP
 */

@Stateless
public class ValidationBean {
    
        public boolean validarCampoVacio(String c, String tipoMsg, String tituloMsg, String descMsg){
            boolean flag;
            if("".equals(c)){
                flag= false;
                lanzarMensaje(tipoMsg, tituloMsg, descMsg );
            }
            else{
                flag=true;
            }
            return flag;
        }
    
        public void lanzarMensaje(String tipo, String titulo, String msg) {
        FacesMessage.Severity typeMessage;
        switch (tipo.toLowerCase()) {
            case "info":
                typeMessage = FacesMessage.SEVERITY_INFO;
                break;
            case "warn":
                typeMessage = FacesMessage.SEVERITY_WARN;
                break;
            case "fatal":
                typeMessage = FacesMessage.SEVERITY_FATAL;
                break;
            case "error":
                typeMessage = FacesMessage.SEVERITY_ERROR;
                break;
            default:
                typeMessage = FacesMessage.SEVERITY_INFO;
                break;
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(typeMessage, getMsgBundle( titulo ),getMsgBundle( msg )));
    }
    
    public String getMsgBundle(String key){
        ResourceBundle bundle = ResourceBundle.getBundle("/Bundle", FacesContext.getCurrentInstance().getViewRoot().getLocale());
        String value = bundle.getString(key);
        return value;
    }
}
