using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using MVC23.Models;

namespace MVC23.Controllers
{
    public class VehiculoController : Controller
    {
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
            return View();
        }

        // POST: VehiculoController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(IFormCollection collection)
        {
            try
            {
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
            ViewBag.SerieID = new SelectList(contexto.Series, "ID", "Nom_Serie");
            VehiculoModelo vehiculo = contexto.Vehiculos.Find(id);
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
