import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ExtraService {

  constructor(private http:HttpClient) { }

  obtenerExtraConocimientos():Observable<any>{
    return this.http.get('./assets/data/extra.json');
   }

}
