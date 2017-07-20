/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.controller;


import com.infomedic.facade.PacienteFacade;
import com.infomedic.forms.PacienteForm;
import com.infomedic.validation.ValidationBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author dell
 */
@Named
//@ViewScoped
@SessionScoped
//@Specializes
public class PacienteController implements Serializable{
    
    private PacienteForm pf = new PacienteForm();
    private @Getter @Setter List<PacienteForm> listaPaciente = new ArrayList<PacienteForm>();
    private @Getter @Setter String nomPac;
    private @Getter @Setter String apePac;
    private @Getter @Setter String dirPac;
    private @Getter @Setter String fecNacPac;
    private @Getter @Setter String genPac;
    private @Getter @Setter String estadoCivilPac;
    private @Getter @Setter String nomPadrePac;
    private @Getter @Setter String nomMadrePac;
    private @Getter @Setter String nomParejaPac;
    private @Getter @Setter String ocupacionPac;
    private @Getter @Setter String correoPac;
    private @Getter @Setter String lugarNacPac;
    private @Getter @Setter String numDuiPac;
    private @Getter @Setter String estadoPac;
    private @Getter @Setter String nomRespPac;
    
    
    @EJB
    private PacienteFacade pfacade;
    
    @EJB
    private ValidationBean vb;
    
    public PacienteController(){}
    
    @PostConstruct
    public void init(){
    listaPaciente = pfacade.obtenerPacientes();
        //System.out.println("com.infomedic.controller.PacienteController.init()");
    }
    
    public void limpiarDatos(){
          this.pf = new PacienteForm();
          nomPac = "";
          apePac = "";
          dirPac = "";
          fecNacPac = "";
          genPac = "";
          estadoCivilPac = "";
          nomPadrePac = "";
          nomMadrePac = "";
          nomParejaPac = "";
          ocupacionPac = "";
          correoPac = "";
          lugarNacPac = "";
          numDuiPac = "";
          nomRespPac = "";
          estadoPac = null;
    
    }
    
    public void guardarPaciente(){
        if (setValores()) {
            if (pfacade.agregarPaciente(pf)) {
                
                //LIMPIAR VARIABLES
                
                vb.lanzarMensaje("info", "titleMsgExitoso", "lblRegExitoso");
                listaPaciente = pfacade.obtenerPacientes();
                //pf = new PacienteForm();
                limpiarDatos();
            } else {
              vb.lanzarMensaje("error", "titleMsgError", "lblRegError");
            }
        }
    
    }
    
    public boolean setValores(){
        boolean flag = true;
        //VALIDACIONES AQUI
        if (flag) {
            if (pf.getIdpaciente() == null) {
                pf = new PacienteForm();
                //SET VARIABLES control a form
                asignacionSinEstado();
                pf.setEstadopaciente("A");
                
            } else if (!pf.getIdpaciente().equals("")) {
                //SET VARIABLES control a form
                asignacionSinEstado();
                estadoPac = pf.getEstadopaciente(); // aqui si se setea estado porque es para editar
            }
        }
        
        
        return flag;
    }
    public void asignacionSinEstado(){
                pf.setNombrepaciente(nomPac);
                pf.setApellidospaciente(apePac);
                pf.setDireccionpaciente(dirPac);
                pf.setFechanacimientopaciente(fecNacPac);
                pf.setGeneropaciente(genPac);
                pf.setEstadocivilpaciente(estadoCivilPac);
                pf.setNombrepadrepaciente(nomPadrePac);
                pf.setNombremadrepaciente(nomMadrePac);
                pf.setNombreparejapaciente(nomParejaPac);
                pf.setOcupacionpaciente(ocupacionPac);
                pf.setCorreopaciente(correoPac);
                pf.setLugarnacimientopaciente(lugarNacPac);
                pf.setNumeroduipaciente(numDuiPac);
                pf.setNombreresponsable(nomRespPac);
    }
 
    
    public String validarSeleccion(){
        String redirect = null;
        if (pf == null) {
            vb.lanzarMensaje("warn", "titleMsgAdv", "lblPacienteReq");
        } else if (pf.equals(new PacienteForm())) {
            vb.lanzarMensaje("warn", "titleMsgAdv", "lblPacienteReq");
        } else if (pf.getIdpaciente().equals("")) {
            vb.lanzarMensaje("warn", "titleMsgAdv", "lblPacienteReq");
        }
        else{
          //SET VARIABLES de form a control
          nomPac = pf.getNombrepaciente();
          apePac = pf.getApellidospaciente();
          dirPac = pf.getDireccionpaciente();
          fecNacPac = pf.getFechanacimientopaciente();
          setGenPac(pf.getGeneropaciente().toUpperCase());
          //genPac = pf.getGeneropaciente();
          estadoCivilPac = pf.getEstadocivilpaciente();
          nomPadrePac = pf.getNombrepadrepaciente();
          nomMadrePac = pf.getNombremadrepaciente();
          nomParejaPac = pf.getNombreparejapaciente();
          ocupacionPac = pf.getOcupacionpaciente();
          correoPac = pf.getCorreopaciente();
          lugarNacPac = pf.getLugarnacimientopaciente();
          numDuiPac = pf.getNumeroduipaciente();
          nomRespPac = pf.getNombreresponsable();
          estadoPac = pf.getEstadopaciente(); //AQUI SI SE SETEA EL ESTADO 
          redirect = "agregarPaciente?faces-redirect=true";
        }
      return redirect;
    }

    public PacienteForm getPf() {
        if (pf == null) {
            pf = new PacienteForm();
        }
        return pf;
    }

    public void setPf(PacienteForm pf) {
        this.pf = pf;
    }
    
    
}