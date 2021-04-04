/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.PermisoRol;
import Facade.PermisoRolFacade;
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
@Named(value = "permisoRolController")
@SessionScoped
public class permisoRolController implements Serializable {

    /**
     * Creates a new instance of permisoRolController
     */
    public permisoRolController() {
    }
    
    private PermisoRol permisoRol;
    @EJB
    PermisoRolFacade permisoRolFacade;
    @Inject
    mensajeController mensajesController;
    
    @PostConstruct
    public void init(){
    permisoRol = new PermisoRol();
    }

    public PermisoRol getPermisoRol() {
        return permisoRol;
    }

    public void setPermisoRol(PermisoRol permisoRol) {
        this.permisoRol = permisoRol;
    }
    
    public void registrarPermisoRol(){
        try{
            permisoRolFacade.create(this.permisoRol);
            permisoRol = new PermisoRol();
            mensajesController.setMensaje("Mensaje('Correcto','El permiso del rol ha sido creado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al crear el permiso rol','error')");
        }
        
    }
    
    public String preActualizarPermisoRol(PermisoRol permisoRol){
        this.permisoRol = permisoRol;
        return "permiso-edit";
    }
     
    public String actualizarPermisoRol(){
        try{
            permisoRolFacade.edit(this.permisoRol);
            permisoRol = new PermisoRol();
            mensajesController.setMensaje("Mensaje('Satisfactorio','El permiso del rol ha sido actualizado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al actualizar el permiso rol','error')");
        }
        return "permiso";
        
    } 
         
    public void eliminarPermisoRol(PermisoRol permisoRol){
        try{
            permisoRolFacade.remove(permisoRol);
            mensajesController.setMensaje("Mensaje('Exitoso','El permiso del rol ha sido eliminado','warning')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al eliminar el permiso rol','error')");
        }
        
    }
   
    public List<PermisoRol> consultarPermisoRol(){
        return permisoRolFacade.findAll();
    }
    
    public PermisoRol consultarID(){
        return permisoRolFacade.find(this.permisoRol.getCodPer());
    }
    
    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userLogged",null);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        return "index.xhtml?faces-redirect=true";
    }
}
