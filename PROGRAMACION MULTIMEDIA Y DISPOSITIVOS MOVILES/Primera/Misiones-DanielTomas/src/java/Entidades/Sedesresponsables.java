/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danie
 */
@Entity
@Table(name = "sedesresponsables")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sedesresponsables.findAll", query = "SELECT s FROM Sedesresponsables s")
    , @NamedQuery(name = "Sedesresponsables.findByCodSede", query = "SELECT s FROM Sedesresponsables s WHERE s.sedesresponsablesPK.codSede = :codSede")
    , @NamedQuery(name = "Sedesresponsables.findByCodResponsable", query = "SELECT s FROM Sedesresponsables s WHERE s.sedesresponsablesPK.codResponsable = :codResponsable")
    , @NamedQuery(name = "Sedesresponsables.findByFechaInicio", query = "SELECT s FROM Sedesresponsables s WHERE s.sedesresponsablesPK.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Sedesresponsables.findByFechaFin", query = "SELECT s FROM Sedesresponsables s WHERE s.fechaFin = :fechaFin")
    , @NamedQuery(name = "Sedesresponsables.findByEmail", query = "SELECT s FROM Sedesresponsables s WHERE s.email = :email")
    , @NamedQuery(name = "Sedesresponsables.findByTelefono", query = "SELECT s FROM Sedesresponsables s WHERE s.telefono = :telefono")})
public class Sedesresponsables implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SedesresponsablesPK sedesresponsablesPK;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 20)
    @Column(name = "telefono")
    private String telefono;
    @JoinColumn(name = "cod_responsable", referencedColumnName = "cod_responsable", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Responsables responsables;
    @JoinColumn(name = "cod_sede", referencedColumnName = "cod_sede", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sedes sedes;

    public Sedesresponsables() {
    }

    public Sedesresponsables(SedesresponsablesPK sedesresponsablesPK) {
        this.sedesresponsablesPK = sedesresponsablesPK;
    }

    public Sedesresponsables(String codSede, short codResponsable, Date fechaInicio) {
        this.sedesresponsablesPK = new SedesresponsablesPK(codSede, codResponsable, fechaInicio);
    }

    public SedesresponsablesPK getSedesresponsablesPK() {
        return sedesresponsablesPK;
    }

    public void setSedesresponsablesPK(SedesresponsablesPK sedesresponsablesPK) {
        this.sedesresponsablesPK = sedesresponsablesPK;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Responsables getResponsables() {
        return responsables;
    }

    public void setResponsables(Responsables responsables) {
        this.responsables = responsables;
    }

    public Sedes getSedes() {
        return sedes;
    }

    public void setSedes(Sedes sedes) {
        this.sedes = sedes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sedesresponsablesPK != null ? sedesresponsablesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sedesresponsables)) {
            return false;
        }
        Sedesresponsables other = (Sedesresponsables) object;
        if ((this.sedesresponsablesPK == null && other.sedesresponsablesPK != null) || (this.sedesresponsablesPK != null && !this.sedesresponsablesPK.equals(other.sedesresponsablesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Sedesresponsables[ sedesresponsablesPK=" + sedesresponsablesPK + " ]";
    }
    
}
