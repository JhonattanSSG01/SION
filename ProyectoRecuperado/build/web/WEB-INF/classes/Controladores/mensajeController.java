/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author USUARIO
 */
@Named(value = "mensajeController")
@RequestScoped
public class mensajeController {

    /**
     * Creates a new instance of mensajeController
     */
    public mensajeController() {
    }
    
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
