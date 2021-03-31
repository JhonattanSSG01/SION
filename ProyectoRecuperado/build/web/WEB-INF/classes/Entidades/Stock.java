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
@Table(name = "stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s")
    , @NamedQuery(name = "Stock.findByCodSto", query = "SELECT s FROM Stock s WHERE s.codSto = :codSto")
    , @NamedQuery(name = "Stock.findByTipSto", query = "SELECT s FROM Stock s WHERE s.tipSto = :tipSto")
    , @NamedQuery(name = "Stock.findByCatpSto", query = "SELECT s FROM Stock s WHERE s.catpSto = :catpSto")
    , @NamedQuery(name = "Stock.findByCanSto", query = "SELECT s FROM Stock s WHERE s.canSto = :canSto")})
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_Sto")
    private Integer codSto;
    @Size(max = 30)
    @Column(name = "Tip_Sto")
    private String tipSto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "catp_Sto")
    private String catpSto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Can_Sto")
    private int canSto;
    @OneToMany(mappedBy = "codSto", fetch = FetchType.EAGER)
    private Collection<Inventario> inventarioCollection;

    public Stock() {
    }

    public Stock(Integer codSto) {
        this.codSto = codSto;
    }

    public Stock(Integer codSto, String catpSto, int canSto) {
        this.codSto = codSto;
        this.catpSto = catpSto;
        this.canSto = canSto;
    }

    public Integer getCodSto() {
        return codSto;
    }

    public void setCodSto(Integer codSto) {
        this.codSto = codSto;
    }

    public String getTipSto() {
        return tipSto;
    }

    public void setTipSto(String tipSto) {
        this.tipSto = tipSto;
    }

    public String getCatpSto() {
        return catpSto;
    }

    public void setCatpSto(String catpSto) {
        this.catpSto = catpSto;
    }

    public int getCanSto() {
        return canSto;
    }

    public void setCanSto(int canSto) {
        this.canSto = canSto;
    }

    @XmlTransient
    public Collection<Inventario> getInventarioCollection() {
        return inventarioCollection;
    }

    public void setInventarioCollection(Collection<Inventario> inventarioCollection) {
        this.inventarioCollection = inventarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSto != null ? codSto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.codSto == null && other.codSto != null) || (this.codSto != null && !this.codSto.equals(other.codSto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Stock[ codSto=" + codSto + " ]";
    }
    
}
