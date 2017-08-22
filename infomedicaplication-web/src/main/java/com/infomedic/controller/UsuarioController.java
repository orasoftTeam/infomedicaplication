/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.controller;

import com.infomedic.facade.UsuarioFacade;
import com.infomedic.forms.UsuarioForm;
import com.infomedic.validation.ValidationBean;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
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
public class UsuarioController implements Serializable{
    
    private UsuarioForm uf = new UsuarioForm();
    private @Getter @Setter String nombreusuario;
    private @Getter @Setter String contrausuario;
    private @Getter @Setter String contrausuario2;
    private @Getter @Setter String correousuario;
    private @Getter @Setter String fechacreacion;
    private @Getter @Setter String estadousuario;
    
    //USERFACADE
    @EJB
    private UsuarioFacade ufacade;
    
    @EJB
    private ValidationBean vb;
    
    public UsuarioController(){}
    
    public void limpiarDatos(){
    uf = new UsuarioForm();
    nombreusuario = "";
    contrausuario = "";
    contrausuario2 = "";
    correousuario = "";
    fechacreacion = "";
    estadousuario = "";
    }
    
    public boolean setValores(){
    boolean flag = true;
    
    //VALIDACIONES AQUI
    
        if (!vb.validarCampoVacio(nombreusuario, "warn","titleMsgAdv" , "lblRegUserVacio")) {
            flag = false;
        }else{
        Pattern patron = Pattern.compile("^[a-zA-Z0-9]*$");
        Matcher validar = patron.matcher(nombreusuario);
            if (!validar.find()) {
                flag = false;
                vb.lanzarMensaje("warn","titleMsgAdv" , "lblRegUserEspacios");
            }
        }
        if (!vb.validarCampoVacio(contrausuario, "warn","titleMsgAdv" , "lblRegUserPassVacio")) {
            flag = false;
        }else{
        if (!vb.validarCampoVacio(contrausuario2, "warn","titleMsgAdv" , "lblRegUserPassVacio2")) {
            flag = false;
        }else{
         if (!contrausuario.equals(contrausuario2)) {
            flag = false;
            vb.lanzarMensaje("warn","titleMsgAdv" , "lblRegUserPassDiff");
        }
        }
        }
        if (!vb.validarCampoVacio(correousuario, "warn","titleMsgAdv" , "lblRegUserCorreo")) {
            flag = false;
           
        }else{
         if (!vb.validarEmail(correousuario, "warn", "titleMsgAdv", "lblCorreoInvalido")) {
                flag = false;
            }
        }
       
    
        if (flag) {
            uf.setNombreusuario(nombreusuario);
            uf.setContrausuario(contrausuario);
            uf.setEstadousuario("A");
            uf.setCorreousuario(correousuario);
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            uf.setFechacreacion(dateFormat.format(date));
            System.out.println("com.infomedic.controller.UsuarioController.setValores()");
            
        }
    
    return flag;
    }
    
    public void guardarUsuario(){
        if (setValores()) {
            if (ufacade.agregarUsuario(uf)) {
                vb.lanzarMensaje("info", "titleMsgExitoso", "lblRegExitoso");
                limpiarDatos();
            }else{
              vb.lanzarMensaje("error", "titleMsgError", "lblRegError");
            }
            
            
            
        }
    }
    
}
