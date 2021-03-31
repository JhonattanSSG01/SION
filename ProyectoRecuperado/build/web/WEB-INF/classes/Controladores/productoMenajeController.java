/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.ProductoMenaje;
import Entidades.Proveedor;
import Facade.ProductoMenajeFacade;
import Facade.ProveedorFacade;
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
@Named(value = "productoMenajeController")
@SessionScoped
public class productoMenajeController implements Serializable {

    /**
     * Creates a new instance of productoMenajeController
     */
    public productoMenajeController() {
    }
    
    private Proveedor proveedor;
    private ProductoMenaje productoMenaje;
    @EJB
    ProveedorFacade proveedorFacade;
    @EJB
    ProductoMenajeFacade  productoMenajeFacade;
    @Inject
    mensajeController mensajesController;
   
    @PostConstruct
    public void init(){ 
        proveedor = new Proveedor();
        productoMenaje = new ProductoMenaje();
    }
    
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public ProductoMenaje getProductoMenaje() {
        return productoMenaje;
    }

    public void setProductoMenaje(ProductoMenaje productoMenaje) {
        this.productoMenaje = productoMenaje;
    }
 
    public void registrarProductoMenaje(){
        try{
            productoMenaje.setCodPro(proveedorFacade.find(this.proveedor.getCodPro()));
            productoMenajeFacade.create(this.productoMenaje);
            productoMenaje = new ProductoMenaje();
            mensajesController.setMensaje("Mensaje('Correcto','El producto ha sido creado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al crear el producto','error')");
        }
       
    }
    
    public String preActualizarProductoMenaje(ProductoMenaje productoMenaje){
        this.productoMenaje = productoMenaje;
        return "producto-edit";
    }
    
    public String actualizarProveedor(){
        try{
            productoMenaje.setCodPro(proveedorFacade.find(this.proveedor.getCodPro()));
            productoMenajeFacade.edit(this.productoMenaje);
            productoMenaje = new ProductoMenaje();
            mensajesController.setMensaje("Mensaje('Satisfactorio','El producto ha sido actualizado','success')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al actualizar el producto','error')");
        }
        
        return "producto-list";
    }
    
    public void eliminarProductoMenaje(ProductoMenaje productoMenaje) { 
        try{
            productoMenajeFacade.remove(productoMenaje);
            mensajesController.setMensaje("Mensaje('Exitoso','El producto ha sido eliminado','warning')");
        }catch(Exception e){
            mensajesController.setMensaje("Mensaje('Error','Error al eliminar el producto','error')");
        }
        
    }
    
    public List<ProductoMenaje> consultarProductoMenaje(){
        return productoMenajeFacade.findAll();
    }
    
    public ProductoMenaje consultarID(){
        return productoMenajeFacade.find(this.productoMenaje.getCodPro());
    }
}
