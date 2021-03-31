/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidades.Evento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author USUARIO
 */
@Stateless
public class EventoFacade extends AbstractFacade<Evento> {

    @PersistenceContext(unitName = "ProyectoRecuperadoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EventoFacade() {
        super(Evento.class);
    }
    
    public String CargaDatos(String archivo, String tabla){
        
        Query query = em.createNativeQuery("LOAD DATA LOCAL INFILE'" + archivo + "' REPLACE INTO TABLE" + tabla + "SIELDS TERMINATED B ';' ENCLOSED BY '\"' ESCAPED BY '\\\\' LINES TERMINATED BY '\\r\\n'");
        int resultado = query.executeUpdate();
        String mensaje = resultado + "Filas afectadas";
        return mensaje;
    }
    
}
