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
@Table(name = "tiposconvocatoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiposconvocatoria.findAll", query = "SELECT t FROM Tiposconvocatoria t")
    , @NamedQuery(name = "Tiposconvocatoria.findByCodTipo", query = "SELECT t FROM Tiposconvocatoria t WHERE t.codTipo = :codTipo")
    , @NamedQuery(name = "Tiposconvocatoria.findByNomTipo", query = "SELECT t FROM Tiposconvocatoria t WHERE t.nomTipo = :nomTipo")})
public class Tiposconvocatoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_tipo")
    private Short codTipo;
    @Size(max = 255)
    @Column(name = "nom_tipo")
    private String nomTipo;

    public Tiposconvocatoria() {
    }

    public Tiposconvocatoria(Short codTipo) {
        this.codTipo = codTipo;
    }

    public Short getCodTipo() {
        return codTipo;
    }

    public void setCodTipo(Short codTipo) {
        this.codTipo = codTipo;
    }

    public String getNomTipo() {
        return nomTipo;
    }

    public void setNomTipo(String nomTipo) {
        this.nomTipo = nomTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipo != null ? codTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiposconvocatoria)) {
            return false;
        }
        Tiposconvocatoria other = (Tiposconvocatoria) object;
        if ((this.codTipo == null && other.codTipo != null) || (this.codTipo != null && !this.codTipo.equals(other.codTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Tiposconvocatoria[ codTipo=" + codTipo + " ]";
    }
    
}
