/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "detalle_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleProducto.findAll", query = "SELECT d FROM DetalleProducto d")
    , @NamedQuery(name = "DetalleProducto.findByCodDpro", query = "SELECT d FROM DetalleProducto d WHERE d.codDpro = :codDpro")})
public class DetalleProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_Dpro")
    private Integer codDpro;
    @JoinColumn(name = "Cod_Prod", referencedColumnName = "Cod_Prod")
    @ManyToOne(fetch = FetchType.EAGER)
    private ProductoMenaje codProd;
    @JoinColumn(name = "Cod_Ose", referencedColumnName = "Cod_Ose")
    @ManyToOne(fetch = FetchType.EAGER)
    private OrdenDeServicio codOse;

    public DetalleProducto() {
    }

    public DetalleProducto(Integer codDpro) {
        this.codDpro = codDpro;
    }

    public Integer getCodDpro() {
        return codDpro;
    }

    public void setCodDpro(Integer codDpro) {
        this.codDpro = codDpro;
    }

    public ProductoMenaje getCodProd() {
        return codProd;
    }

    public void setCodProd(ProductoMenaje codProd) {
        this.codProd = codProd;
    }

    public OrdenDeServicio getCodOse() {
        return codOse;
    }

    public void setCodOse(OrdenDeServicio codOse) {
        this.codOse = codOse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDpro != null ? codDpro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleProducto)) {
            return false;
        }
        DetalleProducto other = (DetalleProducto) object;
        if ((this.codDpro == null && other.codDpro != null) || (this.codDpro != null && !this.codDpro.equals(other.codDpro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DetalleProducto[ codDpro=" + codDpro + " ]";
    }
    
}
