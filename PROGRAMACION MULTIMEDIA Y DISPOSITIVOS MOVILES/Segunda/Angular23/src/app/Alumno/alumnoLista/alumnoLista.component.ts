import { Component, OnInit } from '@angular/core';
import { Alumno } from '../IAlumno';
import { AlumnoServiceService } from '../AlumnoService.service';

@Component({
  selector: 'app-alumnoLista',
  templateUrl: './alumnoLista.component.html',
  styleUrls: ['./AlumnoLista.component.css']
})
export class AlumnoListaComponent implements OnInit {

  seleccion: string = "Todos";

  alumnos: Alumno[];

  constructor(private service: AlumnoServiceService) {
    this.alumnos = [];
  }

  ngOnInit() {
    this.service.getAlumnos().subscribe((datosalumnos) => this.alumnos = datosalumnos);
  }

  getTodos(): number{
    return this.alumnos.length;
  }
  getHombres(): number{
    return this.alumnos.filter(a => a.sexo == 'Hombre').length;
  }
  getMujeres(): number{
    return this.alumnos.filter(a => a.sexo == 'Mujer').length;
  }

  alPulsar(opcionElegida: string): void{
    this.seleccion = opcionElegida;
  }
}
