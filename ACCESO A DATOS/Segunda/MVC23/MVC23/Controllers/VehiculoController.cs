using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.Data.SqlClient;
using Microsoft.EntityFrameworkCore;
using MVC23.Models;

namespace MVC23.Controllers
{
    public class VehiculoController : Controller
    {
        public class VehiculoTotal
        {
            public string Matricula { get; set; }
            public string Color { get; set; }
            public string Nom_Serie { get; set; }
            public string Nom_Marca { get; set; }
        }
        public Contexto Contexto { get; set; }
        public VehiculoController(Contexto contexto)
        {
            Contexto = contexto;
            Contexto.Database.EnsureCreated();
        }


        // GET: VehiculoController
        public ActionResult Index()
        {
            ViewBag.LasMarcas = Contexto.Marcas.ToList();
            var lista = Contexto.Vehiculos.Include(s => s.Serie).ToList();
            return View(lista);
        }

        public ActionResult Listado(int? marcaId, int? serieId)
        {
            ViewBag.LasMarcas = new SelectList(Contexto.Marcas, "ID", "Nom_Marca", marcaId);
            ViewBag.LasSeries = new SelectList(Contexto.Series.Where(s => s.MarcaID == marcaId), "ID", "Nom_Serie", serieId);
            List<VehiculoModelo> lista = Contexto.Vehiculos.Where(v => v.SerieID == serieId).Include(s => s.Serie).ToList();
            return View(lista);
        }
        //public ActionResult Listado2()
        //{
        //    List<VehiculoTotal> vehiculoTotal = Contexto.VistaTotal.FromSqlRaw($"SELECT dbo.Marcas.Nom_Marca, dbo.Series.Nom_Serie, dbo.Vehiculos.Matricula, dbo.Vehiculos.Color FROM   dbo.Marcas INNER JOIN dbo.Series ON dbo.Marcas.ID = dbo.Series.MarcaID INNER JOIN dbo.Vehiculos ON dbo.Series.ID = dbo.Vehiculos.SerieID").ToList();
        //    List<VehiculoTotal> vehiculoTotal = Contexto.VistaTotal.ToList();
        //    return View(vehiculoTotal);
        //}

        //public ActionResult Listado3()
        //{
        //    List<VehiculoTotal> vehiculoTotal = Contexto.VistaTotal.FromSqlRaw($"EXECUTE getSeriesVehiculos").ToList();
        //    return View(vehiculoTotal);
        //}

        //public ActionResult Listado4(string color="%")
        //{
        //    var elColor = new SqlParameter("@ColorSel", color);
        //    ViewBag.color = new SelectList(Contexto.VistaTotal.Select(v => new {Color = v.Color }).Distinct(), "Color", "Color", color);
        //    List<VehiculoTotal> vehiculoTotal = Contexto.VistaTotal.FromSqlRaw($"EXECUTE getVehiculosPorColor @ColorSel", elColor).ToList();
        //    return View(vehiculoTotal);
        //}

        public ActionResult Busqueda(string busqueda="")
        {
            ViewBag.busca = busqueda;
            var lista = (from v in Contexto.Vehiculos where v.Matricula.Contains(busqueda) select v).Include(s => s.Serie).ToList();
            return View(lista);
        }

        public ActionResult Busqueda2(string busqueda = " ")
        {
            ViewBag.busca = new SelectList(Contexto.Vehiculos, "Matricula", "Matricula", busqueda);
            var lista = (from v in Contexto.Vehiculos where v.Matricula==busqueda select v).Include(s => s.Serie).ToList();
            return View(lista);
        }


        // GET: VehiculoController/Details/5
        public ActionResult Details(int id)
        {
            VehiculoModelo vehiculo = Contexto.Vehiculos.Include(v => v.Serie).FirstOrDefault(v => v.ID == id);
            return View(vehiculo);
        }

        // GET: VehiculoController/Create
        public ActionResult Create()
        {
            ViewBag.SerieID = new SelectList(Contexto.Series, "ID", "Nom_Serie");
            ViewBag.Extras = new MultiSelectList(Contexto.Extras, "ID", "Nom_Extra");
            return View();
        }

        // POST: VehiculoController/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(VehiculoModelo vehiculo)
        {
            try
            {
                Contexto.Vehiculos.Add(vehiculo);
                Contexto.Database.EnsureCreated();
                Contexto.SaveChanges();
                if (vehiculo.ExtrasSeleccionados != null)
                {
                    foreach (int xtraId in vehiculo.ExtrasSeleccionados)
                    {
                        Contexto.VehiculosExtras.Add(new VehiculoExtraModelo { VehiculoID = vehiculo.ID, ExtraID = xtraId });

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

        // GET: VehiculoController/Edit/5
        public ActionResult Edit(int id)
        {
            ViewBag.SerieID = new SelectList(Contexto.Series, "ID", "Nom_Serie");
            VehiculoModelo vehiculo = Contexto.Vehiculos.Find(id);
            return View(vehiculo);
        }

        // POST: VehiculoController/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, VehiculoModelo vehiculoModificado)
        {
            try
            {
                VehiculoModelo vehiculoActual = Contexto.Vehiculos.FirstOrDefault(v => v.ID == id);
                vehiculoActual.Color = vehiculoModificado.Color;
                vehiculoActual.Matricula = vehiculoModificado.Matricula;
                vehiculoActual.SerieID = vehiculoModificado.SerieID;
                Contexto.SaveChanges();

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
            VehiculoModelo vehiculo = Contexto.Vehiculos.Include(v => v.Serie).FirstOrDefault(v => v.ID == id);
            return View(vehiculo);
        }

        // POST: VehiculoController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, IFormCollection collection)
        {
            try
            {
                VehiculoModelo vehiculo = Contexto.Vehiculos.Find(id);
                Contexto.Vehiculos.Remove(vehiculo);
                Contexto.SaveChanges();
                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }
    }
}
