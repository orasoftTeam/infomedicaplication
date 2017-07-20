/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.facade;

import com.infomedic.entity.TblPaciente;
import com.infomedic.forms.PacienteForm;
import com.infomedic.utily.facade.AbstractFacade;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dell
 */
@Stateless
public class PacienteFacade extends AbstractFacade<TblPaciente, PacienteForm>{
    @PersistenceContext(unitName = "infomedicPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager(){
    return em;
    }
    
    public PacienteFacade(){
    super(TblPaciente.class);
    }
    
    public boolean agregarPaciente(PacienteForm pf){
    boolean flag = true;
        try {
            if (pf == null) {
                flag = false;
            }else if (pf.getIdpaciente() == null) {
                TblPaciente paciente = new TblPaciente();
                paciente = asignar(paciente, pf);
                create(paciente);
            } else {
              TblPaciente paciente = find(new BigDecimal(pf.getIdpaciente())); 
              paciente = asignar(paciente, pf);
              edit(paciente);
            }
        } catch (Exception e) {
            flag = false;
            System.err.println(e.toString());
        }
    
    return flag;
    }
    
    public TblPaciente asignar(TblPaciente paciente, PacienteForm pf){
            paciente.setNombrepaciente(pf.getNombrepaciente());
                paciente.setApellidospaciente(pf.getApellidospaciente());
                paciente.setDireccionpaciente(pf.getDireccionpaciente());
                //set date format
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try 
                {
                  paciente.setFechanacimientopaciente
                  (sdf.parse(pf.getFechaNacFormatoEntrada()));
                } 
                catch (Exception e) 
                {
                    System.err.println(e.toString());
                }
                
                paciente.setGeneropaciente(pf.getGeneropaciente().charAt(0));
                paciente.setEstadocivilpaciente(pf.getEstadocivilpaciente());
                paciente.setNombrepadrepaciente(pf.getNombrepadrepaciente());
                paciente.setNombremadrepaciente(pf.getNombremadrepaciente());
                paciente.setNombreparejapaciente(pf.getNombreparejapaciente());
                paciente.setOcupacionpaciente(pf.getOcupacionpaciente());
                paciente.setCorreopaciente(pf.getCorreopaciente());
                paciente.setLugarnacimientopaciente(pf.getLugarnacimientopaciente());
                paciente.setNumeroduipaciente(pf.getNumeroduipaciente());
                paciente.setEstadopaciente(pf.getEstadopaciente().charAt(0));
                paciente.setNombreresponsable(pf.getNombreresponsable());
       return paciente;
    }
    
    
    public List<PacienteForm> obtenerPacientes(){
    List <TblPaciente> listaTmp;
    List <PacienteForm> listaTmpForm;
        try {
            listaTmp = findAll();
            if (listaTmp.isEmpty()) {
                listaTmpForm = new ArrayList<PacienteForm>();
                
            } else {
            listaTmpForm = entityToDtoList(listaTmp, new PacienteForm());
            }
        } catch (Exception e) {
            listaTmpForm = new ArrayList<PacienteForm>();
        }
        
        return listaTmpForm;
    }
}
