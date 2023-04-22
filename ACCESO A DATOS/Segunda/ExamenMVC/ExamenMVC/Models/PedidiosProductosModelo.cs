namespace ExamenMVC.Models
{
    public class PedidiosProductosModelo
    {
        public int ID { get; set; }
        public int PedidoID { get; set; }
        public int ProductoID { get; set; }
        public PedidosModelo Pedido { get; set; }
        public ProductosModelo Producto { get; set; }
    }
}
