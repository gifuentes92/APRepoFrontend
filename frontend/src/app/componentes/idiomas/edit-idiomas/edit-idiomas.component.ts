import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Idioma } from 'src/app/entidades/idiomas';
import { IdiomasService } from 'src/app/servicios/idiomas.service';

@Component({
  selector: 'app-edit-idiomas',
  templateUrl: './edit-idiomas.component.html',
  styleUrls: ['./edit-idiomas.component.css']
})
export class EditIdiomasComponent implements OnInit {
  idiEdit: Idioma = null;
  
  constructor(private idiomaService:IdiomasService,private activatedRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void { const id = this.activatedRouter.snapshot.params['id'];
  this.idiomaService.IdiomaPorId(id).subscribe(
    data => {
      this.idiEdit = data;

    }, err => {
      alert('Error al modificar los datos');
      this.router.navigate(['']);

    }
  )
}
  


  onUpdateI(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.idiomaService.editarDatosIdioma(id, this.idiEdit).subscribe(
      data => {
        this.router.navigate(['']);
      }, err => {
        alert('Error al modificar los datos');
        this.router.navigate(['']);
      }
    )
  }
}
