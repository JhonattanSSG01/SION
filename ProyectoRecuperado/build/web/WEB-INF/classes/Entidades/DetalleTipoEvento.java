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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "detalle_tipo_evento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleTipoEvento.findAll", query = "SELECT d FROM DetalleTipoEvento d")
    , @NamedQuery(name = "DetalleTipoEvento.findByCodDee", query = "SELECT d FROM DetalleTipoEvento d WHERE d.codDee = :codDee")})
public class DetalleTipoEvento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_Dee")
    private Integer codDee;
    @OneToMany(mappedBy = "codDee", fetch = FetchType.EAGER)
    private Collection<Evento> eventoCollection;
    @JoinColumn(name = "Cod_Emp", referencedColumnName = "Cod_Emp")
    @ManyToOne(fetch = FetchType.EAGER)
    private Empleado codEmp;

    public DetalleTipoEvento() {
    }

    public DetalleTipoEvento(Integer codDee) {
        this.codDee = codDee;
    }

    public Integer getCodDee() {
        return codDee;
    }

    public void setCodDee(Integer codDee) {
        this.codDee = codDee;
    }

    @XmlTransient
    public Collection<Evento> getEventoCollection() {
        return eventoCollection;
    }

    public void setEventoCollection(Collection<Evento> eventoCollection) {
        this.eventoCollection = eventoCollection;
    }

    public Empleado getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(Empleado codEmp) {
        this.codEmp = codEmp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDee != null ? codDee.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleTipoEvento)) {
            return false;
        }
        DetalleTipoEvento other = (DetalleTipoEvento) object;
        if ((this.codDee == null && other.codDee != null) || (this.codDee != null && !this.codDee.equals(other.codDee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DetalleTipoEvento[ codDee=" + codDee + " ]";
    }
    
}
