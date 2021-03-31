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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByCodCli", query = "SELECT c FROM Cliente c WHERE c.codCli = :codCli")
    , @NamedQuery(name = "Cliente.findByTelCli", query = "SELECT c FROM Cliente c WHERE c.telCli = :telCli")
    , @NamedQuery(name = "Cliente.findByDirCli", query = "SELECT c FROM Cliente c WHERE c.dirCli = :dirCli")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cod_Cli")
    private Integer codCli;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Tel_Cli")
    private int telCli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Dir_Cli")
    private String dirCli;
    @JoinColumn(name = "Cod_Usu", referencedColumnName = "Cod_Usu")
    @ManyToOne(fetch = FetchType.EAGER)
    private UsuarioRol codUsu;
    @OneToMany(mappedBy = "codCli", fetch = FetchType.EAGER)
    private Collection<Evento> eventoCollection;

    public Cliente() {
    }

    public Cliente(Integer codCli) {
        this.codCli = codCli;
    }

    public Cliente(Integer codCli, int telCli, String dirCli) {
        this.codCli = codCli;
        this.telCli = telCli;
        this.dirCli = dirCli;
    }

    public Integer getCodCli() {
        return codCli;
    }

    public void setCodCli(Integer codCli) {
        this.codCli = codCli;
    }

    public int getTelCli() {
        return telCli;
    }

    public void setTelCli(int telCli) {
        this.telCli = telCli;
    }

    public String getDirCli() {
        return dirCli;
    }

    public void setDirCli(String dirCli) {
        this.dirCli = dirCli;
    }

    public UsuarioRol getCodUsu() {
        return codUsu;
    }

    public void setCodUsu(UsuarioRol codUsu) {
        this.codUsu = codUsu;
    }

    @XmlTransient
    public Collection<Evento> getEventoCollection() {
        return eventoCollection;
    }

    public void setEventoCollection(Collection<Evento> eventoCollection) {
        this.eventoCollection = eventoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCli != null ? codCli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.codCli == null && other.codCli != null) || (this.codCli != null && !this.codCli.equals(other.codCli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Cliente[ codCli=" + codCli + " ]";
    }
    
}
