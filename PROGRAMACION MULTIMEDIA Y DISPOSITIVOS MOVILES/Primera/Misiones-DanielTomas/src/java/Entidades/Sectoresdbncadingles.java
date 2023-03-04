/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danie
 */
@Entity
@Table(name = "sectoresdbncadingles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sectoresdbncadingles.findAll", query = "SELECT s FROM Sectoresdbncadingles s")
    , @NamedQuery(name = "Sectoresdbncadingles.findByCodSectoring", query = "SELECT s FROM Sectoresdbncadingles s WHERE s.codSectoring = :codSectoring")
    , @NamedQuery(name = "Sectoresdbncadingles.findByNomSectoring", query = "SELECT s FROM Sectoresdbncadingles s WHERE s.nomSectoring = :nomSectoring")})
public class Sectoresdbncadingles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_sectoring")
    private Short codSectoring;
    @Size(max = 150)
    @Column(name = "nom_sectoring")
    private String nomSectoring;
    @JoinColumn(name = "cod_sector", referencedColumnName = "cod_sector")
    @ManyToOne
    private Sectoresdbncadespanol codSector;

    public Sectoresdbncadingles() {
    }

    public Sectoresdbncadingles(Short codSectoring) {
        this.codSectoring = codSectoring;
    }

    public Short getCodSectoring() {
        return codSectoring;
    }

    public void setCodSectoring(Short codSectoring) {
        this.codSectoring = codSectoring;
    }

    public String getNomSectoring() {
        return nomSectoring;
    }

    public void setNomSectoring(String nomSectoring) {
        this.nomSectoring = nomSectoring;
    }

    public Sectoresdbncadespanol getCodSector() {
        return codSector;
    }

    public void setCodSector(Sectoresdbncadespanol codSector) {
        this.codSector = codSector;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSectoring != null ? codSectoring.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sectoresdbncadingles)) {
            return false;
        }
        Sectoresdbncadingles other = (Sectoresdbncadingles) object;
        if ((this.codSectoring == null && other.codSectoring != null) || (this.codSectoring != null && !this.codSectoring.equals(other.codSectoring))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Sectoresdbncadingles[ codSectoring=" + codSectoring + " ]";
    }
    
}
