export interface IDepartamento {
  ID: number;
  NomDepartamento: string;

}

export class Departamento implements IDepartamento {

  constructor(
    public ID: number,
    public NomDepartamento: string
  ) {}

}
