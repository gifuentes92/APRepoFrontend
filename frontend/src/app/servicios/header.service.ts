import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Persona } from '../entidades/persona';


@Injectable({
  providedIn: 'root'
})
export class HeaderService {
  url="http://localhost:8080/persona";
  constructor(private http:HttpClient) { 
  }
public getPersona(): Observable<Persona>{
  return this.http.get<Persona>(this.url+"/traer/perfil");
  }

  public personaPorId(id:number):Observable<Persona>{
    return this.http.get<Persona>(this.url+ "/buscar"  + "/"  + id);
  }

  public editarDatosPersona(id:number,persona:Persona):Observable<any>{
    return this.http.put(this.url+"/editar"+"/"+id,persona);
  }
}

