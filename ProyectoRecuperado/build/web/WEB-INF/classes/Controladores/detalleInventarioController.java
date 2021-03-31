/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.DetalleInventario;
import Entidades.Inventario;
import Entidades.ProductoMenaje;
import Facade.DetalleInventarioFacade;
import Facade.InventarioFacade;
import Facade.ProductoMenajeFacade;
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
@Named(value = "detalleInventarioController")
@SessionScoped
public class detalleInventarioController implements Serializable {

    /**
     * Creates a new instance of detalleInventarioController
     */
    public detalleInventarioController() {
    }
    
    private Inventario inventario;
    private ProductoMenaje productoMenaje;
    private DetalleInventario detalleInventario;
    @EJB
    InventarioFacade inventarioFacade;
    @EJB
    ProductoMenajeFacade productoMenajeFacade;
    @EJB
    DetalleInventarioFacade detalleInventarioFacade;
    @Inject
    mensajeController mensajesController;
            
    @PostConstruct
    public void init(){
        inventario = new Inventario();
        productoMenaje = new ProductoMenaje();
        detalleInventario = new DetalleInventario();
    }
    
    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public ProductoMenaje getProductoMenaje() {
        return productoMenaje;
    }

    public void setProductoMenaje(ProductoMenaje productoMenaje) {
        this.productoMenaje = productoMenaje;
    }

    public DetalleInventario getDetalleInventario() {
        return detalleInventario;
    }

    public void setDetalleInventario(DetalleInventario detalleInventario) {
        this.detalleInventario = detalleInventario;
    }
    
    public void registrarDetalleInventario(){
        try{
            detalleInventario.setCodInv(inventarioFacade.find(this.inventario.getCodInv()));
            detalleInventario.setCodProd(productoMenajeFacade.find(this.productoMenaje.getCodProd()));
            detalleInventarioFacade.create(this.detalleInventario);
            detalleInventario = new DetalleInventario();
            mensajesController.setMensaje("Mensaje('Correcto','El detalle sobre el inventario ha sido creado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al crear el detalle','error')");
        }
        
        
    }
    
    public String preActualizarDetalleInventario(DetalleInventario detalleInventario){
        this.detalleInventario = detalleInventario;
        return "actualizarDetalleInventario";
    }
    
    public void actualizarDetalleInventario(){
        try{
            detalleInventario.setCodInv(inventarioFacade.find(this.inventario.getCodInv()));
            detalleInventario.setCodProd(productoMenajeFacade.find(this.productoMenaje.getCodProd()));
            detalleInventarioFacade.edit(detalleInventario);
            detalleInventario = new DetalleInventario();
            mensajesController.setMensaje("Mensaje('Satisfactorio','El detalle sobre el inventario ha sido actualizado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al actualizar el detalle','error')");
        }
    }
       
    
    public void eliminarDetalleInventario(DetalleInventario detalleInventario){
        try{
            detalleInventarioFacade.remove(this.detalleInventario);
            mensajesController.setMensaje("Mensaje('Exitoso','El detalle ha sido eliminado','warning')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al eliminar el registro','error')");
        }
        
    }
    
    public List<DetalleInventario> consultarDetallesInventario(){
        return detalleInventarioFacade.findAll();
    }
    
    public DetalleInventario consultarID(){
        return detalleInventarioFacade.find(this.detalleInventario.getCodDin());
    }
}
