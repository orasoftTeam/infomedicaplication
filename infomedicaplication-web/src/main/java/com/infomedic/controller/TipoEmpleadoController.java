/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.controller;

import com.infomedic.facade.TipoEmpleadoFacade;
import com.infomedic.forms.TipoEmpleadoForm;
import com.infomedic.validation.ValidationBean;
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
public class TipoEmpleadoController implements Serializable{
    
    private TipoEmpleadoForm tef = new TipoEmpleadoForm();
    private @Getter @Setter List<TipoEmpleadoForm> listaTiposEmpleado = new ArrayList<TipoEmpleadoForm>();
    private @Getter @Setter String nomTipoEmp;
    
    @EJB
    private TipoEmpleadoFacade tefacade;
    @EJB
    private ValidationBean val;
    
    public TipoEmpleadoController(){}
    
    @PostConstruct
    public void init(){
     listaTiposEmpleado = tefacade.obtenerTiposEmpleado();
    }
    public void limpiarDatos(){
    nomTipoEmp = "";
    tef = new TipoEmpleadoForm();
    }
    
    public void guardarTipoEmpleado(){
        if (setValores()) {
            if (tefacade.agregarTipoEmpleado(tef)) {
                nomTipoEmp = "";
                lanzarMensaje("info", getMsgBundle("titleMsgExitoso"), getMsgBundle("lblRegExitoso"));
                listaTiposEmpleado = tefacade.obtenerTiposEmpleado();
                tef = new TipoEmpleadoForm();
            } else {
           lanzarMensaje("error", getMsgBundle("titleMsgError"), getMsgBundle("lblRegError"));
        }
        }
    
    }
    public boolean setValores(){
        boolean flag = true;
        flag = val.validarSoloLetras(nomTipoEmp, "warn","errorVal", "errorNum") == true
            ? val.validarLongitudCampo(nomTipoEmp, 4, 30, "warn", "titleMsgAdv", "lblLongitud") == true
            : false;
        
        if ("".equals(nomTipoEmp)) {
            flag = false;
            //lanzarMensaje("warn", getMsgBundle("titleMsgAdv"), getMsgBundle("lblTipoEmpleadoAdd"));
        } else if (!"".equals(nomTipoEmp)){
           if(tef == null){
           tef = new TipoEmpleadoForm();
           tef.setNombretipo(nomTipoEmp);
           } else if (!tef.getIdtipoempleado().equals("")) {
                tef.setNombretipo(nomTipoEmp);
            }
        }
        
        return flag;
    }
    public void validarSeleccion() {
        if (tef == null) {
            lanzarMensaje("warn", getMsgBundle("titleMsgAdv"), getMsgBundle("lblTipoEmpleadoReq"));
        } else if (tef.equals(new TipoEmpleadoForm())) {
            lanzarMensaje("warn", getMsgBundle("titleMsgAdv"), getMsgBundle("lblTipoEmpleadoReq"));
        } else if (tef.getIdtipoempleado().equals("")) {
            lanzarMensaje("warn", getMsgBundle("titleMsgAdv"), getMsgBundle("lblTipoEmpleadoReq"));
        }
        else{
            nomTipoEmp= tef.getNombretipo();
        }
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
        context.addMessage(null, new FacesMessage(typeMessage, titulo, msg));
    }
    public String getMsgBundle(String key){
        ResourceBundle bundle = ResourceBundle.getBundle("/Bundle", FacesContext.getCurrentInstance().getViewRoot().getLocale());
        String value = bundle.getString(key);
        return value;
    }

    public TipoEmpleadoForm getTef() {
        if(tef == null){
         tef = new TipoEmpleadoForm();
        }
        return tef;
    }

    public void setTef(TipoEmpleadoForm tef) {
        this.tef = tef;
    }
    
    
    
    
}