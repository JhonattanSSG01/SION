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
@Table(name = "detalle_individual")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleIndividual.findAll", query = "SELECT d FROM DetalleIndividual d")
    , @NamedQuery(name = "DetalleIndividual.findByCodDins", query = "SELECT d FROM DetalleIndividual d WHERE d.codDins = :codDins")})
public class DetalleIndividual implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_dins")
    private Integer codDins;
    @JoinColumn(name = "Cod_Pati", referencedColumnName = "Cod_Pati")
    @ManyToOne(fetch = FetchType.EAGER)
    private PaqueteTodoIncluido codPati;
    @JoinColumn(name = "Cod_Sei", referencedColumnName = "Cod_Sei")
    @ManyToOne(fetch = FetchType.EAGER)
    private ServicioIndividual codSei;

    public DetalleIndividual() {
    }

    public DetalleIndividual(Integer codDins) {
        this.codDins = codDins;
    }

    public Integer getCodDins() {
        return codDins;
    }

    public void setCodDins(Integer codDins) {
        this.codDins = codDins;
    }

    public PaqueteTodoIncluido getCodPati() {
        return codPati;
    }

    public void setCodPati(PaqueteTodoIncluido codPati) {
        this.codPati = codPati;
    }

    public ServicioIndividual getCodSei() {
        return codSei;
    }

    public void setCodSei(ServicioIndividual codSei) {
        this.codSei = codSei;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDins != null ? codDins.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleIndividual)) {
            return false;
        }
        DetalleIndividual other = (DetalleIndividual) object;
        if ((this.codDins == null && other.codDins != null) || (this.codDins != null && !this.codDins.equals(other.codDins))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DetalleIndividual[ codDins=" + codDins + " ]";
    }
    
}
