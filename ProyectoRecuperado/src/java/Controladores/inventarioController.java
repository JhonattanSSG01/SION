/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Inventario;
import Entidades.Stock;
import Facade.InventarioFacade;
import Facade.StockFacade;
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
@Named(value = "inventarioController")
@SessionScoped
public class inventarioController implements Serializable {

    /**
     * Creates a new instance of inventarioController
     */
    public inventarioController() {
    }
    
    private Stock stock;
    private Inventario inventario;
    @EJB
    StockFacade stockFacade;
    @EJB
    InventarioFacade inventarioFacade;
    @Inject
    mensajeController mensajesController;
    
    @PostConstruct
    public void init(){
        stock = new Stock();
        inventario = new Inventario();
    }
    
    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario (Inventario inventario) {
        this.inventario = inventario;
    }
    
    public void registrarInventario(){
        try{
            inventario.setCodSto(stockFacade.find(this.stock.getCodSto()));
            inventarioFacade.create(this.inventario);
            inventario = new Inventario();
            mensajesController.setMensaje("Mensaje('Correcto','El registro al inventario ha sido creado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al crear el registro en el inventario','error')");
        }
        
        
    }
    
    public String preActualizarInventario(Inventario inventario){
        this.inventario = inventario;
        return "inventario-edit";
    }
    
    public String actualizarInventario(){
        try{ 
            inventario.setCodSto(stockFacade.find(this.stock.getCodSto()));
            inventarioFacade.edit(this.inventario);
            inventario = new Inventario();
            mensajesController.setMensaje("Mensaje('Satisfactorio','El registro al inventario ha sido creado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al actualizar el registro en el inventario','error')");
        }
        
        return "inventario-list";
    }
    
    public void eliminarInventario(Inventario inventario){
        try{
            inventarioFacade.remove(inventario);
            mensajesController.setMensaje("Mensaje('Exitoso','El registro al inventario ha sido rliminado','warning')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al eliminar el registro en el inventario','error')");
        }
        
    }
    
    public List<Inventario> consultarInventario(){
        return inventarioFacade.findAll();
    }
    
    public Inventario consultarID(){
        return inventarioFacade.find(this.inventario.getCodInv());
    }
    
    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userLogged",null);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        return "index.xhtml?faces-redirect=true";
    }
}
