/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Mailer.Mailer;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;

/**
 *
 * @author USUARIO
 */
@Named(value = "contactenosController")
@SessionScoped
public class contactenosController implements Serializable {

    /**
     * Creates a new instance of contactenosController
     */
    public contactenosController() {
    }
    
    
    String nombre="";
    String descripcion="";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void enviarCorreo() throws UnsupportedEncodingException, MessagingException{
       
        Mailer.content(mensajeEstilo(), descripcion);
    }
    
     public String mensajeEstilo(){
        return "<h1 style=\"font-size: 20px; color:#990000; font-weight: bold; text-transform: uppercase ; \">Bienvenido a SION" + "</h1>" 
                + "<img src='https://contamos.com.co/wp-content/uploads/2019/05/uno-de-cada-3-contratos-en-sanidad-de-este-ano-dura-menos-de-una-semana-2427_620x368-1.jpg'/ style=\"float: left; width: 200px; height: 200px;\"><p>" + nombre + "<br>\n"
                + "<p style=\"text-align: center; color: #307EDF\">\n"
                + "</p> \n"
                + "<br>\n"
                + "<p style=\"color:#990000;font-weight: bold;\"> Gracias por ser parte de Casa de Banqutes y Eventos SION </p> ";

    }
}
