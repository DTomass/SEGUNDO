/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author danie
 */
@Entity
@Table(name = "proyectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyectos.findAll", query = "SELECT p FROM Proyectos p")
    , @NamedQuery(name = "Proyectos.findByCodProyecto", query = "SELECT p FROM Proyectos p WHERE p.codProyecto = :codProyecto")
    , @NamedQuery(name = "Proyectos.findByOng", query = "SELECT p FROM Proyectos p WHERE p.ong = :ong")
    , @NamedQuery(name = "Proyectos.findByCodigo", query = "SELECT p FROM Proyectos p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Proyectos.findByParte", query = "SELECT p FROM Proyectos p WHERE p.parte = :parte")
    , @NamedQuery(name = "Proyectos.findByReferencia", query = "SELECT p FROM Proyectos p WHERE p.referencia = :referencia")
    , @NamedQuery(name = "Proyectos.findByNumProyecto", query = "SELECT p FROM Proyectos p WHERE p.numProyecto = :numProyecto")
    , @NamedQuery(name = "Proyectos.findByLocalizacion", query = "SELECT p FROM Proyectos p WHERE p.localizacion = :localizacion")
    , @NamedQuery(name = "Proyectos.findByAnyo", query = "SELECT p FROM Proyectos p WHERE p.anyo = :anyo")
    , @NamedQuery(name = "Proyectos.findByTitulo", query = "SELECT p FROM Proyectos p WHERE p.titulo = :titulo")
    , @NamedQuery(name = "Proyectos.findByDescripcion", query = "SELECT p FROM Proyectos p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Proyectos.findByRegionSdb", query = "SELECT p FROM Proyectos p WHERE p.regionSdb = :regionSdb")
    , @NamedQuery(name = "Proyectos.findByOpd", query = "SELECT p FROM Proyectos p WHERE p.opd = :opd")
    , @NamedQuery(name = "Proyectos.findByOpdContactoMail", query = "SELECT p FROM Proyectos p WHERE p.opdContactoMail = :opdContactoMail")
    , @NamedQuery(name = "Proyectos.findByOpdContactoTelefono", query = "SELECT p FROM Proyectos p WHERE p.opdContactoTelefono = :opdContactoTelefono")
    , @NamedQuery(name = "Proyectos.findByCostoTotal", query = "SELECT p FROM Proyectos p WHERE p.costoTotal = :costoTotal")
    , @NamedQuery(name = "Proyectos.findByDineroSolicitado", query = "SELECT p FROM Proyectos p WHERE p.dineroSolicitado = :dineroSolicitado")
    , @NamedQuery(name = "Proyectos.findByAprobado", query = "SELECT p FROM Proyectos p WHERE p.aprobado = :aprobado")
    , @NamedQuery(name = "Proyectos.findByDocConcesion", query = "SELECT p FROM Proyectos p WHERE p.docConcesion = :docConcesion")
    , @NamedQuery(name = "Proyectos.findByFechaConcesion", query = "SELECT p FROM Proyectos p WHERE p.fechaConcesion = :fechaConcesion")
    , @NamedQuery(name = "Proyectos.findByDineroConcedido", query = "SELECT p FROM Proyectos p WHERE p.dineroConcedido = :dineroConcedido")
    , @NamedQuery(name = "Proyectos.findByCd", query = "SELECT p FROM Proyectos p WHERE p.cd = :cd")
    , @NamedQuery(name = "Proyectos.findByCdSedeLocal", query = "SELECT p FROM Proyectos p WHERE p.cdSedeLocal = :cdSedeLocal")
    , @NamedQuery(name = "Proyectos.findByCi", query = "SELECT p FROM Proyectos p WHERE p.ci = :ci")
    , @NamedQuery(name = "Proyectos.findByCiMs", query = "SELECT p FROM Proyectos p WHERE p.ciMs = :ciMs")
    , @NamedQuery(name = "Proyectos.findByCiSocioLocal", query = "SELECT p FROM Proyectos p WHERE p.ciSocioLocal = :ciSocioLocal")
    , @NamedQuery(name = "Proyectos.findByApoCdMs", query = "SELECT p FROM Proyectos p WHERE p.apoCdMs = :apoCdMs")
    , @NamedQuery(name = "Proyectos.findByDuracionReal", query = "SELECT p FROM Proyectos p WHERE p.duracionReal = :duracionReal")
    , @NamedQuery(name = "Proyectos.findByFechaInicio", query = "SELECT p FROM Proyectos p WHERE p.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Proyectos.findByFechaFin", query = "SELECT p FROM Proyectos p WHERE p.fechaFin = :fechaFin")
    , @NamedQuery(name = "Proyectos.findByFechaFinAmpliacion", query = "SELECT p FROM Proyectos p WHERE p.fechaFinAmpliacion = :fechaFinAmpliacion")
    , @NamedQuery(name = "Proyectos.findByDuracionTrasAmpliacion", query = "SELECT p FROM Proyectos p WHERE p.duracionTrasAmpliacion = :duracionTrasAmpliacion")
    , @NamedQuery(name = "Proyectos.findByDuracionif", query = "SELECT p FROM Proyectos p WHERE p.duracionif = :duracionif")
    , @NamedQuery(name = "Proyectos.findByFechaMaximaif", query = "SELECT p FROM Proyectos p WHERE p.fechaMaximaif = :fechaMaximaif")
    , @NamedQuery(name = "Proyectos.findByIngles", query = "SELECT p FROM Proyectos p WHERE p.ingles = :ingles")
    , @NamedQuery(name = "Proyectos.findByFechaCierre", query = "SELECT p FROM Proyectos p WHERE p.fechaCierre = :fechaCierre")
    , @NamedQuery(name = "Proyectos.findByCerrado", query = "SELECT p FROM Proyectos p WHERE p.cerrado = :cerrado")
    , @NamedQuery(name = "Proyectos.findByNumBeneficiarios", query = "SELECT p FROM Proyectos p WHERE p.numBeneficiarios = :numBeneficiarios")
    , @NamedQuery(name = "Proyectos.findByNumBeneficiariosMujeres", query = "SELECT p FROM Proyectos p WHERE p.numBeneficiariosMujeres = :numBeneficiariosMujeres")
    , @NamedQuery(name = "Proyectos.findByNumBeneficiariosHombres", query = "SELECT p FROM Proyectos p WHERE p.numBeneficiariosHombres = :numBeneficiariosHombres")
    , @NamedQuery(name = "Proyectos.findByDescripcionBeneficiarios", query = "SELECT p FROM Proyectos p WHERE p.descripcionBeneficiarios = :descripcionBeneficiarios")
    , @NamedQuery(name = "Proyectos.findByNumBeneficiarioInd", query = "SELECT p FROM Proyectos p WHERE p.numBeneficiarioInd = :numBeneficiarioInd")
    , @NamedQuery(name = "Proyectos.findByNumEntidadesBeneficiarias", query = "SELECT p FROM Proyectos p WHERE p.numEntidadesBeneficiarias = :numEntidadesBeneficiarias")
    , @NamedQuery(name = "Proyectos.findByInformeDonante", query = "SELECT p FROM Proyectos p WHERE p.informeDonante = :informeDonante")
    , @NamedQuery(name = "Proyectos.findByExtinguido", query = "SELECT p FROM Proyectos p WHERE p.extinguido = :extinguido")})
public class Proyectos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_proyecto")
    private Integer codProyecto;
    @Size(max = 3)
    @Column(name = "ong")
    private String ong;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "parte")
    private short parte;
    @Size(max = 20)
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "num_proyecto")
    private Short numProyecto;
    @Size(max = 255)
    @Column(name = "localizacion")
    private String localizacion;
    @Column(name = "anyo")
    private Short anyo;
    @Size(max = 255)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 255)
    @Column(name = "region_sdb")
    private String regionSdb;
    @Size(max = 50)
    @Column(name = "opd")
    private String opd;
    @Size(max = 100)
    @Column(name = "opd_contacto_mail")
    private String opdContactoMail;
    @Size(max = 20)
    @Column(name = "opd_contacto_telefono")
    private String opdContactoTelefono;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo_total")
    private Double costoTotal;
    @Column(name = "dinero_solicitado")
    private Double dineroSolicitado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aprobado")
    private boolean aprobado;
    @Size(max = 255)
    @Column(name = "doc_concesion")
    private String docConcesion;
    @Column(name = "fecha_concesion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaConcesion;
    @Column(name = "dinero_concedido")
    private Double dineroConcedido;
    @Column(name = "cd")
    private Double cd;
    @Column(name = "cd_sede_local")
    private Double cdSedeLocal;
    @Column(name = "ci")
    private Double ci;
    @Column(name = "ci_ms")
    private Double ciMs;
    @Column(name = "ci_socio_local")
    private Double ciSocioLocal;
    @Column(name = "apo_cd_ms")
    private Double apoCdMs;
    @Column(name = "duracion_real")
    private Short duracionReal;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Column(name = "fecha_fin_ampliacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinAmpliacion;
    @Column(name = "duracion_tras_ampliacion")
    private Short duracionTrasAmpliacion;
    @Column(name = "duracionif")
    private Short duracionif;
    @Column(name = "fecha_maximaif")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMaximaif;
    @Size(max = 255)
    @Column(name = "ingles")
    private String ingles;
    @Column(name = "fecha_cierre")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCierre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cerrado")
    private boolean cerrado;
    @Column(name = "num_beneficiarios")
    private Integer numBeneficiarios;
    @Column(name = "num_beneficiarios_mujeres")
    private Integer numBeneficiariosMujeres;
    @Column(name = "num_beneficiarios_hombres")
    private Integer numBeneficiariosHombres;
    @Size(max = 255)
    @Column(name = "descripcion_beneficiarios")
    private String descripcionBeneficiarios;
    @Column(name = "num_beneficiario_ind")
    private Integer numBeneficiarioInd;
    @Size(max = 50)
    @Column(name = "num_entidades_beneficiarias")
    private String numEntidadesBeneficiarias;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "comentarios")
    private String comentarios;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "justificacion")
    private String justificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "informe_donante")
    private boolean informeDonante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "extinguido")
    private boolean extinguido;
    @ManyToMany(mappedBy = "proyectosList")
    private List<Odsprincipal> odsprincipalList;
    @ManyToMany(mappedBy = "proyectosList")
    private List<Crss> crssList;
    @JoinColumn(name = "subcategoria", referencedColumnName = "cod_subcategoria")
    @ManyToOne
    private Subcategorias subcategoria;
    @JoinColumn(name = "responsable_legal", referencedColumnName = "cod_responsable")
    @ManyToOne
    private Responsables responsableLegal;
    @JoinColumn(name = "socio_local", referencedColumnName = "cod_socio")
    @ManyToOne
    private Socioslocales socioLocal;
    @JoinColumn(name = "instrumento", referencedColumnName = "lt")
    @ManyToOne
    private Instrumentos instrumento;
    @JoinColumn(name = "status", referencedColumnName = "cod_status")
    @ManyToOne
    private Status status;
    @JoinColumn(name = "sectorcad", referencedColumnName = "cod_cad")
    @ManyToOne
    private Cads sectorcad;
    @JoinColumn(name = "subsectorms", referencedColumnName = "cod_subsector")
    @ManyToOne
    private Subsectores subsectorms;
    @JoinColumn(name = "target", referencedColumnName = "cod_poblacion")
    @ManyToOne
    private Poblaciones target;
    @JoinColumn(name = "inspectoria", referencedColumnName = "cod_inspectoria")
    @ManyToOne
    private Inspectorias inspectoria;
    @JoinColumn(name = "responsable_local", referencedColumnName = "cod_responsable")
    @ManyToOne
    private Responsables responsableLocal;
    @JoinColumn(name = "sede", referencedColumnName = "cod_sede")
    @ManyToOne
    private Sedes sede;
    @JoinColumn(name = "sectorjyd", referencedColumnName = "cod_sector")
    @ManyToOne
    private Sectorespropios sectorjyd;
    @JoinColumn(name = "sectorms", referencedColumnName = "cod_sector")
    @ManyToOne
    private Sectores sectorms;
    @JoinColumn(name = "opd_contacto_nombre", referencedColumnName = "cod_responsable")
    @ManyToOne
    private Responsables opdContactoNombre;
    @JoinColumn(name = "pais", referencedColumnName = "cod_pais")
    @ManyToOne
    private Paises pais;
    @JoinColumn(name = "subsectorjyd", referencedColumnName = "cod_subsector")
    @ManyToOne
    private Subsectorespropios subsectorjyd;
    @JoinColumn(name = "entidad", referencedColumnName = "codigo")
    @ManyToOne
    private Entidades entidad;
    @JoinColumn(name = "tipo_entidad", referencedColumnName = "cod_tipo")
    @ManyToOne
    private Tiposentidades tipoEntidad;
    @JoinColumn(name = "tipo_proyecto", referencedColumnName = "cod_tipo")
    @ManyToOne
    private Tiposproyecto tipoProyecto;
    @JoinColumn(name = "categoria", referencedColumnName = "cod_categoria")
    @ManyToOne
    private Categorias categoria;
    @JoinColumn(name = "tec_for", referencedColumnName = "cod_tecnico")
    @ManyToOne
    private Tecnicos tecFor;
    @JoinColumn(name = "tec_seg", referencedColumnName = "cod_tecnico")
    @ManyToOne
    private Tecnicos tecSeg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyectos")
    private List<Envios> enviosList;

    public Proyectos() {
    }

    public Proyectos(Integer codProyecto) {
        this.codProyecto = codProyecto;
    }

    public Proyectos(Integer codProyecto, String codigo, short parte, boolean aprobado, boolean cerrado, boolean informeDonante, boolean extinguido) {
        this.codProyecto = codProyecto;
        this.codigo = codigo;
        this.parte = parte;
        this.aprobado = aprobado;
        this.cerrado = cerrado;
        this.informeDonante = informeDonante;
        this.extinguido = extinguido;
    }

    public Integer getCodProyecto() {
        return codProyecto;
    }

    public void setCodProyecto(Integer codProyecto) {
        this.codProyecto = codProyecto;
    }

    public String getOng() {
        return ong;
    }

    public void setOng(String ong) {
        this.ong = ong;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public short getParte() {
        return parte;
    }

    public void setParte(short parte) {
        this.parte = parte;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Short getNumProyecto() {
        return numProyecto;
    }

    public void setNumProyecto(Short numProyecto) {
        this.numProyecto = numProyecto;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public Short getAnyo() {
        return anyo;
    }

    public void setAnyo(Short anyo) {
        this.anyo = anyo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRegionSdb() {
        return regionSdb;
    }

    public void setRegionSdb(String regionSdb) {
        this.regionSdb = regionSdb;
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

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Double getDineroSolicitado() {
        return dineroSolicitado;
    }

    public void setDineroSolicitado(Double dineroSolicitado) {
        this.dineroSolicitado = dineroSolicitado;
    }

    public boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    public String getDocConcesion() {
        return docConcesion;
    }

    public void setDocConcesion(String docConcesion) {
        this.docConcesion = docConcesion;
    }

    public Date getFechaConcesion() {
        return fechaConcesion;
    }

    public void setFechaConcesion(Date fechaConcesion) {
        this.fechaConcesion = fechaConcesion;
    }

    public Double getDineroConcedido() {
        return dineroConcedido;
    }

    public void setDineroConcedido(Double dineroConcedido) {
        this.dineroConcedido = dineroConcedido;
    }

    public Double getCd() {
        return cd;
    }

    public void setCd(Double cd) {
        this.cd = cd;
    }

    public Double getCdSedeLocal() {
        return cdSedeLocal;
    }

    public void setCdSedeLocal(Double cdSedeLocal) {
        this.cdSedeLocal = cdSedeLocal;
    }

    public Double getCi() {
        return ci;
    }

    public void setCi(Double ci) {
        this.ci = ci;
    }

    public Double getCiMs() {
        return ciMs;
    }

    public void setCiMs(Double ciMs) {
        this.ciMs = ciMs;
    }

    public Double getCiSocioLocal() {
        return ciSocioLocal;
    }

    public void setCiSocioLocal(Double ciSocioLocal) {
        this.ciSocioLocal = ciSocioLocal;
    }

    public Double getApoCdMs() {
        return apoCdMs;
    }

    public void setApoCdMs(Double apoCdMs) {
        this.apoCdMs = apoCdMs;
    }

    public Short getDuracionReal() {
        return duracionReal;
    }

    public void setDuracionReal(Short duracionReal) {
        this.duracionReal = duracionReal;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaFinAmpliacion() {
        return fechaFinAmpliacion;
    }

    public void setFechaFinAmpliacion(Date fechaFinAmpliacion) {
        this.fechaFinAmpliacion = fechaFinAmpliacion;
    }

    public Short getDuracionTrasAmpliacion() {
        return duracionTrasAmpliacion;
    }

    public void setDuracionTrasAmpliacion(Short duracionTrasAmpliacion) {
        this.duracionTrasAmpliacion = duracionTrasAmpliacion;
    }

    public Short getDuracionif() {
        return duracionif;
    }

    public void setDuracionif(Short duracionif) {
        this.duracionif = duracionif;
    }

    public Date getFechaMaximaif() {
        return fechaMaximaif;
    }

    public void setFechaMaximaif(Date fechaMaximaif) {
        this.fechaMaximaif = fechaMaximaif;
    }

    public String getIngles() {
        return ingles;
    }

    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public boolean getCerrado() {
        return cerrado;
    }

    public void setCerrado(boolean cerrado) {
        this.cerrado = cerrado;
    }

    public Integer getNumBeneficiarios() {
        return numBeneficiarios;
    }

    public void setNumBeneficiarios(Integer numBeneficiarios) {
        this.numBeneficiarios = numBeneficiarios;
    }

    public Integer getNumBeneficiariosMujeres() {
        return numBeneficiariosMujeres;
    }

    public void setNumBeneficiariosMujeres(Integer numBeneficiariosMujeres) {
        this.numBeneficiariosMujeres = numBeneficiariosMujeres;
    }

    public Integer getNumBeneficiariosHombres() {
        return numBeneficiariosHombres;
    }

    public void setNumBeneficiariosHombres(Integer numBeneficiariosHombres) {
        this.numBeneficiariosHombres = numBeneficiariosHombres;
    }

    public String getDescripcionBeneficiarios() {
        return descripcionBeneficiarios;
    }

    public void setDescripcionBeneficiarios(String descripcionBeneficiarios) {
        this.descripcionBeneficiarios = descripcionBeneficiarios;
    }

    public Integer getNumBeneficiarioInd() {
        return numBeneficiarioInd;
    }

    public void setNumBeneficiarioInd(Integer numBeneficiarioInd) {
        this.numBeneficiarioInd = numBeneficiarioInd;
    }

    public String getNumEntidadesBeneficiarias() {
        return numEntidadesBeneficiarias;
    }

    public void setNumEntidadesBeneficiarias(String numEntidadesBeneficiarias) {
        this.numEntidadesBeneficiarias = numEntidadesBeneficiarias;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public boolean getInformeDonante() {
        return informeDonante;
    }

    public void setInformeDonante(boolean informeDonante) {
        this.informeDonante = informeDonante;
    }

    public boolean getExtinguido() {
        return extinguido;
    }

    public void setExtinguido(boolean extinguido) {
        this.extinguido = extinguido;
    }

    @XmlTransient
    public List<Odsprincipal> getOdsprincipalList() {
        return odsprincipalList;
    }

    public void setOdsprincipalList(List<Odsprincipal> odsprincipalList) {
        this.odsprincipalList = odsprincipalList;
    }

    @XmlTransient
    public List<Crss> getCrssList() {
        return crssList;
    }

    public void setCrssList(List<Crss> crssList) {
        this.crssList = crssList;
    }

    public Subcategorias getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(Subcategorias subcategoria) {
        this.subcategoria = subcategoria;
    }

    public Responsables getResponsableLegal() {
        return responsableLegal;
    }

    public void setResponsableLegal(Responsables responsableLegal) {
        this.responsableLegal = responsableLegal;
    }

    public Socioslocales getSocioLocal() {
        return socioLocal;
    }

    public void setSocioLocal(Socioslocales socioLocal) {
        this.socioLocal = socioLocal;
    }

    public Instrumentos getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(Instrumentos instrumento) {
        this.instrumento = instrumento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Cads getSectorcad() {
        return sectorcad;
    }

    public void setSectorcad(Cads sectorcad) {
        this.sectorcad = sectorcad;
    }

    public Subsectores getSubsectorms() {
        return subsectorms;
    }

    public void setSubsectorms(Subsectores subsectorms) {
        this.subsectorms = subsectorms;
    }

    public Poblaciones getTarget() {
        return target;
    }

    public void setTarget(Poblaciones target) {
        this.target = target;
    }

    public Inspectorias getInspectoria() {
        return inspectoria;
    }

    public void setInspectoria(Inspectorias inspectoria) {
        this.inspectoria = inspectoria;
    }

    public Responsables getResponsableLocal() {
        return responsableLocal;
    }

    public void setResponsableLocal(Responsables responsableLocal) {
        this.responsableLocal = responsableLocal;
    }

    public Sedes getSede() {
        return sede;
    }

    public void setSede(Sedes sede) {
        this.sede = sede;
    }

    public Sectorespropios getSectorjyd() {
        return sectorjyd;
    }

    public void setSectorjyd(Sectorespropios sectorjyd) {
        this.sectorjyd = sectorjyd;
    }

    public Sectores getSectorms() {
        return sectorms;
    }

    public void setSectorms(Sectores sectorms) {
        this.sectorms = sectorms;
    }

    public Responsables getOpdContactoNombre() {
        return opdContactoNombre;
    }

    public void setOpdContactoNombre(Responsables opdContactoNombre) {
        this.opdContactoNombre = opdContactoNombre;
    }

    public Paises getPais() {
        return pais;
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }

    public Subsectorespropios getSubsectorjyd() {
        return subsectorjyd;
    }

    public void setSubsectorjyd(Subsectorespropios subsectorjyd) {
        this.subsectorjyd = subsectorjyd;
    }

    public Entidades getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidades entidad) {
        this.entidad = entidad;
    }

    public Tiposentidades getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(Tiposentidades tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }

    public Tiposproyecto getTipoProyecto() {
        return tipoProyecto;
    }

    public void setTipoProyecto(Tiposproyecto tipoProyecto) {
        this.tipoProyecto = tipoProyecto;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public Tecnicos getTecFor() {
        return tecFor;
    }

    public void setTecFor(Tecnicos tecFor) {
        this.tecFor = tecFor;
    }

    public Tecnicos getTecSeg() {
        return tecSeg;
    }

    public void setTecSeg(Tecnicos tecSeg) {
        this.tecSeg = tecSeg;
    }

    @XmlTransient
    public List<Envios> getEnviosList() {
        return enviosList;
    }

    public void setEnviosList(List<Envios> enviosList) {
        this.enviosList = enviosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProyecto != null ? codProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectos)) {
            return false;
        }
        Proyectos other = (Proyectos) object;
        if ((this.codProyecto == null && other.codProyecto != null) || (this.codProyecto != null && !this.codProyecto.equals(other.codProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Proyectos[ codProyecto=" + codProyecto + " ]";
    }
    
}
