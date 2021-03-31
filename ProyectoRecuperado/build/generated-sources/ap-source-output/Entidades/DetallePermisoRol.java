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
@Table(name = "detalle_permiso_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallePermisoRol.findAll", query = "SELECT d FROM DetallePermisoRol d")
    , @NamedQuery(name = "DetallePermisoRol.findByCodDprol", query = "SELECT d FROM DetallePermisoRol d WHERE d.codDprol = :codDprol")})
public class DetallePermisoRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_Dprol")
    private Integer codDprol;
    @JoinColumn(name = "Cod_Rol", referencedColumnName = "Cod_Rol")
    @ManyToOne(fetch = FetchType.EAGER)
    private Rol codRol;
    @JoinColumn(name = "Cod_Per", referencedColumnName = "Cod_Per")
    @ManyToOne(fetch = FetchType.EAGER)
    private PermisoRol codPer;

    public DetallePermisoRol() {
    }

    public DetallePermisoRol(Integer codDprol) {
        this.codDprol = codDprol;
    }

    public Integer getCodDprol() {
        return codDprol;
    }

    public void setCodDprol(Integer codDprol) {
        this.codDprol = codDprol;
    }

    public Rol getCodRol() {
        return codRol;
    }

    public void setCodRol(Rol codRol) {
        this.codRol = codRol;
    }

    public PermisoRol getCodPer() {
        return codPer;
    }

    public void setCodPer(PermisoRol codPer) {
        this.codPer = codPer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDprol != null ? codDprol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePermisoRol)) {
            return false;
        }
        DetallePermisoRol other = (DetallePermisoRol) object;
        if ((this.codDprol == null && other.codDprol != null) || (this.codDprol != null && !this.codDprol.equals(other.codDprol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DetallePermisoRol[ codDprol=" + codDprol + " ]";
    }
    
}
