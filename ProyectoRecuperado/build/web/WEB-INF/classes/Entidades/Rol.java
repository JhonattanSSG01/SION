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
import javax.persistence.Lob;
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
@Table(name = "rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
    , @NamedQuery(name = "Rol.findByCodRol", query = "SELECT r FROM Rol r WHERE r.codRol = :codRol")
    , @NamedQuery(name = "Rol.findByNomRol", query = "SELECT r FROM Rol r WHERE r.nomRol = :nomRol")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_Rol")
    private Integer codRol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Nom_Rol")
    private String nomRol;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Des_Rol")
    private String desRol;
    @OneToMany(mappedBy = "codRol", fetch = FetchType.EAGER)
    private Collection<UsuarioRol> usuarioRolCollection;
    @OneToMany(mappedBy = "codRol", fetch = FetchType.EAGER)
    private Collection<DetallePermisoRol> detallePermisoRolCollection;

    public Rol() {
    }

    public Rol(Integer codRol) {
        this.codRol = codRol;
    }

    public Rol(Integer codRol, String nomRol, String desRol) {
        this.codRol = codRol;
        this.nomRol = nomRol;
        this.desRol = desRol;
    }

    public Integer getCodRol() {
        return codRol;
    }

    public void setCodRol(Integer codRol) {
        this.codRol = codRol;
    }

    public String getNomRol() {
        return nomRol;
    }

    public void setNomRol(String nomRol) {
        this.nomRol = nomRol;
    }

    public String getDesRol() {
        return desRol;
    }

    public void setDesRol(String desRol) {
        this.desRol = desRol;
    }

    @XmlTransient
    public Collection<UsuarioRol> getUsuarioRolCollection() {
        return usuarioRolCollection;
    }

    public void setUsuarioRolCollection(Collection<UsuarioRol> usuarioRolCollection) {
        this.usuarioRolCollection = usuarioRolCollection;
    }

    @XmlTransient
    public Collection<DetallePermisoRol> getDetallePermisoRolCollection() {
        return detallePermisoRolCollection;
    }

    public void setDetallePermisoRolCollection(Collection<DetallePermisoRol> detallePermisoRolCollection) {
        this.detallePermisoRolCollection = detallePermisoRolCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRol != null ? codRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.codRol == null && other.codRol != null) || (this.codRol != null && !this.codRol.equals(other.codRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Rol[ codRol=" + codRol + " ]";
    }
    
}
