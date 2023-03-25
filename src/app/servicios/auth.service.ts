import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NuevoUsuario } from '../entidades/nuevo-usuario';
import { Observable } from 'rxjs';
import { LoginUsuario } from '../entidades/login-usuario';
import { JwtDTO } from '../entidades/jwt-dto';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
authURL="https://backendapfuentes.onrender.com/auth";

  constructor(private httpClient:HttpClient) { }

  public nuevo(nuevoUsuario: NuevoUsuario):Observable<any>{
    return this.httpClient.post<any>(this.authURL + "/" +"nuevo",nuevoUsuario);
  }

  public login(loginUsuario: LoginUsuario):Observable<JwtDTO>{
    return this.httpClient.post<JwtDTO>(this.authURL +  "/" + 'login', loginUsuario);
  }
}
