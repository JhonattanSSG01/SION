package Entidades;

import Entidades.DetalleProducto;
import Entidades.Evento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-04T17:33:17")
@StaticMetamodel(OrdenDeServicio.class)
public class OrdenDeServicio_ { 

    public static volatile SingularAttribute<OrdenDeServicio, Integer> codOse;
    public static volatile SingularAttribute<OrdenDeServicio, Integer> salOse;
    public static volatile CollectionAttribute<OrdenDeServicio, DetalleProducto> detalleProductoCollection;
    public static volatile SingularAttribute<OrdenDeServicio, Date> fecOse;
    public static volatile SingularAttribute<OrdenDeServicio, Evento> codEve;
    public static volatile SingularAttribute<OrdenDeServicio, Integer> aboOse;

}