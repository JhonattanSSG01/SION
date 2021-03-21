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
        cliente.setCodUsu(usuarioRolFacade.find(this.usuarioRol.getCodUsu()));
        clienteFacade.create(this.cliente);
        cliente = new Cliente();
    }
    
    public String preActualizarCliente(Cliente cliente){
        this.cliente = cliente;
        return "actualizarCliente";
    }
    
    public String actualizarCliente(){
        cliente.setCodUsu(usuarioRolFacade.find(this.usuarioRol.getCodUsu()));
        clienteFacade.edit(this.cliente);
        cliente = new Cliente();
        return "registroCliente";
    }
    
    public void eliminarCliente(Cliente cliente){
           clienteFacade.remove(cliente);
    }
    
    public List<Cliente> consultarClientes(){
        return clienteFacade.findAll();
    }
    
    public Cliente consultarID(){
        return clienteFacade.find(this.cliente.getCodCli());
    }
}
