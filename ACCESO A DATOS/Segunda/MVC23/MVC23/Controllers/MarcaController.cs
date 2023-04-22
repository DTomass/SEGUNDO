using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using MVC23.Models;

namespace MVC23.Controllers
{
    public class MarcaController : Controller
    {
        public Contexto Contexto { get; }

        public MarcaController(Contexto contexto)
        {
            Contexto = contexto;
            Contexto.Database.EnsureCreated();
        }



        // GET: MarcaController
        public ActionResult Index()
        {
            var lista = Contexto.Marcas.ToList();
            return View(lista);
        }

        public ActionResult Listado()
        {
            List<MarcaModelo> lista = Contexto.Marcas.Include("Series").ToList();
            return View(lista);
        }

        public ActionResult Desplegable()
        {
            ViewBag.Marcas = new SelectList(Contexto.Marcas, "ID", "Nom_Marca");
            ViewBag.Marcas2 = Contexto.Marcas.ToList();
            return View();
        }

        // GET: MarcaController/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: MarcaController/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: MarcaController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(MarcaModelo marca)
        {
            try
            {
                Contexto.Add(marca);
                Contexto.Database.EnsureCreated();
                Contexto.SaveChanges();
                return RedirectToAction(nameof(Create));
            }
            catch
            {
                return View("Create");
            }
        }

        // GET: MarcaController/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: MarcaController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, IFormCollection collection)
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

        // GET: MarcaController/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: MarcaController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, IFormCollection collection)
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
    }
}
