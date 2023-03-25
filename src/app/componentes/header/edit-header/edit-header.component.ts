import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Persona } from 'src/app/entidades/persona';
import { HeaderService } from 'src/app/servicios/header.service';

@Component({
  selector: 'app-edit-header',
  templateUrl: './edit-header.component.html',
  styleUrls: ['./edit-header.component.css']
})
export class EditHeaderComponent implements OnInit {
  persEdit: Persona = null;
  constructor(private headerService:HeaderService,private activatedRouter: ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.headerService.personaPorId(id).subscribe(
      data => {
      this.persEdit = data;
     
    },err=>{
      alert('Error al modificar los datos');
       this.router.navigate(['']);
       
    }
    )

  }

  onUpdateH(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.headerService.editarDatosPersona(id, this.persEdit).subscribe(
      data =>{
        this.router.navigate(['']);
      },err =>{
        alert('Error al modificar los datos');
        this.router.navigate(['']);
      }
    )
  }


}
