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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "permiso_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermisoRol.findAll", query = "SELECT p FROM PermisoRol p")
    , @NamedQuery(name = "PermisoRol.findByCodPer", query = "SELECT p FROM PermisoRol p WHERE p.codPer = :codPer")
    , @NamedQuery(name = "PermisoRol.findByNomforPer", query = "SELECT p FROM PermisoRol p WHERE p.nomforPer = :nomforPer")
    , @NamedQuery(name = "PermisoRol.findByUrlper", query = "SELECT p FROM PermisoRol p WHERE p.urlper = :urlper")
    , @NamedQuery(name = "PermisoRol.findByIcoper", query = "SELECT p FROM PermisoRol p WHERE p.icoper = :icoper")
    , @NamedQuery(name = "PermisoRol.findByPadPer", query = "SELECT p FROM PermisoRol p WHERE p.padPer = :padPer")})
public class PermisoRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_Per")
    private Integer codPer;
    @Size(max = 25)
    @Column(name = "nomfor_per")
    private String nomforPer;
    @Size(max = 80)
    @Column(name = "Url_per")
    private String urlper;
    @Size(max = 45)
    @Column(name = "Ico_per")
    private String icoper;
    @Column(name = "pad_per")
    private Integer padPer;
    @OneToMany(mappedBy = "codPer", fetch = FetchType.EAGER)
    private Collection<DetallePermisoRol> detallePermisoRolCollection;

    public PermisoRol() {
    }

    public PermisoRol(Integer codPer) {
        this.codPer = codPer;
    }

    public Integer getCodPer() {
        return codPer;
    }

    public void setCodPer(Integer codPer) {
        this.codPer = codPer;
    }

    public String getNomforPer() {
        return nomforPer;
    }

    public void setNomforPer(String nomforPer) {
        this.nomforPer = nomforPer;
    }

    public String getUrlper() {
        return urlper;
    }

    public void setUrlper(String urlper) {
        this.urlper = urlper;
    }

    public String getIcoper() {
        return icoper;
    }

    public void setIcoper(String icoper) {
        this.icoper = icoper;
    }

    public Integer getPadPer() {
        return padPer;
    }

    public void setPadPer(Integer padPer) {
        this.padPer = padPer;
    }

    @XmlTransient
    public Collection<DetallePermisoRol> getDetallePermisoRolCollection() {
        return detallePermisoRolCollection;
    }

    public void setDetallePermisoRolCollection(Collection<DetallePermisoRol> detallePermisoRolCollection) {
        this.detallePermisoRolCollection = detallePermisoRolCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPer != null ? codPer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermisoRol)) {
            return false;
        }
        PermisoRol other = (PermisoRol) object;
        if ((this.codPer == null && other.codPer != null) || (this.codPer != null && !this.codPer.equals(other.codPer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PermisoRol[ codPer=" + codPer + " ]";
    }
    
}
