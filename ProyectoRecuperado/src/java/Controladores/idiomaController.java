/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

/**
 *
 * @author USUARIO
 */
@Named(value = "idiomaController")
@SessionScoped
public class idiomaController implements Serializable {

    /**
     * Creates a new instance of idiomaController
     */
    public idiomaController() {
    }
    
    private Locale idiomaActual;
    private Locale espaniol;
    private Locale ingles;
    
    @PostConstruct
    public void init(){
        idiomaActual = new Locale("es");
        espaniol = new Locale("es");
        ingles = new Locale("en");
    }    

    public Locale getIdiomaActual() {
        return idiomaActual;
    }

    public void setIdiomaActual(Locale idiomaActual) {
        this.idiomaActual = idiomaActual;
    }

    public Locale getEspaniol() {
        return espaniol;
    }

    public void setEspaniol(Locale espaniol) {
        this.espaniol = espaniol;
    }

    public Locale getIngles() {
        return ingles;
    }

    public void setIngles(Locale ingles) {
        this.ingles = ingles;
    }
    
    public void CambiarIdioma(String idiomas){
        Locale idioma = new Locale (idiomas);
            this.idiomaActual = idioma;
            FacesContext.getCurrentInstance().getViewRoot().setLocale(idiomaActual);
    }
}
