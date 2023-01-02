using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection.Metadata;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Data.SqlClient;
using Microsoft.EntityFrameworkCore;
using Tomás.Modelos;
using Tomás.Service;

namespace Tomás.Service
{
    public class SeleccionesRepositorioDb
    {
        private readonly SeleccionesDbContext context;

        public SeleccionesRepositorioDb(SeleccionesDbContext context)
        {
            this.context = context;
        }
        public Seleccion Add(Seleccion seleccionNuevo)
        {
            context.Database.ExecuteSqlRaw("InsertAlumno", seleccionNuevo.Codigo, seleccionNuevo.NomPais, seleccionNuevo.Bandera, seleccionNuevo.NumTitulos, seleccionNuevo.Grupo);
            return seleccionNuevo;
        }


        public IEnumerable<GruposCuantos> SeleccionesPorGrupos(Grupos? grupos = null)
        {
            IEnumerable<Seleccion> consulta = context.selecciones;

            if (grupos.HasValue)
            {
                consulta = context.selecciones.Where(a => a.Grupo == grupos);
            }

            return consulta.GroupBy(a => a.Grupo)
                .Select(g => new GruposCuantos()
                {
                    Grupo = g.Key,
                    Selecciones = g.Count()
                }).ToList();
        }

        public void Delete(int id)
        {
            var seleccionABorrar = GetSeleccion(id);
            if (seleccionABorrar != null)
            {
                context.selecciones.Remove(seleccionABorrar);
            }
        }

        public IEnumerable<Seleccion> GetAllSelecciones()
        {
            return context.selecciones.FromSqlRaw<Seleccion>("select * from Selecciones").ToList();
        }

        public Seleccion GetSeleccion(int codigo)
        {
            SqlParameter parameter = new SqlParameter("@Codigo", codigo);
            //Procedimiento

            //USE[Mundial]
            //GO
            //
            //SET ANSI_NULLS ON
            //GO
            //SET QUOTED_IDENTIFIER ON
            //GO
            //Create procedure[dbo].[GetSeleccionById]
            //@Id int
            //as
            //BEGIN

            //    select* from Selecciones
            //    where Codigo = @Id
            //END
            return context.selecciones.FromSqlRaw<Seleccion>("GetSeleccionById @Codigo", parameter)
                .ToList()
                .FirstOrDefault(); //Busca por el campo que sea primary key
        }
        public Seleccion Update(Seleccion seleccionActualizado)
        {
            var seleccion = context.selecciones.Attach(seleccionActualizado);
            seleccion.State = EntityState.Modified;

            return seleccionActualizado;
        }
    }
}