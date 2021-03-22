/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Cliente;
import Entidades.PermisoRol;
import Entidades.Rol;
import Entidades.UsuarioRol;
import Facade.ClienteFacade;
import Facade.PermisoRolFacade;
import Facade.RolFacade;
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
@Named(value = "usuarioRolController")
@SessionScoped
public class usuarioRolController implements Serializable {

    /**
     * Creates a new instance of usuarioRolController
     */
    public usuarioRolController() {
    }
    
    private Rol rolUsuario;
    private Cliente cliente;
    private Rol rol;
    private UsuarioRol usuarioRol;
    @EJB
    PermisoRolFacade permisoRolFacade; 
    @EJB
    ClienteFacade clienteFacade;
    @EJB
    RolFacade rolFacade;
    @EJB
    UsuarioRolFacade usuarioRolFacade;  
    @Inject
    mensajeController mensajesController;
    
    @PostConstruct
    public void init(){
        rolUsuario = new Rol();
        cliente = new Cliente();
        rol = new Rol();
        usuarioRol = new UsuarioRol();
    }
    
    public Rol getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(Rol rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public UsuarioRol getUsuarioRol() {
        return usuarioRol;
    }

    public void setUsuarioRol(UsuarioRol usuarioRol) {
        this.usuarioRol = usuarioRol;
    }
    
    public void registrarUsuarioRol(int rol){
        try{
            if (rol == 1) {
            usuarioRol.setCodRol(rolFacade.find(5));
            }else {
                usuarioRol.setCodRol(rolFacade.find(this.rol.getCodRol()));  
            }
            usuarioRol.setCodUsu(1);
            usuarioRolFacade.create(this.usuarioRol);
            cliente.setCodUsu(usuarioRol);
            clienteFacade.create(cliente);
            usuarioRol = new UsuarioRol();
            mensajesController.setMensaje("Mensaje('Correcto','Te has resgistrado exitosamente','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Ha habido un error al registrarse','error')");
        }
        

    }
    
    public String preActualizarUsuarioRol(UsuarioRol usuarioRol){
        cliente = clienteFacade.consultarClienteID(usuarioRol.getCodUsu());
        this.usuarioRol = usuarioRol;
        return "usuario-edit";
    }
    
    public void actualizarUsuarioRol(){
        try{
            usuarioRol.setCodRol(rolFacade.find(5));
            usuarioRolFacade.edit(this.usuarioRol);
            cliente.setCodUsu(usuarioRol);
            clienteFacade.edit(cliente);
            usuarioRol = new UsuarioRol();
            mensajesController.setMensaje("Mensaje('Satisfactorio','El usuario ha sido actualizado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Ha habido un error al actualizar','error')");
        }
        
    }
    
    public void eliminarUsuarioRol(UsuarioRol usuarioRol){
        try{
            cliente = clienteFacade.consultarClienteID(usuarioRol.getCodUsu());
            clienteFacade.remove(cliente);
            usuarioRolFacade.remove(usuarioRol);
            mensajesController.setMensaje("Mensaje('Exitoso','El usuario ha sido eliminado','warning')");
        }catch(Exception e){
             mensajesController.setMensaje("Mensaje('Error','Ha habido un error al eliminar','error')");
        }
        
        
    }
    
    public List<UsuarioRol> consultarUsuarioRol(){
        return usuarioRolFacade.findAll();
    }
    
    public UsuarioRol consultarID(){
        return usuarioRolFacade.find(this.usuarioRol.getCodUsu());
    }
    
    public List<PermisoRol> consultarPermiso(){
        return permisoRolFacade.permisoRol(rolUsuario);
    }
    
    public List<PermisoRol> consultarPermisoPadre(int CodPdr){
        return permisoRolFacade.permisoPadre(CodPdr);
    }
    
    public String signIn(){
        String redireccion="";
        UsuarioRol usuarioRolSignIn = new UsuarioRol();
        try{
            usuarioRolSignIn = usuarioRolFacade.signIn(this.usuarioRol.getCorUsu(), this.usuarioRol.getConUsu());
            if(usuarioRolSignIn.getCodUsu()!= null){
                rolUsuario = usuarioRolSignIn.getCodRol();
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogeado", usuarioRolSignIn);
                if (1 == usuarioRolSignIn.getCodRol().getCodRol() ) {  
                    redireccion="dashboardAdmin";
                }else if (2 == usuarioRolSignIn.getCodRol().getCodRol()) {
                    redireccion="gadashboard";
                }else if (3 == usuarioRolSignIn.getCodRol().getCodRol()) {
                    redireccion="secretariadashboard";
                }else if (4 == usuarioRolSignIn.getCodRol().getCodRol()) {
                    redireccion="empleadodashboard";
                }else if (5 == usuarioRolSignIn.getCodRol().getCodRol()) {
                    redireccion="dashboardCliente";
                }else{
                    redireccion="";
                }
            }
                else{
                    System.out.println("Usuario y/o contraseña incorrectas");
                }
            
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return redireccion;
    }

    
}
