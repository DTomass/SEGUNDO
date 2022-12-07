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
 * @author danie
 */
@Entity
@Table(name = "tiposentidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiposentidades.findAll", query = "SELECT t FROM Tiposentidades t")
    , @NamedQuery(name = "Tiposentidades.findEntidades", query = "SELECT t FROM Tiposentidades t WHERE t.tipoOrganismo = :elOrg")
    , @NamedQuery(name = "Tiposentidades.findByCodTipo", query = "SELECT t FROM Tiposentidades t WHERE t.codTipo = :codTipo")
    , @NamedQuery(name = "Tiposentidades.findByNomTipo", query = "SELECT t FROM Tiposentidades t WHERE t.nomTipo = :nomTipo")})
public class Tiposentidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_tipo")
    private Short codTipo;
    @Size(max = 50)
    @Column(name = "nom_tipo")
    private String nomTipo;
    @OneToMany(mappedBy = "tipoEntidad")
    private List<Proyectos> proyectosList;
    @JoinColumn(name = "tipo_organismo", referencedColumnName = "cod_tipo")
    @ManyToOne
    private Tiposorganismos tipoOrganismo;
    @OneToMany(mappedBy = "tipoEntidad")
    private List<Entidades> entidadesList;

    public Tiposentidades() {
    }

    public Tiposentidades(Short codTipo) {
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

    @XmlTransient
    public List<Proyectos> getProyectosList() {
        return proyectosList;
    }

    public void setProyectosList(List<Proyectos> proyectosList) {
        this.proyectosList = proyectosList;
    }

    public Tiposorganismos getTipoOrganismo() {
        return tipoOrganismo;
    }

    public void setTipoOrganismo(Tiposorganismos tipoOrganismo) {
        this.tipoOrganismo = tipoOrganismo;
    }

    @XmlTransient
    public List<Entidades> getEntidadesList() {
        return entidadesList;
    }

    public void setEntidadesList(List<Entidades> entidadesList) {
        this.entidadesList = entidadesList;
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
        if (!(object instanceof Tiposentidades)) {
            return false;
        }
        Tiposentidades other = (Tiposentidades) object;
        if ((this.codTipo == null && other.codTipo != null) || (this.codTipo != null && !this.codTipo.equals(other.codTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Tiposentidades[ codTipo=" + codTipo + " ]";
    }
    
}
