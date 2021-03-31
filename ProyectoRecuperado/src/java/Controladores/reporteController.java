/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Evento;
import Facade.EventoFacade;
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
    EventoFacade eventoFacade;
    private List<Evento> listaEvento;
    private List<Object[]> listaTotal;
    
    JasperPrint jasperPrint;

    public List<Evento> getListaEvento() {
        listaEvento=eventoFacade.findAll();
        return listaEvento;
    }

    public void setListaEvento(List<Evento> listaEvento) {
        this.listaEvento = listaEvento;
    }

    
    public void init() throws JRException{
    
    }
    public void PDF(ActionEvent actionEvent) throws JRException, IOException{
    JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(listaTotal);
    String ruta=FacesContext.getCurrentInstance().getExternalContext().getRealPath("//Reportes//");
    jasperPrint=JasperFillManager.fillReport(ruta+"//ReportePrueba_2.jasper", new HashMap(),beanCollectionDataSource);
    HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
    httpServletResponse.addHeader("Content-disposition", "attachment; filename = reporteEventos.pdf");
    ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
    JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
    FacesContext.getCurrentInstance().responseComplete();
       
   
   }
    
}
