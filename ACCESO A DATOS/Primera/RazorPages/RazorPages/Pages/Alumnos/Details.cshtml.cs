using Microsoft.AspNetCore.Mvc.RazorPages;
using RazorPages.Service;
using RazorPages.Modelos;

namespace RazorPages.Pages.Alumnos
{
    public class DetailsModel : PageModel
    {
        public Alumno alumno { get; set; }
        private readonly IAlumnoRepositorio AlumnoRepositorio;
        public DetailsModel(IAlumnoRepositorio alumnoRepositorio)
        {
            this.AlumnoRepositorio = alumnoRepositorio;
        }
        
        public void OnGet(int id)
        {
            alumno = AlumnoRepositorio.GetAlumno(id);
        }
    }
}
