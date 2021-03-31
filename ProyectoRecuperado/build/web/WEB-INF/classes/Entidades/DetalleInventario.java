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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "detalle_inventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleInventario.findAll", query = "SELECT d FROM DetalleInventario d")
    , @NamedQuery(name = "DetalleInventario.findByCodDin", query = "SELECT d FROM DetalleInventario d WHERE d.codDin = :codDin")
    , @NamedQuery(name = "DetalleInventario.findByCapDin", query = "SELECT d FROM DetalleInventario d WHERE d.capDin = :capDin")
    , @NamedQuery(name = "DetalleInventario.findByCatpDin", query = "SELECT d FROM DetalleInventario d WHERE d.catpDin = :catpDin")
    , @NamedQuery(name = "DetalleInventario.findByTippDin", query = "SELECT d FROM DetalleInventario d WHERE d.tippDin = :tippDin")})
public class DetalleInventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_Din")
    private Integer codDin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cap_Din")
    private int capDin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "catp_din")
    private String catpDin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "tipp_din")
    private String tippDin;
    @JoinColumn(name = "Cod_Inv", referencedColumnName = "Cod_Inv")
    @ManyToOne(fetch = FetchType.EAGER)
    private Inventario codInv;
    @JoinColumn(name = "Cod_Prod", referencedColumnName = "Cod_Prod")
    @ManyToOne(fetch = FetchType.EAGER)
    private ProductoMenaje codProd;

    public DetalleInventario() {
    }

    public DetalleInventario(Integer codDin) {
        this.codDin = codDin;
    }

    public DetalleInventario(Integer codDin, int capDin, String catpDin, String tippDin) {
        this.codDin = codDin;
        this.capDin = capDin;
        this.catpDin = catpDin;
        this.tippDin = tippDin;
    }

    public Integer getCodDin() {
        return codDin;
    }

    public void setCodDin(Integer codDin) {
        this.codDin = codDin;
    }

    public int getCapDin() {
        return capDin;
    }

    public void setCapDin(int capDin) {
        this.capDin = capDin;
    }

    public String getCatpDin() {
        return catpDin;
    }

    public void setCatpDin(String catpDin) {
        this.catpDin = catpDin;
    }

    public String getTippDin() {
        return tippDin;
    }

    public void setTippDin(String tippDin) {
        this.tippDin = tippDin;
    }

    public Inventario getCodInv() {
        return codInv;
    }

    public void setCodInv(Inventario codInv) {
        this.codInv = codInv;
    }

    public ProductoMenaje getCodProd() {
        return codProd;
    }

    public void setCodProd(ProductoMenaje codProd) {
        this.codProd = codProd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDin != null ? codDin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleInventario)) {
            return false;
        }
        DetalleInventario other = (DetalleInventario) object;
        if ((this.codDin == null && other.codDin != null) || (this.codDin != null && !this.codDin.equals(other.codDin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DetalleInventario[ codDin=" + codDin + " ]";
    }
    
}
