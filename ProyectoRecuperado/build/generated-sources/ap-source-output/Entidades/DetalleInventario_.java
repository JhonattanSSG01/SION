package Entidades;

import Entidades.Inventario;
import Entidades.ProductoMenaje;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-20T16:27:24")
@StaticMetamodel(DetalleInventario.class)
public class DetalleInventario_ { 

    public static volatile SingularAttribute<DetalleInventario, Inventario> codInv;
    public static volatile SingularAttribute<DetalleInventario, ProductoMenaje> codProd;
    public static volatile SingularAttribute<DetalleInventario, String> tippDin;
    public static volatile SingularAttribute<DetalleInventario, String> catpDin;
    public static volatile SingularAttribute<DetalleInventario, Integer> codDin;
    public static volatile SingularAttribute<DetalleInventario, Integer> capDin;

}