/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "producto_menaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoMenaje.findAll", query = "SELECT p FROM ProductoMenaje p")
    , @NamedQuery(name = "ProductoMenaje.findByCodProd", query = "SELECT p FROM ProductoMenaje p WHERE p.codProd = :codProd")
    , @NamedQuery(name = "ProductoMenaje.findByNomProd", query = "SELECT p FROM ProductoMenaje p WHERE p.nomProd = :nomProd")
    , @NamedQuery(name = "ProductoMenaje.findByValProd", query = "SELECT p FROM ProductoMenaje p WHERE p.valProd = :valProd")})
public class ProductoMenaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_Prod")
    private Integer codProd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "nom_prod")
    private String nomProd;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "val_prod")
    private BigDecimal valProd;
    @OneToMany(mappedBy = "codProd", fetch = FetchType.EAGER)
    private Collection<DetalleProducto> detalleProductoCollection;
    @OneToMany(mappedBy = "codProd", fetch = FetchType.EAGER)
    private Collection<DetalleInventario> detalleInventarioCollection;
    @JoinColumn(name = "Cod_Pro", referencedColumnName = "Cod_Pro")
    @ManyToOne(fetch = FetchType.EAGER)
    private Proveedor codPro;

    public ProductoMenaje() {
    }

    public ProductoMenaje(Integer codProd) {
        this.codProd = codProd;
    }

    public ProductoMenaje(Integer codProd, String nomProd, BigDecimal valProd) {
        this.codProd = codProd;
        this.nomProd = nomProd;
        this.valProd = valProd;
    }

    public Integer getCodProd() {
        return codProd;
    }

    public void setCodProd(Integer codProd) {
        this.codProd = codProd;
    }

    public String getNomProd() {
        return nomProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public BigDecimal getValProd() {
        return valProd;
    }

    public void setValProd(BigDecimal valProd) {
        this.valProd = valProd;
    }

    @XmlTransient
    public Collection<DetalleProducto> getDetalleProductoCollection() {
        return detalleProductoCollection;
    }

    public void setDetalleProductoCollection(Collection<DetalleProducto> detalleProductoCollection) {
        this.detalleProductoCollection = detalleProductoCollection;
    }

    @XmlTransient
    public Collection<DetalleInventario> getDetalleInventarioCollection() {
        return detalleInventarioCollection;
    }

    public void setDetalleInventarioCollection(Collection<DetalleInventario> detalleInventarioCollection) {
        this.detalleInventarioCollection = detalleInventarioCollection;
    }

    public Proveedor getCodPro() {
        return codPro;
    }

    public void setCodPro(Proveedor codPro) {
        this.codPro = codPro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProd != null ? codProd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoMenaje)) {
            return false;
        }
        ProductoMenaje other = (ProductoMenaje) object;
        if ((this.codProd == null && other.codProd != null) || (this.codProd != null && !this.codProd.equals(other.codProd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ProductoMenaje[ codProd=" + codProd + " ]";
    }
    
}
