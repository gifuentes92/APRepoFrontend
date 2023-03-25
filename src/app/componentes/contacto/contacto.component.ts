import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Contacto } from 'src/app/entidades/contacto';
import { ContactoService } from 'src/app/servicios/contacto.service';
import { TokenService } from 'src/app/servicios/token.service';

@Component({
  selector: 'app-contacto',
  templateUrl: './contacto.component.html',
  styleUrls: ['./contacto.component.css']
})


 
export class ContactoComponent implements OnInit {
  contacto: Contacto[] = [];
  conList: any;
  isLogged = false;

userAuntenticado:boolean=true;//deberia ser false
form:FormGroup;
  constructor(private contactoService:ContactoService,private tokenService: TokenService,
    private router: Router) {
    
   }

  ngOnInit(): void {
    this.obtenerContacto();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    };
  }

  obtenerContacto(): void {
    this.contactoService.obtenerContacto().subscribe((data) => {
      this.conList = data;
       console.log(this.conList)
    });
  }

}