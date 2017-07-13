/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.controller;

import com.infomedic.facade.TipoXTelefonoFacade;
import com.infomedic.forms.TipoXTelefonoForm;
import com.infomedic.validation.ValidationBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author talkcity
 */
@Named(value = "tipoXTelefonoController")
@ViewScoped
public class TipoXTelefonoController implements Serializable{

    @EJB
    private ValidationBean validationBean;

    @EJB
    private TipoXTelefonoFacade tipoXTelefonoFacade;
    
    private @Getter @Setter TipoXTelefonoForm telForm;
    private @Getter @Setter List<TipoXTelefonoForm> listaTelefonoTipos = new ArrayList<TipoXTelefonoForm>();
    private @Getter @Setter String nombreTipo;
    

    public TipoXTelefonoController() {
    }
    
    @PostConstruct
    public void init() {
        this.listaTelefonoTipos = tipoXTelefonoFacade.obtenerTiposTelefono();
    }
    
    public void limpiarDatos() {
        this.nombreTipo = "";
        this.telForm = new TipoXTelefonoForm();
    }
    
    public void guardarTipoTelefono() {
        if(this.setValores()) {
            if(this.tipoXTelefonoFacade.agregarTipoTelefono(telForm)) {
                this.nombreTipo = "";
                validationBean.lanzarMensaje("info", "titleMsgExitoso", "lblRegExitoso");
                this.listaTelefonoTipos = this.tipoXTelefonoFacade.obtenerTiposTelefono();
                this.telForm = new TipoXTelefonoForm();
            } else {
                validationBean.lanzarMensaje("error", "titleMsgError", "lblRegError");
            }
        }
    }
    
    public boolean setValores() {
        boolean flag = true;
        flag = validationBean.validarCampoVacio(nombreTipo, "warn", "titleMsgAdv", "lblTipoTelefonoAdd") == true
               ? (validationBean.validarSoloLetras(nombreTipo, "warn", "titleMsgAdv", "lblLetras") == true
               ? validationBean.validarLongitudCampo(nombreTipo, 4, 30, "warn", "titleMsgAdv", "lblLongitud") : false)
               : false;
        
        if(flag) {
            if(this.telForm == null) {
                this.telForm = new TipoXTelefonoForm();
                this.telForm.setNombreTipo(this.nombreTipo);
            } else if(!this.telForm.getIdTipoXTelefono().equals("")) {
                this.telForm.setNombreTipo(this.nombreTipo);
            }
        }
        
        return flag;
    }
    
    public void validarSeleccion() {
        if(this.telForm == null) {
            validationBean.lanzarMensaje("warn", "titleMsgAdv", "lblTipoTelefonoReq");
        } else if(this.telForm.equals(new TipoXTelefonoForm())) {
            validationBean.lanzarMensaje("warn", "titleMsgAdv", "lblTipoTelefonoReq");
        } else if(this.telForm.getIdTipoXTelefono().equals("")) {
            validationBean.lanzarMensaje("warn", "titleMsgAdv", "lblTipoTelefonoReq");
        } else {
            this.nombreTipo = this.telForm.getNombreTipo();
        }
    }
    
    
}
