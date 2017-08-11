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
public class HorarioXServicioForm {
    private @Getter @Setter String idhorarioxempleadoxservicio="";
    private @Getter @Setter String dia="";
    private @Getter @Setter String horainicio="";
    private @Getter @Setter String horafin="";
    //private @Setter String formathorainicio="";
    //private @Setter String formathorafin="";
    private @Getter @Setter String idempleadoxservicio="";
    private @Getter @Setter String  nomservicio="";
    //private @Setter String  nombreDia="";
    
    public String getShow(){
        return nomservicio+",   "+dia+",   "+horainicio+",   "+horafin;
    }
    
    public String getNombreDia(){
        
        String nomdia="";
        if(dia!=null)
            switch (dia){
                case "1":
                    nomdia="Lunes";
                    break;
                case "2":
                    nomdia="Martes";
                    break;
                case "3":
                    nomdia="Miercoles";
                    break;
                case "4":
                    nomdia="Jueves";
                    break;
                case "5":
                    nomdia="Viernes";
                    break;
                case "6":
                    nomdia="Sábado";
                    break;
                case "7":
                    nomdia="Domingo";
                    break;
                case "8":
                    nomdia="Lunes - Viernes";
                    break;
                case "9":
                    nomdia="Lunes - Sábado";
                    break;

            }
        return nomdia.toUpperCase();
    }

    public String getFormathorainicio() {
        return formatTime(horainicio);
    }

    public String getFormathorafin() {
        return formatTime(horafin);
    }
   
    public String formatTime(String horas) {
        if(horas!=null){
            String time= horas;
            String hora="";
            String minutos="";
            if(time.length()==3){
                hora= time.substring(0, 1);
                minutos= time.substring(1,3);
            }
            else{
               hora= time.substring(0, 2); 
               minutos= time.substring(2,4);
            }
            horas= hora+":"+minutos;
        }
        return horas;
   }
}
