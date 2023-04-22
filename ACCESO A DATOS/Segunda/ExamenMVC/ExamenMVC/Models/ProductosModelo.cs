using System.ComponentModel.DataAnnotations.Schema;

namespace ExamenMVC.Models
{
    public class ProductosModelo
    {
        public int ID { get; set; }
        public string NomProducto { get; set; }
        [NotMapped]
        public List<int> ProveedoresSeleccionados { get; set; }
        public List<ProvProdModelo> ProveedoresProductos { get; set; }
    }
}
