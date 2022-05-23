import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IdiomasService {

  constructor(private http:HttpClient){

  }


  obtenerIdiomas():Observable<any>{
    return this.http.get('./assets/data/idioma.json');
   }


}
