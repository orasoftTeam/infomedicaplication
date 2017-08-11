/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.facade;


import com.infomedic.forms.UserForm;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author LAP
 */
@Stateless
public class UserFacade {

     @PersistenceContext(unitName = "infomedicPU")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
    }

    public UserForm getUser(String user, String pass) {
        String sql = "select usu.idusuario, usu.nombreusuario nombre, usu.contrausuario pass, usu.correousuario email, company.nombrecompany, company.idcompany, roluser.idrol from tbl_usuario usu, TBL_USUARIO_X_CIA usuxcia, tbl_company company,\n"
                + "tbl_rolusuario roluser\n"
                + "where usu.idusuario= usuxcia.idusuario and usuxcia.idcompany=company.idcompany and roluser.idusuario= usu.idusuario\n"
                + "and usu.nombreusuario='"+user+"' and usu.contrausuario='"+pass+"'";
        Query q= getEntityManager().createNativeQuery(sql, "UserMapping");
        List<UserForm> temp= q.getResultList();
        return temp.isEmpty()? new UserForm():temp.get(0);
    }
}
