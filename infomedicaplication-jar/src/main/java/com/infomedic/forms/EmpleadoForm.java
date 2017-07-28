/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.forms;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LAP
 */
public class EmpleadoForm {

    private @Getter
    @Setter
    String idempleado;
    private @Getter
    @Setter
    String idcompany;
    private @Getter
    @Setter
    String idmunicipio;
    private @Getter
    @Setter
    String idusuario;
    private @Getter
    @Setter
    String nombreempleado;
    private @Getter
    @Setter
    String apellidoempleado;
    private @Getter
    @Setter
    String duiempleado;
    private @Getter
    @Setter
    String nitempleado;
    private @Getter
    @Setter
    String numeroissempleado;
    private @Getter
    @Setter
    String direccionempleado;
    private @Setter
    String fechanacimientoempleado;
    private @Getter
    @Setter
    String generoempleado;
    private @Getter
    @Setter
    String estadoempleado;
    private @Getter
    @Setter
    String fechainicio;
    private @Getter
    @Setter
    String descripcionempleado;
    private @Getter
    @Setter
    String fechafin;

    public String getFechanacimientoempleado() {
        if (fechanacimientoempleado != null && !fechanacimientoempleado.equals("") && fechanacimientoempleado.length()==10) {
            fechanacimientoempleado = formatearFecha(fechanacimientoempleado);
        }
        return fechanacimientoempleado;
    }

    public String formatearFecha(String fecha) {
        try {
            System.err.println("Fecha al formatear fecha:    " + fecha);
            //String dateStr = "Mon Jun 18 00:00:00 IST 2012";
            DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy", Locale.US);
            Date date = (Date) formatter.parse(fecha);
            System.out.println(date);

            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            String formatedDate = (cal.get(Calendar.DATE) < 10 ? "0" + cal.get(Calendar.DATE) : cal.get(Calendar.DATE)) + "/" + ((cal.get(Calendar.MONTH) + 1) < 10 ? "0" + (cal.get(Calendar.MONTH) + 1) : (cal.get(Calendar.MONTH) + 1)) + "/" + cal.get(Calendar.YEAR);
            System.out.println("formatedDate : " + formatedDate);
            fecha = formatedDate;
        } catch (ParseException ex) {
            System.err.println("Fecha al formatear fecha en exception:    " + fecha);
            //fecha="";
        }
        return fecha;
    }
}
