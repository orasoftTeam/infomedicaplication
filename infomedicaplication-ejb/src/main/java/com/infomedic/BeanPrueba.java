/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic;

import javax.ejb.Stateless;

/**
 *
 * @author LAP
 */


@Stateless
public class BeanPrueba {
    public void mostrarMensaje(){
        System.err.println("Prueba Error");
    }
}
