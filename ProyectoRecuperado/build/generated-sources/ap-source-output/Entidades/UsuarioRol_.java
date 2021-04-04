package Entidades;

import Entidades.Cliente;
import Entidades.Empleado;
import Entidades.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-04T17:33:17")
@StaticMetamodel(UsuarioRol.class)
public class UsuarioRol_ { 

    public static volatile SingularAttribute<UsuarioRol, String> docUsu;
    public static volatile SingularAttribute<UsuarioRol, String> corUsu;
    public static volatile SingularAttribute<UsuarioRol, Integer> codUsu;
    public static volatile SingularAttribute<UsuarioRol, String> nomcUsu;
    public static volatile CollectionAttribute<UsuarioRol, Empleado> empleadoCollection;
    public static volatile SingularAttribute<UsuarioRol, String> conUsu;
    public static volatile SingularAttribute<UsuarioRol, Rol> codRol;
    public static volatile CollectionAttribute<UsuarioRol, Cliente> clienteCollection;

}