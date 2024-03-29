﻿using System.ComponentModel.DataAnnotations.Schema;

namespace MVC23.Models
{
    public class VehiculoModelo
    {
        public int ID { get; set; }
        public string Matricula { get; set; }
        public string Color { get; set; }
        public int SerieID { get; set; }
        public SerieModelo Serie { get; set; }

        [NotMapped]
        public List<int> ExtrasSeleccionados { get; set; }
        public List<VehiculoExtraModelo> VehiculoExtras { get; set; }
    }
}
