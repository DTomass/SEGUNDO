/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "envios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Envios.findAll", query = "SELECT e FROM Envios e")
    , @NamedQuery(name = "Envios.findByCodigo", query = "SELECT e FROM Envios e WHERE e.enviosPK.codigo = :codigo")
    , @NamedQuery(name = "Envios.findByFecha", query = "SELECT e FROM Envios e WHERE e.enviosPK.fecha = :fecha")
    , @NamedQuery(name = "Envios.findByCantidad", query = "SELECT e FROM Envios e WHERE e.cantidad = :cantidad")
    , @NamedQuery(name = "Envios.findByAcuseReciboMs", query = "SELECT e FROM Envios e WHERE e.acuseReciboMs = :acuseReciboMs")
    , @NamedQuery(name = "Envios.findByAcuseBanco", query = "SELECT e FROM Envios e WHERE e.acuseBanco = :acuseBanco")})
public class Envios implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EnviosPK enviosPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    private Double cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acuse_recibo_ms")
    private boolean acuseReciboMs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acuse_banco")
    private boolean acuseBanco;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentario")
    private String comentario;
    @JoinColumn(name = "codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyectos proyectos;

    public Envios() {
    }

    public Envios(EnviosPK enviosPK) {
        this.enviosPK = enviosPK;
    }

    public Envios(EnviosPK enviosPK, boolean acuseReciboMs, boolean acuseBanco) {
        this.enviosPK = enviosPK;
        this.acuseReciboMs = acuseReciboMs;
        this.acuseBanco = acuseBanco;
    }

    public Envios(String codigo, Date fecha) {
        this.enviosPK = new EnviosPK(codigo, fecha);
    }

    public EnviosPK getEnviosPK() {
        return enviosPK;
    }

    public void setEnviosPK(EnviosPK enviosPK) {
        this.enviosPK = enviosPK;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public boolean getAcuseReciboMs() {
        return acuseReciboMs;
    }

    public void setAcuseReciboMs(boolean acuseReciboMs) {
        this.acuseReciboMs = acuseReciboMs;
    }

    public boolean getAcuseBanco() {
        return acuseBanco;
    }

    public void setAcuseBanco(boolean acuseBanco) {
        this.acuseBanco = acuseBanco;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Proyectos getProyectos() {
        return proyectos;
    }

    public void setProyectos(Proyectos proyectos) {
        this.proyectos = proyectos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enviosPK != null ? enviosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Envios)) {
            return false;
        }
        Envios other = (Envios) object;
        if ((this.enviosPK == null && other.enviosPK != null) || (this.enviosPK != null && !this.enviosPK.equals(other.enviosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Envios[ enviosPK=" + enviosPK + " ]";
    }
    
}
