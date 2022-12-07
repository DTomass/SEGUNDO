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
@Table(name = "misioneros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Misioneros.findAll", query = "SELECT m FROM Misioneros m")
    , @NamedQuery(name = "Misioneros.findByCodMisionero", query = "SELECT m FROM Misioneros m WHERE m.codMisionero = :codMisionero")
    , @NamedQuery(name = "Misioneros.findByNomMisionero", query = "SELECT m FROM Misioneros m WHERE m.nomMisionero = :nomMisionero")
    , @NamedQuery(name = "Misioneros.findByTipoMisionero", query = "SELECT m FROM Misioneros m WHERE m.tipoMisionero = :tipoMisionero")
    , @NamedQuery(name = "Misioneros.findByMail1", query = "SELECT m FROM Misioneros m WHERE m.mail1 = :mail1")
    , @NamedQuery(name = "Misioneros.findByMail2", query = "SELECT m FROM Misioneros m WHERE m.mail2 = :mail2")
    , @NamedQuery(name = "Misioneros.findByTelefono", query = "SELECT m FROM Misioneros m WHERE m.telefono = :telefono")})
public class Misioneros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_misionero")
    private Short codMisionero;
    @Size(max = 255)
    @Column(name = "nom_misionero")
    private String nomMisionero;
    @Size(max = 3)
    @Column(name = "tipo_misionero")
    private String tipoMisionero;
    @Size(max = 100)
    @Column(name = "mail1")
    private String mail1;
    @Size(max = 100)
    @Column(name = "mail2")
    private String mail2;
    @Size(max = 30)
    @Column(name = "telefono")
    private String telefono;
    @JoinColumn(name = "cod_mision", referencedColumnName = "cod_mision")
    @ManyToOne
    private Misiones codMision;

    public Misioneros() {
    }

    public Misioneros(Short codMisionero) {
        this.codMisionero = codMisionero;
    }

    public Short getCodMisionero() {
        return codMisionero;
    }

    public void setCodMisionero(Short codMisionero) {
        this.codMisionero = codMisionero;
    }

    public String getNomMisionero() {
        return nomMisionero;
    }

    public void setNomMisionero(String nomMisionero) {
        this.nomMisionero = nomMisionero;
    }

    public String getTipoMisionero() {
        return tipoMisionero;
    }

    public void setTipoMisionero(String tipoMisionero) {
        this.tipoMisionero = tipoMisionero;
    }

    public String getMail1() {
        return mail1;
    }

    public void setMail1(String mail1) {
        this.mail1 = mail1;
    }

    public String getMail2() {
        return mail2;
    }

    public void setMail2(String mail2) {
        this.mail2 = mail2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Misiones getCodMision() {
        return codMision;
    }

    public void setCodMision(Misiones codMision) {
        this.codMision = codMision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMisionero != null ? codMisionero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Misioneros)) {
            return false;
        }
        Misioneros other = (Misioneros) object;
        if ((this.codMisionero == null && other.codMisionero != null) || (this.codMisionero != null && !this.codMisionero.equals(other.codMisionero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Misioneros[ codMisionero=" + codMisionero + " ]";
    }
    
}
