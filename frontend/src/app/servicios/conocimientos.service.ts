import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Skill } from '../entidades/conocimientos';

@Injectable({
  providedIn: 'root'
})
export class ConocimientosService {
  url:string="http://localhost:8080/skill";
  constructor(private http:HttpClient) { 

  }

  
  obtenerDatosConocimientos():Observable<any>{
    return this.http.get(this.url+"/mostrar");
  }

  editarDatosConocimientos(id:number,skill:Skill):Observable<any>{
  return this.http.post(this.url+ "/"+id,skill)
}
  }

