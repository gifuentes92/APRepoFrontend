import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConocimientosService {

  constructor(private http:HttpClient) { }

  
  obtenerDatosConocimientos():Observable<any>{
    return this.http.get('./assets/data/conocimientos.json');
   }
}
