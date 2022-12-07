/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "responsables")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Responsables.findAll", query = "SELECT r FROM Responsables r")
    , @NamedQuery(name = "Responsables.findByCodResponsable", query = "SELECT r FROM Responsables r WHERE r.codResponsable = :codResponsable")
    , @NamedQuery(name = "Responsables.findByNomResponsable", query = "SELECT r FROM Responsables r WHERE r.nomResponsable = :nomResponsable")
    , @NamedQuery(name = "Responsables.findByTratamiento", query = "SELECT r FROM Responsables r WHERE r.tratamiento = :tratamiento")
    , @NamedQuery(name = "Responsables.findByTipoMisionero", query = "SELECT r FROM Responsables r WHERE r.tipoMisionero = :tipoMisionero")})
public class Responsables implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_responsable")
    private Short codResponsable;
    @Size(max = 100)
    @Column(name = "nom_responsable")
    private String nomResponsable;
    @Size(max = 50)
    @Column(name = "tratamiento")
    private String tratamiento;
    @Size(max = 3)
    @Column(name = "tipo_misionero")
    private String tipoMisionero;
    @OneToMany(mappedBy = "responsableLegal")
    private List<Proyectos> proyectosList;
    @OneToMany(mappedBy = "responsableLocal")
    private List<Proyectos> proyectosList1;
    @OneToMany(mappedBy = "opdContactoNombre")
    private List<Proyectos> proyectosList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "responsables")
    private List<Sedesresponsables> sedesresponsablesList;
    @OneToMany(mappedBy = "responsableLegal")
    private List<Inspectorias> inspectoriasList;
    @OneToMany(mappedBy = "opdContactoNombre")
    private List<Inspectorias> inspectoriasList1;

    public Responsables() {
    }

    public Responsables(Short codResponsable) {
        this.codResponsable = codResponsable;
    }

    public Short getCodResponsable() {
        return codResponsable;
    }

    public void setCodResponsable(Short codResponsable) {
        this.codResponsable = codResponsable;
    }

    public String getNomResponsable() {
        return nomResponsable;
    }

    public void setNomResponsable(String nomResponsable) {
        this.nomResponsable = nomResponsable;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getTipoMisionero() {
        return tipoMisionero;
    }

    public void setTipoMisionero(String tipoMisionero) {
        this.tipoMisionero = tipoMisionero;
    }

    @XmlTransient
    public List<Proyectos> getProyectosList() {
        return proyectosList;
    }

    public void setProyectosList(List<Proyectos> proyectosList) {
        this.proyectosList = proyectosList;
    }

    @XmlTransient
    public List<Proyectos> getProyectosList1() {
        return proyectosList1;
    }

    public void setProyectosList1(List<Proyectos> proyectosList1) {
        this.proyectosList1 = proyectosList1;
    }

    @XmlTransient
    public List<Proyectos> getProyectosList2() {
        return proyectosList2;
    }

    public void setProyectosList2(List<Proyectos> proyectosList2) {
        this.proyectosList2 = proyectosList2;
    }

    @XmlTransient
    public List<Sedesresponsables> getSedesresponsablesList() {
        return sedesresponsablesList;
    }

    public void setSedesresponsablesList(List<Sedesresponsables> sedesresponsablesList) {
        this.sedesresponsablesList = sedesresponsablesList;
    }

    @XmlTransient
    public List<Inspectorias> getInspectoriasList() {
        return inspectoriasList;
    }

    public void setInspectoriasList(List<Inspectorias> inspectoriasList) {
        this.inspectoriasList = inspectoriasList;
    }

    @XmlTransient
    public List<Inspectorias> getInspectoriasList1() {
        return inspectoriasList1;
    }

    public void setInspectoriasList1(List<Inspectorias> inspectoriasList1) {
        this.inspectoriasList1 = inspectoriasList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codResponsable != null ? codResponsable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responsables)) {
            return false;
        }
        Responsables other = (Responsables) object;
        if ((this.codResponsable == null && other.codResponsable != null) || (this.codResponsable != null && !this.codResponsable.equals(other.codResponsable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Responsables[ codResponsable=" + codResponsable + " ]";
    }
    
}
