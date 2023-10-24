import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Extra } from '../entidades/extra';

@Injectable({
  providedIn: 'root'
})
export class ExtraService {
  url:string="https://backendapfuentes.onrender.com/extra/";
  constructor(private http:HttpClient) {
  
   }

   public obtenerExtra(): Observable<Extra[]> {
    return this.http.get<Extra[]>(this.url+"mostrar");
  }
  public extraPorId(id:number):Observable<Extra>{
    return this.http.get<Extra>(this.url+ "detail"  + "/"  + id);
  }

  public agregarDatosExtra(extra:Extra):Observable<any>{
    return this.http.post(this.url+"crear",extra);
  }

  public editarDatosExtra(id:number,extra:Extra):Observable<any>{
    return this.http.put(this.url+"editar"+"/"+id,extra);
  }

  public borrarDatosExtra(id:number):Observable<any>{
    return this.http.delete(this.url+`borrar/${id}`);
  }

}