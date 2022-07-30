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
persona!:Persona;
userAuntenticado:boolean=true;//deberia ser false
form:FormGroup;
  constructor(private miServicio:HeaderService, private miFormBuild:FormBuilder) {
    this.form=this.miFormBuild.group({
      nombre:['',[Validators.required,Validators.minLength(4)]],
      apellido:['',[Validators.required,Validators.minLength(4)]],
      urlfoto:['https://',[Validators.required, Validators.pattern("https?://.+")]],
      puesto:['',[Validators.required, Validators.minLength(4)]],
      acerca_de:['',[Validators.required, Validators.maxLength(50)]]
    });
  
   }
 
   get nombre(){
      return this.form.get("nombre");
    }

    get apellido(){
      return this.form.get("apellido");
    }

    get fecha_nacimiento(){
      return this.form.get("fecha_nacimiento");
    }

    get urlfoto(){
      return this.form.get("urlfoto");
    }

    get puesto(){
      return this.form.get("puesto");
    }

    get acerca_de(){
      return this.form.get("acerca_de");
    }
    
    get email(){
      return this.form.get("email");
    }


  ngOnInit(): void {
    this.miServicio.obtenerDatosPersona(1).subscribe(data =>{
      this.persona=data;
      console.log(data);
    })
  }

  guardarNombre(){
    if(this.form.valid){
     
      let id=this.form.get("id")?.value;
      let nombre =this.form.get("nombre")?.value;
      let apellido= this.form.get("apellido")?.value;
      let puesto =this.form.get("puesto")?.value;
      let fecha_nacimiento=this.form.get("fecha_nacimiento")?.value;
      let acerca_de =this.form.get("acerca_de")?.value;
      
      
      let personaEditar = new Persona(id,nombre,apellido,puesto,fecha_nacimiento,acerca_de,puesto);
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
    this.form.get("nombre")?.setValue(this.persona.nombre);
    this.form.get("puesto")?.setValue(this.persona.puesto);
    this.form.get("acerca_de")?.setValue(this.persona.acerca_de);
  }
}

