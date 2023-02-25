using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace WebAPI.Controllers
{
    public class ProfesoresController : ApiController
    {
        public IEnumerable<Profesores> Get()
        {
            using(ColegioEntities colegioEntities = new ColegioEntities())
            {
                return colegioEntities.Profesores.ToList();
            }
        }
        public Profesores Get(int id)
        {
            using (ColegioEntities colegioEntities = new ColegioEntities())
            {
                return colegioEntities.Profesores.FirstOrDefault(a => a.ID == id);
            }
        }
    }
}
