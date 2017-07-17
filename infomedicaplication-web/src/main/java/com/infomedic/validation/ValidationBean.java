/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infomedic.validation;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author LAP
 */
@Stateless
public class ValidationBean {

    public boolean validarCampoVacio(String c, String tipoMsg, String tituloMsg, String descMsg) {
        boolean flag;
        if ("".equals(c)) {
            flag = false;
            lanzarMensaje(tipoMsg, tituloMsg, descMsg);
        } else {
            flag = true;
        }
        return flag;
    }

    public boolean validarSoloLetras(String c, String tipoMsg, String tituloMsg, String descMsg) {
        Pattern patron = Pattern.compile("[^A-Za-z-ZñÑáéíóúÁÉÍÓÚ]");
        Matcher validar = patron.matcher(c);
        boolean flag;
        if (validar.find()) {
            flag = false;
            lanzarMensaje(tipoMsg, tituloMsg, descMsg);
        } else {
            flag = true;
        }
        return flag;
    }

    public boolean validarLongitudCampo(String c, int min, int max, String tipoMsg, String tituloMsg, String descMsg) {
        boolean flag;
        if (!(c.length() >= min && c.length() <= max)) {
            flag = false;
            lanzarMensaje(tipoMsg, tituloMsg, descMsg);
        } else {
            flag = true;
        }
        return flag;
    }

    public boolean validarEmail(String c, String tipoMsg, String tituloMsg, String descMsg) {
        Pattern patron = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher validar = patron.matcher(c);
        boolean flag;
        if (!validar.find()) {
            flag = false;
            lanzarMensaje(tipoMsg, tituloMsg, descMsg);
        } else {
            flag = true;
        }
        return flag;
    }

    public boolean validarSoloNumeros(String c, String tipoMsg, String tituloMsg, String descMsg) {
        Pattern patron = Pattern.compile("[^0-9]");
        Matcher validar = patron.matcher(c);
        boolean flag;
        if (validar.find()) {
            flag = false;
            lanzarMensaje(tipoMsg, tituloMsg, descMsg);
        } else {
            flag = true;
        }
        return flag;
    }

    public void lanzarMensaje(String tipo, String titulo, String msg) {
        FacesMessage.Severity typeMessage;
        switch (tipo.toLowerCase()) {
            case "info":
                typeMessage = FacesMessage.SEVERITY_INFO;
                break;
            case "warn":
                typeMessage = FacesMessage.SEVERITY_WARN;
                break;
            case "fatal":
                typeMessage = FacesMessage.SEVERITY_FATAL;
                break;
            case "error":
                typeMessage = FacesMessage.SEVERITY_ERROR;
                break;
            default:
                typeMessage = FacesMessage.SEVERITY_INFO;
                break;
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(typeMessage, getMsgBundle(titulo), getMsgBundle(msg)));
    }

    public String getMsgBundle(String key) {
        ResourceBundle bundle = ResourceBundle.getBundle("/Bundle", FacesContext.getCurrentInstance().getViewRoot().getLocale());
        String value = bundle.getString(key);
        return value;
    }

    public String Encriptar(String texto) {

        String secretKey = "infomedicsolutions"; //llave para encriptar datos
        String base64EncryptedString = "";

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);

        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }
    
    public String Desencriptar(String textoEncriptado) throws Exception {
 
        String secretKey = "infomedicsolutions"; //llave para encriptar datos
        String base64EncryptedString = "";
 
        try {
            byte[] message = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
 
            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);
 
            byte[] plainText = decipher.doFinal(message);
 
            base64EncryptedString = new String(plainText, "UTF-8");
 
        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }
}
