/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Proveedor;
import Facade.ProveedorFacade;
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
@Named(value = "proveedorController")
@SessionScoped
public class proveedorController implements Serializable {

    /**
     * Creates a new instance of proveedorController
     */
    public proveedorController() {
    }
    
    private Proveedor proveedor;
    @EJB
    ProveedorFacade proveedorFacade;
    @Inject
    mensajeController mensajesController;
    
    @PostConstruct
    public void init(){
    proveedor = new Proveedor ();
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    public void registrarProveedor(){
        try{
            proveedorFacade.create(this.proveedor);
            proveedor = new Proveedor();
            mensajesController.setMensaje("Mensaje('Correcto','El provedor ha sido creado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al crear el proveedor','error')");
        }
        
    }
    
    public String preActualizarProveedor(Proveedor proveedor){
        this.proveedor = proveedor;
        return "proveedor-edit";
    }
    
    public String actualizarProveedor(){
        try{
            proveedorFacade.edit(this.proveedor);
            proveedor = new Proveedor();
            mensajesController.setMensaje("Mensaje('Satisfactorio','El proveedor ha sido actualizado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al actualizar el proveedor','error')");
        }
        
        return "proveedor-list";
    }
    
    public void eliminarProveedor(Proveedor proveedor) { 
        try{
            proveedorFacade.remove(proveedor);
            mensajesController.setMensaje("Mensaje('Exitoso','El proveedor ha sido eliminado','warning')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al eliminar el proveedor','error')");
        }
        
        }
    
    public List<Proveedor> consultarProveedor(){
       return proveedorFacade.findAll();
    }
    
    public Proveedor consultarId(){
       return proveedorFacade.find(this.proveedor.getCodPro());
    }
}
