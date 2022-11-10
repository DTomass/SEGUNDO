using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using RazorPages.Modelos;
using RazorPages.Service;

namespace RazorPages.Pages.Alumnos
{
    public class IndexModel : PageModel
    {
        public IEnumerable<Alumno> Alumnos { get; set; }

        private readonly IAlumnoRepositorio alumnoRepositorio;
        [BindProperty(SupportsGet = true)]
        public string elementoABuscar { get; set; }
        public IndexModel(IAlumnoRepositorio alumnoRepositorio)
        {
            this.alumnoRepositorio = alumnoRepositorio;
        }
        public void OnGet()
        {
            Alumnos = alumnoRepositorio.Busqueda(elementoABuscar);
        }
    }
}
