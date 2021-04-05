package Entidades;

import Entidades.DetalleInventario;
import Entidades.DetalleProducto;
import Entidades.Proveedor;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-04T22:30:03")
@StaticMetamodel(ProductoMenaje.class)
public class ProductoMenaje_ { 

    public static volatile SingularAttribute<ProductoMenaje, Integer> codProd;
    public static volatile SingularAttribute<ProductoMenaje, BigDecimal> valProd;
    public static volatile CollectionAttribute<ProductoMenaje, DetalleProducto> detalleProductoCollection;
    public static volatile CollectionAttribute<ProductoMenaje, DetalleInventario> detalleInventarioCollection;
    public static volatile SingularAttribute<ProductoMenaje, String> nomProd;
    public static volatile SingularAttribute<ProductoMenaje, Proveedor> codPro;

}