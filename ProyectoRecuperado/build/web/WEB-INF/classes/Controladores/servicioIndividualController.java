/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.ServicioIndividual;
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
@Named(value = "servicioIndividualController")
@SessionScoped
public class servicioIndividualController implements Serializable {

    /**
     * Creates a new instance of servicioIndividualController
     */
    public servicioIndividualController() {
    }
    
    private ServicioIndividual servicioIndividual;
    @EJB
    ServicioIndividualFacade servicioIndividualFacade;
    @Inject
    mensajeController mensajesController;
    
    @PostConstruct
    public void init(){
        servicioIndividual = new ServicioIndividual();
    }

    public ServicioIndividual getServicioIndividual() {
        return servicioIndividual;
    }

    public void setServicioIndividual(ServicioIndividual servicioIndividual) {
        this.servicioIndividual = servicioIndividual;
    }
    
    public void registrarServicioIndividual(){
        try{
            servicioIndividualFacade.create(this.servicioIndividual);
            servicioIndividual = new ServicioIndividual();
            mensajesController.setMensaje("Mensaje('Correcto','El servicio ha sido creado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al crear el servicio','error')");
        }
         
    }
    
    public String preActualizarServicioIndividual(ServicioIndividual servicioIndividual){
         this.servicioIndividual = servicioIndividual;
         return "servicioIndividual-edit";
    }
    
    public String actualizarServicioIndividual(){
        try{
            servicioIndividualFacade.edit(this.servicioIndividual);
            servicioIndividual = new ServicioIndividual();
            mensajesController.setMensaje("Mensaje('Satisfactorio','El servicio ha sido atualizado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al actualizar el servicio','error')");
        }
        
        return "servicioIndividual-list";
    }
    
    public void eliminarServicioIndividual (ServicioIndividual servicioIndividual){
        try{
            servicioIndividualFacade.remove(servicioIndividual);
            mensajesController.setMensaje("Mensaje('Exitoso','El servicio ha sido eliminado','warning')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al eliminar el servicio','error')");
        }
        
    }
  
    public List<ServicioIndividual> consultarServicioIndividual(){
        return servicioIndividualFacade.findAll();
    }
    
    public ServicioIndividual consultarId(){
        return servicioIndividualFacade.find(this.servicioIndividual.getCodSei());
    }
}
