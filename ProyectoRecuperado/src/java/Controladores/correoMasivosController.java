/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Mailer.Mailer_2;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import javax.inject.Inject;
import javax.mail.MessagingException;

/**
 *
 * @author USUARIO
 */
@Named(value = "correoMasivosController")
@SessionScoped
public class correoMasivosController implements Serializable {

    /**
     * Creates a new instance of correoMasivosController
     */
    public correoMasivosController() {
    }

    String titulo="";
    String descripcion="";
    String titulo1="";
    String descripcion1="";
    String titulo2="";
    String descripcion2="";
    String contenido="";
    
    @Inject
    mensajeController mensajesController;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo1() {
        return titulo1;
    }

    public void setTitulo1(String titulo1) {
        this.titulo1 = titulo1;
    }

    public String getDescripcion1() {
        return descripcion1;
    }

    public void setDescripcion1(String descripcion1) {
        this.descripcion1 = descripcion1;
    }

    public String getTitulo2() {
        return titulo2;
    }

    public void setTitulo2(String titulo2) {
        this.titulo2 = titulo2;
    }

    public String getDescripcion2() {
        return descripcion2;
    }

    public void setDescripcion2(String descripcion2) {
        this.descripcion2 = descripcion2;
    }
    
    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    
    public void enviarCorreo() throws UnsupportedEncodingException, MessagingException{
       try{
            Mailer_2.content(titulo, descripcion, mensajeEstilo());
            mensajesController.setMensaje("Mensaje('Información!!','Se ha enviado la información expuesta')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Verifique los campos e intente de nuevo','error')");
        }
        
    }
    
    public void enviarCorreo_1() throws UnsupportedEncodingException, MessagingException{
       
        try{
            Mailer_2.content(titulo1, descripcion1, mensajeEstilo_1());
            mensajesController.setMensaje("Mensaje('Información!!','Se ha enviado la información sobre el mantenimiento')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Verifique los campos e intente de nuevo','error')");
        }
    }
    
    public void enviarCorreo_2() throws UnsupportedEncodingException, MessagingException{
       
        try{
            Mailer_2.content(titulo2, descripcion2, mensajeEstilo_2());
            mensajesController.setMensaje("Mensaje('Información!!','Se ha enviado la información sobre las ofertas')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Verifique los campos e intente de nuevo','error')");
        }
    }
    
     public String mensajeEstilo(){
        return "<div style=\"max-width: 700px; padding: 20px; margin:0 auto; font-family: inherit;\">" 
                   + "<div class=\"row\">"
                        + "<div class=\"col\" style=\"padding: 20px; margin: 10px auto; border-collapse: collapse; background-color: rgba(160, 168, 177, 0.2); border-radius: 2%; \">"
                            + "<div class=\"row\">"
                                + "<div class=\"col-2\" style=\"text-align: left;  \">"
                                    +  "<a href=\"index.xhtml\">" + "<img src='https://i.imgur.com/raWGRVJ.png'/ style=\"display:block; margin: 10px 15px; float: left; width: 80px; height: 120px;\">" + "</a>"       
                                + "</div>"
                                + "<div class=\"col-10\">"
                                    + "<h2 style=\"text-transform: uppercase; font-size: xx-large; display: flex; align-items: center; justify-content: center; text-align: center; text-align: center; color: #4d84c2;\">Información importante para todos nuestros usuarios!</h2>"
                                + "</div>"
                            + "</div>"
                            + "<div class=\"row\">"
                                + "<div class=\"col-12\" style=\"text-align: -webkit-center;\">"
                                     + "<img src='https://i.pinimg.com/originals/45/b2/e7/45b2e764d14cf9dee6dc3ed1ba0ad680.gif'/ style=\"padding: 10px; display: block; opacity: 50%; box-shadow: 0 0 20px rgb(61, 61, 61); width: 95%; \">"
                                + "</div>"
                            + "</div>"
                            + "<div style=\"margin 0 auto;\">"
                                + "<div class=\"row\">"
                                    + "<div class=\"col-12\" style=\"margin: 30px 20px 10px; color: #52718f; text-align: justify;\">"
                                        + "<h2 style=\"color: #4d84c2; margin: 0 0 7px; text-transform: uppercase; \">"					
                                                + titulo
                                         + "</h2>"
                                           + "<p style=\"margin: 2px; font-size: 15px; \"> Gracias por pertenecer a nuestra Casa Banqutes y Eventos SION, te informamos que realizaremos cambios que te pueden interesar. " + "</p>"
                                               + "<ul style=\"font-size: 15px;  margin: 10px 0; \">"
                                                       +  "<li>Actualización de datos." + "</li>"
                                                       +  "<li>Entrega de detalles." + "</li>"
                                                       +  "<li>Pagos de ordén de servicios." + "</li>"
                                                       +  "<li>Promociones mejoradas." + "</li>"
                                               + "</ul>"
                                               + "<div style=\"width: 100%; text-align: center; margin-top:40px;\">"
                                                   + "<a style=\"text-decoration: none; border-radius: 5px; padding: 11px 23px; color: white; background-color: #3477db;\" href=\"#\">Ir a la página" + "</a>"
                                               + "</div>"
                                                
                                                + "<div class=\"row\">"
                                                   + "<div class=\"col\" style=\"width: 100%; margin:15px 0; display: inline-block;text-align: right\">"
                                                       + "<a href=\"https://imgur.com/QHz9RXH\"><img src=\"https://i.imgur.com/QHz9RXH.png\" width=\"30\" style=\"padding: 0; margin: 5px;\">" + "</a>"
                                                       + "<a href=\"https://imgur.com/VGdNZCj\"><img src=\"https://i.imgur.com/VGdNZCj.png\" width=\"30\" style=\"padding: 0; margin: 5px;\">" + "</a>"
                                                       + "<a href=\"https://imgur.com/PDYFmh2\"><img src=\"https://i.imgur.com/PDYFmh2.png\" width=\"30\" style=\"padding: 0; margin: 5px;\">" + "</a>"
                                                       + "<a href=\"https://imgur.com/p887qcr\"><img src=\"https://i.imgur.com/p887qcr.png\" width=\"30\" style=\"padding: 0; margin: 5px;\">" + "</a>"
                                                       + "<p style=\"color: #4d84c2; font-size: 12px; text-align: right; margin: 20px 0 0; \">SION - Casa De Banquetes 2021" + "</p>"
                                                   + "</div>"
                                               + "</div>"                 
                                    + "</div>"
                                + "</div>"
                            + "</div>"
                       + "</div>"
                   + "</div>"
              + "</div>";

    }
     public String mensajeEstilo_1(){
        return "<div style=\"max-width: 700px; padding: 20px; margin:0 auto; font-family: inherit;\">" 
                   + "<div class=\"row\">"
                        + "<div class=\"col\" style=\"padding: 20px; margin: 10px auto; border-collapse: collapse; background-color: rgba(160, 168, 177, 0.2); border-radius: 2%; \">"
                            + "<div class=\"row\">"
                                + "<div class=\"col-2\" style=\"text-align: left;  \">"
                                    +  "<a href=\"index.xhtml\">" + "<img src='https://i.imgur.com/raWGRVJ.png'/ style=\"display:block; margin: 10px 15px; float: left; width: 80px; height: 120px;\">" + "</a>"       
                                + "</div>"
                                + "<div class=\"col-10\">"
                                    + "<h2 style=\"text-transform: uppercase; font-size: xx-large; display: flex; align-items: center; justify-content: center; text-align: center; text-align: center; color: #8b8a8a;\">Información importante para todos nuestros usuarios!</h2>"
                                + "</div>"
                            + "</div>"
                            + "<div class=\"row\">"
                                + "<div class=\"col-12\" style=\"text-align: -webkit-center;\">"
                                     + "<img src='https://i.pinimg.com/originals/45/8a/01/458a01d2a893bacda8c050d943d71e1a.gif'/ style=\"padding: 10px; display: block; opacity: 50%; box-shadow: 0 0 20px rgb(61, 61, 61); width: 95%; \">"
                                + "</div>"
                            + "</div>"
                            + "<div style=\"margin 0 auto;\">"
                                + "<div class=\"row\">"
                                    + "<div class=\"col-12\" style=\"margin: 30px 20px 10px; color: #52718f; text-align: justify;\">"
                                        + "<h2 style=\"color: #8b8a8a; margin: 0 0 7px; text-transform: uppercase; \">"					
                                                + titulo1
                                         + "</h2>"
                                           + "<p style=\"margin: 2px; font-size: 15px; \"> Gracias por pertenecer a nuestra Casa Banqutes y Eventos SION, te informamos que realizaremos que realizaremos mantenimiento a nuestros servios y a nuestra pagina durante 6 horas. " + "</p>"
                                               + "<ul style=\"font-size: 15px;  margin: 10px 0; \">"
                                                       +  "<li>Manteniemiento de Usuarios." + "</li>"
                                                       +  "<li>Mantenimiento de Promociones." + "</li>"
                                                       +  "<li>Mantenimiento de eventos." + "</li>"
                                               + "</ul>"
                                               + "<div style=\"width: 100%; text-align: center; margin-top:40px;\">"
                                                   + "<a style=\"text-decoration: none; border-radius: 5px; padding: 11px 23px; color: white; background-color: #555555\" href=\"#\">Ir a la página" + "</a>"
                                               + "</div>"  
                                                + "<div class=\"row\">"
                                                   + "<div class=\"col\" style=\"width: 100%; margin:15px 0; display: inline-block;text-align: right\">"
                                                       + "<a href=\"https://imgur.com/QHz9RXH\"><img src=\"https://i.imgur.com/QHz9RXH.png\" width=\"30\" style=\"padding: 0; margin: 5px;\">" + "</a>"
                                                       + "<a href=\"https://imgur.com/VGdNZCj\"><img src=\"https://i.imgur.com/VGdNZCj.png\" width=\"30\" style=\"padding: 0; margin: 5px;\">" + "</a>"
                                                       + "<a href=\"https://imgur.com/PDYFmh2\"><img src=\"https://i.imgur.com/PDYFmh2.png\" width=\"30\" style=\"padding: 0; margin: 5px;\">" + "</a>"
                                                       + "<a href=\"https://imgur.com/p887qcr\"><img src=\"https://i.imgur.com/p887qcr.png\" width=\"30\" style=\"padding: 0; margin: 5px;\">" + "</a>"
                                                       + "<p style=\"color: #8b8a8a; font-size: 12px; text-align: right; margin: 20px 0 0; \">SION - Casa De Banquetes 2021" + "</p>"
                                                   + "</div>"
                                               + "</div>"                 
                                    + "</div>"
                                + "</div>"
                            + "</div>"
                       + "</div>"
                   + "</div>"
              + "</div>";

    }
     public String mensajeEstilo_2(){
        return "<div style=\"max-width: 700px; padding: 20px; margin:0 auto; font-family: inherit;\">" 
                   + "<div class=\"row\">"
                        + "<div class=\"col\" style=\"padding: 20px; margin: 10px auto; border-collapse: collapse; background-color: rgba(160, 168, 177, 0.2); border-radius: 2%; \">"
                            + "<div class=\"row\">"
                                + "<div class=\"col-2\" style=\"text-align: left;  \">"
                                    +  "<a href=\"index.xhtml\">" + "<img src='https://i.imgur.com/raWGRVJ.png'/ style=\"display:block; margin: 10px 15px; float: left; width: 80px; height: 120px;\">" + "</a>"       
                                + "</div>"
                                + "<div class=\"col-10\">"
                                    + "<h2 style=\"text-transform: uppercase; font-size: xx-large; display: flex; align-items: center; justify-content: center; text-align: center; text-align: center; color: #F9806D;\">Información importante para todos nuestros usuarios!</h2>"
                                + "</div>"
                            + "</div>"
                            + "<div class=\"row\">"
                                 + "<div class=\"col-12\" style=\"text-align: -webkit-center;\">"
                                       + "<img src='https://i.pinimg.com/originals/3d/e0/b1/3de0b1c2cd036a5112ac231af2c5b7c6.gif'/ style=\"padding: 10px; display: block; opacity: 50%; box-shadow: 0 0 20px rgb(61, 61, 61); width: 95%; \">"
                                 + "</div>"
                            + "</div>"
                            + "<div style=\"margin 0 auto;\">"
                                + "<div class=\"row\">"
                                    + "<div class=\"col-12\" style=\"margin: 30px 20px 10px; color: #52718f; text-align: justify;\">"
                                        + "<h2 style=\"color: #F9806D; margin: 0 0 7px; text-transform: uppercase; \">"					
                                                + titulo2
                                         + "</h2>"
                                           + "<p style=\"margin: 2px; font-size: 15px; \"> Gracias por pertenecer a nuestra Casa Banqutes y Eventos SION, te informamos que hemos pensado en tí y realizaremos obsequios los cuales se verán reflejados en ciertas ofertas y descuentos en nuestros servicios." + "</p>"
                                               + "<ul style=\"font-size: 15px;  margin: 10px 0; \">"
                                                       +  "<li>Servicio Individual con el 15% de descuento." + "</li>"
                                                       +  "<li>Paquetes Incluidos mayores a $3.200.000 con obsequi de bono extra." + "</li>"
                                                       +  "<li>Un solo Servicio Individual oferta X2." + "</li>"
                                                       +  "<li>Eventos mayores a 30 días doble menaje." + "</li>"
                                               + "</ul>"
                                               + "<div style=\"width: 100%; text-align: center; margin-top:40px;\">"
                                                   + "<a style=\"text-decoration: none; border-radius: 5px; padding: 11px 23px; color: white; background-color: #ec563f\" href=\"#\">Ir a la página" + "</a>"
                                               + "</div>"
                                                + "<div class=\"row\">"
                                                   + "<div class=\"col\" style=\"width: 100%; margin:15px 0; display: inline-block;text-align: right\">"
                                                       + "<a href=\"https://imgur.com/QHz9RXH\"><img src=\"https://i.imgur.com/QHz9RXH.png\" width=\"30\" style=\"padding: 0; margin: 5px;\">" + "</a>"
                                                       + "<a href=\"https://imgur.com/VGdNZCj\"><img src=\"https://i.imgur.com/VGdNZCj.png\" width=\"30\" style=\"padding: 0; margin: 5px;\">" + "</a>"
                                                       + "<a href=\"https://imgur.com/PDYFmh2\"><img src=\"https://i.imgur.com/PDYFmh2.png\" width=\"30\" style=\"padding: 0; margin: 5px;\">" + "</a>"
                                                       + "<a href=\"https://imgur.com/p887qcr\"><img src=\"https://i.imgur.com/p887qcr.png\" width=\"30\" style=\"padding: 0; margin: 5px;\">" + "</a>"
                                                       + "<p style=\"color: #F9806D; font-size: 12px; text-align: right; margin: 20px 0 0; \">SION - Casa De Banquetes 2021" + "</p>"
                                                   + "</div>"
                                               + "</div>"                 
                                    + "</div>"
                                + "</div>"
                            + "</div>"
                       + "</div>"
                   + "</div>"
              + "</div>";

    }
}

    
