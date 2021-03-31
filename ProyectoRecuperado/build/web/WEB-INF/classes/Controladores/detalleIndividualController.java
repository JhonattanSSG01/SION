/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.DetalleIndividual;
import Entidades.PaqueteTodoIncluido;
import Entidades.ServicioIndividual;
import Facade.DetalleIndividualFacade;
import Facade.PaqueteTodoIncluidoFacade;
import Facade.ServicioIndividualFacade;
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
@Named(value = "detalleIndividualController")
@SessionScoped
public class detalleIndividualController implements Serializable {

    /**
     * Creates a new instance of detalleIndividualController
     */
    public detalleIndividualController() {
    }
    
    private PaqueteTodoIncluido paqueteTodoIncluido;
    private ServicioIndividual servicioIndividual;
    private DetalleIndividual detalleIndividual;
    @EJB
    PaqueteTodoIncluidoFacade paqueteTodoIncluidoFacade;
    @EJB
    ServicioIndividualFacade servicioIndividualFacade;
    @EJB
    DetalleIndividualFacade detalleIndividualFacade;
    
    @PostConstruct
    public void init(){
        paqueteTodoIncluido = new PaqueteTodoIncluido();
        servicioIndividual = new ServicioIndividual();
        detalleIndividual = new DetalleIndividual();
    } 

    public PaqueteTodoIncluido getPaqueteTodoIncluido() {
        return paqueteTodoIncluido;
    }

    public void setPaqueteTodoIncluido(PaqueteTodoIncluido paqueteTodoIncluido) {
        this.paqueteTodoIncluido = paqueteTodoIncluido;
    }

    public ServicioIndividual getServicioIndividual() {
        return servicioIndividual;
    }

    public void setServicioIndividual(ServicioIndividual servicioIndividual) {
        this.servicioIndividual = servicioIndividual;
    }

    public DetalleIndividual getDetalleIndividual() {
        return detalleIndividual;
    }

    public void setDetalleIndividual(DetalleIndividual detalleIndividual) {
        this.detalleIndividual = detalleIndividual;
    }
    
    public void registrarDetalleIndividual(){
        detalleIndividual.setCodPati(paqueteTodoIncluidoFacade.find(this.paqueteTodoIncluido.getCodPati()));
        detalleIndividual.setCodSei(servicioIndividualFacade.find(this.servicioIndividual.getCodSei()));
        detalleIndividualFacade.create(this.detalleIndividual);
        detalleIndividual = new DetalleIndividual();
    }
    
    public String preActualizarDetalleIndividual(DetalleIndividual detalleIndividual){
        this.detalleIndividual = detalleIndividual;
        return "actualizarDetalleIndividual";
    }
    
    public String actualizarDetalleIndividual(){
        detalleIndividual.setCodPati(paqueteTodoIncluidoFacade.find(this.paqueteTodoIncluido.getCodPati()));
        detalleIndividual.setCodSei(servicioIndividualFacade.find(this.servicioIndividual.getCodSei()));
        detalleIndividualFacade.edit(this.detalleIndividual);
        detalleIndividual = new DetalleIndividual();
        return "registroDetalleIndividual";
    }
    
    public void eliminarDetaleIndividual(DetalleIndividual detalleIndividual){
        detalleIndividualFacade.remove(detalleIndividual);
    }
    
    public List<DetalleIndividual> consultarDetalleIndividual(){
        return detalleIndividualFacade.findAll();
    }
    
    public DetalleIndividual consultarID(){
        return detalleIndividualFacade.find(this.detalleIndividual.getCodDins());
    }
}
