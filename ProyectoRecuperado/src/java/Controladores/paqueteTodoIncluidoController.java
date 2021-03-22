/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.PaqueteTodoIncluido;
import Facade.PaqueteTodoIncluidoFacade;
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
@Named(value = "paqueteTodoIncluidoController")
@SessionScoped
public class paqueteTodoIncluidoController implements Serializable {

    /**
     * Creates a new instance of paqueteTodoIncluidoController
     */
    public paqueteTodoIncluidoController() {
    }
    
    private PaqueteTodoIncluido  paqueteTodoIncluido;
    @EJB
    PaqueteTodoIncluidoFacade paqueteTodoIncluidoFacade;
    
    @PostConstruct
    public void init(){
        paqueteTodoIncluido = new PaqueteTodoIncluido();
    }

    public PaqueteTodoIncluido getPaqueteTodoIncluido() {
        return paqueteTodoIncluido;
    }

    public void setPaqueteTodoIncluido(PaqueteTodoIncluido paqueteTodoIncluido) {
        this.paqueteTodoIncluido = paqueteTodoIncluido;
    }
    
    public void registrarPaqueteTodoIncluido(){
       paqueteTodoIncluidoFacade.create(this.paqueteTodoIncluido);
       paqueteTodoIncluido = new PaqueteTodoIncluido();
    }
    
    public String preActualizarPaquetTodoIncluido(PaqueteTodoIncluido paqueteTodoIncluido){
        this.paqueteTodoIncluido = paqueteTodoIncluido;
        return "paquete-edit";
    }
     
    public String actualizarPaqueteTodoIncluido(){
       paqueteTodoIncluidoFacade.edit(this.paqueteTodoIncluido);
       paqueteTodoIncluido = new PaqueteTodoIncluido();
       return "paquete";
    }
    
    public void eliminarPaqueteTodoIncluido(PaqueteTodoIncluido paqueteTodoIncluido){
       paqueteTodoIncluidoFacade.remove(paqueteTodoIncluido);
    }
     
    public List<PaqueteTodoIncluido> consultarPaqueteTodoIncluido(){
        return paqueteTodoIncluidoFacade.findAll();
    }
     
    public PaqueteTodoIncluido consultarID(){
        return paqueteTodoIncluidoFacade.find(this.paqueteTodoIncluido.getCodPati());
    }
}
