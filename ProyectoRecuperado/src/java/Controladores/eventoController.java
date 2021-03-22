/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Cliente;
import Entidades.DetalleTipoEvento;
import Entidades.Evento;
import Facade.ClienteFacade;
import Facade.DetalleTipoEventoFacade;
import Facade.EventoFacade;
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
@Named(value = "eventoController")
@SessionScoped
public class eventoController implements Serializable {

    /**
     * Creates a new instance of eventoController
     */
    public eventoController() {
    }
    
    private Cliente cliente;
    private DetalleTipoEvento detalleTipoEvento;
    private Evento evento;
    @EJB
    ClienteFacade clienteFacade;
    @EJB
    DetalleTipoEventoFacade detalleTipoEventoFacade;
    @EJB
    EventoFacade eventoFacade;
    
    @PostConstruct
    public void init(){
        cliente = new Cliente();
        detalleTipoEvento = new DetalleTipoEvento();
        evento = new Evento();
    }
   
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public DetalleTipoEvento getDetalleTipoEvento() {
        return detalleTipoEvento;
    }

    public void setDetalleTipoEvento(DetalleTipoEvento detalleTipoEvento) {
        this.detalleTipoEvento = detalleTipoEvento;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    public void registroEvento(){
        evento.setCodCli(clienteFacade.find(this.cliente.getCodCli()));
        evento.setCodDee(detalleTipoEventoFacade.find(this.detalleTipoEvento.getCodDee()));
        eventoFacade.create(this.evento);
        evento = new Evento();
    }
    
    public String preActualizarEvento(Evento evento){
        this.evento = evento;
        return "evento-edit";
    }
    
    public String actualizarEvento(){
        evento.setCodCli(clienteFacade.find(this.cliente.getCodCli()));
        evento.setCodDee(detalleTipoEventoFacade.find(this.detalleTipoEvento.getCodDee()));
        eventoFacade.edit(this.evento);
        evento = new Evento();
        return "evento-list";
    }
    
    public void eliminarEvento(Evento evento){
        eventoFacade.remove(evento);
    }
    
    public List<Evento> consultarEventos(){
        return eventoFacade.findAll();
    }
    
    public Evento consultarID(){
        return eventoFacade.find(this.evento.getCodEve());
    }
}
