package com.infomedic.forms;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author dell
 */
public class PacienteForm {

    private @Getter
    @Setter
    String idpaciente;
    private @Getter
    @Setter
    String idusuario;
    private @Getter
    @Setter
    String nombrepaciente;
    private @Getter
    @Setter
    String apellidospaciente;
    private @Getter
    @Setter
    String direccionpaciente;
    private String fechanacimientopaciente;
    private @Getter
    @Setter
    String generopaciente;
    private @Getter
    @Setter
    String estadocivilpaciente;
    private @Getter
    @Setter
    String nombrepadrepaciente;
    private @Getter
    @Setter
    String nombremadrepaciente;
    private @Getter
    @Setter
    String nombreparejapaciente;
    private @Getter
    @Setter
    String ocupacionpaciente;
    private @Getter
    @Setter
    String correopaciente;
    private @Getter
    @Setter
    String lugarnacimientopaciente;
    private @Getter
    @Setter
    String numeroduipaciente;
    private @Getter
    @Setter
    String estadopaciente;
    private @Getter
    @Setter
    String nombreresponsable;

    public String getFechaNacFormatoEntrada() {
        return this.fechanacimientopaciente;
    }

    public String getFechanacimientopaciente() {
        String formatedDate = "";
        try {
            DateFormat formatter = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.US);
            Date date = (Date) formatter.parse(fechanacimientopaciente);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            String mes = String.valueOf(cal.get(Calendar.MONTH) + 1);
            if (Integer.parseInt(mes) < 10) {
                mes = "0" + mes;
            }
            String dia = String.valueOf(cal.get(Calendar.DATE));
            if (Integer.parseInt(dia) < 10) {
                dia = "0" + dia;
            }
            formatedDate = dia + "/" + mes + "/" + cal.get(Calendar.YEAR);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return formatedDate;
    }

    public void setFechanacimientopaciente(String fechanacimientopaciente) {
        this.fechanacimientopaciente = fechanacimientopaciente;
    }

}
