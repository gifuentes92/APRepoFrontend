import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Contacto } from '../entidades/contacto';


@Injectable({
  providedIn: 'root'
})
export class ContactoService {
  url:string="https://backendapfuentes.onrender.com/contacto/";
  constructor(private http:HttpClient) { 

  }


  public obtenerContacto(): Observable<Contacto[]> {
    return this.http.get<Contacto[]>(this.url+"mostrar");
  }
  public ContactoPorId(id:number):Observable<Contacto>{
    return this.http.get<Contacto>(this.url+ "detail"  + "/"  + id);
  }
}
