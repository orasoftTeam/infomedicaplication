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
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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
public class TelefonoxpacienteController implements Serializable{
    
    private @Getter @Setter TelefonoxpacienteForm tpf = new TelefonoxpacienteForm();
    private @Getter @Setter PacienteForm pf = new PacienteForm();
    private @Getter @Setter List<TelefonoxpacienteForm> listaTels = new ArrayList<TelefonoxpacienteForm>();
    private @Getter @Setter String numeroTel;
    private @Getter @Setter String idPaciente;
    
    @EJB
    private TelefonoxpacienteFacade tpFacade;
    
    @EJB
    private PacienteFacade pacFacade;
    
    @EJB
    private ValidationBean vb;
    
    public TelefonoxpacienteController(){}
    
    @PostConstruct
    public void init(){
    
    }
    
}   

