using Microsoft.AspNetCore.Mvc.RazorPages;
using Tomás.Service;
using Tomás.Modelos;

namespace Tomás.Pages.Selecciones
{
    public class SeleccionesModel : PageModel
    {
        public IEnumerable<Seleccion> Seleccion { get; set; }
        private readonly SeleccionesRepositorioDb seleccionesRepositorio;
        public SeleccionesModel(SeleccionesRepositorioDb seleccionesRepositorioDb)
        {
            this.seleccionesRepositorio = seleccionesRepositorioDb;
        }
        public void OnGet()
        {
            Seleccion = seleccionesRepositorio.GetAllSelecciones().ToList();
        }
    }
}
