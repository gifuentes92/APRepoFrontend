
import { Component, OnInit } from '@angular/core';
import { EducacionService } from 'src/app/servicios/educacion.service';
import { Educacion } from 'src/app/entidades/educacion';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent implements OnInit {
  educacion!:Educacion;
  edulist:any;
  usuarioAutenticado:boolean=true; //deberia estar en false hasta login de usuario
  form: FormGroup;



  
  
  constructor(private miServicio:EducacionService, private miFormBuild:FormBuilder) {
    this.form=this.miFormBuild.group({
      id:[''],
      institucion:['',[Validators.required,Validators.minLength(3)]],
      titulo:['',[Validators.required, Validators.minLength(4)]],
      curso:['',[Validators.required,Validators.minLength(4)]],
      inicio:['',],
      fin:['']});
  
   }
 
   
   

   get id(){
    return this.form.get("id");
  } 


   get institucion(){
    return this.form.get("institucion");
  } 

  get curso(){
    return this.form.get("curso");
  }

  get titulo(){
    return this.form.get("titulo");
  }

  get inicio(){
    return this.form.get("inicio");
  }

  get fin(){
    return this.form.get("fin");
  }
 

  ngOnInit(): void {

    

    this.miServicio.obtenerEducacion().subscribe(data=>{
      
      this.educacion=data["educacion"];
      console.log(data);
      this.edulist=this.educacion["id"];
      console.log(this.edulist);
     
      
    })
  }

 
 
 

   guardarEducacion(){
    if(this.form.valid){
     
      let institucion =this.form.get("institucion")?.value;
      let titulo =this.form.get("titulo")?.value;
      let curso=this.form.get("curso")?.value;
      let inicio =this.form.get("inicio")?.value;
      let fin =this.form.get("fin")?.value;
     
      let educacionEditar = new Educacion(this.edulist,institucion, curso,titulo, inicio,fin);
      this.miServicio.editarDatosEducacion(this.edulist,educacionEditar).subscribe({
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
    this.form.get("school")?.setValue(this.educacion.institucion);
    this.form.get("title")?.setValue(this.educacion.titulo);
    this.form.get("career")?.setValue(this.educacion.curso);
    this.form.get("start")?.setValue(this.educacion.inicio);
    this.form.get("end")?.setValue(this.educacion.fin);
   



  }
}
