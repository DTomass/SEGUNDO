import { Component, OnInit } from '@angular/core';
import { Profesor } from './Profesor';
import { ProfesorService } from './Profesor.service';

@Component({
  selector: 'app-Profesor',
  templateUrl: './Profesor.component.html',
  styleUrls: ['./Profesor.component.css']
})
export class ProfesorComponent implements OnInit {

  profesores : Profesor[];
  constructor(private service: ProfesorService) {
    this.profesores = [];
  }

  ngOnInit() {
    this.service.getProfesores().subscribe((datosprofesores) => this.profesores = datosprofesores);
  }

}
