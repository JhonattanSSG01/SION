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
import javax.persistence.Lob;
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
@Table(name = "paquete_todo_incluido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaqueteTodoIncluido.findAll", query = "SELECT p FROM PaqueteTodoIncluido p")
    , @NamedQuery(name = "PaqueteTodoIncluido.findByCodPati", query = "SELECT p FROM PaqueteTodoIncluido p WHERE p.codPati = :codPati")
    , @NamedQuery(name = "PaqueteTodoIncluido.findByNomPati", query = "SELECT p FROM PaqueteTodoIncluido p WHERE p.nomPati = :nomPati")
    , @NamedQuery(name = "PaqueteTodoIncluido.findByValPati", query = "SELECT p FROM PaqueteTodoIncluido p WHERE p.valPati = :valPati")})
public class PaqueteTodoIncluido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_Pati")
    private Integer codPati;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Nom_Pati")
    private String nomPati;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Des_pati")
    private String despati;
    @Basic(optional = false)
    @NotNull
    @Column(name = "val_pati")
    private int valPati;
    @OneToMany(mappedBy = "codPati", fetch = FetchType.EAGER)
    private Collection<DetallePaquete> detallePaqueteCollection;
    @OneToMany(mappedBy = "codPati", fetch = FetchType.EAGER)
    private Collection<DetalleIndividual> detalleIndividualCollection;

    public PaqueteTodoIncluido() {
    }

    public PaqueteTodoIncluido(Integer codPati) {
        this.codPati = codPati;
    }

    public PaqueteTodoIncluido(Integer codPati, String nomPati, String despati, int valPati) {
        this.codPati = codPati;
        this.nomPati = nomPati;
        this.despati = despati;
        this.valPati = valPati;
    }

    public Integer getCodPati() {
        return codPati;
    }

    public void setCodPati(Integer codPati) {
        this.codPati = codPati;
    }

    public String getNomPati() {
        return nomPati;
    }

    public void setNomPati(String nomPati) {
        this.nomPati = nomPati;
    }

    public String getDespati() {
        return despati;
    }

    public void setDespati(String despati) {
        this.despati = despati;
    }

    public int getValPati() {
        return valPati;
    }

    public void setValPati(int valPati) {
        this.valPati = valPati;
    }

    @XmlTransient
    public Collection<DetallePaquete> getDetallePaqueteCollection() {
        return detallePaqueteCollection;
    }

    public void setDetallePaqueteCollection(Collection<DetallePaquete> detallePaqueteCollection) {
        this.detallePaqueteCollection = detallePaqueteCollection;
    }

    @XmlTransient
    public Collection<DetalleIndividual> getDetalleIndividualCollection() {
        return detalleIndividualCollection;
    }

    public void setDetalleIndividualCollection(Collection<DetalleIndividual> detalleIndividualCollection) {
        this.detalleIndividualCollection = detalleIndividualCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPati != null ? codPati.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaqueteTodoIncluido)) {
            return false;
        }
        PaqueteTodoIncluido other = (PaqueteTodoIncluido) object;
        if ((this.codPati == null && other.codPati != null) || (this.codPati != null && !this.codPati.equals(other.codPati))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PaqueteTodoIncluido[ codPati=" + codPati + " ]";
    }
    
}
