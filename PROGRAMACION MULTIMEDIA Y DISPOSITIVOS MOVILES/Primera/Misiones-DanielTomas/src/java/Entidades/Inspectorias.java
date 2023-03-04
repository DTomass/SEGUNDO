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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author danie
 */
@Entity
@Table(name = "inspectorias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inspectorias.findAll", query = "SELECT i FROM Inspectorias i")
    , @NamedQuery(name = "Inspectorias.findByCodigo", query = "SELECT i FROM Inspectorias i WHERE i.codigo = :codigo")
    , @NamedQuery(name = "Inspectorias.findByCodInspectoria", query = "SELECT i FROM Inspectorias i WHERE i.codInspectoria = :codInspectoria")
    , @NamedQuery(name = "Inspectorias.findByNomInspectoria", query = "SELECT i FROM Inspectorias i WHERE i.nomInspectoria = :nomInspectoria")
    , @NamedQuery(name = "Inspectorias.findByOpd", query = "SELECT i FROM Inspectorias i WHERE i.opd = :opd")
    , @NamedQuery(name = "Inspectorias.findByOpdContactoMail", query = "SELECT i FROM Inspectorias i WHERE i.opdContactoMail = :opdContactoMail")
    , @NamedQuery(name = "Inspectorias.findByOpdContactoTelefono", query = "SELECT i FROM Inspectorias i WHERE i.opdContactoTelefono = :opdContactoTelefono")})
public class Inspectorias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Size(max = 3)
    @Column(name = "cod_inspectoria")
    private String codInspectoria;
    @Size(max = 100)
    @Column(name = "nom_inspectoria")
    private String nomInspectoria;
    @Size(max = 50)
    @Column(name = "opd")
    private String opd;
    @Size(max = 100)
    @Column(name = "opd_contacto_mail")
    private String opdContactoMail;
    @Size(max = 20)
    @Column(name = "opd_contacto_telefono")
    private String opdContactoTelefono;
    @OneToMany(mappedBy = "codInspectoria")
    private List<Sedes> sedesList;
    @OneToMany(mappedBy = "inspectoria")
    private List<Proyectos> proyectosList;
    @JoinColumn(name = "socio_local", referencedColumnName = "cod_socio")
    @ManyToOne
    private Socioslocales socioLocal;
    @JoinColumn(name = "responsable_legal", referencedColumnName = "cod_responsable")
    @ManyToOne
    private Responsables responsableLegal;
    @JoinColumn(name = "opd_contacto_nombre", referencedColumnName = "cod_responsable")
    @ManyToOne
    private Responsables opdContactoNombre;

    public Inspectorias() {
    }

    public Inspectorias(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getCodInspectoria() {
        return codInspectoria;
    }

    public void setCodInspectoria(String codInspectoria) {
        this.codInspectoria = codInspectoria;
    }

    public String getNomInspectoria() {
        return nomInspectoria;
    }

    public void setNomInspectoria(String nomInspectoria) {
        this.nomInspectoria = nomInspectoria;
    }

    public String getOpd() {
        return opd;
    }

    public void setOpd(String opd) {
        this.opd = opd;
    }

    public String getOpdContactoMail() {
        return opdContactoMail;
    }

    public void setOpdContactoMail(String opdContactoMail) {
        this.opdContactoMail = opdContactoMail;
    }

    public String getOpdContactoTelefono() {
        return opdContactoTelefono;
    }

    public void setOpdContactoTelefono(String opdContactoTelefono) {
        this.opdContactoTelefono = opdContactoTelefono;
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

    public Socioslocales getSocioLocal() {
        return socioLocal;
    }

    public void setSocioLocal(Socioslocales socioLocal) {
        this.socioLocal = socioLocal;
    }

    public Responsables getResponsableLegal() {
        return responsableLegal;
    }

    public void setResponsableLegal(Responsables responsableLegal) {
        this.responsableLegal = responsableLegal;
    }

    public Responsables getOpdContactoNombre() {
        return opdContactoNombre;
    }

    public void setOpdContactoNombre(Responsables opdContactoNombre) {
        this.opdContactoNombre = opdContactoNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inspectorias)) {
            return false;
        }
        Inspectorias other = (Inspectorias) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Inspectorias[ codigo=" + codigo + " ]";
    }
    
}
