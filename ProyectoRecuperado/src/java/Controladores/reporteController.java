/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Evento;
import Entidades.Inventario;
import Entidades.ProductoMenaje;
import Entidades.Proveedor;
import Entidades.Rol;
import Entidades.Stock;
import Entidades.UsuarioRol;
import Facade.EventoFacade;
import Facade.InventarioFacade;
import Facade.ProductoMenajeFacade;
import Facade.ProveedorFacade;
import Facade.RolFacade;
import Facade.StockFacade;
import Facade.UsuarioRolFacade;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author USUARIO
 */
@Named(value = "reporteController")
@SessionScoped
public class reporteController implements Serializable {

    /**
     * Creates a new instance of reporteController
     */
    public reporteController() {
    }
    
    @EJB
    ProductoMenajeFacade productoMenajeFacade;
    @EJB
    StockFacade stockFacade;
    @EJB
    UsuarioRolFacade usuarioRolFacade;
    @EJB
    ProveedorFacade proveedorFacade;
    
    private List<ProductoMenaje> listaProducto;
    private List<Proveedor> listaProveedor;
    private List<Stock> listaStock;
    private List<UsuarioRol> listaUsuarios;
    private List<Object[]> listaTotal;
    
    JasperPrint jasperPrint;

    public List<ProductoMenaje> getListaProducto() {
        listaProducto=productoMenajeFacade.findAll();
        return listaProducto;
    }

    public void setListaProducto(List<ProductoMenaje> listaProducto) {
        this.listaProducto = listaProducto;
    }
    
    public List<Proveedor> getListaProveedor() {
        listaProveedor=proveedorFacade.findAll();
        return listaProveedor;
    }

    public void setListaEvento(List<Proveedor> listaEvento) {
        this.listaProveedor = listaEvento;
    }
    
    public List<Stock> getListaStock() {
        listaStock=stockFacade.findAll();
        return listaStock;
    }

    public void setListaStock(List<Stock> listaStock) {
        this.listaStock = listaStock;
    }

    public List<UsuarioRol> getListaUsuarios() {
        listaUsuarios=usuarioRolFacade.findAll();
        return listaUsuarios;
    }

    public void setListaUsuarios(List<UsuarioRol> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    } 
    
    public void init() throws JRException{
    
    }

    
    public void PDF(ActionEvent actionEvent) throws JRException, IOException{
    JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(listaProveedor);
    String ruta=FacesContext.getCurrentInstance().getExternalContext().getRealPath("//Reportes//");
    jasperPrint=JasperFillManager.fillReport(ruta+"//ReporteProveedores.jasper", new HashMap(),beanCollectionDataSource);
    HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
    httpServletResponse.addHeader("Content-disposition", "attachment; filename = Reporte_Proveedores.pdf");
    ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
    JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
    FacesContext.getCurrentInstance().responseComplete();
    
    }
    
    public void PDF1(ActionEvent actionEvent) throws JRException, IOException{
    JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(listaProducto);
    String ruta=FacesContext.getCurrentInstance().getExternalContext().getRealPath("//Reportes//");
    jasperPrint=JasperFillManager.fillReport(ruta+"//ReporteProductoo.jasper", new HashMap(),beanCollectionDataSource);
    HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
    httpServletResponse.addHeader("Content-disposition", "attachment; filename = Reporte_Productos.pdf");
    ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
    JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
    FacesContext.getCurrentInstance().responseComplete();
    
    }

    public void PDF2(ActionEvent actionEvent) throws JRException, IOException{
    JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(listaStock);
    String ruta=FacesContext.getCurrentInstance().getExternalContext().getRealPath("//Reportes//");
    jasperPrint=JasperFillManager.fillReport(ruta+"//ReporteInventario.jasper", new HashMap(),beanCollectionDataSource);
    HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
    httpServletResponse.addHeader("Content-disposition", "attachment; filename = Reporte_Stock.pdf");
    ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
    JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
    FacesContext.getCurrentInstance().responseComplete();
    
    }
   
    public void PDF3(ActionEvent actionEvent) throws JRException, IOException{
    JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(listaUsuarios);
    String ruta=FacesContext.getCurrentInstance().getExternalContext().getRealPath("//Reportes//");
    jasperPrint=JasperFillManager.fillReport(ruta+"//ReporteUsuarios.jasper", new HashMap(),beanCollectionDataSource);
    HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
    httpServletResponse.addHeader("Content-disposition", "attachment; filename = Reporte_Usuarios.pdf");
    ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
    JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
    FacesContext.getCurrentInstance().responseComplete();
    
    }
}
