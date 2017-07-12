/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.controller;

import com.infomedic.facade.RubroFacade;
import com.infomedic.forms.RubroForm;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author dell
 */
@Named
@ViewScoped
public class RubroController implements Serializable{
    
    private RubroForm rf = new RubroForm();
    private @Getter @Setter List<RubroForm> listaRubro = new ArrayList<RubroForm>();
    private @Getter @Setter String nomRubro;
    
    @EJB
    private RubroFacade rfacade;
    
    public RubroController(){}
    
    @PostConstruct
    public void init(){
     listaRubro = rfacade.obtenerRubros();
    }
    
    public void guardarRubro(){
        if (setValores()) {
            if (rfacade.agregarRubro(rf)) {
                nomRubro="";
                lanzarMensaje("info", getMsgBundle("titleMsgExitoso"), getMsgBundle("lblRegExitoso"));
                listaRubro = rfacade.obtenerRubros();
                rf = new RubroForm();
            } else {
                lanzarMensaje("error", getMsgBundle("titleMsgError"), getMsgBundle("lblRegError"));
            }
            
        }
    }
    
    public boolean setValores(){
    boolean flag = true;
        if ("".equals(nomRubro)) {
            flag = false;
            lanzarMensaje("warn", getMsgBundle("titleMsgAdv"), getMsgBundle("lblRubroAdd"));
        } else if (!"".equals(nomRubro)) {
            if (rf == null) {
                rf = new RubroForm();
                rf.setNombrerubro(nomRubro);
                
            }else if (!rf.getIdrubro().equals("")) {
                rf.setNombrerubro(nomRubro);
            }
            
        }
        return flag;
    }
    
    public void validarSeleccion(){
        if (rf == null) {
            lanzarMensaje("warn", getMsgBundle("titleMsgAdv"), getMsgBundle("lblRubroReq"));
        } else if (rf.equals(new RubroForm())) {
            lanzarMensaje("warn", getMsgBundle("titleMsgAdv"), getMsgBundle("lblRubroReq"));
        } else if (rf.getIdrubro().equals("")) {
            lanzarMensaje("warn", getMsgBundle("titleMsgAdv"), getMsgBundle("lblRubroReq"));
        }
        else{
        nomRubro = rf.getNombrerubro();
        }
    
    }
    
    
    public void lanzarMensaje(String tipo, String titulo, String msg){
    FacesMessage.Severity typeMessage;
    switch(tipo.toLowerCase()){
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
        context.addMessage(null, new FacesMessage(typeMessage, titulo, msg));
    }
    
    public String getMsgBundle(String key){
    ResourceBundle bundle = ResourceBundle.getBundle("/Bundle",FacesContext.getCurrentInstance().getViewRoot().getLocale());
    String value = bundle.getString(key);
    return value;
    }
    public RubroForm getRf(){
    if(rf == null){
    rf = new RubroForm();
    }
    
    return rf;
    }
    
    public void setRf(RubroForm rf){
    this.rf = rf;
    }
    
}
