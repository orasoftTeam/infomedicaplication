/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.controller;

import com.infomedic.facade.EmpleadoEspecialidadFacade;
import com.infomedic.facade.EmpleadoFacade;
import com.infomedic.facade.EmpleadoXServicioFacade;
import com.infomedic.facade.EspecialidadFacade;
import com.infomedic.facade.FormacionEmpleadoFacade;
import com.infomedic.facade.HorarioXServicioFacade;
import com.infomedic.facade.ServicioFacade;
import com.infomedic.facade.TelefonoEmpleadoFacade;
import com.infomedic.facade.TipoEmpleadoFacade;
import com.infomedic.facade.TipoServicioFacade;
import com.infomedic.forms.DepartamentoForm;
import com.infomedic.forms.EmpleadoForm;
import com.infomedic.forms.EmpleadoServicioForm;
import javax.inject.Named;
import com.infomedic.forms.EspecialidadForm;
import com.infomedic.forms.FormacionProfesionalForm;
import com.infomedic.forms.HorarioXServicioForm;
import com.infomedic.forms.ServicioForm;
import com.infomedic.forms.TelefonoXEmpleadoForm;
import com.infomedic.forms.TipoEmpleadoForm;
import com.infomedic.forms.TipoServicioForm;
import com.infomedic.validation.ValidationBean;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    private TipoServicioFacade tipoServicioFacade;
    
    @EJB
    private ServicioFacade servicioFacade;

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
    
    @EJB
    
    private EmpleadoXServicioFacade empservFacade;
    
    @EJB
    private HorarioXServicioFacade horaservFacade;
    


    private @Getter @Setter EmpleadoForm emp = new EmpleadoForm();

    private @Getter @Setter EmpleadoForm selectEmp = new EmpleadoForm();
    private @Getter @Setter List<EmpleadoForm> listaEmpleado = new ArrayList<EmpleadoForm>();
    
    private @Getter @Setter EmpleadoForm selectEmp2 = new EmpleadoForm();
    private @Getter @Setter List<EmpleadoForm> listaEmpleado2 = new ArrayList<EmpleadoForm>();
    
    private @Getter @Setter List<TipoServicioForm> listaTipoServicios= new ArrayList<>();
    
    private @Getter @Setter List<ServicioForm> listaServicios= new ArrayList<ServicioForm>();
    private @Getter @Setter List<ServicioForm> listaServicios2= new ArrayList<ServicioForm>();
    private @Getter @Setter TipoServicioForm tipoServicio= new TipoServicioForm();
    
    private @Getter @Setter ServicioForm servicio= new ServicioForm();
    private @Getter @Setter ServicioForm servicio2= new ServicioForm();
    private @Getter @Setter List<TipoEmpleadoForm> listaTipoEmpleado = new ArrayList<TipoEmpleadoForm>();
    private @Getter @Setter List<TelefonoXEmpleadoForm> listaTelefono = new ArrayList<TelefonoXEmpleadoForm>();
    
    private @Getter @Setter List<EmpleadoServicioForm> listaEmpServ= new ArrayList<>();

    private @Getter @Setter List<FormacionProfesionalForm> listaFormacion = new ArrayList<FormacionProfesionalForm>();

    private @Getter @Setter FormacionProfesionalForm selectFormacion = new FormacionProfesionalForm();

    private @Getter @Setter FormacionProfesionalForm formacion = new FormacionProfesionalForm();

    private @Getter @Setter TelefonoXEmpleadoForm selectedTel = new TelefonoXEmpleadoForm();
    
    private @Getter @Setter HorarioXServicioForm horaxserv= new HorarioXServicioForm();
    
    private @Getter @Setter HorarioXServicioForm horaxserv2= new HorarioXServicioForm();
    
    private @Getter @Setter List<HorarioXServicioForm> listaHorarios= new ArrayList<HorarioXServicioForm>();
    
     private @Getter @Setter List<HorarioXServicioForm> listaHorarios2= new ArrayList<HorarioXServicioForm>();
    
    private @Getter @Setter Date horaIni;
    private @Getter @Setter Date horaFin;
    
    
    private @Getter @Setter String tipoEmpleado;
    private @Getter @Setter String telefono;

    private @Getter @Setter List<EspecialidadForm> listaEspecialidad = new ArrayList<EspecialidadForm>();

    private @Getter @Setter String profesional = "";

    private @Getter @Setter String especialidad;

    private @Getter @Setter boolean isEmpleado = false;
    //private @Getter @Setter String nomEspecialidad;
    
    private @Getter @Setter String idcompany= "1";

    public EmpleadoController() {
    }

    @PostConstruct
    public void init() {
        listaTipoEmpleado = tipoEmpleadoFacade.obtenerTiposEmpleado();
        listaEspecialidad = especialidadFacade.obtenerEspecialidades();
        listaEmpleado = empleadoFacade.obtenerEmpleados(idcompany);
        listaEmpleado2 = empleadoFacade.obtenerEmpleados(idcompany);
        listaTipoServicios= tipoServicioFacade.obtenerTiposServicio();
        
        if(!listaTipoServicios.isEmpty()){
            listaServicios= servicioFacade.findByTipoServicio(listaTipoServicios.get(0).getIdtiposervicio());
        }
        //this.listaEspecialidad = this.EspecFacade.obtenerEspecialidades();
    }
    
    public void obtenerServiciosEmp(){
        listaHorarios2= new ArrayList<>();
        listaServicios2= servicioFacade.findByIdEmpleado(selectEmp2.getIdempleado());
    }
    
    public void obtenerHorariosServ(){
        if(servicio2!=null && servicio2.getIdservicio()!=null)
            listaHorarios2= horaservFacade.getAllByServ(servicio2.getIdservicio());
        //validationBean.updateComponent("horarioDT");
        return;
    }
    
    public void eliminarHorario(){
        if(horaservFacade.eliminarHorariosById(horaxserv2.getIdhorarioxempleadoxservicio())){
            validationBean.lanzarMensaje("info", "titleHorariosServicios", "lblRegDeleteExitoso");
            listaHorarios2= horaservFacade.getAllByServ(servicio2.getIdservicio());
        }
        else{
           validationBean.lanzarMensaje("error", "titleHorariosServicios", "lblRegDeleteError"); 
        }
    }
    
    public void eliminarServicio(){
        empservFacade.setEmpleado(empleadoFacade.buscarEmpleado(selectEmp2.getDuiempleado(), selectEmp2.getNitempleado()));
        EmpleadoServicioForm obj= empservFacade.getByIdEmpServ(selectEmp2.getIdempleado(), servicio2.getIdservicio()).get(0);
        if(empservFacade.agregarServicioEmp(obj)){
            listaServicios2= servicioFacade.findByIdEmpleado(selectEmp2.getIdempleado());
            if(horaservFacade.eliminarHorariosXServicio(obj.getIdempleadoxservicio())){
                listaHorarios= new ArrayList<>();
                validationBean.lanzarMensaje("info", "titleHorariosServicios", "lblRegDeleteExitoso");
            }
            else{
                validationBean.lanzarMensaje("error", "titleHorariosServicios", "lblRegDeleteError");
            }
        }
        else{
            validationBean.lanzarMensaje("error", "titleHorariosServicios", "lblRegDeleteError");
        }
    }
    

    public boolean agregarEmpleado() {
        boolean flag = true;
        emp.setFechainicio(validationBean.obtenerFechaActual());
        emp.setIdcompany(idcompany);
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
        System.out.println("Tipo de Empleado:       "+ getTipoEmpleado());
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
                                    listaEmpleado = empleadoFacade.obtenerEmpleados(idcompany);
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
    
    public List<TipoServicioForm> completeTipo(String query){
        List<TipoServicioForm> tipos= new ArrayList<>();
        for(TipoServicioForm obj: listaTipoServicios){
            if(obj.getNombretiposervicio().toUpperCase().startsWith(query)){
                tipos.add(obj);
            }
        }
        return tipos;
    }
    
    public void setServices(){
        listaServicios= servicioFacade.findByTipoServicio(tipoServicio.getIdtiposervicio());
    }
    
    public void setServicesHour(){
        //listaServicios= servicioFacade.findByTipoServicio(tipoServicio.getIdtiposervicio());
        horaxserv.setNomservicio(servicioFacade.findById(servicio.getIdservicio()).get(0).getNombreservicio());
    }

    public void horaIniChange() {
        System.err.println(horaIni);
        String temp = horaIni.toString().replace(" ", "-");
        System.err.println(temp);
        String[] cad = temp.split("-");
        String[] time = cad[3].split(":");
        System.err.println(time);
        horaxserv.setHorainicio(new BigInteger(time[0] + time[1]).toString());
        //selected.setHorafin2company(new BigInteger(time[0] + time[1]));
        //System.err.println(cad[3]);
    }
    
    public void horaFinChange() {
        System.err.println(horaFin);
        String temp = horaFin.toString().replace(" ", "-");
        System.err.println(temp);
        String[] cad = temp.split("-");
        String[] time = cad[3].split(":");
        System.err.println(time);
        horaxserv.setHorafin(new BigInteger(time[0] + time[1]).toString());
        //selected.setHorafin2company(new BigInteger(time[0] + time[1]));
        //System.err.println(cad[3]);
    }
    
    public Date formatTime(BigInteger horas) {
        Date d;
        if(horas!=null){
        String time= horas.toString();
        String hora="";
        String minutos="";
        if(time.length()==3){
            hora= time.substring(0, 1);
            minutos= time.substring(1,3);
        }
        else{
           hora= time.substring(0, 2); 
           minutos= time.substring(2,4);
        }
        //String minutos= time.substring(2,4);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, new Integer(hora));
        cal.set(Calendar.MINUTE, new Integer(minutos));
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        d = cal.getTime();
        }
        else{
          d= new Date();
        }
        return d;
    }
    
    public void guardarServicio(){
        if(selectEmp!=null && selectEmp.getIdempleado()!=null){
            if(servicio!=null && servicio.getIdservicio()!=null){
                if(horaxserv!=null && (horaxserv.getHorainicio()!=null && !horaxserv.getHorainicio().equals(""))
                        &&
                        (horaxserv.getHorafin()!=null && !horaxserv.getHorafin().equals(""))){
                    List<EmpleadoServicioForm> temp= empservFacade.getByIdEmpServ(selectEmp.getIdempleado(), servicio.getIdservicio());
                    if(temp.isEmpty()){
                        EmpleadoServicioForm empSer= new EmpleadoServicioForm();
                        empSer.setIdservicio(servicio.getIdservicio());
                        empservFacade.setEmpleado(empleadoFacade.buscarEmpleado(selectEmp.getDuiempleado(), selectEmp.getNitempleado()));
                        if(empservFacade.agregarServicioEmp(empSer)){
                            List<EmpleadoServicioForm> temp2= empservFacade.getByIdEmpServ(selectEmp.getIdempleado(), servicio.getIdservicio());
                            HorarioXServicioForm horxserv= new HorarioXServicioForm();
                            horxserv.setIdempleadoxservicio(temp2.get(0).getIdempleadoxservicio());
                            horxserv.setDia(horaxserv.getDia());
                            horxserv.setHorainicio(horaxserv.getHorainicio());
                            horxserv.setHorafin(horaxserv.getHorafin());
                            if(horaservFacade.agregarHorarioServ(horxserv)){
                                limpiarServicios();
                                validationBean.lanzarMensaje("info", "titleHorariosServicios", "lblExitoServ");
                            }
                            else{
                               validationBean.lanzarMensaje("warn", "titleHorariosServicios", "lblRegError"); 
                            }
                        }
                        else{
                           validationBean.lanzarMensaje("error", "titleHorariosServicios", "lblErrorAddService"); 
                        }
                    }
                    else{
                      //if (temp.get(0).get)
                      List<HorarioXServicioForm> listaHor= horaservFacade.getAllByServ(servicio.getIdservicio());
                      //List<HorarioXServicioForm> listaHor= horaservFacade.getAllByServDiaHora(servicio.getIdservicio(),horaxserv.getDia(), horaxserv.getHorainicio());
                      if(listaHor.size()==1 && (new Integer(listaHor.get(0).getDia())==8|| new Integer(listaHor.get(0).getDia())==9)){
                          validationBean.lanzarMensaje("warn", "titleHorariosServicios", "lblErrorSem");
                      }
                      else{
                          if(!(new Integer(horaxserv.getDia())==8 || new Integer(horaxserv.getDia())==9)){
                                listaHor= horaservFacade.getAllByServDiaHora(servicio.getIdservicio(),horaxserv.getDia(), horaxserv.getHorainicio());
                                boolean flag= buscarHoras(horaxserv.getHorainicio(), horaxserv.getHorafin(), listaHor);
                                if(flag){
                                    HorarioXServicioForm objtmp= listaHor.get(0);
                                    objtmp.setDia(horaxserv.getDia());
                                    objtmp.setHorainicio(horaxserv.getHorainicio());
                                    objtmp.setHorafin(horaxserv.getHorafin());
                                    if (horaservFacade.agregarHorarioServ(objtmp)){
                                        limpiarServicios();
                                        validationBean.lanzarMensaje("info", "titleHorariosServicios", "lblRegExitoso");
                                    }
                                    else{
                                        validationBean.lanzarMensaje("error", "titleHorariosServicios", "lblRegError");
                                    }
                                }
                                else{
                                    validationBean.lanzarMensaje("warn", "titleHorariosServicios", "lblErrorHorAsig");
                                }
                          }
                          else{
                             validationBean.lanzarMensaje("warn", "titleHorariosServicios", "lblErrorSoloDia"); 
                          }
                      }   
                    }
                }
                else{
                   validationBean.lanzarMensaje("warn", "titleHorariosServicios", "lblHorasReq");  
                }
            }
            else{
               validationBean.lanzarMensaje("warn", "titleHorariosServicios", "lblServReq"); 
            }
        }
        else{
            validationBean.lanzarMensaje("warn", "titleHorariosServicios", "lblSelectEmpReq");
        }
    }
    
    public boolean buscarHoras(String horainicio, String horafin, List<HorarioXServicioForm> temp){
        int i=0;
        if(temp.size()==1){
            return new Integer(horainicio) > new Integer(temp.get(0).getHorafin());
           //return new Integer(temp.get(0).getHorainicio()) > new Integer(horafin);
        }
        else{
            while(i<temp.size()){
                if(i==temp.size()){
                    if(new Integer(horainicio)> new Integer(temp.get(i).getHorafin())){
                        return true;
                    }
                }
                else{
                    if(new Integer(horainicio)> new Integer(temp.get(i).getHorafin())
                            && new Integer(horafin) < new Integer(i+1==temp.size()?temp.get(i).getHorafin() : temp.get(i+1).getHorafin())){
                        return true;
                    }
                }
                i++;
            }
        }
        return false;
    }
    public void limpiarServicios(){
       selectEmp = new EmpleadoForm();
       servicio= new ServicioForm();
       horaxserv= new HorarioXServicioForm();
       selectEmp2 = new EmpleadoForm();
       servicio2= new ServicioForm();
       horaxserv2= new HorarioXServicioForm();
       horaFin=null;
       horaIni=null;
       
    }
}
