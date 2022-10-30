import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Persona } from 'src/app/entidades/persona';
import { HeaderService } from 'src/app/servicios/header.service';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})


export class HeaderComponent implements OnInit {
persona!:Persona;
userAuntenticado:boolean=true;//deberia ser false
form:FormGroup;
id:any;
 


constructor(private miServicio:HeaderService, private miFormBuild:FormBuilder, private router:Router) {
    
  this.form=this.miFormBuild.group({
      nombre:['',[Validators.required,Validators.minLength(4)]],
      urlfoto:['https://',[Validators.required, Validators.pattern("https?://.+")]],
      puesto:['',[Validators.required, Validators.minLength(4)]],
      acercade:['',[Validators.required, Validators.maxLength(50)]]
      
    });
  
   

   }
 
   get nombre(){
      return this.form.get("nombre");
    } 

    get urlfoto(){
      return this.form.get("urlfoto");
    }

    get puesto(){
      return this.form.get("puesto");
    }

    get acercade(){
      return this.form.get("acercade");
    }
    
   

  ngOnInit(): void {
    this.miServicio.obtenerDatosPersona(1).subscribe(data =>{
      this.persona=data;
      console.log(data);
      this.id=this.persona['id']
    })

    

  }
login(){
      this.router.navigate(['/login']);
    }
    
  editarDatosPersona(){
    if(this.form.valid){
     
      let nombre =this.form.get("nombre")?.value;
      let urlfoto=this.form.get("urlfoto")?.value;
      let puesto =this.form.get("puesto")?.value;
      let acercade =this.form.get("acercade")?.value;
      
      
      let personaEditar = new Persona(this.id,nombre,puesto,urlfoto,acercade);
      this.miServicio.editarDatosPersona(personaEditar).subscribe({
        next: (data) => {
          this.persona=personaEditar;
          this.ngOnInit();
           document.getElementById("cerrarModal")?.click();
        },
        error: (error) => {
          alert("No se pudo actualizar el registro, por favor intente nuevamente.");
        }
      })
      
     
    }
    else
      {
     alert("Hay errores, por favor revise los datos");
      this.form.markAllAsTouched();
    }
  }
  
  cerrarModalData(){
    this.form.reset();
    this.form.markAsPristine();
  }

  mostrarDatosEncabezado(){
    this.form.get("nombre")?.setValue(this.persona.nombre);
    this.form.get("urlfoto")?.setValue(this.persona.urlfoto);
    this.form.get("puesto")?.setValue(this.persona.puesto);
    this.form.get("acercade")?.setValue(this.persona.acercade);
  }
}

