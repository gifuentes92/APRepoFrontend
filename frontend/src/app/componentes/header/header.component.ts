import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Persona } from 'src/app/entidades/persona';
import { HeaderService } from 'src/app/servicios/header.service';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})



export class HeaderComponent implements OnInit {
persona:any;
userAuntenticado:boolean=true;//deberia ser false
form:FormGroup;
  constructor(private miServicio:HeaderService, private miFormBuild:FormBuilder) {
    this.form=this.miFormBuild.group({
      fullname:['',[Validators.required,Validators.minLength(4)]],
      position:['',[Validators.required, Validators.minLength(4)]],
      aboutMe:['',[Validators.required, Validators.maxLength(50)]]
    });
  
   }
 
   get fullname(){
      return this.form.get("fullname");
    }

    get position(){
      return this.form.get("position");
    }

    get aboutMe(){
      return this.form.get("aboutMe");
    }

  ngOnInit(): void {
    this.miServicio.obtenerDatosPersona().subscribe(data =>{
      this.persona=data["persona"];
      console.log(data);
    })
  }

  guardarNombre(){
    if(this.form.valid){
     
      let fullname =this.form.get("fullname")?.value;
      let position =this.form.get("position")?.value;
      let aboutMe =this.form.get("aboutMe")?.value;
      
    
      let personaEditar = new Persona(fullname,aboutMe,position);
      this.miServicio.editarDatosPersona(personaEditar).subscribe({
        next: (data) => {
          this.persona=personaEditar;
          this.form.reset();
          this.form.markAsPristine();
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
    this.form.get("fullname")?.setValue(this.persona.fullname);
    this.form.get("position")?.setValue(this.persona.position);
    this.form.get("aboutMe")?.setValue(this.persona.aboutMe);
  }
}

