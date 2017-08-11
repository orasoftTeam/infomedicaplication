/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.forms;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LAP
 */
public class EmpleadoServicioForm  {
    private @Getter @Setter String idempleadoxservicio;
    private @Getter @Setter String idservicio;
    private @Getter @Setter String fechainicio;
    private @Getter @Setter String fechafin;
    private @Getter @Setter String estadoservicio;
}
