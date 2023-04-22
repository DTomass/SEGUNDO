import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Departamento } from '../IDepartamento';
import { DepartamentosService } from '../departamentos.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-ElegirDep',
  templateUrl: './departamentos-count.component.html',
  styleUrls: ['./departamentos-count.component.css']
})
export class ElegirDepartamentoComponent implements OnInit {


  @Output()
  DepartamentoElegido: EventEmitter<number> = new EventEmitter<number>();

  eleccion: number = 0;

  departamentos: Departamento[]

  constructor(private departamentoService: DepartamentosService, private activatedRoute: ActivatedRoute) {
    this.departamentos = []
  }

  ngOnInit() {
    this.departamentoService.getDepartamentos().subscribe((datosDepartamentos) => this.departamentos = datosDepartamentos);
  }

  alCambiar() {
    this.DepartamentoElegido.emit(this.eleccion);
  }

}
