using Microsoft.Data.SqlClient;
using Tomás.Modelos;

namespace Tomás.Service
{
    public interface ISeleccionesRepositorio
    {
        public Seleccion Add(Seleccion seleccionNuevo);

        //public IEnumerable<CursoCuantos> AlumnosPorCurso(Curso? curso = null){}

        public void Delete(int id);

        public IEnumerable<Seleccion> GetAllSelecciones();

        public Seleccion GetSeleccion(int codigo);
    }
}