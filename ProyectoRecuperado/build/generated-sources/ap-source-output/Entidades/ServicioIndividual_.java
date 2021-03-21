package Entidades;

import Entidades.DetalleIndividual;
import Entidades.DetalleServicio;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-20T16:27:24")
@StaticMetamodel(ServicioIndividual.class)
public class ServicioIndividual_ { 

    public static volatile SingularAttribute<ServicioIndividual, Integer> valSei;
    public static volatile SingularAttribute<ServicioIndividual, Integer> codSei;
    public static volatile CollectionAttribute<ServicioIndividual, DetalleIndividual> detalleIndividualCollection;
    public static volatile CollectionAttribute<ServicioIndividual, DetalleServicio> detalleServicioCollection;
    public static volatile SingularAttribute<ServicioIndividual, String> desSei;
    public static volatile SingularAttribute<ServicioIndividual, String> nomSei;

}