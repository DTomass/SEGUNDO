namespace ExamenMVC.Models
{
    public class ProvProdModelo
    {
        public int ID { get; set; }
        public int ProveedorID { get; set; }
        public int ProductoID { get; set; }
        public ProveedoresModelo Proveedor { get; set; }
        public ProductosModelo Producto { get; set; }
    }
}
