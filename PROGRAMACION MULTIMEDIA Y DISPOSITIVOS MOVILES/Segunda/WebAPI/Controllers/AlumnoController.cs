using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace WebAPI.Controllers
{
    public class AlumnoController : ApiController
    {
        public IEnumerable<Alumnos> Get()
        {
            using(ColegioEntities colegioEntities = new ColegioEntities())
            {
                return colegioEntities.Alumnos.ToList();
            }
        }
        public Alumnos Get(int id)
        {
            using (ColegioEntities colegioEntities = new ColegioEntities())
            {
                return colegioEntities.Alumnos.FirstOrDefault(a => a.ID == id);
            }
        }
    }
}
