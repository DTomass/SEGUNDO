using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using RazorPages.Modelos;

namespace RazorPages.Service
{
    public class AlumnoRepositorio : IAlumnoRepositorio
    {
        public List<Alumno> ListaAlumnos;
        public AlumnoRepositorio()
        {
            ListaAlumnos = new List<Alumno>()
            {
                new Alumno() { Id = 1, Nombre = "Diego Blas", CursoID = Curso.H2, Email = "diego.blas@gmail.com", Foto = "blas.jpg"},
                new Alumno() { Id = 2, Nombre = "Javier Burillo", CursoID = Curso.H2, Email = "javier.burillo@gmail.com", Foto = "burillo.jpg" },
                new Alumno() { Id = 3, Nombre = "David Fron", CursoID = Curso.H2, Email = "david.fron@gmail.com", Foto = "fron.jpg" },
                new Alumno() { Id = 4, Nombre = "Jon Fernandez", CursoID = Curso.H2, Email = "jon.fernandez@gmail.com", Foto = "fernandez.jpg" },
                new Alumno() { Id = 5, Nombre = "Alejandro Guardiola", CursoID = Curso.H2, Email = "alejandro.guardiola@gmail.com", Foto = "guardiola.jpg" }
            };
        }
        public IEnumerable<Alumno> GetAllAlumnos()
        {
            return ListaAlumnos;
        }
        public Alumno GetAlumno(int id)
        {
            return ListaAlumnos.FirstOrDefault(a => a.Id == id);
        }

        public Alumno Update(Alumno alumnoActualizado)
        {
            Alumno alumno = ListaAlumnos.FirstOrDefault(a => a.Id == alumnoActualizado.Id);
            alumno.Nombre = alumnoActualizado.Nombre;
            alumno.Email = alumnoActualizado.Email;
            alumno.CursoID = alumnoActualizado.CursoID;

            return alumno;
        }
    }
}
