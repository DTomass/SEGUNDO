import { Injectable } from '@angular/core';
import { Profesor } from './Profesor';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/';

@Injectable({
  providedIn: 'root'
})
export class ProfesorService {

constructor(private _http: HttpClient) { }

getProfesores(): Observable<Profesor[]>{
  return this._http.get<Profesor[]>("https://localhost:44391/api/Profesor");

}

}
