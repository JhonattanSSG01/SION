/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author USUARIO
 */
@Named(value = "contraseñaController")
@SessionScoped
public class contraseñaController implements Serializable {

    /**
     * Creates a new instance of contraseñaController
     */
    public contraseñaController() {
    }
    
}
