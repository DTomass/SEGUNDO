using Microsoft.AspNetCore.Mvc;
using Tomás.Modelos;
using Tomás.Service;

namespace Tomás.Components
{
    public class SeleccionesGrupoViewComponent : ViewComponent
    {
        private readonly SeleccionesRepositorioDb seleccionesRepositorio;

        public SeleccionesGrupoViewComponent(SeleccionesRepositorioDb seleccionesRepositorio)
        {
            this.seleccionesRepositorio = seleccionesRepositorio;
        }

        public IViewComponentResult Invoke(Grupos? grupos = null)
        {
            var resultado = seleccionesRepositorio.SeleccionesPorGrupos(grupos);
            return View(resultado);
        }
    }
}
