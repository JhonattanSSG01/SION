package Entidades;

import Entidades.ProductoMenaje;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-20T16:27:24")
@StaticMetamodel(Proveedor.class)
public class Proveedor_ { 

    public static volatile SingularAttribute<Proveedor, Integer> telPro;
    public static volatile SingularAttribute<Proveedor, String> dirPro;
    public static volatile CollectionAttribute<Proveedor, ProductoMenaje> productoMenajeCollection;
    public static volatile SingularAttribute<Proveedor, String> nomPro;
    public static volatile SingularAttribute<Proveedor, Integer> codPro;

}