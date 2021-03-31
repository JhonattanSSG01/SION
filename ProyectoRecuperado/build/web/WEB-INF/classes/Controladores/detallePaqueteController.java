/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.DetallePaquete;
import Entidades.Evento;
import Entidades.PaqueteTodoIncluido;
import Facade.DetallePaqueteFacade;
import Facade.EventoFacade;
import Facade.PaqueteTodoIncluidoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author USUARIO
 */
@Named(value = "detallePaqueteController")
@SessionScoped
public class detallePaqueteController implements Serializable {

    /**
     * Creates a new instance of detallePaqueteController
     */
    public detallePaqueteController() {
    }
    
    private Evento evento;
    private PaqueteTodoIncluido paqueteTodoIncluido;
    private DetallePaquete detallePaquete;
    @EJB
    EventoFacade eventoFacade;
    @EJB
    PaqueteTodoIncluidoFacade paqueteTodoIncluidoFacade;
    @EJB
    DetallePaqueteFacade detallePaqueteFacade;
    
    @PostConstruct
    public void init(){
        evento = new Evento();
        paqueteTodoIncluido = new PaqueteTodoIncluido();
        detallePaquete = new DetallePaquete();
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public PaqueteTodoIncluido getPaqueteTodoIncluido() {
        return paqueteTodoIncluido;
    }

    public void setPaqueteTodoIncluido(PaqueteTodoIncluido paqueteTodoIncluido) {
        this.paqueteTodoIncluido = paqueteTodoIncluido;
    }

    public DetallePaquete getDetallePaquete() {
        return detallePaquete;
    }

    public void setDetallePaquete(DetallePaquete detallePaquete) {
        this.detallePaquete = detallePaquete;
    }
    
    public void registrarDetallePaquete(){
        detallePaquete.setCodEve(eventoFacade.find(this.evento.getCodEve()));
        detallePaquete.setCodPati(paqueteTodoIncluidoFacade.find(this.paqueteTodoIncluido.getCodPati()));
        detallePaqueteFacade.create(this.detallePaquete);
        detallePaquete = new DetallePaquete();
    }
    
    public String preActualizarDetallePaquete(DetallePaquete detallePaquete){
        this.detallePaquete = detallePaquete;
        return "actualizarDetallePaquete";
    }
    
    public String actualizarDetallePaquete(){
        detallePaquete.setCodEve(eventoFacade.find(this.evento.getCodEve()));
        detallePaquete.setCodPati(paqueteTodoIncluidoFacade.find(this.paqueteTodoIncluido.getCodPati()));
        detallePaqueteFacade.edit(this.detallePaquete);
        detallePaquete = new DetallePaquete();
        return "registrarDetallePaquete";
    }
    
    public void eliminarDetallePaquete(DetallePaquete detallePaquete){
        detallePaqueteFacade.remove(detallePaquete);
    }
    
    public List<DetallePaquete> consultarDetallePaquete(){
        return detallePaqueteFacade.findAll();
    }
    
    public DetallePaquete consultarID(){
        return detallePaqueteFacade.find(this.detallePaquete.getCodDpati());
    }
}
