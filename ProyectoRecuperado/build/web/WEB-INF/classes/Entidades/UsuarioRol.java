/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "usuario_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioRol.findAll", query = "SELECT u FROM UsuarioRol u")
    , @NamedQuery(name = "UsuarioRol.findByCodUsu", query = "SELECT u FROM UsuarioRol u WHERE u.codUsu = :codUsu")
    , @NamedQuery(name = "UsuarioRol.findByDocUsu", query = "SELECT u FROM UsuarioRol u WHERE u.docUsu = :docUsu")
    , @NamedQuery(name = "UsuarioRol.findByNomcUsu", query = "SELECT u FROM UsuarioRol u WHERE u.nomcUsu = :nomcUsu")
    , @NamedQuery(name = "UsuarioRol.findByCorUsu", query = "SELECT u FROM UsuarioRol u WHERE u.corUsu = :corUsu")
    , @NamedQuery(name = "UsuarioRol.findByConUsu", query = "SELECT u FROM UsuarioRol u WHERE u.conUsu = :conUsu")})
public class UsuarioRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_Usu")
    private Integer codUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Doc_Usu")
    private String docUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "nomc_usu")
    private String nomcUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Cor_Usu")
    private String corUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Con_Usu")
    private String conUsu;
    @JoinColumn(name = "Cod_Rol", referencedColumnName = "Cod_Rol")
    @ManyToOne(fetch = FetchType.EAGER)
    private Rol codRol;
    @OneToMany(mappedBy = "codUsu", fetch = FetchType.EAGER)
    private Collection<Cliente> clienteCollection;
    @OneToMany(mappedBy = "codUsu", fetch = FetchType.EAGER)
    private Collection<Empleado> empleadoCollection;

    public UsuarioRol() {
    }

    public UsuarioRol(Integer codUsu) {
        this.codUsu = codUsu;
    }

    public UsuarioRol(Integer codUsu, String docUsu, String nomcUsu, String corUsu, String conUsu) {
        this.codUsu = codUsu;
        this.docUsu = docUsu;
        this.nomcUsu = nomcUsu;
        this.corUsu = corUsu;
        this.conUsu = conUsu;
    }

    public Integer getCodUsu() {
        return codUsu;
    }

    public void setCodUsu(Integer codUsu) {
        this.codUsu = codUsu;
    }

    public String getDocUsu() {
        return docUsu;
    }

    public void setDocUsu(String docUsu) {
        this.docUsu = docUsu;
    }

    public String getNomcUsu() {
        return nomcUsu;
    }

    public void setNomcUsu(String nomcUsu) {
        this.nomcUsu = nomcUsu;
    }

    public String getCorUsu() {
        return corUsu;
    }

    public void setCorUsu(String corUsu) {
        this.corUsu = corUsu;
    }

    public String getConUsu() {
        return conUsu;
    }

    public void setConUsu(String conUsu) {
        this.conUsu = conUsu;
    }

    public Rol getCodRol() {
        return codRol;
    }

    public void setCodRol(Rol codRol) {
        this.codRol = codRol;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUsu != null ? codUsu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRol)) {
            return false;
        }
        UsuarioRol other = (UsuarioRol) object;
        if ((this.codUsu == null && other.codUsu != null) || (this.codUsu != null && !this.codUsu.equals(other.codUsu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.UsuarioRol[ codUsu=" + codUsu + " ]";
    }
    
}
