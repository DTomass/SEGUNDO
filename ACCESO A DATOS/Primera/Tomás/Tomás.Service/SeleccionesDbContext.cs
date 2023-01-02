using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using Tomás.Modelos;

namespace Tomás.Service
{
    public class SeleccionesDbContext : DbContext
    {
        public SeleccionesDbContext(DbContextOptions<SeleccionesDbContext> options) : base(options)
        {
            
        }
        public DbSet<Seleccion> selecciones { get; set; }
    }
}
