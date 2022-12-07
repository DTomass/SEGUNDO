using RazorPages.Modelos;
namespace RazorPages.Alumnos
{
    public interface IAlumnoRepositorio
    {
        IEnumerable<Alumno> GetAllAlumnos();
    }
}