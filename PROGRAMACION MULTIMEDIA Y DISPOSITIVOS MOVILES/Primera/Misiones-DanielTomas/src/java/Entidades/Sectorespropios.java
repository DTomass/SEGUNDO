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
@Table(name = "sectorespropios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sectorespropios.findAll", query = "SELECT s FROM Sectorespropios s")
    , @NamedQuery(name = "Sectorespropios.findByCodSector", query = "SELECT s FROM Sectorespropios s WHERE s.codSector = :codSector")
    , @NamedQuery(name = "Sectorespropios.findByNomSector", query = "SELECT s FROM Sectorespropios s WHERE s.nomSector = :nomSector")})
public class Sectorespropios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cod_sector")
    private String codSector;
    @Size(max = 50)
    @Column(name = "nom_sector")
    private String nomSector;
    @OneToMany(mappedBy = "sectorjyd")
    private List<Proyectos> proyectosList;
    @OneToMany(mappedBy = "codSector")
    private List<Subsectorespropios> subsectorespropiosList;

    public Sectorespropios() {
    }

    public Sectorespropios(String codSector) {
        this.codSector = codSector;
    }

    public String getCodSector() {
        return codSector;
    }

    public void setCodSector(String codSector) {
        this.codSector = codSector;
    }

    public String getNomSector() {
        return nomSector;
    }

    public void setNomSector(String nomSector) {
        this.nomSector = nomSector;
    }

    @XmlTransient
    public List<Proyectos> getProyectosList() {
        return proyectosList;
    }

    public void setProyectosList(List<Proyectos> proyectosList) {
        this.proyectosList = proyectosList;
    }

    @XmlTransient
    public List<Subsectorespropios> getSubsectorespropiosList() {
        return subsectorespropiosList;
    }

    public void setSubsectorespropiosList(List<Subsectorespropios> subsectorespropiosList) {
        this.subsectorespropiosList = subsectorespropiosList;
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
        if (!(object instanceof Sectorespropios)) {
            return false;
        }
        Sectorespropios other = (Sectorespropios) object;
        if ((this.codSector == null && other.codSector != null) || (this.codSector != null && !this.codSector.equals(other.codSector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Sectorespropios[ codSector=" + codSector + " ]";
    }
    
}
