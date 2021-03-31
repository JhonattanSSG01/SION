/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidades.PermisoRol;
import Entidades.Rol;
import java.util.ArrayList;
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
public class PermisoRolFacade extends AbstractFacade<PermisoRol> {

    @PersistenceContext(unitName = "ProyectoRecuperadoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PermisoRolFacade() {
        super(PermisoRol.class);
    }
    
    public List<PermisoRol> permisoRol(Rol rol){
        
        List<Object[]> listaPermiso = new ArrayList();
        List<PermisoRol> listaFinal = new ArrayList();
        
        try {
            
            Query query = em.createNativeQuery( "SELECT permiso_rol.cod_Per, permiso_rol.nomfor_per, permiso_rol.url_per, permiso_rol.ico_per, permiso_rol.pad_per FROM permiso_rol " +
                                                "INNER JOIN detalle_permiso_rol ON permiso_rol.Cod_Per = detalle_permiso_rol.Cod_Per " +
                                                "INNER JOIN rol ON detalle_permiso_rol.Cod_Rol = rol.Cod_Rol " +
                                                "WHERE rol.Cod_Rol = " + rol.getCodRol());

            listaPermiso = query.getResultList(); 
            
            for (Object[] object : listaPermiso) {
                
                PermisoRol permiso = new PermisoRol();
                permiso.setCodPer(Integer.parseInt(object[0].toString()));
                permiso.setNomforPer(object[1].toString());
                permiso.setUrlper(object[2].toString());
                permiso.setIcoper(object[3].toString());
                listaFinal.add(permiso);
            
        }
            
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        
        
            return listaFinal;
    }
    
    public List<PermisoRol> permisoPadre(int CodPadre){
        
        List<Object[]> listaPermiso = new ArrayList();
        List<PermisoRol> listaFinal = new ArrayList();
        
        Query query = em.createNativeQuery("SELECT cod_per, nomfor_per, url_per, ico_per FROM permiso_rol WHERE pad_per =" + CodPadre);
        
        listaPermiso = query.getResultList();
            
            for (Object[] object : listaPermiso) {
                
                PermisoRol permiso = new PermisoRol();
                permiso.setCodPer(Integer.parseInt(object[0].toString()));
                permiso.setNomforPer(object[1].toString());
                permiso.setUrlper(object[2].toString());
                permiso.setIcoper(object[3].toString());
                listaFinal.add(permiso);
            
        }
            
         return listaFinal;
    }
}
