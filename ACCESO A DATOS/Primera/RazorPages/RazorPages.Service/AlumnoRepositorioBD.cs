﻿using System;
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
            IEnumerable<Alumno> consulta = context.Alumnos;

            if (curso.HasValue)
            {
                consulta = context.Alumnos.Where(a => a.CursoID == curso);
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
                return context.Alumnos;
            }
            return context.Alumnos.Where(a => a.Nombre.Contains(elementoABuscar) || a.Email.Contains(elementoABuscar));
        }

        public void Delete(int id)
        {
            var alumnoABorrar = GetAlumno(id);
            if (alumnoABorrar != null)
            {
                context.Alumnos.Remove(alumnoABorrar);
            }
        }

        public IEnumerable<Alumno> GetAllAlumnos()
        {
            return context.Alumnos;
        }

        public Alumno GetAlumno(int id)
        {
            return context.Alumnos.Find(id); //Busca por el campo que sea primary key
        }

        public Alumno Update(Alumno alumnoActualizado)
        {
            var alumno = context.Alumnos.Attach(alumnoActualizado);
            alumno.State = Microsoft.EntityFrameworkCore.EntityState.Modified;
            
            return alumnoActualizado;
        }
    }
}