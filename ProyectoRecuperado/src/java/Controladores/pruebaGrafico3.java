/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Facade.StockFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author USUARIO
 */
@Named(value = "pruebaGrafico3")
@Dependent
public class pruebaGrafico3 {

    /**
     * Creates a new instance of pruebaGrafico3
     */
    public pruebaGrafico3() {
    }
    
    @EJB
    StockFacade stockFacade;
    
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
        
        barModel.setTitle("Información Detallada");
        barModel.setLegendPosition("ne");
        
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Tipo Stock");
        
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad");
        yAxis.setMin(100);
        yAxis.setMax(1800); 
    }
    
    private BarChartModel initBarModel(){
        BarChartModel model = new BarChartModel();
        List<Object[]> listaStock=stockFacade.consultarStock(); 
        ChartSeries Stock = new ChartSeries();
        Stock.setLabel("Paquete Todo Incluido");
        for(Object[] objecto:listaStock){
            Stock.set(objecto[0].toString(),Integer.parseInt(objecto[1].toString()));
            
        }
        
        model.addSeries(Stock);
        return model;
    
    }
}
