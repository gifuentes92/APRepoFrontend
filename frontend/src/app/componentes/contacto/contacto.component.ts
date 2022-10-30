import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { contacto } from 'src/app/entidades/contacto';
import { ContactoService } from 'src/app/servicios/contacto.service';

@Component({
  selector: 'app-contacto',
  templateUrl: './contacto.component.html',
  styleUrls: ['./contacto.component.css']
})


 
export class ContactoComponent implements OnInit {
Contacto!:contacto;
userAuntenticado:boolean=true;//deberia ser false
form:FormGroup;
  constructor(private miServicio:ContactoService, private miFormBuild:FormBuilder) {
    this.form=this.miFormBuild.group({
      discord:['https://',[Validators.pattern("https?://+")]],
      telegram:['https://',[Validators.pattern("https?://+")]],
      github:['https://',[Validators.pattern("https?://+")]]
      
    });
  
   }
 
   get discord(){
      return this.form.get("discord");
    } 

    get telegram(){
      return this.form.get("telegram");
    }

    get github(){
      return this.form.get("github");
    }
    
   

  ngOnInit(): void {
    this.miServicio.obtenerContacto().subscribe(data =>{
      this.Contacto=data;
      console.log(data);
    })
  }
}