/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Stock;
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
@Named(value = "stockController")
@SessionScoped
public class stockController implements Serializable {

    /**
     * Creates a new instance of stockController
     */
    public stockController() {
    }
    
    private Stock stock;
    @EJB
    StockFacade  stockFacade;
    @Inject
    mensajeController mensajesController;
   
    @PostConstruct
    public void init(){
        stock = new Stock();
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
    
    
    public void registrarStock(){
        try{
            stockFacade.create(this.stock);
            stock = new Stock();
            mensajesController.setMensaje("Mensaje('Correcto','El stock ha sido creado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al crear el stock','error')");
        }
        
    }
    
    public String preActualizarStock(Stock stock){
         this.stock = stock;
         return "stock-edit";
    }
    
     
   public String actualizarStock(){
       try{
           stockFacade.edit(this.stock);
            stock = new Stock();
           mensajesController.setMensaje("Mensaje('Satisfacrotio','El stock ha sido actualizado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al actualizar el stock','error')");
        }
        
       return "stock-list";
   }
    
   public void eliminarStock(Stock stock){
       try{
           stockFacade.remove(stock);
           mensajesController.setMensaje("Mensaje('Exitoso','El stock ha sido eliminado','warning')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al eliminar el stock','error')");
        }
      
   }
    
   public List<Stock> consultarStock(){
       return stockFacade.findAll();
   }
    
   public Stock consultarID(){
      return stockFacade.find(this.stock.getCodSto());
   }
   
   public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userLogged",null);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        return "../index.xhtml?faces-redirect=true";
    }
}
