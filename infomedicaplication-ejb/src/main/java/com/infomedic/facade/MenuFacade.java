/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.facade;


import com.infomedic.forms.MenuForm;
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
public class MenuFacade {

     @PersistenceContext(unitName = "infomedicPU")
    private EntityManager em;

    public EntityManager getEntityManager() {
        return em;
    }

    public MenuFacade() {
    }

    public List<MenuForm> buscarModulos(String codRol, String codCia) {
        String sql= "SELECT A.NIVEL,B.NOMBREMODULO DESAPLIC,A.SECUENCIA,A.CODAPLIC,A.OPCION,A.INDFORMA, A.IDMODULO as codmodulo\n" +
"               FROM TBL_MODULOS_X_ROL A,TBL_MNTO_MODULOS B\n" +
"                WHERE A.IDMODULO=B.IDMODULO\n" +
"                and a.IDCOMPANY=?\n" +
"                AND a.IDROL=?\n" +
"                AND B.ESTADOMODULO='A'"
        /*
        String sql = "SELECT A.NIVEL,B.NOMBREMODULO DESAPLIC,A.SECUENCIA,A.CODAPLIC,A.OPCION,A.INDFORMA, A.IDMODULO as codmodulo\n"
                + "  FROM SEG_MODULOS_X_ROL A,SEG_MNTO_MODULOS B\n"
                + "  WHERE A.IDMODULO=B.IDMODULO\n"
                + "      and a.IDCOMPANY=?\n"
                //+ "      and A.CODROL_CIA=?\n"
                + "      AND B.ESTADOMODULO='A'\n"
                /*
                + "      AND a.NIVEL=2\n"
                + "      AND A.ISWEB=1"*/;

        Query q = getEntityManager().createNativeQuery(sql, "MenuMapping");
        q.setParameter(1, new BigDecimal(codCia));
        q.setParameter(2, new BigDecimal(codRol));
        List<MenuForm> listTmp = (List<MenuForm>) q.getResultList();
        listTmp = (listTmp.isEmpty() ? new ArrayList<MenuForm>() : listTmp);
        return listTmp;
        //return entityToDtoList(listTmp, new DepartamentoForm());
    }

    public List<MenuForm> buscarOpciones(String codModulo, String codCia) {
        String sql="SELECT A.NIVEL,A.NOMBREMENU DESAPLIC,A.SECUENCIA,A.CODAPLIC,A.OPCION,A.INDFORMA , A.IDMODULO as codmodulo\n" +
"                    FROM TBL_MENUS_X_MODULO A,TBL_MNTO_MODULOS B\n" +
"                    WHERE a.IDCOMPANY=?\n" +
"                     AND A.IDMODULO=B.IDMODULO\n" +
"                     AND B.ESTADOMODULO='A'\n" +
"                     AND A.estadomenu='A'\n" +
"                     AND A.IDMODULO=?"
        /*
        String sql = "   SELECT A.NIVEL,A.NOMBREMENU DESAPLIC,A.SECUENCIA,A.CODAPLIC,A.OPCION,A.INDFORMA , A.IDMODULO as codmodulo\n"
                + "     FROM SEG_MENUS_X_MODULO A,SEG_MNTO_MODULOS B\n"
                + "     WHERE a.IDCOMPANY=?\n"
                + "      AND A.IDMODULO=B.IDMODULO\n"
                + "      AND B.ESTADOMODULO='A'\n"
                + "      AND A.estadomenu='A'\n"
                + "      AND A.IDMODULO=?\n"
                /*
                + "      AND A.ISWEB=1"*/;

        Query q = getEntityManager().createNativeQuery(sql, "MenuMapping");
        q.setParameter(1, new BigDecimal(codCia));
        q.setParameter(2, codModulo);
        List<MenuForm> listTmp = (List<MenuForm>) q.getResultList();
        listTmp = (listTmp.isEmpty() ? new ArrayList<MenuForm>() : listTmp);
        return listTmp;
        //return entityToDtoList(listTmp, new DepartamentoForm());
    }

    public List<MenuForm> buscarEnlaces(String codModulo, String codCia, String codRolCia, String codRolUser) {
        String sql = " SELECT A.NIVEL,A.DESC_APLIC DESAPLIC,A.SECUENCIA,A.CODAPLIC,A.OPCIONWEB AS OPCION,A.INDFORMA, A.OPCION as codmodulo\n"
                + "    FROM   TMG_MENU_X_ROLUSER A, TMG_MNTO_MODULOS B\n"
                + "    WHERE A.COD_MODULO=B.COD_MODULO\n"
                + "      and a.codcia=?\n"
                + "      AND B.ESTADO_MODULO='A'\n"
                + "      AND A.CODROL_CIA=?\n"
                + "      AND A.CODROL_USUARIO=?    \n"
                + "      AND A.acceso='S' \n"
                + "      AND A.ISWEB=1\n"
                + "      AND A.COD_MODULO=?\n"
                + "        ORDER BY SECUENCIA ASC, Secuencia ASC";

        Query q = getEntityManager().createNativeQuery(sql, "MenuMapping");
        q.setParameter(1, new BigDecimal(codCia));
        q.setParameter(2, codRolCia);
        q.setParameter(3, codRolUser);
        q.setParameter(4, codModulo);
        List<MenuForm> listTmp = (List<MenuForm>) q.getResultList();
        listTmp = (listTmp.isEmpty() ? new ArrayList<MenuForm>() : listTmp);
        return listTmp;
        //return entityToDtoList(listTmp, new DepartamentoForm());
    }
}
