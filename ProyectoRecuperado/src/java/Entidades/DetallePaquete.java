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
@Table(name = "detalle_paquete")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallePaquete.findAll", query = "SELECT d FROM DetallePaquete d")
    , @NamedQuery(name = "DetallePaquete.findByCodDpati", query = "SELECT d FROM DetallePaquete d WHERE d.codDpati = :codDpati")})
public class DetallePaquete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_dpati")
    private Integer codDpati;
    @JoinColumn(name = "cod_eve", referencedColumnName = "Cod_Eve")
    @ManyToOne(fetch = FetchType.EAGER)
    private Evento codEve;
    @JoinColumn(name = "Cod_Pati", referencedColumnName = "Cod_Pati")
    @ManyToOne(fetch = FetchType.EAGER)
    private PaqueteTodoIncluido codPati;

    public DetallePaquete() {
    }

    public DetallePaquete(Integer codDpati) {
        this.codDpati = codDpati;
    }

    public Integer getCodDpati() {
        return codDpati;
    }

    public void setCodDpati(Integer codDpati) {
        this.codDpati = codDpati;
    }

    public Evento getCodEve() {
        return codEve;
    }

    public void setCodEve(Evento codEve) {
        this.codEve = codEve;
    }

    public PaqueteTodoIncluido getCodPati() {
        return codPati;
    }

    public void setCodPati(PaqueteTodoIncluido codPati) {
        this.codPati = codPati;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDpati != null ? codDpati.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePaquete)) {
            return false;
        }
        DetallePaquete other = (DetallePaquete) object;
        if ((this.codDpati == null && other.codDpati != null) || (this.codDpati != null && !this.codDpati.equals(other.codDpati))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DetallePaquete[ codDpati=" + codDpati + " ]";
    }
    
}
