import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Skill } from 'src/app/entidades/conocimientos';
import { ConocimientosService } from 'src/app/servicios/conocimientos.service';

@Component({
  selector: 'app-edit-conocimientos',
  templateUrl: './edit-conocimientos.component.html',
  styleUrls: ['./edit-conocimientos.component.css']
})
export class EditConocimientosComponent implements OnInit {
  skillEdit:Skill=null;

  constructor(private conocimientoService:ConocimientosService,private activatedRouter: ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.conocimientoService.skillPorId(id).subscribe(
      data => {
      this.skillEdit = data;
     
    },err=>{
      alert('Error al modificar los datos');
       this.router.navigate(['']);
       
    }
    )
  }

  onUpdateS(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.conocimientoService.editarDatosConocimientos(id, this.skillEdit).subscribe(
      data =>{
        this.router.navigate(['']);
      },err =>{
        alert('Error al modificar los datos');
        this.router.navigate(['']);
      }
    )
  }


}
