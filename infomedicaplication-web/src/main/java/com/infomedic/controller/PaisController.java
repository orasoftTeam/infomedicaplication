/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.controller;

import com.infomedic.facade.PaisFacade;
import com.infomedic.forms.PaisForm;
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
                lanzarMensaje("info", getMsgBundle("titleMsgExitoso"), getMsgBundle("lblRegExitoso"));
                listaPais = pfacade.obtenerPaises();
                pf= new PaisForm();
            } else {
                lanzarMensaje("error", getMsgBundle("titleMsgError"), getMsgBundle("lblRegError"));
            }
        }
    }

    public boolean setValores() {
        boolean flag = true;
        if ("".equals(nomPais)) {
            flag = false;
            lanzarMensaje("warn", getMsgBundle("titleMsgAdv"), getMsgBundle("lblPaisAdd"));
        } else if (!"".equals(nomPais)) {
            if (pf == null) {
                pf=new PaisForm();
                pf.setNombrepais(nomPais);
            } else if (!pf.getCodpais().equals("")) {
                pf.setNombrepais(nomPais);
            }
        }
        return flag;
    }

    public void validarSeleccion() {
        if (pf == null) {
            lanzarMensaje("warn", getMsgBundle("titleMsgAdv"), getMsgBundle("lblPaisReq"));
        } else if (pf.equals(new PaisForm())) {
            lanzarMensaje("warn", getMsgBundle("titleMsgAdv"), getMsgBundle("lblPaisReq"));
        } else if (pf.getCodpais().equals("")) {
            lanzarMensaje("warn", getMsgBundle("titleMsgAdv"), getMsgBundle("lblPaisReq"));
        }
        else{
            nomPais= pf.getNombrepais();
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
