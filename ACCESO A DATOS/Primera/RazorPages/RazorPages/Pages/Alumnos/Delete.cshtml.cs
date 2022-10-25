using System.Runtime.CompilerServices;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using RazorPages.Modelos;
using RazorPages.Service;

namespace RazorPages.Pages.Alumnos
{
    public class DeleteModel : PageModel
    {
        private readonly IAlumnoRepositorio alumnoRepositorio;
        public Alumno alumno;
        public DeleteModel(IAlumnoRepositorio alumnoRepositorio)
        {
            this.alumnoRepositorio = alumnoRepositorio;
        }
        public void OnGet(int id)
        {
            alumno = alumnoRepositorio.GetAlumno(id);
        }
    }
}
