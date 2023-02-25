using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using MVC23.Models;

namespace MVC23.Controllers
{
    public class VehiculoController : Controller
    {
        public class VehiculoTotal
        {
            public string Nom_Marca { get; set; }
            public string Nom_Serie { get; set; }
            public string Color { get; set; }
            public string Matricula { get; set; }
        }
        public Contexto contexto { get;}
        public VehiculoController(Contexto contexto)
        {
            this.contexto = contexto;
        }
        // GET: VehiculoController
        public ActionResult Index()
        {
            return View(contexto.Vehiculos.ToList());
        }

        public ActionResult Listado(int ID)
        {
            ViewBag.lasMarcas = contexto.Marcas.ToList();
            SerieModelo serie = contexto.Series.Include("Vehiculos").FirstOrDefault(s => s.ID == ID);
            return View(serie);
        }

        public ActionResult Listado2(int marcaID=1, int serieID=0)
        {
            ViewBag.MarcasList = new SelectList(contexto.Marcas, "ID", "Nom_Marca");
            ViewBag.SeriesList = new SelectList(contexto.Series, "ID", "Nom_Serie");
            List<VehiculoModelo> vehiculos = contexto.Vehiculos.ToList();
            return View(vehiculos);
        }

        public ActionResult Listado3(int marcaID = 1, int serieID = 0)
        {
            List<VehiculoTotal> lista = contexto.Database.SqlQuery<VehiculoTotal>($"dbo.getSeriesVehiculos").ToList();
            return View(lista);
        }

        public ActionResult Listado4(int marcaID = 1, int serieID = 0)
        {
            var lista = contexto.VistaTotal.FromSql($"EXECUTE getSeriesVehiculos").ToList();
            return View(lista);
        }

        // GET: VehiculoController/Details/5
        public ActionResult Details(int id)
        {
            ViewBag.SerieID = new SelectList(contexto.Series, "ID", "Nom_Serie");
            VehiculoModelo vehiculo = contexto.Vehiculos.Find(id);
            return View(vehiculo);
        }

        // GET: VehiculoController/Create
        public ActionResult Create()
        {
            ViewBag.SerieID = new SelectList(contexto.Series, "ID", "Nom_Serie");
            ViewBag.VehiculosExtras = new MultiSelectList(contexto.Vehiculos, "ID", "Nom_Extra");
            return View();
        }

        // POST: VehiculoController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(VehiculoModelo vehiculo)
        {
            try
            {
                contexto.Vehiculos.Add(vehiculo);
                contexto.SaveChanges();

                foreach (var extraID in vehiculo.ExtraSeleccionados)
                {
                    var obj = new VehiculoExtraModelo() { ExtraID = extraID, VehiculoID = vehiculo.ID };
                    contexto.VehiculoExtra.Add(obj);
                }
                contexto.SaveChanges();
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: VehiculoController/Edit/5
        public ActionResult Edit(int id)
        {
            VehiculoModelo vehiculo = contexto.Vehiculos.Find(id);
            vehiculo.ExtraSeleccionados=contexto.VehiculoExtra.Where(a => a.VehiculoID == id).Select(a => a.ExtraID).ToList();
            ViewBag.SerieID = new SelectList(contexto.Series, "ID", "Nom_Serie");
            ViewBag.VehiculoExtras = new MultiSelectList(contexto.Extras, "ID", "Nom_Extra");
            return View(vehiculo);
        }

        // POST: VehiculoController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, VehiculoModelo vehiculoActualizado)
        {
            try
            {
                VehiculoModelo vehiculo = contexto.Vehiculos.Find(id);
                vehiculo.Matricula = vehiculoActualizado.Matricula;
                vehiculo.Color = vehiculoActualizado.Color;
                vehiculo.SerieID = vehiculoActualizado.SerieID;
                var extraActuales = contexto.VehiculoExtra.Where(v => v.VehiculoID == vehiculo.ID).ToList();
                foreach (VehiculoExtraModelo extra in extraActuales)
                {
                    contexto.VehiculoExtra.Remove(extra);
                }
                for (int i = 0; i < vehiculoActualizado.ExtraSeleccionados.Count(); i++)
                {
                    vehiculo.ExtraSeleccionados.Add(vehiculoActualizado.ExtraSeleccionados[i]);
                }
                contexto.SaveChanges();
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: VehiculoController/Delete/5
        public ActionResult Delete(int id)
        {
            VehiculoModelo vehiculo = contexto.Vehiculos.Include(v => v.Serie).FirstOrDefault(v => v.ID == id);
            return View(vehiculo);
        }

        // POST: VehiculoController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, IFormCollection collection)
        {
            try
            {
                VehiculoModelo vehiculo = contexto.Vehiculos.Find(id);
                contexto.Vehiculos.Remove(vehiculo);
                contexto.SaveChanges();
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}
