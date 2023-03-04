using Microsoft.EntityFrameworkCore;
using MVC23.Models;

namespace MVC23.Models
{
    public class Contexto :DbContext
    {
        public Contexto(DbContextOptions<Contexto> options) : base(options)
        {

        }
        protected override void OnModelCreating(ModelBuilder model)
        {
            model
                .Entity<VehiculoModelo>(
                eb =>
                {
                    eb.HasNoKey();
                });
        }
        public DbSet<MarcaModelo> Marcas { get; set; }
        public DbSet<SerieModelo> Series { get; set; }
        public DbSet<VehiculoModelo> Vehiculos { get; set; }
        public DbSet<VehiculoModelo> VistaTotal { get; set; }
        public DbSet<ExtraModelo> Extras { get; set; }
        public DbSet<VehiculoExtraModelo> VehiculoExtra { get; set; }

    }
}
