import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Educacion } from '../entidades/educacion';

@Injectable({
  providedIn: 'root'
})
export class EducacionService {
url:string="http://localhost:8080/educacion/";
  constructor(private http:HttpClient) {
  }

  /*Educacion*/
  public obtenerEducacion(): Observable<Educacion[]> {
    return this.http.get<Educacion[]>(this.url+"lista");
  }
  public educacionPorId(id:number):Observable<Educacion>{
    return this.http.get<Educacion>(this.url+ "detail"  + "/"  + id);
  }

  public agregarDatosEducacion(educacion:Educacion):Observable<any>{
    return this.http.post(this.url+"crear",educacion);
  }

  public editarDatosEducacion(id:number,educacion:Educacion):Observable<any>{
    return this.http.put(this.url+"editar"+"/"+id,educacion);
  }

  public borrarDatosEducacion(id:number):Observable<any>{
    return this.http.delete(this.url+`borrar/${id}`);
  }
}
