import { Component, OnInit } from '@angular/core';
import { EducacionService } from 'src/app/servicios/educacion.service';
import { Educacion } from 'src/app/entidades/educacion';
import { TokenService } from 'src/app/servicios/token.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css'],
})
export class EducacionComponent implements OnInit {
  educacion: Educacion[] = [];
  edulist: any;
  isLogged = false;

  institucion: string = '';
  titulo: string = '';
  curso: string = '';
  inicio: string = '';
  fin: string = '';

  

  constructor(
    private educacionService: EducacionService,
    private tokenService: TokenService,
    private router: Router,

  ) {}

  ngOnInit(): void {
    this.obtenerEducacion();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    };
  }

  obtenerEducacion(): void {
    this.educacionService.obtenerEducacion().subscribe((data) => {
      this.edulist = data;
    });
  }

  onCreate(): void {
    const edu = new Educacion(
      this.institucion,
      this.titulo,
      this.curso,
      this.inicio,
      this.fin
    );
    this.educacionService.agregarDatosEducacion(edu).subscribe(
      (data) => {
        alert('Se añadió correctamente la educación');
        this.router.navigate(['']);
      },
      (err) => {
        alert('No se pudieron guardar los datos');
      }
    );
  }

delete(id?:number){
  if(id !=undefined){
    this.educacionService.borrarDatosEducacion(id).subscribe(
      data=>{
        this.obtenerEducacion();
      }, err=>{
        alert("No se pudo eliminar la educacion");    
    }
    )
  }
}
}
