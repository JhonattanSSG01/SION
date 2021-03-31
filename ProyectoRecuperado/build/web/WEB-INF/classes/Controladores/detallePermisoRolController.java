/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.DetallePermisoRol;
import Entidades.PermisoRol;
import Entidades.Rol;
import Facade.DetallePermisoRolFacade;
import Facade.PermisoRolFacade;
import Facade.RolFacade;
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
@Named(value = "detallePermisoRolController")
@SessionScoped
public class detallePermisoRolController implements Serializable {

    /**
     * Creates a new instance of detallePermisoRolController
     */
    public detallePermisoRolController() {
    }
    
    private PermisoRol permisoRol;
    private Rol rol;
    private DetallePermisoRol detallePermisoRol;
    @EJB
    PermisoRolFacade permisoRolFacade;
    @EJB
    RolFacade rolFacade;
    @EJB
    DetallePermisoRolFacade detallePermisoRolFacade;
            
    @PostConstruct
    public void init(){
        permisoRol = new PermisoRol();
        rol = new Rol();
        detallePermisoRol = new DetallePermisoRol();
    }

    public PermisoRol getPermisoRol() {
        return permisoRol;
    }

    public void setPermisoRol(PermisoRol permisoRol) {
        this.permisoRol = permisoRol;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public DetallePermisoRol getDetallePermisoRol() {
        return detallePermisoRol;
    }

    public void setDetallePermisoRol(DetallePermisoRol detallePermisoRol) {
        this.detallePermisoRol = detallePermisoRol;
    }
    
    public void registroDetallePermisoRol(){
        detallePermisoRol.setCodPer(permisoRolFacade.find(this.detallePermisoRol.getCodPer()));
        detallePermisoRol.setCodRol(rolFacade.find(this.rol.getCodRol()));
        detallePermisoRolFacade.create(this.detallePermisoRol);
        detallePermisoRol = new DetallePermisoRol();
    }
    
    public String preActualizarDetallePermisoRol(DetallePermisoRol detallePermisoRol){
        this.detallePermisoRol = detallePermisoRol;
        return "actualizarDetallePermisoRol";    
    }
    
    public String actualizarDetallePermisoRol(){
        detallePermisoRol.setCodPer(permisoRolFacade.find(this.detallePermisoRol.getCodPer()));
        detallePermisoRol.setCodRol(rolFacade.find(this.rol.getCodRol()));
        detallePermisoRolFacade.edit(detallePermisoRol);
        detallePermisoRol = new DetallePermisoRol();
        return "registroDetallePermisoRol";
    }
    
    public void eliminarDetallePermisoRol(DetallePermisoRol detallePermisoRol){
        detallePermisoRolFacade.remove(this.detallePermisoRol);
    }
    
    public List<DetallePermisoRol> consultarDetallePermisoRol(){
        return detallePermisoRolFacade.findAll();
    }
    
    public DetallePermisoRol consultarID(){
        return detallePermisoRolFacade.find(this.detallePermisoRol.getCodDprol());
    }
}
