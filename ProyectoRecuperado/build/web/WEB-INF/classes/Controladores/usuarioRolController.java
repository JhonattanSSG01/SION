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
    
    String Nombre="";
    int Documento;
    int Telefono;
    String Direccion="";
    String Correo="";
    String Contraseña="";
    
    private Rol rolUsuario;
    private Cliente cliente;
    private Rol rol;
    private UsuarioRol usuarioRol;
    private UsuarioRol usuarioLogin;
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
        usuarioLogin = (UsuarioRol) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioRolSignIn");
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getDocumento() {
        return Documento;
    }

    public void setDocumento(int Documento) {
        this.Documento = Documento;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
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
    
    public void registrarUsuarioRol(int rol) throws UnsupportedEncodingException, MessagingException{
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
            Mailer_1.content(mensajeEstilo(), usuarioRol.getDocUsu(), cliente.getTelCli(), cliente.getDirCli(), usuarioRol.getCorUsu(), usuarioRol.getConUsu());
            usuarioRol = new UsuarioRol();
            mensajesController.setMensaje("Mensaje('Correcto','Te has resgistrado exitosamente','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Ha habido un error al registrarse, verifica los campos e intentalo de nuevo','error')");
        }
        

    }
    
    public String preActualizarUsuarioRol(UsuarioRol usuarioRol){
        cliente = clienteFacade.consultarClienteID(usuarioRol.getCodUsu());
        this.usuarioRol = usuarioRol;
        return "usuario-edit";
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
    
    
    public String mensajeEstilo(){
        return "<div style=\"max-width: 700px; padding: 20px; margin:0 auto; font-family: inherit;\">" 
                   + "<div class=\"row\">"
                        + "<div class=\"col\" style=\"padding: 20px; margin: 10px auto; border-collapse: collapse; background-color: rgba(160, 168, 177, 0.2); border-radius: 2%; \">"
                            + "<div class=\"row\">"
                                + "<div class=\"col-2\" style=\"text-align: left;  \">"
                                    +  "<a href=\"index.xhtml\">" + "<img src='https://i.imgur.com/raWGRVJ.png'/ style=\"display:block; margin: 10px 15px; float: left; width: 80px; height: 120px;\">" + "</a>"       
                                + "</div>"
                                + "<div class=\"col-10\">"
                                    + "<h2 style=\"text-transform: uppercase; font-size: xx-large; display: flex; align-items: center; justify-content: center; text-align: center; text-align: center; color: #4d84c2;\">Bienvenido" + usuarioRol.getNomcUsu() + "!!</h2>"
                                + "</div>"
                            + "</div>"
                            
                            + "<div style=\"margin 0 auto;\">"
                                + "<div class=\"row\">"
                                    + "<div class=\"col-12\" style=\"margin: 30px 20px 10px; color: #52718f; text-align: justify;\">"
                                        + "<h2 style=\"color: #4d84c2; margin: 0 0 7px; text-transform: uppercase; \">"					
                                                + usuarioRol.getNomcUsu()
                                         + "</h2>"
                                           + "<p style=\"margin: 2px; font-size: 15px; \"> Lorem ipsum dolor sit amet consectetur, adipisicing elit. Doloribus id, esse totam sit voluptate molestiae impedit corrupti porro ab eius praesentium et, debitis ratione quisquam! Et iusto omnis eligendi corrupti?" + "</p>"
                                               + "<ul style=\"font-size: 15px;  margin: 10px 0; \">"
                                                       +  "<li>Lorem ipsum dolor sit amet." + "</li>"
                                                       +  "<li>Lorem ipsum dolor sit amet." + "</li>"
                                                       +  "<li>Lorem ipsum dolor sit amet." + "</li>"
                                                       +  "<li>Lorem ipsum dolor sit amet." + "</li>"
                                                       +  "<li>Lorem ipsum dolor sit amet." + "</li>"
                                               + "</ul>"
                                               + "<div style=\"width: 100%; text-align: center; margin-top:40px;\">"
                                                   + "<a style=\"text-decoration: none; border-radius: 5px; padding: 11px 23px; color: white; background-color: #3477db\" href=\"#\">Ir a la página" + "</a>"
                                               + "</div>"
                                                + "<div class=\"row\">"
                                                    + "<div class=\"col-12\" style=\"text-align: -webkit-center;\">"
                                                        + "<img src='https://images.unsplash.com/photo-1612198188060-c7c2a3b66eae?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTR8fGNvbXB1dGVyJTIwaGFyZHdhcmV8ZW58MHwwfDB8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60'/ style=\"padding: 10px; display: block; opacity: 50%; box-shadow: 0 0 20px rgb(61, 61, 61); width: 95%; \">"
                                                    + "</div>"
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
                       + "</div>"
                   + "</div>"
              + "</div>";

    }

    
}
