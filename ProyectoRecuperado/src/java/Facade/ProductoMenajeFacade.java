/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidades.ProductoMenaje;
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
public class ProductoMenajeFacade extends AbstractFacade<ProductoMenaje> {

    @PersistenceContext(unitName = "ProyectoRecuperadoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoMenajeFacade() {
        super(ProductoMenaje.class);
    }
    
    public String CargaDatos(String archivo, String tabla){
        
        Query query = em.createNativeQuery("LOAD DATA LOCAL INFILE '" + archivo + "' INTO TABLE " + tabla + " FIELDS TERMINATED BY ';' ENCLOSED BY '\"' ESCAPED BY '\\\\' LINES TERMINATED BY '\\r\\n'");
        int resultado = query.executeUpdate();
        String mensaje = resultado + "Filas afectadas";
        return mensaje;
    }
    
    public List<Object[]>consultarProductos(){
        List<Object[]>listaProductos;
        Query query=em.createNativeQuery(" SELECT producto_menaje.nom_prod AS Nombre, producto_menaje.Cod_Prod FROM producto_menaje " +
                                            " WHERE producto_menaje.Cod_Prod BETWEEN 8 AND 18; ");
        listaProductos=query.getResultList();
        return listaProductos;
    }
}
