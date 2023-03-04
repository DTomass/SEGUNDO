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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "sectores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sectores.findAll", query = "SELECT s FROM Sectores s")
    , @NamedQuery(name = "Sectores.findByCodSector", query = "SELECT s FROM Sectores s WHERE s.codSector = :codSector")
    , @NamedQuery(name = "Sectores.findByNomSector", query = "SELECT s FROM Sectores s WHERE s.nomSector = :nomSector")
    , @NamedQuery(name = "Sectores.findByNomSectoring", query = "SELECT s FROM Sectores s WHERE s.nomSectoring = :nomSectoring")
    , @NamedQuery(name = "Sectores.findBySectorCad", query = "SELECT s FROM Sectores s WHERE s.sectorCad = :sectorCad")})
public class Sectores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_sector")
    private Short codSector;
    @Size(max = 50)
    @Column(name = "nom_sector")
    private String nomSector;
    @Size(max = 50)
    @Column(name = "nom_sectoring")
    private String nomSectoring;
    @Size(max = 20)
    @Column(name = "sector_cad")
    private String sectorCad;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "explicacion")
    private String explicacion;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "explicacioning")
    private String explicacioning;
    @ManyToMany(mappedBy = "sectoresList")
    private List<Odsprincipal> odsprincipalList;
    @OneToMany(mappedBy = "sectorms")
    private List<Proyectos> proyectosList;
    @OneToMany(mappedBy = "codSector")
    private List<Subsectores> subsectoresList;

    public Sectores() {
    }

    public Sectores(Short codSector) {
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

    public String getNomSectoring() {
        return nomSectoring;
    }

    public void setNomSectoring(String nomSectoring) {
        this.nomSectoring = nomSectoring;
    }

    public String getSectorCad() {
        return sectorCad;
    }

    public void setSectorCad(String sectorCad) {
        this.sectorCad = sectorCad;
    }

    public String getExplicacion() {
        return explicacion;
    }

    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }

    public String getExplicacioning() {
        return explicacioning;
    }

    public void setExplicacioning(String explicacioning) {
        this.explicacioning = explicacioning;
    }

    @XmlTransient
    public List<Odsprincipal> getOdsprincipalList() {
        return odsprincipalList;
    }

    public void setOdsprincipalList(List<Odsprincipal> odsprincipalList) {
        this.odsprincipalList = odsprincipalList;
    }

    @XmlTransient
    public List<Proyectos> getProyectosList() {
        return proyectosList;
    }

    public void setProyectosList(List<Proyectos> proyectosList) {
        this.proyectosList = proyectosList;
    }

    @XmlTransient
    public List<Subsectores> getSubsectoresList() {
        return subsectoresList;
    }

    public void setSubsectoresList(List<Subsectores> subsectoresList) {
        this.subsectoresList = subsectoresList;
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
        if (!(object instanceof Sectores)) {
            return false;
        }
        Sectores other = (Sectores) object;
        if ((this.codSector == null && other.codSector != null) || (this.codSector != null && !this.codSector.equals(other.codSector))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Sectores[ codSector=" + codSector + " ]";
    }
    
}
