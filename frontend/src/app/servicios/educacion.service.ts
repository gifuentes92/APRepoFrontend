import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Educacion } from '../entidades/educacion';

@Injectable({
  providedIn: 'root'
})
export class EducacionService {
url:string="http://localhost:8080/educacion";
  constructor(private http:HttpClient) {
  }

  /*Educacion*/
  obtenerEducacion(): Observable<any> {
    return this.http.get(this.url+"/lista");
  }
  editarDatosEducacion(id:number,educacion:Educacion):Observable<any>{
    return this.http.put(this.url+'/editar/'+id,educacion);
  }

  borrarDatosEducacion(id:number):Observable<any>{
    return this.http.delete(this.url+'/'+id);
  }
}
