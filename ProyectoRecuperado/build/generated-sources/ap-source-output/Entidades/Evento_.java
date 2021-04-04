package Entidades;

import Entidades.Cliente;
import Entidades.DetallePaquete;
import Entidades.DetalleServicio;
import Entidades.DetalleTipoEvento;
import Entidades.OrdenDeServicio;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-04T16:04:43")
@StaticMetamodel(Evento.class)
public class Evento_ { 

    public static volatile SingularAttribute<Evento, Date> horEve;
    public static volatile CollectionAttribute<Evento, OrdenDeServicio> ordenDeServicioCollection;
    public static volatile SingularAttribute<Evento, Integer> invEve;
    public static volatile SingularAttribute<Evento, Cliente> codCli;
    public static volatile SingularAttribute<Evento, String> tipEve;
    public static volatile SingularAttribute<Evento, Integer> codEve;
    public static volatile SingularAttribute<Evento, DetalleTipoEvento> codDee;
    public static volatile SingularAttribute<Evento, Date> fecEve;
    public static volatile CollectionAttribute<Evento, DetalleServicio> detalleServicioCollection;
    public static volatile CollectionAttribute<Evento, DetallePaquete> detallePaqueteCollection;

}