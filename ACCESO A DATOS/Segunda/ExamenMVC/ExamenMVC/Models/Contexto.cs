using Microsoft.EntityFrameworkCore;

namespace ExamenMVC.Models
{
    public class Contexto : DbContext
    {
        public Contexto(DbContextOptions<Contexto> options) : base(options)
        {
        }   
        public DbSet<PedidiosProductosModelo> PedidiosProductos { get; set; }
        public DbSet<ProductosModelo> Productos { get; set; }
        public DbSet<ProveedoresModelo> Proveedores { get; set; }
        public DbSet<ProvProdModelo> ProveedoresProductos { get; set; }
        public DbSet<PedidosModelo> Pedidos { get; set; }
    }
}
