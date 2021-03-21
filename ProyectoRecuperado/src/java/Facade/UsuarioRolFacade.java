/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entidades.UsuarioRol;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author USUARIO
 */
@Stateless
public class UsuarioRolFacade extends AbstractFacade<UsuarioRol> {

    @PersistenceContext(unitName = "ProyectoRecuperadoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioRolFacade() {
        super(UsuarioRol.class);
    }

        public UsuarioRol signIn(String correo, String contrasena){
            UsuarioRol usuarioRol = null;
        try{
            Query query = em.createQuery("SELECT usuario FROM UsuarioRol usuario WHERE usuario.corUsu=:correo AND usuario.conUsu=:contrasena");
            query.setParameter("correo", correo);
            query.setParameter("contrasena", contrasena);    
            usuarioRol = (UsuarioRol) query.getResultList().get(0);
            }catch(Exception e){
                 System.out.println("Error: " + e.getMessage());
            }
            return usuarioRol;
    }
}
