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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "odsprincipal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Odsprincipal.findAll", query = "SELECT o FROM Odsprincipal o")
    , @NamedQuery(name = "Odsprincipal.findByCodOds", query = "SELECT o FROM Odsprincipal o WHERE o.codOds = :codOds")
    , @NamedQuery(name = "Odsprincipal.findByNomOds", query = "SELECT o FROM Odsprincipal o WHERE o.nomOds = :nomOds")})
public class Odsprincipal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_ods")
    private Short codOds;
    @Size(max = 50)
    @Column(name = "nom_ods")
    private String nomOds;
    @JoinTable(name = "proyectosods", joinColumns = {
        @JoinColumn(name = "ods", referencedColumnName = "cod_ods")}, inverseJoinColumns = {
        @JoinColumn(name = "cod_proyecto", referencedColumnName = "codigo")})
    @ManyToMany
    private List<Proyectos> proyectosList;
    @JoinTable(name = "sectoresodsprincipal", joinColumns = {
        @JoinColumn(name = "ods_pral", referencedColumnName = "cod_ods")}, inverseJoinColumns = {
        @JoinColumn(name = "cod_sector", referencedColumnName = "cod_sector")})
    @ManyToMany
    private List<Sectores> sectoresList;

    public Odsprincipal() {
    }

    public Odsprincipal(Short codOds) {
        this.codOds = codOds;
    }

    public Short getCodOds() {
        return codOds;
    }

    public void setCodOds(Short codOds) {
        this.codOds = codOds;
    }

    public String getNomOds() {
        return nomOds;
    }

    public void setNomOds(String nomOds) {
        this.nomOds = nomOds;
    }

    @XmlTransient
    public List<Proyectos> getProyectosList() {
        return proyectosList;
    }

    public void setProyectosList(List<Proyectos> proyectosList) {
        this.proyectosList = proyectosList;
    }

    @XmlTransient
    public List<Sectores> getSectoresList() {
        return sectoresList;
    }

    public void setSectoresList(List<Sectores> sectoresList) {
        this.sectoresList = sectoresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codOds != null ? codOds.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Odsprincipal)) {
            return false;
        }
        Odsprincipal other = (Odsprincipal) object;
        if ((this.codOds == null && other.codOds != null) || (this.codOds != null && !this.codOds.equals(other.codOds))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Odsprincipal[ codOds=" + codOds + " ]";
    }
    
}
