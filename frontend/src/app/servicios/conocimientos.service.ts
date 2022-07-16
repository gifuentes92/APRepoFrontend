import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { conocimientos } from '../entidades/conocimientos';

@Injectable({
  providedIn: 'root'
})
export class ConocimientosService {

  constructor(private http:HttpClient) { }

  
  obtenerDatosConocimientos():Observable<any>{
    return this.http.get('./assets/data/conocimientos.json');
   }

  editarDatosConocimientos(conocimientos:conocimientos):Observable<any>{
  return this.http.post('http://localhost:3000/posts',conocimientos)
}
  }

