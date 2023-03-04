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
@Table(name = "regiones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regiones.findAll", query = "SELECT r FROM Regiones r")
    , @NamedQuery(name = "Regiones.findByCodRegion", query = "SELECT r FROM Regiones r WHERE r.codRegion = :codRegion")
    , @NamedQuery(name = "Regiones.findByNomRegion", query = "SELECT r FROM Regiones r WHERE r.nomRegion = :nomRegion")})
public class Regiones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_region")
    private Short codRegion;
    @Size(max = 50)
    @Column(name = "nom_region")
    private String nomRegion;
    @OneToMany(mappedBy = "codRegion")
    private List<Paises> paisesList;

    public Regiones() {
    }

    public Regiones(Short codRegion) {
        this.codRegion = codRegion;
    }

    public Short getCodRegion() {
        return codRegion;
    }

    public void setCodRegion(Short codRegion) {
        this.codRegion = codRegion;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    @XmlTransient
    public List<Paises> getPaisesList() {
        return paisesList;
    }

    public void setPaisesList(List<Paises> paisesList) {
        this.paisesList = paisesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRegion != null ? codRegion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regiones)) {
            return false;
        }
        Regiones other = (Regiones) object;
        if ((this.codRegion == null && other.codRegion != null) || (this.codRegion != null && !this.codRegion.equals(other.codRegion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Regiones[ codRegion=" + codRegion + " ]";
    }
    
}
