﻿namespace RazorPages.Modelos
{
    public class Alumno
    {
        public int Id { get; set; }
        public string? Nombre { get; set; }
        public string? Email { get; set; }
        public string Foto{ get; set; }
        public Curso? CursoID { get; set; }
    }
}