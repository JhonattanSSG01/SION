/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Rol;
import Facade.RolFacade;
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
@Named(value = "rolController")
@SessionScoped
public class rolController implements Serializable {

    /**
     * Creates a new instance of rolController
     */
    public rolController() {
    }
    
    private Rol rol;
    @EJB
    RolFacade rolFacade;
    @Inject
    mensajeController mensajesController;
    
    @PostConstruct
    public void init(){
        rol = new Rol();
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    public void registrarRol(){
        try{
            rolFacade.create(this.rol);
            rol = new Rol();
            mensajesController.setMensaje("Mensaje('Correcto','El rol ha sido creado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al crear el rol','error')");
        }
        
    }
     
    public String preActualizarRol(Rol rol){
        this.rol = rol;
        return "rol-edit";
    }
      
    public void actualizarRol(){
        try{
            rolFacade.edit(this.rol);
            rol = new Rol();
            mensajesController.setMensaje("Mensaje('Satisfactorio','El rol ha sido actualizado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al actualizar el rol','error')");
        }
        
    }
      
    public void eliminarRol(Rol rol){
        try{
            rolFacade.remove(rol);
            mensajesController.setMensaje("Mensaje('Exitoso','El rol ha sido eliminado','warning')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al eliminar el rol','error')");
        }
          
    }
    
    public List <Rol> consultarRol(){
        return rolFacade.findAll();  
    }
      
    public Rol consultarID(){
       return rolFacade.find(this.rol.getCodRol());     
    }
}
