using ExamenMVC.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace ExamenMVC.Controllers
{
    public class ProveedorController : Controller
    { 
        public Contexto Contexto { get; set; }
        public ProveedorController(Contexto contexto)
        {
            Contexto = contexto;
            Contexto.Database.EnsureCreated();
        }
        // GET: ProveedorController
        public ActionResult Index()
        {
            List<ProveedoresModelo> proveedores = Contexto.Proveedores.Include(p => p.Pedidos).ToList();
            return View(proveedores);
        }

        // GET: ProveedorController/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: ProveedorController/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: ProveedorController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(ProveedoresModelo proveedor)
        {
            try
            {
                Contexto.Proveedores.Add(proveedor);
                Contexto.SaveChanges();
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: ProveedorController/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: ProveedorController/Edit/5
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

        // GET: ProveedorController/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: ProveedorController/Delete/5
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
