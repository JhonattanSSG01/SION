/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Facade.EventoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author USUARIO
 */
@Named(value = "pruebaGrafico")
@SessionScoped
public class pruebaGrafico implements Serializable {

    /**
     * Creates a new instance of pruebaGrafico
     */
    public pruebaGrafico() {
    }
    
    @EJB
    EventoFacade eventoFacade;
    
    private BarChartModel barModel;

    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }
    
    @PostConstruct
    public void init(){
        createBarModel();
    }
    
    private void createBarModel(){
        barModel = initBarModel();
        
        barModel.setTitle("Eventos En Pandemia");
        barModel.setLegendPosition("ne");
        
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Tipo Evento");
        
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Total Invitados");
        yAxis.setMin(10);
        yAxis.setMax(120); 
    }
    
    private BarChartModel initBarModel(){
        BarChartModel model = new BarChartModel();
        List<Object[]> listaEventos=eventoFacade.consultarEventos(); 
        ChartSeries Eventos = new ChartSeries();
        Eventos.setLabel("Eventos");
        for(Object[] objecto:listaEventos){
            Eventos.set(objecto[0].toString(),Integer.parseInt(objecto[1].toString()));
            
        }
        
        model.addSeries(Eventos);
        return model;
    
    }
    
    
}
