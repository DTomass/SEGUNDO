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
        public IFormFile Photo { get; set; }
        public IWebHostEnvironment WebHostEnvironment { get; set; }
        public EditModel(IAlumnoRepositorio alumnoRepositorio, IWebHostEnvironment webHostEnvironment)
        {
            this.alumnoRepositorio = alumnoRepositorio;
            WebHostEnvironment = webHostEnvironment;
        }
        public IActionResult OnGet(int? ID)
        {
            if (ID.HasValue)
            {
                alumno = alumnoRepositorio.GetAlumno(ID.Value);
            }
            else
            {
                alumno = new Alumno();
            }
            return Page();
        }
        public IActionResult OnPost(Alumno alumno)
        {
            if(Photo != null){
                if (alumno.Foto != null)
                {
                    string 
                }
            }
            alumnoRepositorio.Update(alumno);
            return RedirectToPage("Index");
        }
        private string ProcessUploadedFile()
        {
            if (Photo != null)
            {
                string uploadsFolder = Path.Combine(WebHostEnvironment.WebRootPath, "images");
                string filePath = Path.Combine(uploadsFolder, Photo.FileName);
                FileStream fileStream = new FileStream(filePath, FileMode.Create);

                {
                    Photo.CopyTo(fileStream);
                }
            }
            return Photo.FileName;
        }
    }
}
