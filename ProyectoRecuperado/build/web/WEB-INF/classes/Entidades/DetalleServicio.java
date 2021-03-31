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
@Table(name = "detalle_servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleServicio.findAll", query = "SELECT d FROM DetalleServicio d")
    , @NamedQuery(name = "DetalleServicio.findByCodDse", query = "SELECT d FROM DetalleServicio d WHERE d.codDse = :codDse")})
public class DetalleServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_Dse")
    private Integer codDse;
    @JoinColumn(name = "Cod_Sei", referencedColumnName = "Cod_Sei")
    @ManyToOne(fetch = FetchType.EAGER)
    private ServicioIndividual codSei;
    @JoinColumn(name = "cod_eve", referencedColumnName = "Cod_Eve")
    @ManyToOne(fetch = FetchType.EAGER)
    private Evento codEve;

    public DetalleServicio() {
    }

    public DetalleServicio(Integer codDse) {
        this.codDse = codDse;
    }

    public Integer getCodDse() {
        return codDse;
    }

    public void setCodDse(Integer codDse) {
        this.codDse = codDse;
    }

    public ServicioIndividual getCodSei() {
        return codSei;
    }

    public void setCodSei(ServicioIndividual codSei) {
        this.codSei = codSei;
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
        hash += (codDse != null ? codDse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleServicio)) {
            return false;
        }
        DetalleServicio other = (DetalleServicio) object;
        if ((this.codDse == null && other.codDse != null) || (this.codDse != null && !this.codDse.equals(other.codDse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DetalleServicio[ codDse=" + codDse + " ]";
    }
    
}
