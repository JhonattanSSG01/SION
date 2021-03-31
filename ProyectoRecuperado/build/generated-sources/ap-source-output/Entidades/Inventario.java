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
@Table(name = "inventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i")
    , @NamedQuery(name = "Inventario.findByCodInv", query = "SELECT i FROM Inventario i WHERE i.codInv = :codInv")
    , @NamedQuery(name = "Inventario.findByEncInv", query = "SELECT i FROM Inventario i WHERE i.encInv = :encInv")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_Inv")
    private Integer codInv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Enc_Inv")
    private String encInv;
    @OneToMany(mappedBy = "codInv", fetch = FetchType.EAGER)
    private Collection<DetalleInventario> detalleInventarioCollection;
    @JoinColumn(name = "Cod_Sto", referencedColumnName = "Cod_Sto")
    @ManyToOne(fetch = FetchType.EAGER)
    private Stock codSto;

    public Inventario() {
    }

    public Inventario(Integer codInv) {
        this.codInv = codInv;
    }

    public Inventario(Integer codInv, String encInv) {
        this.codInv = codInv;
        this.encInv = encInv;
    }

    public Integer getCodInv() {
        return codInv;
    }

    public void setCodInv(Integer codInv) {
        this.codInv = codInv;
    }

    public String getEncInv() {
        return encInv;
    }

    public void setEncInv(String encInv) {
        this.encInv = encInv;
    }

    @XmlTransient
    public Collection<DetalleInventario> getDetalleInventarioCollection() {
        return detalleInventarioCollection;
    }

    public void setDetalleInventarioCollection(Collection<DetalleInventario> detalleInventarioCollection) {
        this.detalleInventarioCollection = detalleInventarioCollection;
    }

    public Stock getCodSto() {
        return codSto;
    }

    public void setCodSto(Stock codSto) {
        this.codSto = codSto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codInv != null ? codInv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.codInv == null && other.codInv != null) || (this.codInv != null && !this.codInv.equals(other.codInv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Inventario[ codInv=" + codInv + " ]";
    }
    
}
