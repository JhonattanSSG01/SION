/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Cliente;
import Entidades.UsuarioRol;
import Facade.ClienteFacade;
import Facade.UsuarioRolFacade;
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
@Named(value = "clienteController")
@SessionScoped
public class clienteController implements Serializable {

    /**
     * Creates a new instance of clienteController
     */
    public clienteController() {
    }
    
    private UsuarioRol usuarioRol;
    private Cliente cliente;
    @EJB
    UsuarioRolFacade usuarioRolFacade;
    @EJB
    ClienteFacade clienteFacade;
    @Inject
    mensajeController mensajesController;
    
    @PostConstruct
    public void init(){
        usuarioRol = new UsuarioRol();
        cliente = new Cliente();
    }

    public UsuarioRol getUsuarioRol() {
        return usuarioRol;
    }

    public void setUsuarioRol(UsuarioRol usuarioRol) {
        this.usuarioRol = usuarioRol;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void registroCliente(){
        try{
            cliente.setCodUsu(usuarioRolFacade.find(this.usuarioRol.getCodUsu()));
            clienteFacade.create(this.cliente);
            cliente = new Cliente();
            mensajesController.setMensaje("Mensaje('Correcto','El cliente ha sido creado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al crear el cliente','error')");
        }
        
    }
    
    public String preActualizarCliente(Cliente cliente){
        this.cliente = cliente;
        return "usuario-edit";
    }
    
    public String actualizarCliente(){
        try{
            cliente.setCodUsu(usuarioRolFacade.find(this.usuarioRol.getCodUsu()));
            clienteFacade.edit(this.cliente);
            cliente = new Cliente();
            mensajesController.setMensaje("Mensaje('Satisfactorio','El cliente ha sido actualizado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al actualizar el cliente','error')");
        }
        
        return "cliente";
    }
    
    public void eliminarCliente(Cliente cliente){
        try{
            clienteFacade.remove(cliente);
            mensajesController.setMensaje("Mensaje('Exitoso','El cliente ha sido eliminado','warning')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al eliminar el cliente','error')");
        }
           
    }
    
    public List<Cliente> consultarClientes(){
        return clienteFacade.findAll();
    }
    
    public Cliente consultarID(){
        return clienteFacade.find(this.cliente.getCodCli());
    }
    
    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userLogged",null);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        return "../index.xhtml?faces-redirect=true";
    }
}
