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
import com.infomedic.validation.ValidationBean;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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
    
    @EJB
    private ValidationBean validationBean;

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
           // dfacade.setPais(paisFacade.find(new BigDecimal(idPais)));
            if (dfacade.agregarDepto(df)) {
                //df.setNombrepais("");
                nomDepartamento="";
                validationBean.lanzarMensaje("info", "titleMsgExitoso", "lblRegExitoso");
                listaDepartamento = dfacade.findById(idPais);
                //listaDepartamento = dfacade.obtenerDepartamentos();
                df= new DepartamentoForm();
            } else {
                validationBean.lanzarMensaje("error", "titleMsgError", "lblRegError");
            }
        }
    }
    
   
    
    public void combochanged(AjaxBehaviorEvent evt){
        //dfacade.setPais(paisFacade.find(new BigDecimal(idPais)));
        listaDepartamento = dfacade.findById(idPais);
        df= new DepartamentoForm();
        nomDepartamento="";
        return ;
    }

    public boolean setValores() {
        boolean flag = true;
        flag = validationBean.validarCampoVacio(nomDepartamento, "warn", "titleMsgAdv", "lblDepartamentoAdd");
        if (flag) {
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
            validationBean.lanzarMensaje("warn", "titleMsgAdv", "lblDepartamentoReq");
        } else if (df.equals(new DepartamentoForm())) {
            validationBean.lanzarMensaje("warn", "titleMsgAdv", "lblDepartamentoReq");
        } else if (df.getIddepartamento().equals("")) {
            validationBean.lanzarMensaje("warn", "titleMsgAdv", "lblDepartamentoReq");
        }
        else{
            nomDepartamento= df.getNombredepartamento();
        }
    }
}
