/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.controller;

import com.infomedic.facade.DepartamentoFacade;
import com.infomedic.facade.PaisFacade;
import com.infomedic.forms.DepartamentoForm;
import com.infomedic.forms.PaisForm;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
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
public class DepartamentoController implements Serializable {

    private @Getter @Setter DepartamentoForm df = new DepartamentoForm();
    private @Getter @Setter PaisForm pf = new PaisForm();
    private @Getter @Setter  List<PaisForm> listaPais = new ArrayList<PaisForm>();
    private @Getter @Setter  List<DepartamentoForm> listaDepartamento = new ArrayList<DepartamentoForm>();
    private @Getter @Setter String nomDepartamento;
    private @Getter @Setter String idPais;

    @EJB
    private DepartamentoFacade dfacade;
    
    @EJB
    private PaisFacade paisFacade; 

    public DepartamentoController() {

    }

    @PostConstruct
    public void init() {
        //listaDepartamento = dfacade.obtenerDepartamentos();
        listaPais= paisFacade.obtenerPaises();
        idPais= listaPais.get(0).getIdpais();
        //pf= listaPais.get(0);
        listaDepartamento = dfacade.entityToDtoList(paisFacade.find(new BigDecimal(idPais)).getTblDepartamentoList(), new DepartamentoForm());
    }

    public void guardarDepartamento() {
        if (setValores()) {
            dfacade.setPais(paisFacade.find(new BigDecimal(idPais)));
            if (dfacade.agregarDepto(df)) {
                //df.setNombrepais("");
                nomDepartamento="";
                lanzarMensaje("info", getMsgBundle("titleMsgExitoso"), getMsgBundle("lblRegExitoso"));
                listaDepartamento = dfacade.obtenerDepartamentos();
                df= new DepartamentoForm();
            } else {
                lanzarMensaje("error", getMsgBundle("titleMsgError"), getMsgBundle("lblRegError"));
            }
        }
    }
    
    public void combochanged(AjaxBehaviorEvent evt){
        listaDepartamento = dfacade.entityToDtoList(paisFacade.find(new BigDecimal(idPais)).getTblDepartamentoList(), new DepartamentoForm());
        return ;
    }

    public boolean setValores() {
        boolean flag = true;
        if ("".equals(nomDepartamento)) {
            flag = false;
            lanzarMensaje("warn", getMsgBundle("titleMsgAdv"), getMsgBundle("lblDepartamentoAdd"));
        } else if (!"".equals(nomDepartamento)) {
            if (df == null) {
                df=new DepartamentoForm();
                df.setNombredepartamento(nomDepartamento);
            } else if (!df.getIddepartamento().equals("")) {
                df.setNombredepartamento(nomDepartamento);
            }
        }
        return flag;
    }

    public void validarSeleccion() {
        if (df == null) {
            lanzarMensaje("warn", getMsgBundle("titleMsgAdv"), getMsgBundle("lblDepartamentoReq"));
        } else if (df.equals(new DepartamentoForm())) {
            lanzarMensaje("warn", getMsgBundle("titleMsgAdv"), getMsgBundle("lblDepartamentoReq"));
        } else if (df.getIddepartamento().equals("")) {
            lanzarMensaje("warn", getMsgBundle("titleMsgAdv"), getMsgBundle("lblDepartamentoReq"));
        }
        else{
            nomDepartamento= df.getNombredepartamento();
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
}
