using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using RazorPages.Modelos;

namespace RazorPages.Service
{
    public class AlumnoDBContext : DbContext
    {
        public AlumnoDBContext(DbContextOptions<AlumnoDBContext> options) : base(options)
        {

        }

        public DbSet<Alumno> Alumnos { get; set; }
    }
}
