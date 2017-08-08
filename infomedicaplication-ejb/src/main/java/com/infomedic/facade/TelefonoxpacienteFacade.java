/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.facade;

import com.infomedic.entity.TblPaciente;
import com.infomedic.entity.TblTelefonoxpaciente;
import com.infomedic.forms.TelefonoxpacienteForm;
import com.infomedic.utily.facade.AbstractFacade;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dell
 */
@Stateless
public class TelefonoxpacienteFacade extends AbstractFacade<TblTelefonoxpaciente, TelefonoxpacienteForm> {

    @PersistenceContext(unitName = "infomedicPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    TblPaciente paciente = new TblPaciente();

    public TblPaciente getPaciente() {
        return paciente;
    }

    public void setPaciente(TblPaciente paciente) {
        this.paciente = paciente;
    }

    public TelefonoxpacienteFacade() {
        super(TblTelefonoxpaciente.class);
    }

    public boolean agregarTelefonoxpaciente(List<TelefonoxpacienteForm> listaTels) {
        boolean flag = true;
        TblTelefonoxpaciente ttp;
        actualizarLista(findByIdPacTbl(String.valueOf(paciente.getIdpaciente())), listaTels);
        try {
            for (TelefonoxpacienteForm tel : listaTels) {
                if (tel == null) {
                    flag = false;
                } else if (tel.getIdtelefonoxpaciente() == null) {
                    ttp = new TblTelefonoxpaciente();
                    ttp.setIdpaciente(this.paciente);
                    ttp.setIdtipoxtelefono(BigInteger.valueOf(1));
                    ttp.setNumerotelefono(tel.getNumerotelefono());
                    create(ttp);
                } else {
                    ttp = find(new BigDecimal(tel.getIdtelefonoxpaciente()));
                    edit(ttp);
                }

            }

        } catch (Exception e) {
            flag = false;
            System.out.println("com.infomedic.facade.TelefonoxpacienteFacade.agregarTelefonoxpaciente()");
            e.printStackTrace();
        }

        return flag;
    }

    public void actualizarLista(List<TblTelefonoxpaciente> listaDB, List<TelefonoxpacienteForm> listaForm) {
        if (listaForm.isEmpty() && listaDB != null) {
            for (TblTelefonoxpaciente tel : listaDB) {
                remove(tel);
            }
        } else {
            for (TblTelefonoxpaciente tel : listaDB) {
                if (!isEliminar(tel.getNumerotelefono(), listaForm)) {
                    remove(tel);
                }

            }
        }
    }

    public boolean isEliminar(String numTel, List<TelefonoxpacienteForm> listaForm) {
        boolean flag = false;
        for (TelefonoxpacienteForm telForm : listaForm) {
            if (numTel.equals(telForm.getNumerotelefono())) {
                flag = true;
            }
        }
        return flag;
    }

    public List<TelefonoxpacienteForm> findByIdPac(String idPaciente) {
        Query q = getEntityManager().createNativeQuery("select * from tbl_telefonoxpaciente where idpaciente = ?", TblTelefonoxpaciente.class);
        q.setParameter(1, new BigDecimal(idPaciente));
        List<TblTelefonoxpaciente> listTmp = (List<TblTelefonoxpaciente>) q.getResultList();
        listTmp = (listTmp.isEmpty() ? new ArrayList<TblTelefonoxpaciente>() : listTmp);
        List<TelefonoxpacienteForm> listaF = entityToDtoList(listTmp, new TelefonoxpacienteForm());
        return listaF;
    }

    public List<TblTelefonoxpaciente> findByIdPacTbl(String idPaciente) {
        Query q = getEntityManager().createNativeQuery("select * from tbl_telefonoxpaciente where idpaciente = ?", TblTelefonoxpaciente.class);
        q.setParameter(1, new BigDecimal(idPaciente));
        List<TblTelefonoxpaciente> listTmp = (List<TblTelefonoxpaciente>) q.getResultList();
        listTmp = (listTmp.isEmpty() ? new ArrayList<TblTelefonoxpaciente>() : listTmp);
        return listTmp;
    }
}
