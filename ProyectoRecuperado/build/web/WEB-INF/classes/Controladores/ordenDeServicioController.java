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
import javax.inject.Inject;

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
    @Inject
    mensajeController mensajesController;
    
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
        try{
            ordenDeServicio.setCodEve(eventoFacade.find(this.evento.getCodEve()));
            ordenDeServicioFacade.create(this.ordenDeServicio);
            mensajesController.setMensaje("Mensaje('Correcto','La orden sobre el servicio ha sido creado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al crear la orden','error')");
        }
        
    }
    
    public String preActualizarOrdenDeServicio(OrdenDeServicio ordenDeServicio){
        this.ordenDeServicio = ordenDeServicio;
        return "orden-edit";
    }
    
    public String actualizarOrdenDeServicio(){
        try{
            ordenDeServicio.setCodEve(eventoFacade.find(this.evento.getCodEve()));
            ordenDeServicioFacade.edit(this.ordenDeServicio);
            ordenDeServicio = new OrdenDeServicio();
            mensajesController.setMensaje("Mensaje('Correcto','La orden sobre el servicio ha sido actualizada','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al actualizar la orden','error')");
        }
        
        return "orden-list";
    }
    
    public void eliminarOrdenDeServicio(OrdenDeServicio ordenDeServicio){
        try{
            ordenDeServicioFacade.remove(ordenDeServicio);
            mensajesController.setMensaje("Mensaje('Correcto','La orden sobre el servicio ha sido eliminada','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al eliminar la orden','error')");
        }
        
    }
    
    public List<OrdenDeServicio> consultarOrdenDeServicios(){
        return ordenDeServicioFacade.findAll();
    }
    
    public OrdenDeServicio consultarID(){
        return ordenDeServicioFacade.find(this.ordenDeServicio.getCodOse());
    }
}
