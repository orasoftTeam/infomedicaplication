/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.controller;

import com.infomedic.facade.EmpleadoEspecialidadFacade;
import com.infomedic.facade.EmpleadoFacade;
import com.infomedic.facade.EspecialidadFacade;
import com.infomedic.facade.FormacionEmpleadoFacade;
import com.infomedic.facade.TelefonoEmpleadoFacade;
import com.infomedic.facade.TipoEmpleadoFacade;
import com.infomedic.forms.DepartamentoForm;
import com.infomedic.forms.EmpleadoForm;
import javax.inject.Named;
import com.infomedic.forms.EspecialidadForm;
import com.infomedic.forms.FormacionProfesionalForm;
import com.infomedic.forms.TelefonoXEmpleadoForm;
import com.infomedic.forms.TipoEmpleadoForm;
import com.infomedic.validation.ValidationBean;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import lombok.Getter;
import lombok.Setter;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author talkcity
 */
@Named(value = "empleadoController")
@ViewScoped
public class EmpleadoController implements Serializable {

    @EJB
    private FormacionEmpleadoFacade formacionEmpleadoFacade;

    @EJB
    private TelefonoEmpleadoFacade telefonoEmpleadoFacade;

    @EJB
    private EmpleadoFacade empleadoFacade;

    @EJB
    private EspecialidadFacade especialidadFacade;

    @EJB
    private TipoEmpleadoFacade tipoEmpleadoFacade;

    @EJB
    private ValidationBean validationBean;

    @EJB

    private EmpleadoEspecialidadFacade empespFacade;

    private @Getter
    @Setter
    EmpleadoForm emp = new EmpleadoForm();

    private @Getter
    @Setter
    EmpleadoForm selectEmp = new EmpleadoForm();
    private @Getter
    @Setter
    List<EmpleadoForm> listaEmpleado = new ArrayList<EmpleadoForm>();
    private @Getter
    @Setter
    List<TipoEmpleadoForm> listaTipoEmpleado = new ArrayList<TipoEmpleadoForm>();
    private @Getter
    @Setter
    List<TelefonoXEmpleadoForm> listaTelefono = new ArrayList<TelefonoXEmpleadoForm>();

    private @Getter
    @Setter
    List<FormacionProfesionalForm> listaFormacion = new ArrayList<FormacionProfesionalForm>();

    private @Getter
    @Setter
    FormacionProfesionalForm selectFormacion = new FormacionProfesionalForm();

    private @Getter
    @Setter
    FormacionProfesionalForm formacion = new FormacionProfesionalForm();

    private @Getter
    @Setter
    TelefonoXEmpleadoForm selectedTel = new TelefonoXEmpleadoForm();

    private @Getter
    @Setter
    String tipoEmpleado;
    private @Getter
    @Setter
    String telefono;

    private @Getter
    @Setter
    List<EspecialidadForm> listaEspecialidad = new ArrayList<EspecialidadForm>();

    private @Getter
    @Setter
    String profesional = "";

    private @Getter
    @Setter
    String especialidad;

    private @Getter
    @Setter
    boolean isEmpleado = false;
    //private @Getter @Setter String nomEspecialidad;

    public EmpleadoController() {
    }

    @PostConstruct
    public void init() {
        listaTipoEmpleado = tipoEmpleadoFacade.obtenerTiposEmpleado();
        listaEspecialidad = especialidadFacade.obtenerEspecialidades();
        listaEmpleado = empleadoFacade.obtenerEmpleados();
        //this.listaEspecialidad = this.EspecFacade.obtenerEspecialidades();
    }

    public boolean agregarEmpleado() {
        boolean flag = true;
        emp.setFechainicio(validationBean.obtenerFechaActual());
        // empleadoFacade.setEmpleado(empleadoFacade.buscarEmpleado(emp.getDuiempleado(), emp.getNitempleado()));
        if (tipoEmpleado != null && !tipoEmpleado.equals("")) {
            empleadoFacade.setTipoEmpleado(tipoEmpleadoFacade.find(new BigDecimal(getTipoEmpleado())));
            if (empleadoFacade.agregarEmpleado(emp)) {
                if (especialidad != null && !especialidad.equals("")) {
                    empespFacade.setEmpleado(empleadoFacade.getEmpleado());
                    empespFacade.setEspecialidad(especialidadFacade.find(new BigDecimal(especialidad)));
                    if (!empespFacade.agregarEmpleadoEspecialidad()) {
                        flag = false;
                        validationBean.lanzarMensaje("warn", "empleadoTitulo", "empEspError");
                    }
                }
                telefonoEmpleadoFacade.setEmpleado(empleadoFacade.getEmpleado());
                if (telefonoEmpleadoFacade.agregarTelefonoEmpleado(listaTelefono)) {
                    formacionEmpleadoFacade.setEmpleado(telefonoEmpleadoFacade.getEmpleado());
                    if (!formacionEmpleadoFacade.agregarFormacion(listaFormacion)) {
                        flag = false;
                        validationBean.lanzarMensaje("warn", "empleadoTitulo", "empFormError");
                    }
                } else {
                    validationBean.lanzarMensaje("warn", "empleadoTitulo", "empTelError");
                    flag = false;
                }
            } else {
                validationBean.lanzarMensaje("warn", "empleadoTitulo", "empError");
                flag = false;
            }
        }
        else{
            validationBean.lanzarMensaje("warn", "empleadoTitulo", "lblTipoEmpleadoReq");
            flag = false;           
        }
        /*
        telefonoEmpleadoFacade.setEmpleado(empleadoFacade.getEmpleado());
        telefonoEmpleadoFacade.agregarTelefonoEmpleado(listaTelefono);
        formacionEmpleadoFacade.setEmpleado(telefonoEmpleadoFacade.getEmpleado());
        formacionEmpleadoFacade.agregarFormacion(listaFormacion);
         */
        return flag;
    }

    public void agregarTelefono() {

        if (listaTelefono.size() < 3) {
            if (profesional.length() == 8) {
                TelefonoXEmpleadoForm ext = new TelefonoXEmpleadoForm();
                ext.setNumerotelefono(getProfesional());
                Integer busqueda = buscarTelefono(listaTelefono, getProfesional());
                if (busqueda == -1) {
                    listaTelefono.add(ext);
                    setProfesional("");
                } else {
                    validationBean.lanzarMensaje("warn", "empleadoTitulo", "lblTelExist");
                    setProfesional("");
                }
            } else {
                validationBean.lanzarMensaje("warn", "empleadoTitulo", "errorTelefono");
                setProfesional("");
            }
        } else {
            validationBean.lanzarMensaje("warn", "empleadoTitulo", "errorCantidadTel");
            setProfesional("");
        }

        //System.out.println(profesional);
        return;
    }

    public void agregarFormacion() {
        if (listaFormacion.size() < 4) {
            if (validationBean.validarCampoVacio(formacion.getInstitucionestudio(), "warn", "empleadoTitulo", "errorReqInstitucion")) {
                if (validationBean.validarCampoVacio(formacion.getConceptoestudio(), "warn", "empleadoTitulo", "errorReqTitulo")) {
                    if (validationBean.validarCampoVacio(formacion.getConceptoestudio(), "warn", "empleadoTitulo", "errorReqTitulo")) {
                        if (validationBean.validarCampoVacio(formacion.getAnioestudio(), "warn", "empleadoTitulo", "errorReqAnio")
                                && validationBean.validarLongitudCampo(formacion.getAnioestudio(), 4, 4, "warn", "empleadoTitulo", "errorReqAnio")) {
                            listaFormacion.add(formacion);
                            formacion = new FormacionProfesionalForm();
                        }
                    }
                }
            }
        } else {
            validationBean.lanzarMensaje("warn", "empleadoTitulo", "errorCantidadFormacion");
            formacion = new FormacionProfesionalForm();
        }
    }

    public Integer buscarTelefono(List<TelefonoXEmpleadoForm> lista, String numero) {
        Integer i = 0;
        for (TelefonoXEmpleadoForm obj : lista) {
            if (obj.getNumerotelefono().equals(numero)) {
                return i;
            }
            i++;
        }
        return i == lista.size() ? -1 : i;
    }

    public Integer buscarFormacion(List<FormacionProfesionalForm> lista, FormacionProfesionalForm fp) {
        Integer i = 0;
        for (FormacionProfesionalForm obj : lista) {
            /*
            System.out.println("Objeto-------------");
            System.out.println(obj.getInstitucionestudio());
            System.out.println(obj.getConceptoestudio());
            System.out.println(obj.getAnioestudio());
            System.out.println("Formulario-------------");
            System.out.println(fp.getInstitucionestudio());
            System.out.println(fp.getConceptoestudio());
            System.out.println(fp.getAnioestudio());
             */
            if (obj.getInstitucionestudio().equals(fp.getInstitucionestudio())
                    && obj.getConceptoestudio().equals(fp.getConceptoestudio())
                    && obj.getAnioestudio().equals(fp.getAnioestudio())) {
                return i;
            }
            i++;
        }
        return i == lista.size() ? -1 : i;
    }

    public List<FormacionProfesionalForm> eliminarLista(List<FormacionProfesionalForm> lista, FormacionProfesionalForm fp) {
        List<FormacionProfesionalForm> temp = new ArrayList<>();
        for (FormacionProfesionalForm obj : lista) {
            if (!(obj.getInstitucionestudio().equals(fp.getInstitucionestudio())
                    && obj.getConceptoestudio().equals(fp.getConceptoestudio())
                    && obj.getAnioestudio().equals(fp.getAnioestudio()))) {
                temp.add(obj);
            }
        }
        return temp;
    }

    public void eliminarFormacion() {
        if (getTelefono() != null && !getTelefono().equals("")) {
            String[] campos = getTelefono().split(",");
            selectFormacion.setInstitucionestudio(campos[0].trim());
            selectFormacion.setConceptoestudio(campos[1].trim());
            selectFormacion.setAnioestudio(campos[2].trim());
            Integer busqueda = buscarFormacion(listaFormacion, selectFormacion);
            System.err.println("id Busqueda" + busqueda);
            if (busqueda != -1) {
                listaFormacion = eliminarLista(listaFormacion, selectFormacion);
                System.err.println("Entró acá en eliminar");
            }
        } else {
            validationBean.lanzarMensaje("warn", "empleadoTitulo", "errorSelectFormacion");
        }
        setTelefono("");
        return;

    }

    public void eliminarTelefono() {

        Integer busqueda = buscarTelefono(listaTelefono, selectedTel.getNumerotelefono());
        listaTelefono = eliminarLista(listaTelefono, selectedTel.getNumerotelefono());
        setTelefono("");
        return;
    }

    public List<TelefonoXEmpleadoForm> eliminarLista(List<TelefonoXEmpleadoForm> lista, String telefono) {
        List<TelefonoXEmpleadoForm> temp = new ArrayList<>();
        for (TelefonoXEmpleadoForm obj : lista) {
            if (!obj.getNumerotelefono().equals(telefono)) {
                temp.add(obj);
            }
        }
        return temp;
    }

    public void validarCamposFormulario() {
        boolean flag = true;
        if (validationBean.validarCampoVacio(getTipoEmpleado(), "warn", "empleadoTitulo", "lblTipoEmpleadoReq")) {
            if (validationBean.validarCampoVacio(emp.getNombreempleado(), "warn", "empleadoTitulo", "lblReqNom")
                    && validationBean.validarLongitudCampo(emp.getNombreempleado(), 4, 50, "warn", "empleadoTitulo", "lblLongitud")) {
                if (validationBean.validarCampoVacio(emp.getApellidoempleado(), "warn", "empleadoTitulo", "lblReqApe")
                        && validationBean.validarLongitudCampo(emp.getApellidoempleado(), 4, 50, "warn", "empleadoTitulo", "lblLongitud")) {
                    if (validationBean.validarCampoVacio(emp.getDuiempleado(), "warn", "empleadoTitulo", "lblReqDui")
                            && validationBean.validarLongitudCampo(emp.getDuiempleado().replace("-", ""), 9, 9, "warn", "empleadoTitulo", "lblReqDui")) {
                        if (validationBean.validarLongitudCampo(emp.getGeneroempleado(), 1, 1, "warn", "empleadoTitulo", "lblReqGen")) {
                            if (validationBean.validarFecha(emp.getFechanacimientoempleado(), "warn", "empleadoTitulo", "lblInvFecha")) {
                                if (agregarEmpleado()) {
                                    listaEmpleado = empleadoFacade.obtenerEmpleados();
                                    validationBean.lanzarMensaje("info", "empleadoTitulo", "lblRegExitoso");
                                    resetear();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void resetear() {
        emp = new EmpleadoForm();
        setProfesional("");
        setTelefono("");
        selectedTel = new TelefonoXEmpleadoForm();
        formacion = new FormacionProfesionalForm();
        listaFormacion = new ArrayList<>();
        listaTelefono = new ArrayList<>();
        selectEmp = new EmpleadoForm();
    }

    public void validarSeleccion() {
        if (selectEmp == null) {
            validationBean.lanzarMensaje("warn", "empleadoTitulo", "lblSelectEmpReq");
        } else if (selectEmp.equals(new EmpleadoForm())) {
            validationBean.lanzarMensaje("warn", "empleadoTitulo", "lblSelectEmpReq");
        } else if (selectEmp.getIdempleado().equals("")) {
            validationBean.lanzarMensaje("warn", "empleadoTitulo", "lblSelectEmpReq");
        } else {
            empleadoFacade.setEmpleado(empleadoFacade.buscarEmpleado(selectEmp.getDuiempleado(), selectEmp.getNitempleado()));
            listaTelefono = telefonoEmpleadoFacade.findByIdEmp(selectEmp.getIdempleado());
            listaFormacion = formacionEmpleadoFacade.findByIdEmp(selectEmp.getIdempleado());
           // selectEmp.setFechanacimientoempleado(validationBean.formatearFecha(selectEmp.getFechanacimientoempleado()));
            System.err.println("fecha de nacimiento: "+ selectEmp.getFechanacimientoempleado());
            emp = selectEmp;
            //emp.setFechanacimientoempleado(validationBean.formatearFecha(selectEmp.getFechanacimientoempleado()));
            System.err.println("fecha de nacimiento2: "+ emp.getFechanacimientoempleado());
            //listaEmpleado = empleadoFacade.obtenerEmpleados();
            List<TipoEmpleadoForm> tipo = tipoEmpleadoFacade.findByIdEmpleado(selectEmp.getIdempleado());
            tipoEmpleado = tipo.isEmpty() ? "" : tipo.get(0).getIdtipoempleado();
            List<EspecialidadForm> espe = especialidadFacade.finByIdEmpleado(selectEmp.getIdempleado());
            especialidad = espe.isEmpty() ? "" : espe.get(0).getIdEspecialidad();
            
            // nomDepartamento= df.getNombredepartamento();
        }
    }

}
