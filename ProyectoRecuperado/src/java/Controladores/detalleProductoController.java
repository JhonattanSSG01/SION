/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.DetalleProducto;
import Entidades.OrdenDeServicio;
import Entidades.ProductoMenaje;
import Facade.DetalleProductoFacade;
import Facade.OrdenDeServicioFacade;
import Facade.ProductoMenajeFacade;
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
@Named(value = "detalleProductoController")
@SessionScoped
public class detalleProductoController implements Serializable {

    /**
     * Creates a new instance of detalleProductoController
     */
    public detalleProductoController() {
    }
    
    private ProductoMenaje productoMenaje;
    private OrdenDeServicio ordenDeServicio;
    private DetalleProducto detalleProducto;
    @EJB
    ProductoMenajeFacade productoMenajeFacade;
    @EJB
    OrdenDeServicioFacade ordenDeServicioFacade;
    @EJB
    DetalleProductoFacade detalleProductoFacade;
            
    @PostConstruct
    public void init(){
        productoMenaje = new ProductoMenaje();
        ordenDeServicio = new OrdenDeServicio();
        detalleProducto = new DetalleProducto();
    }
    
    public ProductoMenaje getProductoMenaje() {
        return productoMenaje;
    }

    public void setProductoMenaje(ProductoMenaje productoMenaje) {
        this.productoMenaje = productoMenaje;
    }

    public OrdenDeServicio getOrdenDeServicio() {
        return ordenDeServicio;
    }

    public void setOrdenDeServicio(OrdenDeServicio ordenDeServicio) {
        this.ordenDeServicio = ordenDeServicio;
    }

    public DetalleProducto getDetalleProducto() {
        return detalleProducto;
    }

    public void setDetalleProducto(DetalleProducto detalleProducto) {
        this.detalleProducto = detalleProducto;
    }
    
    public void registrarDetalleProducto(){
        detalleProducto.setCodProd(productoMenajeFacade.find(this.productoMenaje.getCodProd()));
        detalleProducto.setCodOse(ordenDeServicioFacade.find(this.ordenDeServicio.getCodOse()));
        detalleProductoFacade.create(this.detalleProducto);
        detalleProducto = new DetalleProducto();
    }
    
    public String preActualizarDetalleProducto (DetalleProducto detalleProducto){
        this.detalleProducto = detalleProducto;
        return "actualizarDetalleProducto";    
    }
    
    public String actualizarDetalleProducto(){
        detalleProducto.setCodProd(productoMenajeFacade.find(this.productoMenaje.getCodProd()));
        detalleProducto.setCodOse(ordenDeServicioFacade.find(this.ordenDeServicio.getCodOse()));
        detalleProductoFacade.edit(detalleProducto);
        detalleProducto = new DetalleProducto();
        return "registrarDetalleProducto";
    }
    
    public void eliminarDetalleProducto(DetalleProducto detalleProducto){
        detalleProductoFacade.remove(this.detalleProducto);
    }
    
    public List<DetalleProducto> consultarDetallesProducto(){
        return detalleProductoFacade.findAll();
    }
    
    public DetalleProducto consultarID(){
        return detalleProductoFacade.find(this.detalleProducto.getCodDpro());
    }
}
