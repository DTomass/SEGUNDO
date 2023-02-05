import { Component } from '@angular/core';

@Component({
    selector: 'app-root',
    templateUrl: `
                <div><button class='color' [class]='aplicarClases'>Boton 1</button>
                <br><br><br>
                <button class='color italica negria' [class.negrita]='!aplicarClases'>Boton 2</button>
                <br><br><br>
                <button [ngClass]='addClases()>Boton 3</button>
                
                <button (click)='onclick()'>Boton 4</button>
                <img src='./assets/mexico.jpg' *ngIf= 'visible' /></div>
`,
    styleUrls: ['./Alumnos/']
})
export class AlumnoComponent  {
    columnas: number = 2;
    nombre: string = "Pep";
    apellidos: string = "Guardiolin";
    direccion: string = "Ave Maria 63, Purisima, LLena eres de gracia";
    edad: number = 60;
    visible: boolean = true;

    alternarVisibles(): void {
        this.visible = !this.visible
    }

}
