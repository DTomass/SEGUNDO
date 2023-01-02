using System.ComponentModel.DataAnnotations;

namespace Tomás.Modelos
{
    public class Seleccion
    {
        [Key]
        public int Codigo { get; set; }
        public string NomPais { get; set; }
        public string Bandera { get; set; }
        public int NumTitulos { get; set; }
        public Grupos Grupo { get; set; }
    }
}