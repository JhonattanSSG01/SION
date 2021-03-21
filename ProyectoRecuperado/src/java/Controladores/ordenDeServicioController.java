/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Evento;
import Entidades.OrdenDeServicio;
import Facade.EventoFacade;
import Facade.OrdenDeServicioFacade;
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
@Named(value = "ordenDeServicioController")
@SessionScoped
public class ordenDeServicioController implements Serializable {

    /**
     * Creates a new instance of ordenDeServicioController
     */
    public ordenDeServicioController() {
    }
    
    private Evento evento;
    private OrdenDeServicio ordenDeServicio;
    @EJB
    EventoFacade eventoFacade;
    @EJB
    OrdenDeServicioFacade ordenDeServicioFacade; 
    
    @PostConstruct
    public void init(){
        evento = new Evento();
        ordenDeServicio = new OrdenDeServicio();
    }
    
    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public OrdenDeServicio getOrdenDeServicio() {
        return ordenDeServicio;
    }

    public void setOrdenDeServicio(OrdenDeServicio ordenDeServicio) {
        this.ordenDeServicio = ordenDeServicio;
    }
    
    public void registroOrdenDeServicio(){
        ordenDeServicio.setCodEve(eventoFacade.find(this.evento.getCodEve()));
        ordenDeServicioFacade.create(this.ordenDeServicio);
    }
    
    public String preActualizarOrdenDeServicio(OrdenDeServicio ordenDeServicio){
        this.ordenDeServicio = ordenDeServicio;
        return "actualizarOrdenDeServicio";
    }
    
    public String actualizarOrdenDeServicio(){
        ordenDeServicio.setCodEve(eventoFacade.find(this.evento.getCodEve()));
        ordenDeServicioFacade.edit(this.ordenDeServicio);
        ordenDeServicio = new OrdenDeServicio();
        return "registroOrdenDeServicio";
    }
    
    public void eliminarOrdenDeServicio(OrdenDeServicio ordenDeServicio){
        ordenDeServicioFacade.remove(ordenDeServicio);
    }
    
    public List<OrdenDeServicio> consultarOrdenDeServicios(){
        return ordenDeServicioFacade.findAll();
    }
    
    public OrdenDeServicio consultarID(){
        return ordenDeServicioFacade.find(this.ordenDeServicio.getCodOse());
    }
}
