using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;
using System.Web.Mvc;

namespace AlumnosAPI.Controllers
{
    public class AlumnosController : ApiController
    {
        public IEnumerable<Alumnos> Get()
        {
            using (ColegioEntities colegio = new ColegioEntities())
            {
                var alumnos = colegio.Alumnos.ToList();
                return alumnos;
            }
        }
        public Alumnos Get(string nombre)
        {
            using (ColegioEntities colegio = new ColegioEntities())
            {
                return colegio.Alumnos.FirstOrDefault(p => p.nombre == nombre);
            }
        }
    }
}