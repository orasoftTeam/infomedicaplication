/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.controller;


import com.infomedic.facade.MenuFacade;
import com.infomedic.facade.UserFacade;
import com.infomedic.forms.MenuForm;
import com.infomedic.forms.UserForm;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author LAP
 */

/*
@ManagedBean(name = "login")
@SessionScoped
*/
//@Named (value = "login")
@ManagedBean
@Named (value = "login")
@SessionScoped
public class LoginController implements Serializable{

    @EJB
    private MenuFacade menuFacade;

    @EJB
    private UserFacade userFacade;

    private @Getter
    @Setter
    String idCompany = "";
    private @Getter
    @Setter
    String idRol = "";
    private @Getter
    @Setter
    String usuario;
    private @Getter
    @Setter
    String password;
    
    private @Getter @Setter String nombreUsuario;
    private @Getter @Setter Integer idusuario;
    
    private @Getter @Setter boolean loggedIn;

    private @Getter
    @Setter
    List<MenuForm> listaModulos = new ArrayList<>();
    private @Getter
    @Setter
    List<MenuForm> listaOpciones = new ArrayList<>();

    private @Getter
    @Setter
    MenuModel menubar = new DefaultMenuModel();

    @PostConstruct
    public void init() {

    }

    public void cargarMenus() {
        DefaultSubMenu subMenu;
        for (MenuForm obj : listaModulos) {
            listaOpciones = menuFacade.buscarOpciones(obj.getCodmodulo(), idCompany);
            subMenu = new DefaultSubMenu(obj.getDesaplic());
            DefaultMenuItem item;
            for (MenuForm obj2 : listaOpciones) {
                item = new DefaultMenuItem(obj2.getDesaplic());
                item.setUrl("/faces/seguridad/" + obj2.getOpcion());
                subMenu.addElement(item);
            }
            this.menubar.addElement(subMenu);
        }
        return;
    }
    
    public boolean buscarMenus(String op) {
        
        for (MenuForm obj : listaModulos) {
            listaOpciones = menuFacade.buscarOpciones(obj.getCodmodulo(), idCompany);
            for (MenuForm obj2 : listaOpciones) {
                if(obj2.getOpcion().equalsIgnoreCase(op))
                    return true;
            }
        }
        return false;
    }

    public void limpiar() {
        setUsuario("");
        setPassword("");
        menubar = new DefaultMenuModel();
    }
    
    public List<MenuForm> obtenerListaOpciones(String codModulo) {
        listaOpciones = menuFacade.buscarOpciones(codModulo, idCompany);
        return listaOpciones;
    }

    public void logear() {
        String pag = "";
        UserForm usuario = userFacade.getUser(getUsuario(), getPassword());
        if (usuario.getIdusuario() == null) {
            limpiar();
            // pag="faces/login.xhtml";
           // JsfUtil.addErrorMessage(ResourceBundle.getBundle("/Bundle").getString("titleUserNotFound"));
        } else if (usuario.getIdusuario() != null) {
            pag = "/pages/paciente/agregarPaciente.xhtml";
            setIdRol(usuario.getIdrol());
            setIdCompany(usuario.getIdcompany());
            setNombreUsuario(usuario.getNombre());
            setIdusuario(Integer.valueOf(usuario.getIdusuario()));
            listaModulos = menuFacade.buscarModulos(idRol, idCompany);
            //cargarMenus();
            setLoggedIn(true);
            redireccionar(pag);
        }
    }
    public void redirectLogin(){
        redireccionar("/login.xhtml");
    }
    
    public void doLogout() {
        // Set the paremeter indicating that user is logged in to false
        loggedIn = false;
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
        .getExternalContext().getSession(false);
        session.invalidate(); 
        String pag= "/login.xhtml";
        redireccionar(pag);
    }
    
    public void redireccionar(String pag){
            try {
                ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                context.redirect(context.getRequestContextPath()+pag);
            } catch (IOException ex) {
                //JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("titleUserNotFound"));
                //Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void redireccionarEnlaces(String pag){
            try {
                ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                context.redirect(context.getRequestContextPath() + "/pages/" +pag);
            } catch (IOException ex) {
                //JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("titleUserNotFound"));
                //Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
