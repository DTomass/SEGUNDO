export interface IProfesor {
  Nombre: string;
  Apellidos: string;
  Fecha_Ingreso: string;
  Titulacion: string;
  DepartamentoID: number;

}

export class Profesor implements IProfesor {

  constructor(
    public Nombre: string,
    public Apellidos: string,
    public Fecha_Ingreso: string,
    public Titulacion: string,
    public DepartamentoID: number
  ) {}

}
