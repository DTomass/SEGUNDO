using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Tomás.Modelos;
using Tomás.Service;

namespace Tomás.Pages.Grupos
{
    public class GruposModel : PageModel
    {
        public IEnumerable<Seleccion> Seleccion { get; set; }
        private readonly SeleccionesRepositorioDb seleccionesRepositorio;
        public GruposModel(SeleccionesRepositorioDb seleccionesRepositorioDb)
        {
            this.seleccionesRepositorio = seleccionesRepositorioDb;
        }
        public void OnGet()
        {
            Seleccion = seleccionesRepositorio.GetAllSelecciones().ToList();
        }
    }
}
