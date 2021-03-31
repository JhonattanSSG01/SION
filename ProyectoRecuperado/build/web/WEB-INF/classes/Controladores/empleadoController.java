/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Empleado;
import Entidades.UsuarioRol;
import Facade.EmpleadoFacade;
import Facade.UsuarioRolFacade;
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
@Named(value = "empleadoController")
@SessionScoped
public class empleadoController implements Serializable {

    /**
     * Creates a new instance of empleadoController
     */
    public empleadoController() {
    }
    
    private UsuarioRol usuarioRol;
    private Empleado empleado;
    @EJB
    UsuarioRolFacade usuarioRolFacade;
    @EJB 
    EmpleadoFacade empleadoFacade;
    @Inject
    mensajeController mensajesController;     
    
    @PostConstruct
    public void init(){
        usuarioRol = new UsuarioRol();
        empleado = new Empleado();
    }
    
     public UsuarioRol getUsuarioRol() {
        return usuarioRol;
    }

    public void setUsuarioRol(UsuarioRol usuarioRol) {
        this.usuarioRol = usuarioRol;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    public void registrarEmpleado(){
        try{
            empleado.setCodUsu(usuarioRolFacade.find(this.usuarioRol.getCodUsu()));
            empleadoFacade.create(this.empleado);
            empleado = new Empleado();
            mensajesController.setMensaje("Mensaje('Correcto','El empleado ha sido creado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al crear el empleado','error')");
        }
        
    }
    
    public String preActualizarEmpleado(Empleado empleado){
        this.empleado = empleado;
        return "empleado-edit";
    }
    
    public String actualizarEmpleado(){
        try{
            empleado.setCodUsu(usuarioRolFacade.find(this.usuarioRol.getCodUsu()));
            empleadoFacade.edit(this.empleado);
            empleado = new Empleado();
            mensajesController.setMensaje("Mensaje('Satisfactorio','El empleado ha sido actualizado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al actualizar el empleado','error')");
        }
        return "empleado-list";
        
    }
    
    public void eliminarEmpleado(Empleado Empleado){
        try{
            empleadoFacade.remove(Empleado);
            mensajesController.setMensaje("Mensaje('Exitoso','El empleado ha sido eliminado','warning')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al eliminar el empleado','error')");
        }
        
    }
    
    public List<Empleado> consultarEmpleados(){
        return empleadoFacade.findAll();
    }
    
    public Empleado consultarID(){
        return empleadoFacade.find(this.empleado.getCodEmp());
    }
}
