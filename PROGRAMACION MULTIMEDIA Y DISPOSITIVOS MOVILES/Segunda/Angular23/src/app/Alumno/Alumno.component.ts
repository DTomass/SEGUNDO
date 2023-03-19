import { Component, OnInit } from '@angular/core';
import { Alumno } from '../Alumno/IAlumno';
import { AlumnoServiceService } from './AlumnoService.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-Alumno',
  templateUrl: './Alumno.component.html',
  styleUrls: ['./Alumno.component.css']
})
export class AlumnoComponent implements OnInit {
  alumno: Alumno;

  constructor(private alumnoService: AlumnoServiceService, private activatedRoute: ActivatedRoute) {
    this.alumno = new Alumno(1, "","","","","");
  }

  ngOnInit() {
    let idAlumno = this.activatedRoute.snapshot.params['ID'];
    this.alumnoService.getAlumno(idAlumno).subscribe((datosalumno) => this.alumno = datosalumno);
  }

}
