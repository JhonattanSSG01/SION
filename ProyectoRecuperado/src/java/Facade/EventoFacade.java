/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidades.Evento;
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
        
        Query query = em.createNativeQuery("LOAD DATA LOCAL INFILE '" + archivo + "' INTO TABLE " + tabla + " FIELDS TERMINATED BY ';' ENCLOSED BY '\"' ESCAPED BY '\\\\' LINES TERMINATED BY '\\r\\n'");
        int resultado = query.executeUpdate();
        String mensaje = resultado + "Filas afectadas";
        return mensaje;
    }
    
    public List<Object[]>consultarEventos(){
        List<Object[]>listaEventos;
        Query query=em.createNativeQuery("  SELECT evento.tip_Eve, evento.inv_Eve FROM evento WHERE evento.inv_Eve <= 60;");
        listaEventos=query.getResultList();
        return listaEventos;
    }
}
