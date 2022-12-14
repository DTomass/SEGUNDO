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
                new Alumno() { Id = 2, Nombre = "Javier Burillo", CursoID = Curso.H1, Email = "javier.burillo@gmail.com", Foto = "burillo.jpg" },
                new Alumno() { Id = 3, Nombre = "David Fron", CursoID = Curso.H1, Email = "david.fron@gmail.com", Foto = "fron.jpg" },
                new Alumno() { Id = 4, Nombre = "Jon Fernandez", CursoID = Curso.H1, Email = "jon.fernandez@gmail.com", Foto = "fernandez.jpg" },
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
            alumno.Foto = alumnoActualizado.Foto;

            return alumno;
        }
        public Alumno Add(Alumno alumnoNuevo)
        {
            alumnoNuevo.Id = ListaAlumnos.Max(a=>a.Id) + 1;
            ListaAlumnos.Add(alumnoNuevo);
            return alumnoNuevo;
        }

        public IEnumerable<CursoCuantos> AlumnosPorCurso(Curso? curso)
        {
            IEnumerable<Alumno> consulta = ListaAlumnos;
            if (curso.HasValue)
            {
                consulta = consulta.Where(c => c.CursoID == curso);
            }
            return consulta.GroupBy(a => a.CursoID)
                .Select(g => new CursoCuantos()
                {
                    Clase = g.Key.Value,
                    NumAlumnos = g.Count()
                }).ToList();
        }

        public IEnumerable<Alumno> Busqueda(string elementoABuscar)
        {
            if (string.IsNullOrEmpty(elementoABuscar))
            {
                return ListaAlumnos;
            }
            return ListaAlumnos.Where(a => a.Nombre.Contains(elementoABuscar)).ToList();
        }

        void IAlumnoRepositorio.Delete(int id)
        {
            Alumno alumno = GetAlumno(id);
            ListaAlumnos.Remove(alumno);
        }
    }
}
