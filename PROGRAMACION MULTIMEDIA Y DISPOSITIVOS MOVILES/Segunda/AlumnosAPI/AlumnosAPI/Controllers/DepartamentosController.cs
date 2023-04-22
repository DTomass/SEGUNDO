using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;
using System.Web.Mvc;

namespace AlumnosAPI.Controllers
{
    public class DepartamentosController : ApiController
    {
        public IEnumerable<Departamentos> Get()
        {
            using (ColegioEntities colegio = new ColegioEntities())
            {
                var departamentos = colegio.Departamentos.ToList();
                return departamentos;
            }
        }
        public Departamentos Get(string nombre)
        {
            using (ColegioEntities colegio = new ColegioEntities())
            {
                return colegio.Departamentos.FirstOrDefault(p => p.NomDepartamento == nombre);
            }
        }
    }
}