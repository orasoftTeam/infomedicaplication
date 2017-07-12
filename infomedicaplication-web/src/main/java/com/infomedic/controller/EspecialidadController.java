/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.controller;

import com.infomedic.facade.EspecialidadFacade;
import javax.inject.Named;
import com.infomedic.forms.EspecialidadForm;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author talkcity
 */
@Named(value = "especialidadController")
@ViewScoped
public class EspecialidadController implements Serializable{

    @EJB
    private EspecialidadFacade EspecFacade;

    private EspecialidadForm specForm = new EspecialidadForm();
    private @Getter @Setter List<EspecialidadForm> listaEspecialidad = new ArrayList<>();
    private @Getter @Setter String nomEspecialidad;
    

    public EspecialidadController() {
    }
    
    @PostConstruct
    public void init() {
       this.listaEspecialidad = this.EspecFacade.obtenerEspecialidades();
    }
    
    public void guardarEspecialidad() {
        if(this.setValores()) {
            if(this.EspecFacade.agregarEspecialidad(this.specForm)) {
                this.nomEspecialidad = "";
                lanzarMensaje("info", getMesgBundle("titleMsgExitoso"), getMesgBundle("lblRegExitoso"));
                this.listaEspecialidad = this.EspecFacade.obtenerEspecialidades();
                this.specForm = new EspecialidadForm();
            } else {
                lanzarMensaje("error", getMesgBundle("titleMsgError"), getMesgBundle("lblRegError"));
            }
        }
    }
    
    public boolean setValores() {
        boolean flag = true;
        if("".equals(this.nomEspecialidad)) {
            flag = false;
            this.lanzarMensaje("warn", this.getMesgBundle("titleMsgAdv"), this.getMesgBundle("lblEspecialidadAdd"));
        } else if(!"".equals(this.nomEspecialidad)) {
            if(this.specForm == null) {
                this.specForm = new EspecialidadForm();
                this.specForm.setNombreEspecialidad(this.nomEspecialidad);
            } else if(!this.specForm.getIdEspecialidad().equals("")) {
                this.specForm.setNombreEspecialidad(this.nomEspecialidad);
            }
        }
        
        return flag;
    }
    
    public void validarSeleccion() {
        if(this.specForm == null) {
            this.lanzarMensaje("warn", this.getMesgBundle("titleMsgAdv"), this.getMesgBundle("lblEspecialidadReq"));
        } else if(this.specForm.equals(new EspecialidadForm())) {
            this.lanzarMensaje("warn", this.getMesgBundle("titleMsgAdv"), this.getMesgBundle("lblEspecialidadReq"));
        } else if(this.specForm.getIdEspecialidad().equals("")) {
            this.lanzarMensaje("warn", this.getMesgBundle("titleMsgAdv"), this.getMesgBundle("lblEspecialidadReq"));
        } else {
            this.nomEspecialidad = this.specForm.getNombreEspecialidad();
        }
    }
    
    public void lanzarMensaje(String tipo, String titulo, String msg) {
        FacesMessage.Severity typeMessage;
        
        switch(tipo.toLowerCase()) {
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
    
    public String getMesgBundle(String key) {
        ResourceBundle bundle = ResourceBundle.getBundle("/Bundle", FacesContext.getCurrentInstance().getViewRoot().getLocale());
        String value = bundle.getString(key);
        return value;
    }

    public EspecialidadForm getSpecForm() {
        if(this.specForm == null) {
            this.specForm = new EspecialidadForm();
        }
        
        return this.specForm;
    }

    public void setSpecForm(EspecialidadForm specForm) {
        this.specForm = specForm;
    }
    
    
    
}
