import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <div style="padding:10px">
      <ul class="nav">
        <li class="nav-item"><a class="nav-link" routerLink="Alumno">Alumnos</a></li>
        <li class="nav-item"><a class="nav-link" routerLink="Profesor">Profesores</a></li>
      </ul>
      <router-outlet></router-outlet>
    </div>

`,
  styleUrls: ['./app.component.css']
})
export class AppComponent {

}
