import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Persona } from '../entidades/persona';

@Injectable({
  providedIn: 'root'
})
export class HeaderService {
  url:string="http://localhost:8080/persona";
  constructor(private http:HttpClient) { 
  }

  obtenerDatosPersona(id:number):Observable<Persona>{
    return this.http.get<Persona>(this.url+"/"+id);
  }

  editarDatosPersona(persona:Persona):Observable<any>{
    return this.http.put(this.url,persona);
  }
}
