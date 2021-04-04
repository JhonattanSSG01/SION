/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidades.PaqueteTodoIncluido;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author USUARIO
 */
@Stateless
public class PaqueteTodoIncluidoFacade extends AbstractFacade<PaqueteTodoIncluido> {

    @PersistenceContext(unitName = "ProyectoRecuperadoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaqueteTodoIncluidoFacade() {
        super(PaqueteTodoIncluido.class);
    }
    
    public List<Object[]>consultarPaquetes(){
        List<Object[]>listaPaquetes;
        Query query=em.createNativeQuery(" SELECT paquete_todo_incluido.Nom_Pati AS Nombre_Paquete, paquete_todo_incluido.val_pati  FROM paquete_todo_incluido " +
        " WHERE paquete_todo_incluido.Nom_Pati LIKE \"Ma%\" ;");
        listaPaquetes=query.getResultList();
        return listaPaquetes;
    }
    
}
