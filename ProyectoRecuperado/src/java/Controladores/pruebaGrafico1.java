/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Facade.ProductoMenajeFacade;
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
@Named(value = "pruebaGrafico1")
@SessionScoped
public class pruebaGrafico1 implements Serializable {

    /**
     * Creates a new instance of pruebaGrafico1
     */
    public pruebaGrafico1() {
    }
    
    @EJB
    ProductoMenajeFacade productoMenajeFacade;
    
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
        
        barModel.setTitle("Productos ");
        barModel.setLegendPosition("ne");
        
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Nombre Producto");
        
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Total");
        yAxis.setMin(5);
        yAxis.setMax(20); 
    }
    
    private BarChartModel initBarModel(){
        BarChartModel model = new BarChartModel();
        List<Object[]> listaProductos=productoMenajeFacade.consultarProductos(); 
        ChartSeries Productos = new ChartSeries();
        Productos.setLabel("Eventos");
        for(Object[] objecto:listaProductos){
            Productos.set(objecto[0].toString(),Integer.parseInt(objecto[1].toString()));
            
        }
        
        model.addSeries(Productos);
        return model;
    
    }
    
}
