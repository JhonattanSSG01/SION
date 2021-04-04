/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.PaqueteTodoIncluido;
import Facade.PaqueteTodoIncluidoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author USUARIO
 */
@Named(value = "paqueteTodoIncluidoController")
@SessionScoped
public class paqueteTodoIncluidoController implements Serializable {

    /**
     * Creates a new instance of paqueteTodoIncluidoController
     */
    public paqueteTodoIncluidoController() {
    }
    
    private PaqueteTodoIncluido  paqueteTodoIncluido;
    @EJB
    PaqueteTodoIncluidoFacade paqueteTodoIncluidoFacade;
    @Inject
    mensajeController mensajesController;
    
    
    @PostConstruct
    public void init(){
        paqueteTodoIncluido = new PaqueteTodoIncluido();
    }

    public PaqueteTodoIncluido getPaqueteTodoIncluido() {
        return paqueteTodoIncluido;
    }

    public void setPaqueteTodoIncluido(PaqueteTodoIncluido paqueteTodoIncluido) {
        this.paqueteTodoIncluido = paqueteTodoIncluido;
    }
    
    public void registrarPaqueteTodoIncluido(){
        try{
            paqueteTodoIncluidoFacade.create(this.paqueteTodoIncluido);
            paqueteTodoIncluido = new PaqueteTodoIncluido();
            mensajesController.setMensaje("Mensaje('Correcto','El servicio sobre el paquete ha sido creado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al crear el servicio','error')");
        }
        
       
    }
    
    public String preActualizarPaquetTodoIncluido(PaqueteTodoIncluido paqueteTodoIncluido){
        this.paqueteTodoIncluido = paqueteTodoIncluido;
        return "paquete-edit";
    }
     
    public String actualizarPaqueteTodoIncluido(){
        try{
            paqueteTodoIncluidoFacade.edit(this.paqueteTodoIncluido);
            paqueteTodoIncluido = new PaqueteTodoIncluido();
            mensajesController.setMensaje("Mensaje('Satisfactorio','El servicio sobre el paquete ha sido actualizado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al actualizar el servicio','error')");
        }
       
       return "paquete-list";
    }
    
    public void eliminarPaqueteTodoIncluido(PaqueteTodoIncluido paqueteTodoIncluido){
        try{
            paqueteTodoIncluidoFacade.remove(paqueteTodoIncluido);
            mensajesController.setMensaje("Mensaje('Exitoso','El servicio sobre el paquete ha sido eliminado','warning')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al eliminar el servicio','error')");
        }
       
    }
     
    public List<PaqueteTodoIncluido> consultarPaqueteTodoIncluido(){
        return paqueteTodoIncluidoFacade.findAll();
    }
     
    public PaqueteTodoIncluido consultarID(){
        return paqueteTodoIncluidoFacade.find(this.paqueteTodoIncluido.getCodPati());
    }
    
    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userLogged",null);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        return "../index.xhtml?faces-redirect=true";
    }
}
