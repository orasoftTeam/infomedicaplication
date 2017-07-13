/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.controller;

import com.infomedic.facade.EspecialidadFacade;
import javax.inject.Named;
import com.infomedic.forms.EspecialidadForm;
import com.infomedic.validation.ValidationBean;
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
    private ValidationBean validationBean;

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
    
    public void limpiarDatos() {
        this.nomEspecialidad = "";
        this.specForm = new EspecialidadForm();
    }
    
    public void guardarEspecialidad() {
        if(this.setValores()) {
            if(this.EspecFacade.agregarEspecialidad(this.specForm)) {
                this.nomEspecialidad = "";
                validationBean.lanzarMensaje("info", "titleMsgExitoso", "lblRegExitoso");
                this.listaEspecialidad = this.EspecFacade.obtenerEspecialidades();
                this.specForm = new EspecialidadForm();
            } else {
                validationBean.lanzarMensaje("error", "titleMsgError", "lblRegError");
            }
        }
    }
    
    public boolean setValores() {
        boolean flag = true;
        
        flag = validationBean.validarCampoVacio(nomEspecialidad, "warn", "titleMsgAdv", "lblTipoTelefonoAdd") == true
               ? (validationBean.validarSoloLetras(nomEspecialidad, "warn", "titleMsgAdv", "lblLetras") == true
               ? validationBean.validarLongitudCampo(nomEspecialidad, 5, 30, "warn", "titleMsgAdv", "lblLongitud") : false)
               : false;
        
        
        if(flag) {
            if(this.specForm == null) {
                this.specForm = new EspecialidadForm();
                this.specForm.setNombreEspecialidad(this.nomEspecialidad);
            } else if(!this.specForm.getIdEspecialidad().equals("")) {
                this.specForm.setNombreEspecialidad(nomEspecialidad);
            }
        }
        
        return flag;
    }
    
    public void validarSeleccion() {
        if(this.specForm == null) {
            validationBean.lanzarMensaje("warn", "titleMsgAdv", "lblEspecialidadReq");
        } else if(this.specForm.equals(new EspecialidadForm())) {
            validationBean.lanzarMensaje("warn", "titleMsgAdv", "lblEspecialidadReq");
        } else if(this.specForm.getIdEspecialidad().equals("")) {
            validationBean.lanzarMensaje("warn", "titleMsgAdv", "lblEspecialidadReq");
        } else {
            this.nomEspecialidad = this.specForm.getNombreEspecialidad();
        }
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
