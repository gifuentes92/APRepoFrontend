import { Component, OnInit } from '@angular/core';
import { ConocimientosService } from 'src/app/servicios/conocimientos.service';
import { conocimientos } from 'src/app/entidades/conocimientos';
import { FormBuilder,FormGroup,Validators } from '@angular/forms';

@Component({
  selector: 'app-conocimientos',
  templateUrl: './conocimientos.component.html',
  styleUrls: ['./conocimientos.component.css']
})
export class ConocimientosComponent implements OnInit {
  conocimientos:any;
form:FormGroup;
userAuntenticado:boolean=true; //debería ser false
  constructor(private miServicio:ConocimientosService,private miFormBuld:FormBuilder) {
    this.form=miFormBuld.group({
      skill:['',[Validators.minLength(4),Validators.maxLength(50)]]
    });
  }
     get skill(){
       return this.form.get("skill");
       }

       
  ngOnInit(): void {
    this.miServicio.obtenerDatosConocimientos().subscribe(data =>{
      this.conocimientos=data["conocimientos"];
    });
  }

 
  guardarSkill(){
    if(this.form.valid){
     
      let skill =this.form.get("fullname")?.value;
    
      
    
      let skillEditar = new conocimientos(skill);
      this.miServicio.editarDatosConocimientos(skillEditar).subscribe({
        next: (data) => {
          this.conocimientos=skillEditar;
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
  
  cerrarModalSkill(){
    this.form.reset();
    this.form.markAsPristine();
  }

  mostrarDatosSkill(){
    this.form.get("skill")?.setValue(this.conocimientos.skill);
  }
}


/*


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

}


*/