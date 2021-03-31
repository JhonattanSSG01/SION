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
@Table(name = "servicio_individual")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicioIndividual.findAll", query = "SELECT s FROM ServicioIndividual s")
    , @NamedQuery(name = "ServicioIndividual.findByCodSei", query = "SELECT s FROM ServicioIndividual s WHERE s.codSei = :codSei")
    , @NamedQuery(name = "ServicioIndividual.findByNomSei", query = "SELECT s FROM ServicioIndividual s WHERE s.nomSei = :nomSei")
    , @NamedQuery(name = "ServicioIndividual.findByValSei", query = "SELECT s FROM ServicioIndividual s WHERE s.valSei = :valSei")})
public class ServicioIndividual implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_Sei")
    private Integer codSei;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Nom_Sei")
    private String nomSei;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Des_Sei")
    private String desSei;
    @Basic(optional = false)
    @NotNull
    @Column(name = "val_sei")
    private int valSei;
    @OneToMany(mappedBy = "codSei", fetch = FetchType.EAGER)
    private Collection<DetalleIndividual> detalleIndividualCollection;
    @OneToMany(mappedBy = "codSei", fetch = FetchType.EAGER)
    private Collection<DetalleServicio> detalleServicioCollection;

    public ServicioIndividual() {
    }

    public ServicioIndividual(Integer codSei) {
        this.codSei = codSei;
    }

    public ServicioIndividual(Integer codSei, String nomSei, String desSei, int valSei) {
        this.codSei = codSei;
        this.nomSei = nomSei;
        this.desSei = desSei;
        this.valSei = valSei;
    }

    public Integer getCodSei() {
        return codSei;
    }

    public void setCodSei(Integer codSei) {
        this.codSei = codSei;
    }

    public String getNomSei() {
        return nomSei;
    }

    public void setNomSei(String nomSei) {
        this.nomSei = nomSei;
    }

    public String getDesSei() {
        return desSei;
    }

    public void setDesSei(String desSei) {
        this.desSei = desSei;
    }

    public int getValSei() {
        return valSei;
    }

    public void setValSei(int valSei) {
        this.valSei = valSei;
    }

    @XmlTransient
    public Collection<DetalleIndividual> getDetalleIndividualCollection() {
        return detalleIndividualCollection;
    }

    public void setDetalleIndividualCollection(Collection<DetalleIndividual> detalleIndividualCollection) {
        this.detalleIndividualCollection = detalleIndividualCollection;
    }

    @XmlTransient
    public Collection<DetalleServicio> getDetalleServicioCollection() {
        return detalleServicioCollection;
    }

    public void setDetalleServicioCollection(Collection<DetalleServicio> detalleServicioCollection) {
        this.detalleServicioCollection = detalleServicioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSei != null ? codSei.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicioIndividual)) {
            return false;
        }
        ServicioIndividual other = (ServicioIndividual) object;
        if ((this.codSei == null && other.codSei != null) || (this.codSei != null && !this.codSei.equals(other.codSei))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ServicioIndividual[ codSei=" + codSei + " ]";
    }
    
}
