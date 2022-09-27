using RazorPages.Modelos;
namespace RazorPages.Service
{
    public interface IAlumnoRepositorio
    {
        IEnumerable<Alumno> GetAllAlumnos()
    }
}