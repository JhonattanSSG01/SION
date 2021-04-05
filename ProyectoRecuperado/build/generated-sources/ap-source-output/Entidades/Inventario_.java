package Entidades;

import Entidades.DetalleInventario;
import Entidades.Stock;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-05T14:25:28")
@StaticMetamodel(Inventario.class)
public class Inventario_ { 

    public static volatile SingularAttribute<Inventario, String> encInv;
    public static volatile SingularAttribute<Inventario, Integer> codInv;
    public static volatile SingularAttribute<Inventario, Stock> codSto;
    public static volatile CollectionAttribute<Inventario, DetalleInventario> detalleInventarioCollection;

}