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
@Table(name = "sectoresdbncadespanol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sectoresdbncadespanol.findAll", query = "SELECT s FROM Sectoresdbncadespanol s")
    , @NamedQuery(name = "Sectoresdbncadespanol.findByCodSector", query = "SELECT s FROM Sectoresdbncadespanol s WHERE s.codSector = :codSector")
    , @NamedQuery(name = "Sectoresdbncadespanol.findByNomSector", query = "SELECT s FROM Sectoresdbncadespanol s WHERE s.nomSector = :nomSector")})
public class Sectoresdbncadespanol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_sector")
    private Short codSector;
    @Size(max = 50)
    @Column(name = "nom_sector")
    private String nomSector;
    @OneToMany(mappedBy = "codSector")
    private List<Sectoresdbncadingles> sectoresdbncadinglesList;

    public Sectoresdbncadespanol() {
    }

    public Sectoresdbncadespanol(Short codSector) {
        this.codSector = codSector;
    }

    public Short getCodSector() {
        return codSector;
    }

    public void setCodSector(Short codSector) {
        this.codSector = codSector;
    }

    public String getNomSector() {
        return nomSector;
    }

    public void setNomSector(String nomSector) {
        this.nomSector = nomSector;
    }

    @XmlTransient
    public List<Sectoresdbncadingles> getSectoresdbncadinglesList() {
        return sectoresdbncadinglesList;
    }

    public void setSectoresdbncadinglesList(List<Sectoresdbncadingles> sectoresdbncadinglesList) {
        this.sectoresdbncadinglesList = sectoresdbncadinglesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSector != null ? codSector.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sectoresdbncadespanol)) {
            return false;
        }
        Sectoresdbncadespanol other = (Sectoresdbncadespanol) object;
        if ((this.codSector == null && other.codSector != null) || (this.codSector != null && !this.codSector.equals(other.codSector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Sectoresdbncadespanol[ codSector=" + codSector + " ]";
    }
    
}
