import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EducacionService } from 'src/app/servicios/educacion.service';
import { Educacion } from 'src/app/entidades/educacion';

@Component({
  selector: 'app-editar-educacion',
  templateUrl: './editar-educacion.component.html',
  styleUrls: ['./editar-educacion.component.css']
})
export class EditarEducacionComponent implements OnInit {
  eduEdit: Educacion = null;

  constructor(private educacionService: EducacionService,private activatedRouter: ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
   const id = this.activatedRouter.snapshot.params['id'];
    this.educacionService.educacionPorId(id).subscribe(
      data => {
      this.eduEdit = data;
     
    },err=>{
      alert('Error al modificar los datos');
       this.router.navigate(['']);
       
    }
    )

  }

  onUpdate(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.educacionService.editarDatosEducacion(id, this.eduEdit).subscribe(
      data =>{
        this.router.navigate(['']);
      },err =>{
        alert('Error al modificar los datos');
        this.router.navigate(['']);
      }
    )
  }

}
