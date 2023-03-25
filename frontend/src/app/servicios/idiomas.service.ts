import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Idioma } from '../entidades/idiomas';

@Injectable({
  providedIn: 'root'
})
export class IdiomasService {
  url:string="http://localhost:8080/idioma/";
  constructor(private http:HttpClient){

  }

   public obtenerIdioma(): Observable<Idioma[]> {
    return this.http.get<Idioma[]>(this.url+"mostrar");
  }
  public IdiomaPorId(id:number):Observable<Idioma>{
    return this.http.get<Idioma>(this.url+ "detail"  + "/"  + id);
  }

  public agregarDatosIdioma(idioma:Idioma):Observable<any>{
    return this.http.post(this.url+"crear",idioma);
  }

  public editarDatosIdioma(id:number,idioma:Idioma):Observable<any>{
    return this.http.put(this.url+"editar"+"/"+id,idioma);
  }

  public borrarDatosIdioma(id:number):Observable<any>{
    return this.http.delete(this.url+`borrar/${id}`);
  }

}
