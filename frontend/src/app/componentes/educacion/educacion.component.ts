import { Component, OnInit } from '@angular/core';
import { EducacionService } from 'src/app/servicios/educacion.service';
import { educacion } from 'src/app/entidades/educacion';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent implements OnInit {
  educacion:any;
  usuarioAutenticado:boolean=true; //deberia estar en false hasta login de usuario
  form: FormGroup;
  

constructor(private miServicio:EducacionService, private miFormBuild:FormBuilder) {
    this.form=this.miFormBuild.group({
      id:['',],
      school:['',[Validators.required,Validators.minLength(3)]],
      title:['',[Validators.required, Validators.minLength(4)]],
      career:['',[Validators.required,Validators.minLength(4)]],
      score:['',[Validators.maxLength(15)]],
      start:['',],
      end:['']});
  
   }
 
   get id(){
    return this.form.get("id");
   }
   get school(){
      return this.form.get("school");
    }

    get title(){
      return this.form.get("title");
    }

    get career(){
      return this.form.get("career");
    }

    get score(){
      return this.form.get("score");
    }

        get start(){
      return this.form.get("start");
    }

        get end(){
      return this.form.get("end");
    }

  ngOnInit(): void {
    this.miServicio.obtenerDatosEducacion().subscribe(data =>{
      this.educacion=data["educacion"];
      console.log(data);
    })
  }

 


  
 
 

   guardarEducacion(){
    if(this.form.valid){
     
      let id=this.form.get("id")?.value;
      let school =this.form.get("School")?.value;
      let title =this.form.get("title")?.value;
      let career=this.form.get("carrer")?.value;
      let score =this.form.get("score")?.value;
      let start =this.form.get("start")?.value;
      let end =this.form.get("end")?.value;
     
      let educacionEditar = new educacion(id,school, title,career,score, start, end);
      this.miServicio.editarDatosEducacion(educacionEditar).subscribe({
        next: (data) => {
          this.educacion=educacionEditar;
          this.form.reset();
          this.form.markAsPristine();
           document.getElementById("cerrarModalData")?.click();
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

  mostrarDatosEducacion(){
    this.form.get("school")?.setValue(this.educacion.school);
    this.form.get("title")?.setValue(this.educacion.title);
    this.form.get("career")?.setValue(this.educacion.career);
    this.form.get("score")?.setValue(this.educacion.score);
    this.form.get("start")?.setValue(this.educacion.start);
    this.form.get("end")?.setValue(this.educacion.end);
  }
}
