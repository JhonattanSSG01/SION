package Entidades;

import Entidades.DetallePermisoRol;
import Entidades.UsuarioRol;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-04T16:04:43")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile SingularAttribute<Rol, String> desRol;
    public static volatile CollectionAttribute<Rol, UsuarioRol> usuarioRolCollection;
    public static volatile CollectionAttribute<Rol, DetallePermisoRol> detallePermisoRolCollection;
    public static volatile SingularAttribute<Rol, String> nomRol;
    public static volatile SingularAttribute<Rol, Integer> codRol;

}