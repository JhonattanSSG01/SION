/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.DetalleTipoEvento;
import Entidades.Empleado;
import Facade.DetalleTipoEventoFacade;
import Facade.EmpleadoFacade;
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
@Named(value = "detalleTipo_EventoController")
@SessionScoped
public class detalleTipo_EventoController implements Serializable {

    /**
     * Creates a new instance of detalleTipo_EventoController
     */
    public detalleTipo_EventoController() {
    }
    
    private Empleado empleado;
    private DetalleTipoEvento detalleTipoEvento;   
    @EJB
    EmpleadoFacade empleadoFacade;
    @EJB
    DetalleTipoEventoFacade detalleTipoEventoFacade;   
    @Inject
    mensajeController mensajesController;
    
    @PostConstruct
    public void init(){
        empleado = new Empleado();
        detalleTipoEvento = new DetalleTipoEvento();
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    public DetalleTipoEvento getDetalleTipoEvento() {
        return detalleTipoEvento;
    }

    public void setDetalleTipoEvento(DetalleTipoEvento detalleTipoEvento) {
        this.detalleTipoEvento = detalleTipoEvento;
    }
    
    public void registroDetalleTipoEvento(){
        try{ 
            detalleTipoEvento.setCodEmp(empleadoFacade.find(this.empleado.getCodEmp()));
            detalleTipoEventoFacade.create(detalleTipoEvento);
            mensajesController.setMensaje("Mensaje('Correcto','El detalle del tipo evento ha sido creado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al crear el detalle','error')");
        }
       
    }
    
    public String preActualizarDetalleTipoEvento(DetalleTipoEvento detalleTipoEvento){
        this.detalleTipoEvento = detalleTipoEvento;
        return "actualizarDetalleTipoEvento";    
    }
    
    public void actualizarDetalleTipoEvento(){
        try{
            detalleTipoEvento.setCodEmp(empleadoFacade.find(this.empleado.getCodEmp()));
            detalleTipoEventoFacade.edit(detalleTipoEvento);
            detalleTipoEvento = new DetalleTipoEvento();
            mensajesController.setMensaje("Mensaje('Satisfactorio','El detalle del tipo evento ha sido actualizado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al actualizar el detalle','error')");
        }
        
    }
    
    public void eliminarDetalleTipoEvento(DetalleTipoEvento detalleTipoEvento){
        try{
            detalleTipoEventoFacade.remove(this.detalleTipoEvento);
            mensajesController.setMensaje("Mensaje('Exitoso','El detalle del tipo evento ha sido eliminado','warning')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al eliminar el detalle','error')");
        }
        
    }
    
    public List<DetalleTipoEvento> consultarDetalleTipoEvento(){
        return detalleTipoEventoFacade.findAll();
    }
    
    public DetalleTipoEvento consultarID(){
        return detalleTipoEventoFacade.find(this.detalleTipoEvento.getCodDee());
    }
}
