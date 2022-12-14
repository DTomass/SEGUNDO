using System.Dynamic;
using RazorPages.Modelos;
namespace RazorPages.Service
{
    public interface IAlumnoRepositorio
    {
        IEnumerable<Alumno> GetAllAlumnos();
        Alumno GetAlumno(int id);
        Alumno Update(Alumno alumnoActualizado);
        Alumno Add(Alumno alumnoNuevo);
        void Delete(int id);
        IEnumerable<CursoCuantos> AlumnosPorCurso(Curso? curso=null);
        IEnumerable<Alumno> Busqueda(string elementoABuscar);
        
    }
}