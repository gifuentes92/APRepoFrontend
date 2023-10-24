import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Skill } from '../entidades/conocimientos';

@Injectable({
  providedIn: 'root'
})
export class ConocimientosService {
  url:string="https://backendapfuentes.onrender.com/skill";
  skill: any;
  constructor(private http:HttpClient) { 

  }

  
  obtenerDatosConocimientos():Observable<any>{
    return this.http.get(this.url+"/mostrar");
  }
  public skillPorId(id:number):Observable<Skill>{
    return this.http.get<Skill>(this.url+ "/detail"  + "/"  + id);
  }

  public agregarDatosConocimientos(skill:Skill):Observable<any>{
    return this.http.post(this.url+"/crear",skill);
  }

  public editarDatosConocimientos(id:number,skill:Skill):Observable<any>{
    return this.http.put(this.url+"/editar"+"/"+id,skill);
  }

  public borrarDatosConocimientos(id:number):Observable<any>{
    return this.http.delete(this.url+"/borrar"+"/"+id);
  }

}