import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HeaderService {

  constructor() { 
    console.log("El servicio funciona! :D");
  }
}
