using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Tomás.Service;
using Tomás.Modelos;

namespace Tomás.Pages.Selecciones
{
    public class EditModel : PageModel
    {
        private readonly SeleccionesRepositorioDb seleccionesRepository;
        public Seleccion Seleccion { get; set; }
        public IFormFile Photo { get; set; }
        public IWebHostEnvironment WebHostEnvironment { get; set; }
        public EditModel(SeleccionesRepositorioDb seleccionesRepositorio, IWebHostEnvironment webHostEnvironment)
        {
            this.seleccionesRepository = seleccionesRepositorio;
            WebHostEnvironment = webHostEnvironment;
        }
        public IActionResult OnGet(int? ID)
        {
            Seleccion = seleccionesRepository.GetSeleccion(ID.Value);
            return Page();
        }
        public IActionResult OnPost(Seleccion seleccion)
        {
            if (Photo != null)
            {
                if (seleccion.Bandera != null)
                {
                    string filePath = Path.Combine(WebHostEnvironment.WebRootPath, "images", seleccion.Bandera);
                    System.IO.File.Delete(filePath);
                }
            }
            seleccionesRepository.Update(seleccion);
            return RedirectToPage("Selecciones");
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
