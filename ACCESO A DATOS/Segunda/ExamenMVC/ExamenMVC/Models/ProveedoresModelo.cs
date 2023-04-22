using System.ComponentModel.DataAnnotations.Schema;

namespace ExamenMVC.Models
{
    public class ProveedoresModelo
    {
        public int ID { get; set; }
        public string NomProveedor { get; set; }
        [NotMapped]
        public List<int> ProductosSeleccionados { get; set; }
        public List<ProvProdModelo> ProveedoresProductos { get; set; }
        
        public List<PedidosModelo> Pedidos { get; set; }
    }
}
