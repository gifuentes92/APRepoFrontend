import { Component, OnInit } from '@angular/core';
import { ConocimientosService } from 'src/app/servicios/conocimientos.service';
import { Skill } from 'src/app/entidades/conocimientos';
import { FormBuilder,FormGroup,Validators } from '@angular/forms';

@Component({
  selector: 'app-conocimientos',
  templateUrl: './conocimientos.component.html',
  styleUrls: ['./conocimientos.component.css']
})
export class ConocimientosComponent implements OnInit {
  Skill:any;
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
      this.Skill=data["Skill"];
    });
  }

 
  guardarSkill(){
    if(this.form.valid){
     
      let skill =this.form.get("skill")?.value;
      let id=this.form.get("id")?.value;
    
      
    
      let skillEditar = new Skill(skill,id);
      this.miServicio.editarDatosConocimientos(id, skill).subscribe({
        next: (data) => {
          this.Skill=skillEditar;
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
    this.form.get("skill")?.setValue(this.Skill.skill);
  }
}


