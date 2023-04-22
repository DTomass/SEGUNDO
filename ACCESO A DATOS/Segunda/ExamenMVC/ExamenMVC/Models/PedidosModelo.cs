using System.ComponentModel.DataAnnotations.Schema;

namespace ExamenMVC.Models
{
    public class PedidosModelo
    {
        public int ID { get; set; }
        public DateTime FechaPedido { get; set; }
        public int ProveedorID { get; set; }
        public ProveedoresModelo Proveedor { get; set; }

        [NotMapped]
        public List<int> ProductosSeleccionados { get; set; }
        public List<PedidiosProductosModelo> pedidiosProductos { get; set; }

    }
}
