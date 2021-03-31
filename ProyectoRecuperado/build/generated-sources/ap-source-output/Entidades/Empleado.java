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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByCodEmp", query = "SELECT e FROM Empleado e WHERE e.codEmp = :codEmp")
    , @NamedQuery(name = "Empleado.findByTelEmp", query = "SELECT e FROM Empleado e WHERE e.telEmp = :telEmp")
    , @NamedQuery(name = "Empleado.findByDirEmp", query = "SELECT e FROM Empleado e WHERE e.dirEmp = :dirEmp")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_Emp")
    private Integer codEmp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Tel_Emp")
    private int telEmp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Dir_Emp")
    private String dirEmp;
    @JoinColumn(name = "cod_usu", referencedColumnName = "Cod_Usu")
    @ManyToOne(fetch = FetchType.EAGER)
    private UsuarioRol codUsu;
    @OneToMany(mappedBy = "codEmp", fetch = FetchType.EAGER)
    private Collection<DetalleTipoEvento> detalleTipoEventoCollection;

    public Empleado() {
    }

    public Empleado(Integer codEmp) {
        this.codEmp = codEmp;
    }

    public Empleado(Integer codEmp, int telEmp, String dirEmp) {
        this.codEmp = codEmp;
        this.telEmp = telEmp;
        this.dirEmp = dirEmp;
    }

    public Integer getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(Integer codEmp) {
        this.codEmp = codEmp;
    }

    public int getTelEmp() {
        return telEmp;
    }

    public void setTelEmp(int telEmp) {
        this.telEmp = telEmp;
    }

    public String getDirEmp() {
        return dirEmp;
    }

    public void setDirEmp(String dirEmp) {
        this.dirEmp = dirEmp;
    }

    public UsuarioRol getCodUsu() {
        return codUsu;
    }

    public void setCodUsu(UsuarioRol codUsu) {
        this.codUsu = codUsu;
    }

    @XmlTransient
    public Collection<DetalleTipoEvento> getDetalleTipoEventoCollection() {
        return detalleTipoEventoCollection;
    }

    public void setDetalleTipoEventoCollection(Collection<DetalleTipoEvento> detalleTipoEventoCollection) {
        this.detalleTipoEventoCollection = detalleTipoEventoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEmp != null ? codEmp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.codEmp == null && other.codEmp != null) || (this.codEmp != null && !this.codEmp.equals(other.codEmp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Empleado[ codEmp=" + codEmp + " ]";
    }
    
}
