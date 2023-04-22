import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProfesorService } from '../Profesor/Profesor.service';
import { Profesor } from '../Profesor/IProfesor';

@Component({
  selector: 'app-Departamento',
  templateUrl: './departamentos.component.html',
  styleUrls: ['./departamentos.component.css']
})
export class DepartamentosComponent implements OnInit {

  departamentoSeleccionado: number;
  profesores: Profesor[];

  constructor(private profesorService: ProfesorService, private activatedRoute: ActivatedRoute) {
    this.departamentoSeleccionado = 0;
    this.profesores = []

  }

  ngOnInit() {

  }

  ElegirDepartamento(departamentoSeleccionado: number): void {

    this.profesorService.getProfesores().subscribe(datosProf => {
      this.profesores = datosProf.filter(p => p.DepartamentoID == departamentoSeleccionado);
    });
    console.log(this.profesores);

  }
}
