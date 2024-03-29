//------------------------------------------------------------------------------
// <auto-generated>
//     Este código se generó a partir de una plantilla.
//
//     Los cambios manuales en este archivo pueden causar un comportamiento inesperado de la aplicación.
//     Los cambios manuales en este archivo se sobrescribirán si se regenera el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace WorkFlowXAPI
{
    using System;
    using System.Collections.Generic;
    
    public partial class Trabajadores
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public Trabajadores()
        {
            this.Departamentos = new HashSet<Departamentos>();
            this.Equipos1 = new HashSet<Equipos>();
            this.Tareas = new HashSet<Tareas>();
            this.Trabajadores1 = new HashSet<Trabajadores>();
        }
    
        public int ID { get; set; }
        public int Equipo_ID { get; set; }
        public Nullable<int> Responsable_ID { get; set; }
        public string Nombre { get; set; }
        public string Apellidos { get; set; }
        public string DNI { get; set; }
        public string Direccion { get; set; }
        public Nullable<System.DateTime> FNacimiento { get; set; }
        public string Email { get; set; }
        public string Telefono { get; set; }
        public Nullable<int> Rol { get; set; }
        public Nullable<bool> Activo { get; set; }
    
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<Departamentos> Departamentos { get; set; }
        public virtual Equipos Equipos { get; set; }
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<Equipos> Equipos1 { get; set; }
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<Tareas> Tareas { get; set; }
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<Trabajadores> Trabajadores1 { get; set; }
        public virtual Trabajadores Trabajadores2 { get; set; }
    }
}
