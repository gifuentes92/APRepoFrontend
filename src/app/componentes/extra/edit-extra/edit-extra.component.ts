import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Extra } from 'src/app/entidades/extra';
import { ExtraService } from 'src/app/servicios/extra.service';

@Component({
  selector: 'app-edit-extra',
  templateUrl: './edit-extra.component.html',
  styleUrls: ['./edit-extra.component.css']
})
export class EditExtraComponent implements OnInit {
  extraEdit: Extra = null;

  constructor(private extraService: ExtraService, private activatedRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.extraService.extraPorId(id).subscribe(
      data => {
        this.extraEdit = data;

      }, err => {
        alert('Error al modificar los datos');
        this.router.navigate(['']);

      }
    )
  }


  onUpdateE(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.extraService.editarDatosExtra(id, this.extraEdit).subscribe(
      data => {
        this.router.navigate(['']);
      }, err => {
        alert('Error al modificar los datos');
        this.router.navigate(['']);
      }
    )
  }

}
