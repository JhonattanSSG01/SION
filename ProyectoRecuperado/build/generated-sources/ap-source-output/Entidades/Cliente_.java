package Entidades;

import Entidades.Evento;
import Entidades.UsuarioRol;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-05T14:25:28")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Integer> codCli;
    public static volatile SingularAttribute<Cliente, String> dirCli;
    public static volatile SingularAttribute<Cliente, UsuarioRol> codUsu;
    public static volatile SingularAttribute<Cliente, Integer> telCli;
    public static volatile CollectionAttribute<Cliente, Evento> eventoCollection;

}