/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.controller;

import com.infomedic.facade.PacienteFacade;
import com.infomedic.facade.TelefonoxpacienteFacade;
import com.infomedic.forms.PacienteForm;
import com.infomedic.forms.TelefonoxpacienteForm;
import com.infomedic.validation.ValidationBean;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author dell
 */
@Named
@ViewScoped
//@SessionScoped
//@Specializes
public class PacienteController implements Serializable {

    private PacienteForm pf = new PacienteForm();
    private @Getter
    @Setter
    List<PacienteForm> listaPaciente = new ArrayList<PacienteForm>();
    private @Getter
    @Setter
    List<TelefonoxpacienteForm> listaTels = new ArrayList<TelefonoxpacienteForm>();
    private @Getter
    @Setter
    String nomPac;
    private @Getter
    @Setter
    String apePac;
    private @Getter
    @Setter
    String dirPac;
    private @Getter
    @Setter
    String fecNacPac;
    private @Getter
    @Setter
    String genPac;
    private @Getter
    @Setter
    String estadoCivilPac;
    private @Getter
    @Setter
    String nomPadrePac;
    private @Getter
    @Setter
    String nomMadrePac;
    private @Getter
    @Setter
    String nomParejaPac;
    private @Getter
    @Setter
    String ocupacionPac;
    private @Getter
    @Setter
    String correoPac;
    private @Getter
    @Setter
    String lugarNacPac;
    private @Getter
    @Setter
    String numDuiPac;
    private @Getter
    @Setter
    String estadoPac;
    private @Getter
    @Setter
    String nomRespPac;
    private @Getter
    @Setter
    String numTel;
    private @Getter
    @Setter
    TelefonoxpacienteForm tpf = new TelefonoxpacienteForm();
    //private @Getter @Setter String insertExitoso;
    @EJB
    private PacienteFacade pfacade;

    @EJB
    private TelefonoxpacienteFacade tpfacade;

    @EJB
    private ValidationBean vb;
    
    @Inject
    private LoginController login;

    public PacienteController() {
    }

    @PostConstruct
    public void init() {
        listaPaciente = pfacade.obtenerPacientes(login.getIdusuario());

        //System.out.println("com.infomedic.controller.PacienteController.init()");
    }

    public void limpiarDatos() {
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
        numTel = "";
        tpf = new TelefonoxpacienteForm();
        tpf.setNumerotelefono("");
        this.listaTels = new ArrayList<TelefonoxpacienteForm>();

        estadoPac = null;

    }

    public void guardarPaciente() {
        if (setValores()) {
            if (pfacade.agregarPaciente(pf)) {
                tpfacade.setPaciente(pfacade.getPac());
                tpfacade.agregarTelefonoxpaciente(listaTels);
                //LIMPIAR VARIABLES
                vb.lanzarMensaje("info", "titleMsgExitoso", "lblRegExitoso");
                //FacesContext context = FacesContext.getCurrentInstance();
                //context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, vb.getMsgBundle("titleMsgExitoso"), vb.getMsgBundle("lblRegExitoso") + pf.getNumeroduipaciente()));
                listaPaciente = pfacade.obtenerPacientes(login.getIdusuario());
                //pf = new PacienteForm();
                //this.insertExitoso = "PF('dlgSuccess').show();return false";
                if (pf.getIdpaciente() == null) {
                    RequestContext recon = RequestContext.getCurrentInstance();
                    //"PF('dlgSuccess').show();"
                    String msj = "El paciente " + pf.getNombrepaciente() + " " + pf.getApellidospaciente() + " a sido exitosamente registrado, "
                            + "su codigo de paciente es " + pf.getNumeroduipaciente();
                    recon.execute("mostrar('" + msj + "');");
                }
                limpiarDatos();
            } else {
                vb.lanzarMensaje("error", "titleMsgError", "lblRegError");
            }
        }

    }

    public boolean setValores() {
        boolean flag = true;
        //VALIDACIONES AQUI
        if (!vb.validarCampoVacio(nomPac, "warn", "titleMsgAdv", "lblPacNomAdd")) {
            flag = false;
        } else if (!vb.validarSoloLetras(nomPac, "warn", "titleMsgAdv", "lblLetrasPac")) {
            flag = false;
        }
        if (!vb.validarCampoVacio(apePac, "warn", "titleMsgAdv", "lblPacNomAdd")) {
            flag = false;
        } else if (!vb.validarSoloLetras(apePac, "warn", "titleMsgAdv", "lblLetrasPac")) {
            flag = false;
        }
        if (!vb.validarCampoVacio(fecNacPac, "warn", "titleMsgAdv", "lblPacFnacAdd")) {
            flag = false;
        } else {
            Pattern patron = Pattern.compile("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
            Matcher validar = patron.matcher(fecNacPac);
            if (!validar.find()) {
                flag = false;
                vb.lanzarMensaje("warn", "titleMsgAdv", "lblFormatoFecha");
            }
        }
        if (genPac == null) {
            vb.lanzarMensaje("warn", "titleMsgAdv", "lblPacGenAdd");
            flag = false;
        }
        if (!correoPac.equals("")) {
            if (!vb.validarEmail(correoPac, "warn", "titleMsgAdv", "lblCorreoInvalido")) {
                flag = false;
            }
        }

        if (!nomPadrePac.equals("")) {
            if (!vb.validarSoloLetras(nomPadrePac, "warn", "titleMsgAdv", "lblPadreLetras")) {
                flag = false;
            }
        }
        if (!nomMadrePac.equals("")) {
            if (!vb.validarSoloLetras(nomMadrePac, "warn", "titleMsgAdv", "lblMadreLetras")) {
                flag = false;
            }
        }
        if (!nomParejaPac.equals("")) {
            if (!vb.validarSoloLetras(nomParejaPac, "warn", "titleMsgAdv", "lblParejaLetras")) {
                flag = false;
            }
        }
        if (!nomRespPac.equals("")) {
            if (!vb.validarSoloLetras(nomRespPac, "warn", "titleMsgAdv", "lblRespLetras")) {
                flag = false;
            }
        }
        if (!lugarNacPac.equals("")) {
            if (!vb.validarSoloLetras(lugarNacPac, "warn", "titleMsgAdv", "lblLugNacPac")) {
                flag = false;
            }
        }
        if (!ocupacionPac.equals("")) {
            if (!vb.validarSoloLetras(ocupacionPac, "warn", "titleMsgAdv", "lblOcupaPac")) {
                flag = false;
            }
        }

        if (flag) {
            if (numDuiPac.equals("")) {
                if (this.pf == null) { //agregando
                    numDuiPac = generarCodigo();
                } else if (!this.pf.getIdpaciente().equals("")) {  //editando
                    flag = false;
                    vb.lanzarMensaje("warn", "titleMsgAdv", "lblDuiPacEditar");
                }
            } else //verificar si existe
            if (this.pf == null) {
                if (!pfacade.existeDui(numDuiPac)) {
                    flag = false;
                    vb.lanzarMensaje("warn", "titleMsgAdv", "lblDuiExiste");
                }
            } else if (!this.pf.getIdpaciente().equals("")) {
                if (!pfacade.existeDui(numDuiPac, pf.getIdpaciente())) {
                    flag = false;
                    vb.lanzarMensaje("warn", "titleMsgAdv", "lblDuiExiste");
                }
            }
        }

        /*flag = vb.validarCampoVacio(nomPac, "warn", "titleMsgAdv", "lblPacNomAdd") == true
                ? (vb.validarCampoVacio(apePac, "warn", "titleMsgAdv", "lblPacApeAdd") == true
                ? vb.validarCampoVacio(genPac, "warn", "titleMsgAdv", "lblPacGenAdd") : false)
                : false;*/
        if (flag) {
            if (pf == null) {
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

    public void asignacionSinEstado() {
        pf.setNombrepaciente(nomPac.toUpperCase());
        pf.setApellidospaciente(apePac.toUpperCase());
        pf.setDireccionpaciente(dirPac.toUpperCase());
        pf.setFechanacimientopaciente(fecNacPac);
        pf.setGeneropaciente(genPac);
        pf.setEstadocivilpaciente(estadoCivilPac);
        pf.setNombrepadrepaciente(nomPadrePac.toUpperCase());
        pf.setNombremadrepaciente(nomMadrePac.toUpperCase());
        pf.setNombreparejapaciente(nomParejaPac.toUpperCase());
        pf.setOcupacionpaciente(ocupacionPac.toUpperCase());
        pf.setCorreopaciente(correoPac);
        pf.setLugarnacimientopaciente(lugarNacPac.toUpperCase());
        pf.setNumeroduipaciente(numDuiPac);
        pf.setNombreresponsable(nomRespPac.toUpperCase());
        pf.setIdusuario(String.valueOf(login.getIdusuario()));
        System.out.println("com.infomedic.controller.PacienteController.asignacionSinEstado()");
    }

    public void validarSeleccionEliminar() {
        if (pf == null) {
            vb.lanzarMensaje("warn", "titleMsgAdv", "lblPacienteReq");
        } else if (pf.equals(new PacienteForm())) {
            vb.lanzarMensaje("warn", "titleMsgAdv", "lblPacienteReq");
        } else if (pf.getIdpaciente().equals("")) {
            vb.lanzarMensaje("warn", "titleMsgAdv", "lblPacienteReq");
        } else {
            pf.setEstadopaciente("I");
            if (pfacade.agregarPaciente(pf)) {
                vb.lanzarMensaje("info", "titleMsgExitoso", "lblRegElim");
                listaPaciente = pfacade.obtenerPacientes(login.getIdusuario());
                //pf = new PacienteForm();
                limpiarDatos();
            } else {
                vb.lanzarMensaje("error", "titleMsgError", "lblRegError");
            }

        }

    }

    public void validarSeleccion() {
        String redirect = null;
        if (pf == null) {
            vb.lanzarMensaje("warn", "titleMsgAdv", "lblPacienteReq");
        } else if (pf.equals(new PacienteForm())) {
            vb.lanzarMensaje("warn", "titleMsgAdv", "lblPacienteReq");
        } else if (pf.getIdpaciente().equals("")) {
            vb.lanzarMensaje("warn", "titleMsgAdv", "lblPacienteReq");
        } else {
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
            listaTels = tpfacade.findByIdPac(pf.getIdpaciente());
            //redirect = "agregarPaciente?faces-redirect=true";
        }
        //return redirect;
    }

    public PacienteForm getPf() {
        if (pf == null) {
            pf = new PacienteForm();
        }
        return pf;
    }

    public void setPf(PacienteForm pf) {
        this.pf = pf;
        /* if (pf != null) {
            if (pf.getIdpaciente() != null) {
                listaTels = tpfacade.findByIdPac(pf.getIdpaciente());

            }
        }*/
    }

    public void agregarNumeroALista() {
        if (listaTels.size() >= 3) {
            vb.lanzarMensaje("warn", "titleMsgAdv", "lblTelListMax");
        } else if (this.numTel.length() != 8) {
            vb.lanzarMensaje("warn", "titleMsgAdv", "lblTelVacio");
        } else {
            Integer index = buscarTel(numTel);
            if (index == -1) {
                TelefonoxpacienteForm tpf = new TelefonoxpacienteForm();
                tpf.setIdtipoxtelefono("1");
                tpf.setNumerotelefono(this.numTel);
                this.numTel = "";
                listaTels.add(tpf);
            } else {
                vb.lanzarMensaje("warn", "titleMsgAdv", "lblTelRepetido");
            }
        }

    }

    public void eliminarNumeroDeLista() {
        if (tpf.getNumerotelefono() != null) {
            Integer index = buscarTel(tpf.getNumerotelefono());
            if (index != -1) {
                listaTels.remove(listaTels.get(index));
                tpf = new TelefonoxpacienteForm();
            }
        } else {
            vb.lanzarMensaje("warn", "titleMsgAdv", "lblTelVacio");
        }

    }

    public Integer buscarTel(String num) {
        Integer index = -1;
        for (TelefonoxpacienteForm tels : listaTels) {
            if (tels.getNumerotelefono().equals(num)) {
                index = listaTels.indexOf(tels);
            }
        }
        return index;
    }

    public String generarCodigo() {

        BigDecimal idPaciente = pfacade.getLastId();
        idPaciente = idPaciente.add(new BigDecimal(1));
        String idPacString = String.valueOf(idPaciente);
        String Codigo = "";
        for (int i = idPacString.length(); i < 9; i++) {
            Codigo += "0";
        }
        Codigo += idPacString;

        Codigo = Codigo.substring(0, 8) + "-" + Codigo.substring(8);

        return Codigo;
    }

    /* public String mostrarModalConfirm(){
    String action = "";
        if (insertExitoso) {
            action = "PF('dlgSuccess').show();return false";
        }
        return action;
    }*/
}
