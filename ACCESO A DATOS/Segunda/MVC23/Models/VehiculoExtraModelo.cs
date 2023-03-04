namespace MVC23.Models
{
    public class VehiculoExtraModelo { 
        public int ID { get; set; }
        public int ExtraID { get; set; }
        public ExtraModelo extra { get; set; }
        public int VehiculoID { get; set; }
        public VehiculoModelo vehiculo { get; set; }



    }
}
