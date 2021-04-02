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
import javax.inject.Inject;
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
    String correo="";
    String descripcion="";
    
    @Inject
    mensajeController mensajesController;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void enviarCorreo() throws UnsupportedEncodingException, MessagingException{
    Mailer.content(nombre, correo, mensajeEstilo());
       try{   
            mensajesController.setMensaje("Mensaje('Bienvenido!!','Pronto sabrás de nosotros')");
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
                                    + "<h2 style=\"text-transform: uppercase; font-size: xx-large; display: flex; align-items: center; justify-content: center; text-align: center; text-align: center; color: #c24d4d;\">casa de eventos y banquetes sion" + "</h2>"
                                + "</div>"
                            + "</div>"
                            + "<div class=\"row\">"
                                + "<div class=\"col-12\" style=\"text-align: -webkit-center;\">"
                                    + "<img src='https://quadranslawandfinance.com/wp-content/uploads/2018/09/por-que-debes-realizar-reestructuraciones-corporativas.jpg'/ style=\"padding: 10px; display: block; opacity: 50%; box-shadow: 0 0 20px rgb(61, 61, 61); width: 95%; \">"
                                + "</div>"
                            + "</div>"
                            + "<div style=\"margin 0 auto;\">"
                                + "<div class=\"row\">"
                                    + "<div class=\"col-12\" style=\"margin: 30px 20px 10px; color: #52718f; text-align: justify;\">"
                                        + "<h2 style=\"color: #c54040; margin: 0 0 7px; text-transform: uppercase; \">"					
                                                + descripcion
                                         + "</h2>"
                                           + "<p style=\"margin: 2px; font-size: 15px; \"> Hola!! es un honor tenerte con nosotros, gracias por ponerte en contacto con Casa Banquetes y Eventos SION. Te damos la bienvenida a este maravilloso sitio donde vas a encontarr las mejores ofertas y diseños para tu gran día. Te invitamos a que revise nuestra página y conozcas la información detallada, te esperamos!!!" + "</p>"
                                               + "<ul style=\"font-size: 15px;  margin: 10px 0; \">"
                                                       +  "<h2> Te ofrecemos diferentes servicios para la ocación especial" + "<h2>"
                                                       +  "<li>Servicio de Catering." + "</li>"
                                                       +  "<li>Maquillaje Profesional." + "</li>"
                                                       +  "<li>Ajuar de acuerdo a la ocación." + "</li>"
                                                       +  "<li>Sonido Profesional." + "</li>"
                                                       +  "<li>Silleteria y decoración." + "</li>"
                                                       +  "<li>y mucho más." + "</li>"
                                               + "</ul>"
                                                + "<div style=\"width: 100%; text-align: center; margin-top:40px;\">"
                                                   + "<a style=\"text-decoration: none; border-radius: 5px; padding: 11px 23px; color: white; background-color: #c56040;\" href=\"#\">Ir a la página" + "</a>"
                                               + "</div>"
                                           + "<p style=\"color: #cf7373; font-size: 12px; text-align: center; margin: 20px 0 0; \">SION - Casa De Banquetes 2021" + "</p>"
                                    + "</div>"
                                + "</div>"
                            + "</div>"
                       + "</div>"
                   + "</div>"
              + "</div>";

    }
}
