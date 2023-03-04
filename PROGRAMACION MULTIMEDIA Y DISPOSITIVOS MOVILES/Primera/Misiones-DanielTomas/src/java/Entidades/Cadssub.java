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
import javax.persistence.Lob;
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
@Table(name = "cadssub")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cadssub.findAll", query = "SELECT c FROM Cadssub c")
    , @NamedQuery(name = "Cadssub.findByCodSubcad", query = "SELECT c FROM Cadssub c WHERE c.codSubcad = :codSubcad")
    , @NamedQuery(name = "Cadssub.findByNomSubcad", query = "SELECT c FROM Cadssub c WHERE c.nomSubcad = :nomSubcad")
    , @NamedQuery(name = "Cadssub.findByNomSubcading", query = "SELECT c FROM Cadssub c WHERE c.nomSubcading = :nomSubcading")})
public class Cadssub implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_subcad")
    private Short codSubcad;
    @Size(max = 100)
    @Column(name = "nom_subcad")
    private String nomSubcad;
    @Size(max = 100)
    @Column(name = "nom_subcading")
    private String nomSubcading;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "informacionesp")
    private String informacionesp;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "informacioning")
    private String informacioning;
    @OneToMany(mappedBy = "codCadsub")
    private List<Crss> crssList;
    @JoinColumn(name = "cod_cad", referencedColumnName = "cod_cad")
    @ManyToOne
    private Cads codCad;

    public Cadssub() {
    }

    public Cadssub(Short codSubcad) {
        this.codSubcad = codSubcad;
    }

    public Short getCodSubcad() {
        return codSubcad;
    }

    public void setCodSubcad(Short codSubcad) {
        this.codSubcad = codSubcad;
    }

    public String getNomSubcad() {
        return nomSubcad;
    }

    public void setNomSubcad(String nomSubcad) {
        this.nomSubcad = nomSubcad;
    }

    public String getNomSubcading() {
        return nomSubcading;
    }

    public void setNomSubcading(String nomSubcading) {
        this.nomSubcading = nomSubcading;
    }

    public String getInformacionesp() {
        return informacionesp;
    }

    public void setInformacionesp(String informacionesp) {
        this.informacionesp = informacionesp;
    }

    public String getInformacioning() {
        return informacioning;
    }

    public void setInformacioning(String informacioning) {
        this.informacioning = informacioning;
    }

    @XmlTransient
    public List<Crss> getCrssList() {
        return crssList;
    }

    public void setCrssList(List<Crss> crssList) {
        this.crssList = crssList;
    }

    public Cads getCodCad() {
        return codCad;
    }

    public void setCodCad(Cads codCad) {
        this.codCad = codCad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSubcad != null ? codSubcad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cadssub)) {
            return false;
        }
        Cadssub other = (Cadssub) object;
        if ((this.codSubcad == null && other.codSubcad != null) || (this.codSubcad != null && !this.codSubcad.equals(other.codSubcad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Cadssub[ codSubcad=" + codSubcad + " ]";
    }
    
}
