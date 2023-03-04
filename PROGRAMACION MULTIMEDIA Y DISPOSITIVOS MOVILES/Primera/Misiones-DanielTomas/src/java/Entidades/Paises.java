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
@Table(name = "paises")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paises.findAll", query = "SELECT p FROM Paises p")
    , @NamedQuery(name = "Paises.findByCodPais", query = "SELECT p FROM Paises p WHERE p.codPais = :codPais")
    , @NamedQuery(name = "Paises.findByCodPaisTelefono", query = "SELECT p FROM Paises p WHERE p.codPaisTelefono = :codPaisTelefono")
    , @NamedQuery(name = "Paises.findByNomPais", query = "SELECT p FROM Paises p WHERE p.nomPais = :nomPais")
    , @NamedQuery(name = "Paises.findByNomPaisIngles", query = "SELECT p FROM Paises p WHERE p.nomPaisIngles = :nomPaisIngles")})
public class Paises implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "cod_pais")
    private String codPais;
    @Size(max = 4)
    @Column(name = "cod_pais_telefono")
    private String codPaisTelefono;
    @Size(max = 100)
    @Column(name = "nom_pais")
    private String nomPais;
    @Size(max = 255)
    @Column(name = "nom_pais_ingles")
    private String nomPaisIngles;
    @OneToMany(mappedBy = "pais")
    private List<Sedes> sedesList;
    @OneToMany(mappedBy = "pais")
    private List<Proyectos> proyectosList;
    @JoinColumn(name = "cod_region", referencedColumnName = "cod_region")
    @ManyToOne
    private Regiones codRegion;
    @JoinColumn(name = "sub_continente", referencedColumnName = "cod_subcontinente")
    @ManyToOne
    private Subcontinentes subContinente;

    public Paises() {
    }

    public Paises(String codPais) {
        this.codPais = codPais;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getCodPaisTelefono() {
        return codPaisTelefono;
    }

    public void setCodPaisTelefono(String codPaisTelefono) {
        this.codPaisTelefono = codPaisTelefono;
    }

    public String getNomPais() {
        return nomPais;
    }

    public void setNomPais(String nomPais) {
        this.nomPais = nomPais;
    }

    public String getNomPaisIngles() {
        return nomPaisIngles;
    }

    public void setNomPaisIngles(String nomPaisIngles) {
        this.nomPaisIngles = nomPaisIngles;
    }

    @XmlTransient
    public List<Sedes> getSedesList() {
        return sedesList;
    }

    public void setSedesList(List<Sedes> sedesList) {
        this.sedesList = sedesList;
    }

    @XmlTransient
    public List<Proyectos> getProyectosList() {
        return proyectosList;
    }

    public void setProyectosList(List<Proyectos> proyectosList) {
        this.proyectosList = proyectosList;
    }

    public Regiones getCodRegion() {
        return codRegion;
    }

    public void setCodRegion(Regiones codRegion) {
        this.codRegion = codRegion;
    }

    public Subcontinentes getSubContinente() {
        return subContinente;
    }

    public void setSubContinente(Subcontinentes subContinente) {
        this.subContinente = subContinente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPais != null ? codPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paises)) {
            return false;
        }
        Paises other = (Paises) object;
        if ((this.codPais == null && other.codPais != null) || (this.codPais != null && !this.codPais.equals(other.codPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Paises[ codPais=" + codPais + " ]";
    }
    
}
