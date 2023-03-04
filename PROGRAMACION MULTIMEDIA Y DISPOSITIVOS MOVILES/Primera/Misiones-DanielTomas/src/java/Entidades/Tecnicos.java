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
@Table(name = "tecnicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tecnicos.findAll", query = "SELECT t FROM Tecnicos t")
    , @NamedQuery(name = "Tecnicos.findByCodTecnico", query = "SELECT t FROM Tecnicos t WHERE t.codTecnico = :codTecnico")
    , @NamedQuery(name = "Tecnicos.findByNomTecnico", query = "SELECT t FROM Tecnicos t WHERE t.nomTecnico = :nomTecnico")})
public class Tecnicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_tecnico")
    private Short codTecnico;
    @Size(max = 100)
    @Column(name = "nom_tecnico")
    private String nomTecnico;
    @OneToMany(mappedBy = "tecFor")
    private List<Proyectos> proyectosList;
    @OneToMany(mappedBy = "tecSeg")
    private List<Proyectos> proyectosList1;

    public Tecnicos() {
    }

    public Tecnicos(Short codTecnico) {
        this.codTecnico = codTecnico;
    }

    public Short getCodTecnico() {
        return codTecnico;
    }

    public void setCodTecnico(Short codTecnico) {
        this.codTecnico = codTecnico;
    }

    public String getNomTecnico() {
        return nomTecnico;
    }

    public void setNomTecnico(String nomTecnico) {
        this.nomTecnico = nomTecnico;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTecnico != null ? codTecnico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tecnicos)) {
            return false;
        }
        Tecnicos other = (Tecnicos) object;
        if ((this.codTecnico == null && other.codTecnico != null) || (this.codTecnico != null && !this.codTecnico.equals(other.codTecnico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Tecnicos[ codTecnico=" + codTecnico + " ]";
    }
    
}
