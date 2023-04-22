using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;
using System.Web.Mvc;

namespace AlumnosAPI.Controllers
{
    public class ProfesoresController : ApiController
    {
        public IEnumerable<Profesores> Get()
        {
            using (ColegioEntities colegio = new ColegioEntities())
            {
                var profesores = colegio.Profesores.ToList();
                return profesores;
            }
        }
        public Profesores Get(string nombre)
        {
            using (ColegioEntities colegio = new ColegioEntities())
            {
                return colegio.Profesores.FirstOrDefault(p => p.Nombre == nombre);
            }
        }
    }
}