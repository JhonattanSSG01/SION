/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.DetalleServicio;
import Entidades.Evento;
import Entidades.ServicioIndividual;
import Facade.DetalleServicioFacade;
import Facade.EventoFacade;
import Facade.ServicioIndividualFacade;
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
@Named(value = "detalleServicioController")
@SessionScoped
public class detalleServicioController implements Serializable {

    /**
     * Creates a new instance of detalleServicioController
     */
    public detalleServicioController() {
    }
    
    private ServicioIndividual servicioIndividual;
    private Evento evento;
    private DetalleServicio detalleServicio;
    @EJB
    ServicioIndividualFacade servicioIndividualFacade;
    @EJB
    EventoFacade eventoFacade;
    @EJB
    DetalleServicioFacade detalleServicioFacade;
    @Inject
    mensajeController mensajesController;
            
    @PostConstruct
    public void init(){
        servicioIndividual = new ServicioIndividual();
        evento = new Evento();
        detalleServicio = new DetalleServicio();
    }
    
    public ServicioIndividual getServicioIndividual() {
        return servicioIndividual;
    }

    public void setServicioIndividual(ServicioIndividual servicioIndividual) {
        this.servicioIndividual = servicioIndividual;
    }

    public Evento getServicio() {
        return evento;
    }

    public void setServicio(Evento evento) {
        this.evento = evento;
    }

    public DetalleServicio getDetalleServicio() {
        return detalleServicio;
    }

    public void setDetalleServicio(DetalleServicio detalleServicio) {
        this.detalleServicio = detalleServicio;
    }
    
    public void registrarDetalleServicio(){
        try{
            detalleServicio.setCodSei(servicioIndividualFacade.find(this.servicioIndividual.getCodSei()));
            detalleServicio.setCodEve(eventoFacade.find(this.evento.getCodEve()));
            detalleServicioFacade.create(this.detalleServicio);
            detalleServicio = new DetalleServicio();
            mensajesController.setMensaje("Mensaje('Correcto','El detalle del servicio ha sido creado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al crear el detalle','error')");
        }
        
    }
    
    public String preActualizarDetalleServicio(DetalleServicio detalleServicio){
        this.detalleServicio = detalleServicio;
        return "actualizarDetalleServicio";    
    }
    
    public void actualizarDetalleServicio(){
        try{
            detalleServicio.setCodSei(servicioIndividualFacade.find(this.servicioIndividual.getCodSei()));
            detalleServicio.setCodEve(eventoFacade.find(this.evento.getCodEve()));
            detalleServicioFacade.edit(detalleServicio);
            detalleServicio = new DetalleServicio();
            mensajesController.setMensaje("Mensaje('Satisfactorio','El detalle del servicio ha sido actualizado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al actualizar el detalle','error')");
        }
        
    }
    
    public void eliminarDetalleServicio(DetalleServicio detalleServicio){
        try{
             detalleServicioFacade.remove(this.detalleServicio);
             mensajesController.setMensaje("Mensaje('Exitoso','El detalle del tipo evento ha sido eliminado','warning')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al eliminar el detalle','error')");
        }
       
    }
    
    public List<DetalleServicio> consultarDetalleServicio(){
        return detalleServicioFacade.findAll();
    }
    
    public DetalleServicio consultarID(){
        return detalleServicioFacade.find(this.detalleServicio.getCodDse());
    }
}
