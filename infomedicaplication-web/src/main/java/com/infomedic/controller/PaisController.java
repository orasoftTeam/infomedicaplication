/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.controller;

import com.infomedic.facade.PaisFacade;
import com.infomedic.forms.PaisForm;
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
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author LAP
 */
@Named
@ViewScoped
public class PaisController implements Serializable {

    private PaisForm pf = new PaisForm();
    private @Getter @Setter  List<PaisForm> listaPais = new ArrayList<PaisForm>();
    private @Getter @Setter String nomPais;

    @EJB
    private PaisFacade pfacade;
    
    @EJB
    private ValidationBean validationBean;

    public PaisController() {

    }

    @PostConstruct
    public void init() {
        listaPais = pfacade.obtenerPaises();
    }

    public void guardarPais() {
        if (setValores()) {
            if (pfacade.agregarPais(pf)) {
                //pf.setNombrepais("");
                nomPais="";
                validationBean.lanzarMensaje("info", "titleMsgExitoso", "lblRegExitoso");
                listaPais = pfacade.obtenerPaises();
                pf= new PaisForm();
            } else {
                validationBean.lanzarMensaje("error", "titleMsgError", "lblRegError");
            }
        }
    }

    public boolean setValores() {
        boolean flag = true;
        flag= validationBean.validarCampoVacio(nomPais, "warn", "titleMsgAdv", "lblPaisAdd");
        if (flag) {
            if (pf == null) {
                pf=new PaisForm();
                pf.setNombrepais(nomPais);
            } else if (!pf.getIdpais().equals("")) {
                pf.setNombrepais(nomPais);
            }
        }
        return flag;
    }

    public void validarSeleccion() {
        if (pf == null) {
            validationBean.lanzarMensaje("warn", "titleMsgAdv", "lblPaisReq");
        } else if (pf.equals(new PaisForm())) {
            validationBean.lanzarMensaje("warn", "titleMsgAdv", "lblPaisReq");
        } else if (pf.getIdpais().equals("")) {
            validationBean.lanzarMensaje("warn", "titleMsgAdv", "lblPaisReq");
        }
        else{
            nomPais= pf.getNombrepais();
        }
    }
 

    public PaisForm getPf() {
        if (pf == null) {
            pf = new PaisForm();
        }
        return pf;
    }

    public void setPf(PaisForm pf) {
        this.pf = pf;
    }
}
