/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.facade;

import com.infomedic.forms.UsuarioForm;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author dell
 */
@Stateless
public class UsuarioFacade {
    @PersistenceContext(unitName = "infomedicPU")
    private EntityManager em;
    
    public EntityManager getEntityManager() {
        return em;
    }
    
    public boolean agregarUsuario(UsuarioForm uf)
    {
        int flag = -1;
        try {
            Connection cn = em.unwrap(java.sql.Connection.class);
            //cn.setAutoCommit(false);
    CallableStatement cs = cn.prepareCall("{call SEGURIDAD.Proc_RegUserInfomedic (?,?,?,?,?)}");
    cs.setString(1, uf.getNombreusuario());
    cs.setString(2, uf.getContrausuario());
    cs.setString(3, uf.getCorreousuario());
    //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    cs.setString(4, uf.getFechacreacion());
    cs.registerOutParameter(5, Types.NUMERIC);
    cs.execute();
    flag = cs.getInt(5);
            System.out.println(flag);
            System.out.println("com.infomedic.facade.UsuarioFacade.agregarUsuario(OK)");
        } catch (Exception e) {
            System.out.println("com.infomedic.facade.UsuarioFacade.agregarUsuario(ERROR)");
            e.printStackTrace();
        }
    
        if (flag == 1) {
            return true;
        }else{
           return false;
        }
    }
}
