package Entidades;

import Entidades.Evento;
import Entidades.ServicioIndividual;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-04T16:04:43")
@StaticMetamodel(DetalleServicio.class)
public class DetalleServicio_ { 

    public static volatile SingularAttribute<DetalleServicio, Integer> codDse;
    public static volatile SingularAttribute<DetalleServicio, ServicioIndividual> codSei;
    public static volatile SingularAttribute<DetalleServicio, Evento> codEve;

}