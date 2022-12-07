using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using RazorPages.Alumnos;
using RazorPages.Modelos;

namespace RazorPages.Services
{
    public class AlumnoRepositorio : IAlumnoRepositorio
    {
        public List<Alumno> listaAlumnos;
        public AlumnoRepositorio()
        {
            listaAlumnos = new List<Alumno>()
            {
                new Alumno() { Id = 1, Nombre = "Diego Blas", Email = "diego@gmail.com", Foto = "blas.jpg", CursoId = Curso.H1 },
                new Alumno() { Id = 2, Nombre = "Javier Burillo", Email = "javier@gmail.com", Foto = "burillo.jpg", CursoId = Curso.H2 },
                new Alumno() { Id = 3, Nombre = "Javier Guardiola", Email = "guardiola@gmail.com", Foto = "guardiola.jpg", CursoId = Curso.H1 },
                new Alumno() { Id = 4, Nombre = "Jon Fernandez", Email = "jon@gmail.com", Foto = "fernandez.jpg", CursoId = Curso.E1 },
                new Alumno() { Id = 5, Nombre = "David Fron", Email = "fron@gmail.com", Foto = "fron.jpg", CursoId = Curso.E2 }
            };
        }

        public IEnumerable<Alumno> GetAllAlumnos()
        {
            return listaAlumnos;
        }
    }
}
