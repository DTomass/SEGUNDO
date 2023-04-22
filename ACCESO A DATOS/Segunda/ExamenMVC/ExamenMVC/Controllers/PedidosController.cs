using ExamenMVC.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;

namespace ExamenMVC.Controllers
{
    public class PedidosController : Controller
    {
        public Contexto Contexto { get; set; }
        public PedidosController(Contexto contexto) 
        {
            Contexto = contexto;
            Contexto.Database.EnsureCreated();
        }
        // GET: PedidosController
        public ActionResult Index()
        {
            List<PedidosModelo> pedidos = Contexto.Pedidos.Include(p => p.Proveedor).ToList();
            return View(pedidos);
        }
        public ActionResult Listado(int id)
        {
            List<ProductosModelo> productos = Contexto.PedidiosProductos.Include(p => p.Producto).Where(p => p.PedidoID == id).Select(p => p.Producto).ToList();
            return View(productos);
        }

        // GET: PedidosController/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }
        
        [HttpGet]
        public IActionResult GetProductos(int proveedorID)
        {
            var productos = new SelectList(Contexto.ProveedoresProductos.Where(p => p.ProveedorID == proveedorID).Include(p => p.Producto).Select(p => p.Producto), "ID", "NomProducto");
            var productosJson = productos.Select(p => new { value = p.Value, text = p.Text }).ToList();
            return Json(productos);
        }
        //GET: PedidosController/Create
        public ActionResult Create()
        {
            ViewBag.ProveedorID = new SelectList(Contexto.Proveedores, "ID", "NomProveedor");
            return View();
        }

        // POST: PedidosController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(PedidosModelo pedido)
        {
            try
            {
                Contexto.Pedidos.Add(pedido);
                Contexto.SaveChanges();
                if (pedido.ProductosSeleccionados.Any())
                {
                    foreach (var producto in pedido.ProductosSeleccionados)
                    {
                        Contexto.PedidiosProductos.Add(new PedidiosProductosModelo
                        {
                            PedidoID = pedido.ID,
                            ProductoID = producto
                        });
                    }
                    Contexto.SaveChanges();
                }
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: PedidosController/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: PedidosController/Edit/5
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

        // GET: PedidosController/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: PedidosController/Delete/5
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
