/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.controller;

import com.infomedic.facade.ServicioFacade;
import com.infomedic.facade.TipoServicioFacade;
import com.infomedic.forms.ServicioForm;
import com.infomedic.forms.TipoServicioForm;
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
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author talkcity
 */
@Named
@ViewScoped
public class ServicioController implements Serializable{
    private @Getter @Setter ServicioForm srv = new ServicioForm();
    private @Getter @Setter TipoServicioForm tsv = new TipoServicioForm();
    private @Getter @Setter  List<TipoServicioForm> listaTipoServicio = new ArrayList<TipoServicioForm>();
    private @Getter @Setter  List<ServicioForm> listaServicio = new ArrayList<ServicioForm>();
    private @Getter @Setter String nomServicio;
    private @Getter @Setter String requisitos;
    private @Getter @Setter String idTipoServicio;
    
    @EJB
    private ServicioFacade svfacade;
    
    @EJB
    private TipoServicioFacade tpsvFacade;
    
    @EJB
    private ValidationBean validationBean;

    public ServicioController() {
        
    }
    
    @PostConstruct
    public void init() {
        
        listaTipoServicio = tpsvFacade.obtenerTiposServicio();
        
        idTipoServicio = listaTipoServicio.get(0).getIdtiposervicio();
        
        listaServicio = svfacade.findById(idTipoServicio);                
    }

    public void limpiarDatos(){
        nomServicio= "";
        requisitos= "";
        srv= new ServicioForm();
    }
    
    public void guardarServicio() {
        /*
        if (setValores()) {
            svfacade.setTipoServicio(tpsvFacade.find(new BigDecimal(idTipoServicio)));
            if (svfacade.agregarSrv(srv)) {
                //df.setNombrepais("");
                nomServicio="";
                requisitos="";
                validationBean.lanzarMensaje("info", "titleMsgExitoso", "lblRegExitoso");
                listaServicio = svfacade.findById(idTipoServicio);
                //listaDepartamento = dfacade.obtenerDepartamentos();
                srv = new ServicioForm();
            } else {
                validationBean.lanzarMensaje("error", "titleMsgError", "lblRegError");
            }
        }
        */
    }
    
    public void combochanged(AjaxBehaviorEvent evt){
        //dfacade.setPais(paisFacade.find(new BigDecimal(idPais)));
        listaServicio = svfacade.findById(idTipoServicio);
        srv = new ServicioForm();
        nomServicio="";
        return ;
    }
    
    public boolean setValores() {
        boolean flag = true;
        boolean flag2 = true;
        flag = validationBean.validarCampoVacio(nomServicio, "warn", "titleMsgAdv", "lblNomServicioAdd");
        flag2 = validationBean.validarCampoVacio(requisitos, "warn", "titleMsgAdv", "lblRequisitoAdd");
        if (flag && flag2) {
            if (srv == null) {
                srv=new ServicioForm();
                srv.setNombreservicio(nomServicio);
                srv.setRequisitos(requisitos);
            } else if (!srv.getIdservicio().equals("")) {
                srv.setNombreservicio(nomServicio);
                srv.setRequisitos(requisitos);
            }
        }
        return flag;
    }
    
    public void validarSeleccion() {
        if (srv == null) {
            validationBean.lanzarMensaje("warn", "titleMsgAdv", "lblServicioReq");
        } else if (srv.equals(new ServicioForm())) {
            validationBean.lanzarMensaje("warn", "titleMsgAdv", "lblServicioReq");
        } else if (srv.getIdservicio().equals("")) {
            validationBean.lanzarMensaje("warn", "titleMsgAdv", "lblServicioReq");
        }
        else{
            nomServicio = srv.getNombreservicio();
        }
    }
    
    
}
