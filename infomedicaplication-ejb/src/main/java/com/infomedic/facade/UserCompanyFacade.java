/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.facade;

import com.infomedic.forms.DepartamentoForm;
import com.infomedic.forms.UserCompanyForm;
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
public class UserCompanyFacade {

    @PersistenceContext(unitName = "infomedicPU")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    public UserCompanyFacade() {

    }

    public List<UserCompanyForm> findByUserPass(String idUser, String pass) {
        String sql = "select uscp.idcompany, uscp.idusuario, cp.nombrecompany as company, usuario.nombreusuario, usuario.contrausuario as passwd from tbl_company cp, tbl_usuario_x_cia uscp, tbl_usuario usuario\n"
                + "where  usuario.nombreusuario=? and usuario.contrausuario=? and\n"
                + "uscp.idusuario= usuario.idusuario and uscp.idusuario= usuario.idusuario and uscp.idcompany= cp.idcompany and uscp.status='A' and cp.estadocompany='A'";
        Query q = getEntityManager().createNativeQuery(sql, "UserCompanyMapping");
        q.setParameter(1, idUser);
        q.setParameter(2, pass);
        List<UserCompanyForm> listTmp = (List<UserCompanyForm>) q.getResultList();
        listTmp = (listTmp.isEmpty() ? new ArrayList<UserCompanyForm>() : listTmp);
        return listTmp;
        //return entityToDtoList(listTmp, new DepartamentoForm());
    }
}
