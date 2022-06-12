import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { toJSDate } from '@ng-bootstrap/ng-bootstrap/datepicker/ngb-calendar';
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
    alert("Cambios guardados");
    this.form.reset();
    this.form.markAsPristine();
    document.getElementById("cerrarModal")?.click();
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
}

