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
@Table(name = "sedes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sedes.findAll", query = "SELECT s FROM Sedes s")
    , @NamedQuery(name = "Sedes.findByCodSede", query = "SELECT s FROM Sedes s WHERE s.codSede = :codSede")
    , @NamedQuery(name = "Sedes.findSedes", query = "SELECT s FROM Sedes s WHERE s.codSede = :codSede")
    , @NamedQuery(name = "Sedes.findByNomSede", query = "SELECT s FROM Sedes s WHERE s.nomSede = :nomSede")
    , @NamedQuery(name = "Sedes.findByDireccion", query = "SELECT s FROM Sedes s WHERE s.direccion = :direccion")
    , @NamedQuery(name = "Sedes.findByCiudad", query = "SELECT s FROM Sedes s WHERE s.ciudad = :ciudad")
    , @NamedQuery(name = "Sedes.findByTelefono", query = "SELECT s FROM Sedes s WHERE s.telefono = :telefono")})
public class Sedes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_sede")
    private String codSede;
    @Size(max = 100)
    @Column(name = "nom_sede")
    private String nomSede;
    @Size(max = 255)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 100)
    @Column(name = "ciudad")
    private String ciudad;
    @Size(max = 30)
    @Column(name = "telefono")
    private String telefono;
    @JoinColumn(name = "cod_inspectoria", referencedColumnName = "cod_inspectoria")
    @ManyToOne
    private Inspectorias codInspectoria;
    @JoinColumn(name = "socio_local", referencedColumnName = "cod_socio")
    @ManyToOne
    private Socioslocales socioLocal;
    @JoinColumn(name = "pais", referencedColumnName = "cod_pais")
    @ManyToOne
    private Paises pais;
    @OneToMany(mappedBy = "sede")
    private List<Proyectos> proyectosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sedes")
    private List<Sedesresponsables> sedesresponsablesList;

    public Sedes() {
    }

    public Sedes(String codSede) {
        this.codSede = codSede;
    }

    public String getCodSede() {
        return codSede;
    }

    public void setCodSede(String codSede) {
        this.codSede = codSede;
    }

    public String getNomSede() {
        return nomSede;
    }

    public void setNomSede(String nomSede) {
        this.nomSede = nomSede;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Inspectorias getCodInspectoria() {
        return codInspectoria;
    }

    public void setCodInspectoria(Inspectorias codInspectoria) {
        this.codInspectoria = codInspectoria;
    }

    public Socioslocales getSocioLocal() {
        return socioLocal;
    }

    public void setSocioLocal(Socioslocales socioLocal) {
        this.socioLocal = socioLocal;
    }

    public Paises getPais() {
        return pais;
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }

    @XmlTransient
    public List<Proyectos> getProyectosList() {
        return proyectosList;
    }

    public void setProyectosList(List<Proyectos> proyectosList) {
        this.proyectosList = proyectosList;
    }

    @XmlTransient
    public List<Sedesresponsables> getSedesresponsablesList() {
        return sedesresponsablesList;
    }

    public void setSedesresponsablesList(List<Sedesresponsables> sedesresponsablesList) {
        this.sedesresponsablesList = sedesresponsablesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSede != null ? codSede.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sedes)) {
            return false;
        }
        Sedes other = (Sedes) object;
        if ((this.codSede == null && other.codSede != null) || (this.codSede != null && !this.codSede.equals(other.codSede))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Sedes[ codSede=" + codSede + " ]";
    }
    
}
