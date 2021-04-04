/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Facade.PaqueteTodoIncluidoFacade;
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
@Named(value = "pruebaGrafico2")
@SessionScoped
public class pruebaGrafico2 implements Serializable {

    /**
     * Creates a new instance of pruebaGrafico2
     */
    public pruebaGrafico2() {
    }
    
    @EJB
    PaqueteTodoIncluidoFacade paqueteTodoIncluidoFacade;
    
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
        
        barModel.setTitle("Paquetes Matrimonio");
        barModel.setLegendPosition("ne");
        
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Tipo Paquete");
        
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Total");
        yAxis.setMin(2000000);
        yAxis.setMax(15000000); 
    }
    
    private BarChartModel initBarModel(){
        BarChartModel model = new BarChartModel();
        List<Object[]> listaPaquetes=paqueteTodoIncluidoFacade.consultarPaquetes(); 
        ChartSeries Paquetes = new ChartSeries();
        Paquetes.setLabel("Paquete Todo Incluido");
        for(Object[] objecto:listaPaquetes){
            Paquetes.set(objecto[0].toString(),Integer.parseInt(objecto[1].toString()));
            
        }
        
        model.addSeries(Paquetes);
        return model;
    
    }
}
