package Entidades;

import Entidades.Empleado;
import Entidades.Evento;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-04T16:04:43")
@StaticMetamodel(DetalleTipoEvento.class)
public class DetalleTipoEvento_ { 

    public static volatile SingularAttribute<DetalleTipoEvento, Integer> codDee;
    public static volatile SingularAttribute<DetalleTipoEvento, Empleado> codEmp;
    public static volatile CollectionAttribute<DetalleTipoEvento, Evento> eventoCollection;

}