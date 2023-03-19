import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-alumnoCount',
  templateUrl: './alumnoCount.component.html',
  styleUrls: ['./alumnoCount.component.css']
})
export class AlumnoCountComponent  {

opcionElegida: string = 'Todos';

@Output()
globalElegido: EventEmitter<string> = new EventEmitter();

  @Input()
  todos:number = 0;

  @Input()
  hombres: number = 0;

  @Input()
  mujeres: number = 0;

  alcambiar(){
    this.globalElegido.emit(this.opcionElegida);
  }

  constructor() { }


}
