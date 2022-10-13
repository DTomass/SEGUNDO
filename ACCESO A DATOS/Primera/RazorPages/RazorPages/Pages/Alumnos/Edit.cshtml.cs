using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using RazorPages.Modelos;
using RazorPages.Service;

namespace RazorPages.Pages.Alumnos
{
    public class EditModel : PageModel
    {
        private readonly IAlumnoRepositorio alumnoRepositorio;
        public Alumno alumno { get; set; }
        public EditModel(IAlumnoRepositorio alumnoRepositorio)
        {
            this.alumnoRepositorio = alumnoRepositorio;
        }
        public void OnGet(int ID)
        {
            alumno = alumnoRepositorio.GetAlumno(ID);
        }
        public IActionResult OnPost(Alumno alumno)
        {
            alumnoRepositorio.Update(alumno);
            return RedirectToPage("Index");
        }
    }
}
