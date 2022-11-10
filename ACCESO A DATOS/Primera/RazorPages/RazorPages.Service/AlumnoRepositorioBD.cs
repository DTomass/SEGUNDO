using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using RazorPages.Modelos;

namespace RazorPages.Service
{
    public class AlumnoRepositorioBD : IAlumnoRepositorio
    {
        private readonly AlumnoDBContext context;

        public AlumnoRepositorioBD(AlumnoDBContext context)
        {
            this.context = context;
        }
        public Alumno Add(Alumno alumnoNuevo)
        {
            context.Alumnos.Add(alumnoNuevo);
            context.SaveChanges();
            return alumnoNuevo;
        }

        public IEnumerable<CursoCuantos> AlumnosPorCurso(Curso? curso = null)
        {
            throw new NotImplementedException();
        }

        public IEnumerable<Alumno> Busqueda(string elementoABuscar)
        {
            throw new NotImplementedException();
        }

        public Alumno Delete(int id)
        {
            throw new NotImplementedException();
        }

        public IEnumerable<Alumno> GetAllAlumnos()
        {
            throw new NotImplementedException();
        }

        public Alumno GetAlumno(int id)
        {
            throw new NotImplementedException();
        }

        public Alumno Update(Alumno alumnoActualizado)
        {
            throw new NotImplementedException();
        }
    }
}