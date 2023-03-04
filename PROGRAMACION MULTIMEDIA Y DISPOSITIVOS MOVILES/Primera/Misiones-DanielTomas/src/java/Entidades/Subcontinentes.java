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
@Table(name = "subcontinentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subcontinentes.findAll", query = "SELECT s FROM Subcontinentes s")
    , @NamedQuery(name = "Subcontinentes.findByCodSubcontinente", query = "SELECT s FROM Subcontinentes s WHERE s.codSubcontinente = :codSubcontinente")
    , @NamedQuery(name = "Subcontinentes.findByNomSubcontinente", query = "SELECT s FROM Subcontinentes s WHERE s.nomSubcontinente = :nomSubcontinente")})
public class Subcontinentes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cod_subcontinente")
    private String codSubcontinente;
    @Size(max = 50)
    @Column(name = "nom_subcontinente")
    private String nomSubcontinente;
    @JoinColumn(name = "cod_continente", referencedColumnName = "cod_continente")
    @ManyToOne
    private Continentes codContinente;
    @OneToMany(mappedBy = "subContinente")
    private List<Paises> paisesList;

    public Subcontinentes() {
    }

    public Subcontinentes(String codSubcontinente) {
        this.codSubcontinente = codSubcontinente;
    }

    public String getCodSubcontinente() {
        return codSubcontinente;
    }

    public void setCodSubcontinente(String codSubcontinente) {
        this.codSubcontinente = codSubcontinente;
    }

    public String getNomSubcontinente() {
        return nomSubcontinente;
    }

    public void setNomSubcontinente(String nomSubcontinente) {
        this.nomSubcontinente = nomSubcontinente;
    }

    public Continentes getCodContinente() {
        return codContinente;
    }

    public void setCodContinente(Continentes codContinente) {
        this.codContinente = codContinente;
    }

    @XmlTransient
    public List<Paises> getPaisesList() {
        return paisesList;
    }

    public void setPaisesList(List<Paises> paisesList) {
        this.paisesList = paisesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSubcontinente != null ? codSubcontinente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subcontinentes)) {
            return false;
        }
        Subcontinentes other = (Subcontinentes) object;
        if ((this.codSubcontinente == null && other.codSubcontinente != null) || (this.codSubcontinente != null && !this.codSubcontinente.equals(other.codSubcontinente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Subcontinentes[ codSubcontinente=" + codSubcontinente + " ]";
    }
    
}
