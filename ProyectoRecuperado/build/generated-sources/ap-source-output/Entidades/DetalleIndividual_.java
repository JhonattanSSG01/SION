package Entidades;

import Entidades.PaqueteTodoIncluido;
import Entidades.ServicioIndividual;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-20T16:27:24")
@StaticMetamodel(DetalleIndividual.class)
public class DetalleIndividual_ { 

    public static volatile SingularAttribute<DetalleIndividual, ServicioIndividual> codSei;
    public static volatile SingularAttribute<DetalleIndividual, Integer> codDins;
    public static volatile SingularAttribute<DetalleIndividual, PaqueteTodoIncluido> codPati;

}