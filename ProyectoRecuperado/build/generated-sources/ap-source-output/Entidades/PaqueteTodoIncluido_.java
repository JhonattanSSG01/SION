package Entidades;

import Entidades.DetalleIndividual;
import Entidades.DetallePaquete;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-04T22:30:03")
@StaticMetamodel(PaqueteTodoIncluido.class)
public class PaqueteTodoIncluido_ { 

    public static volatile SingularAttribute<PaqueteTodoIncluido, Integer> codPati;
    public static volatile CollectionAttribute<PaqueteTodoIncluido, DetalleIndividual> detalleIndividualCollection;
    public static volatile SingularAttribute<PaqueteTodoIncluido, String> despati;
    public static volatile SingularAttribute<PaqueteTodoIncluido, Integer> valPati;
    public static volatile CollectionAttribute<PaqueteTodoIncluido, DetallePaquete> detallePaqueteCollection;
    public static volatile SingularAttribute<PaqueteTodoIncluido, String> nomPati;

}