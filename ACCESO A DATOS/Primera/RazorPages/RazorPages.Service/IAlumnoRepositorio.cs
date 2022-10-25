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
        Alumno Delete(int id);
        IEnumerable<CursoCuantos> AlumnosPorCurso();
    }
}