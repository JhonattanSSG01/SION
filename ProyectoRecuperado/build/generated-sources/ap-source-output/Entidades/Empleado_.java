package Entidades;

import Entidades.DetalleTipoEvento;
import Entidades.UsuarioRol;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-04T17:33:17")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile CollectionAttribute<Empleado, DetalleTipoEvento> detalleTipoEventoCollection;
    public static volatile SingularAttribute<Empleado, UsuarioRol> codUsu;
    public static volatile SingularAttribute<Empleado, Integer> codEmp;
    public static volatile SingularAttribute<Empleado, String> dirEmp;
    public static volatile SingularAttribute<Empleado, Integer> telEmp;

}