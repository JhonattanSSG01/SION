/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "orden_de_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenDeServicio.findAll", query = "SELECT o FROM OrdenDeServicio o")
    , @NamedQuery(name = "OrdenDeServicio.findByCodOse", query = "SELECT o FROM OrdenDeServicio o WHERE o.codOse = :codOse")
    , @NamedQuery(name = "OrdenDeServicio.findByFecOse", query = "SELECT o FROM OrdenDeServicio o WHERE o.fecOse = :fecOse")
    , @NamedQuery(name = "OrdenDeServicio.findByAboOse", query = "SELECT o FROM OrdenDeServicio o WHERE o.aboOse = :aboOse")
    , @NamedQuery(name = "OrdenDeServicio.findBySalOse", query = "SELECT o FROM OrdenDeServicio o WHERE o.salOse = :salOse")})
public class OrdenDeServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_Ose")
    private Integer codOse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fec_Ose")
    @Temporal(TemporalType.DATE)
    private Date fecOse;
    @Column(name = "abo_Ose")
    private Integer aboOse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sal_Ose")
    private int salOse;
    @OneToMany(mappedBy = "codOse", fetch = FetchType.EAGER)
    private Collection<DetalleProducto> detalleProductoCollection;
    @JoinColumn(name = "Cod_Eve", referencedColumnName = "Cod_Eve")
    @ManyToOne(fetch = FetchType.EAGER)
    private Evento codEve;

    public OrdenDeServicio() {
    }

    public OrdenDeServicio(Integer codOse) {
        this.codOse = codOse;
    }

    public OrdenDeServicio(Integer codOse, Date fecOse, int salOse) {
        this.codOse = codOse;
        this.fecOse = fecOse;
        this.salOse = salOse;
    }

    public Integer getCodOse() {
        return codOse;
    }

    public void setCodOse(Integer codOse) {
        this.codOse = codOse;
    }

    public Date getFecOse() {
        return fecOse;
    }

    public void setFecOse(Date fecOse) {
        this.fecOse = fecOse;
    }

    public Integer getAboOse() {
        return aboOse;
    }

    public void setAboOse(Integer aboOse) {
        this.aboOse = aboOse;
    }

    public int getSalOse() {
        return salOse;
    }

    public void setSalOse(int salOse) {
        this.salOse = salOse;
    }

    @XmlTransient
    public Collection<DetalleProducto> getDetalleProductoCollection() {
        return detalleProductoCollection;
    }

    public void setDetalleProductoCollection(Collection<DetalleProducto> detalleProductoCollection) {
        this.detalleProductoCollection = detalleProductoCollection;
    }

    public Evento getCodEve() {
        return codEve;
    }

    public void setCodEve(Evento codEve) {
        this.codEve = codEve;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codOse != null ? codOse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenDeServicio)) {
            return false;
        }
        OrdenDeServicio other = (OrdenDeServicio) object;
        if ((this.codOse == null && other.codOse != null) || (this.codOse != null && !this.codOse.equals(other.codOse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.OrdenDeServicio[ codOse=" + codOse + " ]";
    }
    
}
