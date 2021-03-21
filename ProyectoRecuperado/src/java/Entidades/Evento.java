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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e")
    , @NamedQuery(name = "Evento.findByCodEve", query = "SELECT e FROM Evento e WHERE e.codEve = :codEve")
    , @NamedQuery(name = "Evento.findByFecEve", query = "SELECT e FROM Evento e WHERE e.fecEve = :fecEve")
    , @NamedQuery(name = "Evento.findByHorEve", query = "SELECT e FROM Evento e WHERE e.horEve = :horEve")
    , @NamedQuery(name = "Evento.findByTipEve", query = "SELECT e FROM Evento e WHERE e.tipEve = :tipEve")
    , @NamedQuery(name = "Evento.findByInvEve", query = "SELECT e FROM Evento e WHERE e.invEve = :invEve")})
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_Eve")
    private Integer codEve;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_eve")
    @Temporal(TemporalType.DATE)
    private Date fecEve;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hor_eve")
    @Temporal(TemporalType.TIME)
    private Date horEve;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "tip_eve")
    private String tipEve;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inv_eve")
    private int invEve;
    @OneToMany(mappedBy = "codEve", fetch = FetchType.EAGER)
    private Collection<DetallePaquete> detallePaqueteCollection;
    @OneToMany(mappedBy = "codEve", fetch = FetchType.EAGER)
    private Collection<OrdenDeServicio> ordenDeServicioCollection;
    @OneToMany(mappedBy = "codEve", fetch = FetchType.EAGER)
    private Collection<DetalleServicio> detalleServicioCollection;
    @JoinColumn(name = "Cod_Cli", referencedColumnName = "Cod_Cli")
    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente codCli;
    @JoinColumn(name = "Cod_Dee", referencedColumnName = "Cod_Dee")
    @ManyToOne(fetch = FetchType.EAGER)
    private DetalleTipoEvento codDee;

    public Evento() {
    }

    public Evento(Integer codEve) {
        this.codEve = codEve;
    }

    public Evento(Integer codEve, Date fecEve, Date horEve, String tipEve, int invEve) {
        this.codEve = codEve;
        this.fecEve = fecEve;
        this.horEve = horEve;
        this.tipEve = tipEve;
        this.invEve = invEve;
    }

    public Integer getCodEve() {
        return codEve;
    }

    public void setCodEve(Integer codEve) {
        this.codEve = codEve;
    }

    public Date getFecEve() {
        return fecEve;
    }

    public void setFecEve(Date fecEve) {
        this.fecEve = fecEve;
    }

    public Date getHorEve() {
        return horEve;
    }

    public void setHorEve(Date horEve) {
        this.horEve = horEve;
    }

    public String getTipEve() {
        return tipEve;
    }

    public void setTipEve(String tipEve) {
        this.tipEve = tipEve;
    }

    public int getInvEve() {
        return invEve;
    }

    public void setInvEve(int invEve) {
        this.invEve = invEve;
    }

    @XmlTransient
    public Collection<DetallePaquete> getDetallePaqueteCollection() {
        return detallePaqueteCollection;
    }

    public void setDetallePaqueteCollection(Collection<DetallePaquete> detallePaqueteCollection) {
        this.detallePaqueteCollection = detallePaqueteCollection;
    }

    @XmlTransient
    public Collection<OrdenDeServicio> getOrdenDeServicioCollection() {
        return ordenDeServicioCollection;
    }

    public void setOrdenDeServicioCollection(Collection<OrdenDeServicio> ordenDeServicioCollection) {
        this.ordenDeServicioCollection = ordenDeServicioCollection;
    }

    @XmlTransient
    public Collection<DetalleServicio> getDetalleServicioCollection() {
        return detalleServicioCollection;
    }

    public void setDetalleServicioCollection(Collection<DetalleServicio> detalleServicioCollection) {
        this.detalleServicioCollection = detalleServicioCollection;
    }

    public Cliente getCodCli() {
        return codCli;
    }

    public void setCodCli(Cliente codCli) {
        this.codCli = codCli;
    }

    public DetalleTipoEvento getCodDee() {
        return codDee;
    }

    public void setCodDee(DetalleTipoEvento codDee) {
        this.codDee = codDee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEve != null ? codEve.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.codEve == null && other.codEve != null) || (this.codEve != null && !this.codEve.equals(other.codEve))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Evento[ codEve=" + codEve + " ]";
    }
    
}
