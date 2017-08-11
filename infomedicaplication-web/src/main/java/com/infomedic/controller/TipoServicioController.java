/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.controller;
import com.infomedic.facade.TipoServicioFacade;
import com.infomedic.forms.TipoServicioForm;
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
 * @author talkcity
 */

@Named
@ViewScoped
public class TipoServicioController implements Serializable{
    private TipoServicioForm tsf = new TipoServicioForm();
    private @Getter @Setter  List<TipoServicioForm> listaTipoServicio = new ArrayList<TipoServicioForm>();
    private @Getter @Setter String nomTipoServicio;
    
    @EJB
    private TipoServicioFacade tsfacade;
    
    public TipoServicioController(){
        
    }
    
    @PostConstruct
    public void init() {
        listaTipoServicio = tsfacade.obtenerTiposServicio();
    }
    
    public void guardarTiposServicio() {
        /*
        if (setValores()) {
            if (tsfacade.agregarTipoServicio(tsf)) {
                //pf.setNombrepais("");
                nomTipoServicio="";
                lanzarMensaje("info", getMsgBundle("titleMsgExitoso"), getMsgBundle("lblRegExitoso"));
                listaTipoServicio = tsfacade.obtenerTipoServicio();
                tsf= new TipoServicioForm();
            } else {
                lanzarMensaje("error", getMsgBundle("titleMsgError"), getMsgBundle("lblRegError"));
            }
        }
    */
        
    }
    
    public boolean setValores() {
        boolean flag = true;
        if ("".equals(nomTipoServicio)) {
            flag = false;
            lanzarMensaje("warn", getMsgBundle("titleMsgAdv"), getMsgBundle("lblTipoServicioAdd"));
        } else if (!"".equals(nomTipoServicio)) {
            if (tsf == null) {
                tsf=new TipoServicioForm();
                tsf.setNombretiposervicio(nomTipoServicio);
            } else if (!tsf.getIdtiposervicio().equals("")) {
                tsf.setNombretiposervicio(nomTipoServicio);
            }
        }
        return flag;
    }

    public void validarSeleccion() {
        if (tsf == null) {
            lanzarMensaje("warn", getMsgBundle("titleMsgAdv"), getMsgBundle("lblTipoServicioReq"));
        } else if (tsf.equals(new TipoServicioForm())) {
            lanzarMensaje("warn", getMsgBundle("titleMsgAdv"), getMsgBundle("lblTipoServicioReq"));
        } else if (tsf.getIdtiposervicio().equals("")) {
            lanzarMensaje("warn", getMsgBundle("titleMsgAdv"), getMsgBundle("lblTipoServicioReq"));
        }
        else{
            nomTipoServicio = tsf.getNombretiposervicio();
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

    public TipoServicioForm getTsf() {
         if (tsf == null) {
            tsf = new TipoServicioForm();
        }
        return tsf;
    }

    public void setTsf(TipoServicioForm tsf) {
        this.tsf = tsf;
    }

    
}
