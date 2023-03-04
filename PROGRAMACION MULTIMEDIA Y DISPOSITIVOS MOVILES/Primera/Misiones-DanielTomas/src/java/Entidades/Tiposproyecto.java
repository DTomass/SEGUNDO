/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author danie
 */
@Entity
@Table(name = "tiposproyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiposproyecto.findAll", query = "SELECT t FROM Tiposproyecto t")
    , @NamedQuery(name = "Tiposproyecto.findByCodTipo", query = "SELECT t FROM Tiposproyecto t WHERE t.codTipo = :codTipo")
    , @NamedQuery(name = "Tiposproyecto.findByNomTipo", query = "SELECT t FROM Tiposproyecto t WHERE t.nomTipo = :nomTipo")
    , @NamedQuery(name = "Tiposproyecto.findByNomTipoing", query = "SELECT t FROM Tiposproyecto t WHERE t.nomTipoing = :nomTipoing")})
public class Tiposproyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_tipo")
    private Short codTipo;
    @Size(max = 100)
    @Column(name = "nom_tipo")
    private String nomTipo;
    @Size(max = 100)
    @Column(name = "nom_tipoing")
    private String nomTipoing;
    @OneToMany(mappedBy = "tipoProyecto")
    private List<Proyectos> proyectosList;

    public Tiposproyecto() {
    }

    public Tiposproyecto(Short codTipo) {
        this.codTipo = codTipo;
    }

    public Short getCodTipo() {
        return codTipo;
    }

    public void setCodTipo(Short codTipo) {
        this.codTipo = codTipo;
    }

    public String getNomTipo() {
        return nomTipo;
    }

    public void setNomTipo(String nomTipo) {
        this.nomTipo = nomTipo;
    }

    public String getNomTipoing() {
        return nomTipoing;
    }

    public void setNomTipoing(String nomTipoing) {
        this.nomTipoing = nomTipoing;
    }

    @XmlTransient
    public List<Proyectos> getProyectosList() {
        return proyectosList;
    }

    public void setProyectosList(List<Proyectos> proyectosList) {
        this.proyectosList = proyectosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipo != null ? codTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiposproyecto)) {
            return false;
        }
        Tiposproyecto other = (Tiposproyecto) object;
        if ((this.codTipo == null && other.codTipo != null) || (this.codTipo != null && !this.codTipo.equals(other.codTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Tiposproyecto[ codTipo=" + codTipo + " ]";
    }
    
}
