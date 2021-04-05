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
import Mailer.Mailer_1;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.mail.MessagingException;

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
    
    private UsuarioRol userLogged;
    private UsuarioRol LogueadoUsuario;
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
        userLogged = new UsuarioRol();
        LogueadoUsuario = (UsuarioRol) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userLogged");
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

    public UsuarioRol getLogueadoUsuario() {
        return LogueadoUsuario;
    }

    public void setLogueadoUsuario(UsuarioRol LogueadoUsuario) {
        this.LogueadoUsuario = LogueadoUsuario;
    }

    public UsuarioRol getUserLogged() {
        return userLogged;
    }

    public void setUserLogged(UsuarioRol userLogged) {
        this.userLogged = userLogged;
    }
    
    
    public void registrarUsuarioRol(int rol) throws UnsupportedEncodingException, MessagingException{
        Mailer_1.content(mensajeEstilo(), usuarioRol.getDocUsu(), cliente.getTelCli(), cliente.getDirCli(), usuarioRol.getCorUsu(), usuarioRol.getConUsu());
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
            mensajesController.setMensaje("Mensaje('Error','Ha habido un error al registrarse, verifica los campos e intentalo de nuevo','error')");
        }
        

    }
    
    public String preActualizarUsuarioRol(UsuarioRol usuarioRol){
        try {
            cliente = clienteFacade.consultarClienteID(usuarioRol.getCodUsu());
            this.usuarioRol = usuarioRol;
            return "usuario-edit";
        } catch (Exception e) {
            mensajesController.setMensaje("Mensaje('Error','Ha habido un error al actualizar','error')");
        }
        if (usuarioRol.getCodUsu() == 1 || usuarioRol.getCodUsu() == 2 || usuarioRol.getCodUsu() == 3 || usuarioRol.getCodUsu() == 4) {
                return "usuario-list";
            }else{
                return "usuario-edit";
            }
        
        
    }
    
    public String actualizarUsuarioRol(){
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
        return "usuario-list";
        
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
        LogueadoUsuario = (UsuarioRol) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userLogged");
        return permisoRolFacade.permisoRol(rolUsuario);
    }
    
    public List<PermisoRol> consultarPermisoPadre(int CodPdr){
        return permisoRolFacade.permisoPadre(CodPdr);
    }
    
    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userLogged",null);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        return "\\index.xhtml";
    }
    public String signIn(){
        String redireccion="";
        UsuarioRol usuarioRolSignIn = new UsuarioRol();
        try{
            usuarioRolSignIn = usuarioRolFacade.signIn(this.usuarioRol.getCorUsu(), this.usuarioRol.getConUsu());
            mensajesController.setMensaje("Mensaje('Exitoso','Ha accedido correctamente','success')");
            userLogged = usuarioRolSignIn;
            if(usuarioRolSignIn.getCodUsu()!= null){
                rolUsuario = usuarioRolSignIn.getCodRol();
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userLogged", usuarioRolSignIn);
                if (1 == usuarioRolSignIn.getCodRol().getCodRol() ) {  
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userLogged", usuarioRolSignIn);
                    redireccion="dashboardAdmin";
                }else if (2 == usuarioRolSignIn.getCodRol().getCodRol()) {
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userLogged", usuarioRolSignIn);
                    redireccion="gadashboard";
                }else if (3 == usuarioRolSignIn.getCodRol().getCodRol()) {
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userLogged", usuarioRolSignIn);
                    redireccion="secretariadashboard";
                }else if (4 == usuarioRolSignIn.getCodRol().getCodRol()) {
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userLogged", usuarioRolSignIn);
                    redireccion="empleadodashboard";
                }else if (5 == usuarioRolSignIn.getCodRol().getCodRol()) {
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userLogged", usuarioRolSignIn);
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
            mensajesController.setMensaje("Mensaje('Error','Ha habido un error, verifique los datos e intentelo de nuevo','error')");
        }
        return redireccion;
    }
    
    public String volver(){
        String redireccion="";
        UsuarioRol userLoggedin = new UsuarioRol();
        try{
            userLoggedin = usuarioRolFacade.signIn(this.usuarioRol.getCorUsu(), this.usuarioRol.getConUsu());
            userLogged = userLoggedin;
                if (1 ==(userLoggedin.getCodRol().getCodRol()) ) {  
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userLogged", userLoggedin);
                    redireccion="dashboardAdmin";
                }else if (2 == userLoggedin.getCodRol().getCodRol()) {
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userLogged", userLoggedin);
                    redireccion="gadashboard";
                }else if (3 == userLoggedin.getCodRol().getCodRol()) {
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userLogged", userLoggedin);
                    redireccion="secretariadashboard";
                }else if (4 == userLoggedin.getCodRol().getCodRol()) {
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userLogged", userLoggedin);
                    redireccion="empleadodashboard";
                }else if (5 == userLoggedin.getCodRol().getCodRol()) {
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userLogged", userLoggedin);
                    redireccion="dashboardCliente";
                }else{
                    redireccion="";
                }
            
        }catch(Exception e){
            System.out.println("Error: " + e);
            mensajesController.setMensaje("Mensaje('Error','Ha habido un error, verifique los datos e intentelo de nuevo','error')");
        }
        return redireccion;
    }
    
    public String mensajeEstilo(){
        return "<div style=\"max-width: 700px; padding: 20px; margin:0 auto; font-family: inherit;\">" 
                   + "<div class=\"row\">"
                        + "<div class=\"col\" style=\"padding: 20px; margin: 10px auto; border-collapse: collapse; background-color: rgba(160, 168, 177, 0.2); border-radius: 2%; \">"
                            + "<div class=\"row\">"
                                + "<div class=\"col-2\" style=\"text-align: left;  \">"
                                    +  "<a href=\"index.xhtml\">" + "<img src='https://i.imgur.com/raWGRVJ.png'/ style=\"display:block; margin: 10px 15px; float: left; width: 80px; height: 120px;\">" + "</a>"       
                                + "</div>"
                                + "<div class=\"col-10\">"
                                    + "<h2 style=\"text-transform: uppercase; font-size: xx-large; display: flex; align-items: center; justify-content: center; text-align: center; text-align: center; color: #4d84c2;\">Bienvenido " + usuarioRol.getNomcUsu() + "!!</h2>"
                                + "</div>"
                            + "</div>"
                            
                            + "<div style=\"margin 0 auto;\">"
                                + "<div class=\"row\">"
                                    + "<div class=\"col-12\" style=\"margin: 30px 20px 10px; color: #52718f; text-align: justify;\">"
                                        + "<h2 style=\"color: #4d84c2; margin: 0 0 7px; text-transform: uppercase; \">"					
                                                + usuarioRol.getNomcUsu()
                                         + "</h2>"
                                           + "<p style=\"margin: 2px; font-size: 15px; \"> Gracias por tenernos presente para tu día especia, en este momento realizamos el envío de correo de confirmación del registro en nuestro sitio web Cas Banquetes y Eventos SION." + "</p>"
                                               + "<div style=\"width: 100%; text-align: center; margin:40px 0 10px 0;\">"
                                                   + "<a style=\"text-decoration: none; border-radius: 5px; padding: 11px 23px; color: white; background-color: #3477db\" href=\"#\">Ir a la página" + "</a>"
                                               + "</div>"
                                                
                                                + "<div class=\"row\">"
                                                   + "<div class=\"col\" style=\"width: 100%; margin:15px 0; display: inline-block;text-align: center\">"
                                                       + "<a href=\"https://imgur.com/QHz9RXH\"><img src=\"https://i.imgur.com/QHz9RXH.png\" width=\"30\" style=\"padding: 0; margin: 5px;\">" + "</a>"
                                                       + "<a href=\"https://imgur.com/VGdNZCj\"><img src=\"https://i.imgur.com/VGdNZCj.png\" width=\"30\" style=\"padding: 0; margin: 5px;\">" + "</a>"
                                                       + "<a href=\"https://imgur.com/PDYFmh2\"><img src=\"https://i.imgur.com/PDYFmh2.png\" width=\"30\" style=\"padding: 0; margin: 5px;\">" + "</a>"
                                                       + "<a href=\"https://imgur.com/p887qcr\"><img src=\"https://i.imgur.com/p887qcr.png\" width=\"30\" style=\"padding: 0; margin: 5px;\">" + "</a>"
                                                       + "<p style=\"color: #4d84c2; font-size: 12px; text-align: center; margin: 20px 0 0; \">SION - Casa De Banquetes 2021" + "</p>"
                                                   + "</div>"
                                               + "</div>"                 
                                    + "</div>"
                                + "</div>"
                            + "</div>"
                                                + "<div class=\"row\">"
                                                    + "<div class=\"col-12\" style=\"text-align: -webkit-center;\">"
                                                        + "<img src='https://images.unsplash.com/photo-1612198188060-c7c2a3b66eae?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTR8fGNvbXB1dGVyJTIwaGFyZHdhcmV8ZW58MHwwfDB8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60'/ style=\"padding: 10px; display: block; opacity: 50%; box-shadow: 0 0 20px rgb(61, 61, 61); width: 95%; \">"
                                                    + "</div>"
                                                + "</div>"
                       + "</div>"
                   + "</div>"
              + "</div>";

    }

    
}
