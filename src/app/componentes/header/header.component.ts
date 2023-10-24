import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Persona } from 'src/app/entidades/persona';
import { HeaderService } from 'src/app/servicios/header.service';
import { TokenService } from 'src/app/servicios/token.service';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})


export class HeaderComponent implements OnInit {
isLogged=false;

  persona:Persona = new Persona("","","","");
userAuntenticado:boolean=true;//deberia ser false

id:any;
 


constructor(private personaService:HeaderService, private tokenService:TokenService, private router:Router) {
  
  
 
  
   

   }
 
  
    
   

  ngOnInit(): void {
    
    if(this.tokenService.getToken()){
      this.isLogged=true;

    }else{
      this.isLogged=false;
    }
    
    this.personaService.getPersona().subscribe(data =>{
      this.persona=data;
      this.id=this.persona['id']
    })

    

  }

onLogOut():void{
  this.tokenService.logOut();
  window.location.reload();
}

login(){
      this.router.navigate(['/login']);
    }
    
  
}

