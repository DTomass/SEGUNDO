using Microsoft.AspNetCore.Mvc;
using RazorPages.Service;

namespace RazorPages.Componentes
{
    public class AlumnosCursoViewComponent : ViewComponent
    {
        private readonly IAlumnoRepositorio alumnoRepositorio;

        public AlumnosCursoViewComponent(IAlumnoRepositorio alumnoRepositorio)
        {
            this.alumnoRepositorio = alumnoRepositorio;
        }

        public IViewComponentResult Invoke()
        {
            var resultado = alumnoRepositorio.AlumnosPorCurso();
            return View();
        }
    }
}
