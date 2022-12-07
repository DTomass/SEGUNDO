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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "crss")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Crss.findAll", query = "SELECT c FROM Crss c")
    , @NamedQuery(name = "Crss.findByCodCrs", query = "SELECT c FROM Crss c WHERE c.codCrs = :codCrs")
    , @NamedQuery(name = "Crss.findByNomCrs", query = "SELECT c FROM Crss c WHERE c.nomCrs = :nomCrs")
    , @NamedQuery(name = "Crss.findByNomCrsingles", query = "SELECT c FROM Crss c WHERE c.nomCrsingles = :nomCrsingles")})
public class Crss implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_crs")
    private Integer codCrs;
    @Size(max = 100)
    @Column(name = "nom_crs")
    private String nomCrs;
    @Size(max = 100)
    @Column(name = "nom_crsingles")
    private String nomCrsingles;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "informacionesesp")
    private String informacionesesp;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "informacionesing")
    private String informacionesing;
    @JoinTable(name = "proyectoscrs", joinColumns = {
        @JoinColumn(name = "crs", referencedColumnName = "cod_crs")}, inverseJoinColumns = {
        @JoinColumn(name = "cod_proyecto", referencedColumnName = "codigo")})
    @ManyToMany
    private List<Proyectos> proyectosList;
    @JoinColumn(name = "cod_cadsub", referencedColumnName = "cod_subcad")
    @ManyToOne
    private Cadssub codCadsub;

    public Crss() {
    }

    public Crss(Integer codCrs) {
        this.codCrs = codCrs;
    }

    public Integer getCodCrs() {
        return codCrs;
    }

    public void setCodCrs(Integer codCrs) {
        this.codCrs = codCrs;
    }

    public String getNomCrs() {
        return nomCrs;
    }

    public void setNomCrs(String nomCrs) {
        this.nomCrs = nomCrs;
    }

    public String getNomCrsingles() {
        return nomCrsingles;
    }

    public void setNomCrsingles(String nomCrsingles) {
        this.nomCrsingles = nomCrsingles;
    }

    public String getInformacionesesp() {
        return informacionesesp;
    }

    public void setInformacionesesp(String informacionesesp) {
        this.informacionesesp = informacionesesp;
    }

    public String getInformacionesing() {
        return informacionesing;
    }

    public void setInformacionesing(String informacionesing) {
        this.informacionesing = informacionesing;
    }

    @XmlTransient
    public List<Proyectos> getProyectosList() {
        return proyectosList;
    }

    public void setProyectosList(List<Proyectos> proyectosList) {
        this.proyectosList = proyectosList;
    }

    public Cadssub getCodCadsub() {
        return codCadsub;
    }

    public void setCodCadsub(Cadssub codCadsub) {
        this.codCadsub = codCadsub;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCrs != null ? codCrs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Crss)) {
            return false;
        }
        Crss other = (Crss) object;
        if ((this.codCrs == null && other.codCrs != null) || (this.codCrs != null && !this.codCrs.equals(other.codCrs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Crss[ codCrs=" + codCrs + " ]";
    }
    
}
