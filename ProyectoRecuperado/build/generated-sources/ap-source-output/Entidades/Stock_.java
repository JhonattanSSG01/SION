package Entidades;

import Entidades.Inventario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-04T01:18:59")
@StaticMetamodel(Stock.class)
public class Stock_ { 

    public static volatile SingularAttribute<Stock, String> catpSto;
    public static volatile SingularAttribute<Stock, Integer> canSto;
    public static volatile SingularAttribute<Stock, Integer> codSto;
    public static volatile CollectionAttribute<Stock, Inventario> inventarioCollection;
    public static volatile SingularAttribute<Stock, String> tipSto;

}