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
@Table(name = "proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")
    , @NamedQuery(name = "Proveedor.findByCodPro", query = "SELECT p FROM Proveedor p WHERE p.codPro = :codPro")
    , @NamedQuery(name = "Proveedor.findByNomPro", query = "SELECT p FROM Proveedor p WHERE p.nomPro = :nomPro")
    , @NamedQuery(name = "Proveedor.findByTelPro", query = "SELECT p FROM Proveedor p WHERE p.telPro = :telPro")
    , @NamedQuery(name = "Proveedor.findByDirPro", query = "SELECT p FROM Proveedor p WHERE p.dirPro = :dirPro")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_Pro")
    private Integer codPro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Nom_Pro")
    private String nomPro;
    @Column(name = "Tel_Pro")
    private Integer telPro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Dir_Pro")
    private String dirPro;
    @OneToMany(mappedBy = "codPro", fetch = FetchType.EAGER)
    private Collection<ProductoMenaje> productoMenajeCollection;

    public Proveedor() {
    }

    public Proveedor(Integer codPro) {
        this.codPro = codPro;
    }

    public Proveedor(Integer codPro, String nomPro, String dirPro) {
        this.codPro = codPro;
        this.nomPro = nomPro;
        this.dirPro = dirPro;
    }

    public Integer getCodPro() {
        return codPro;
    }

    public void setCodPro(Integer codPro) {
        this.codPro = codPro;
    }

    public String getNomPro() {
        return nomPro;
    }

    public void setNomPro(String nomPro) {
        this.nomPro = nomPro;
    }

    public Integer getTelPro() {
        return telPro;
    }

    public void setTelPro(Integer telPro) {
        this.telPro = telPro;
    }

    public String getDirPro() {
        return dirPro;
    }

    public void setDirPro(String dirPro) {
        this.dirPro = dirPro;
    }

    @XmlTransient
    public Collection<ProductoMenaje> getProductoMenajeCollection() {
        return productoMenajeCollection;
    }

    public void setProductoMenajeCollection(Collection<ProductoMenaje> productoMenajeCollection) {
        this.productoMenajeCollection = productoMenajeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPro != null ? codPro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.codPro == null && other.codPro != null) || (this.codPro != null && !this.codPro.equals(other.codPro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Proveedor[ codPro=" + codPro + " ]";
    }
    
}
