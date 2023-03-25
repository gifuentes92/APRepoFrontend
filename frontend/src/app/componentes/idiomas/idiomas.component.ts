import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Idioma } from 'src/app/entidades/idiomas';
import { EducacionService } from 'src/app/servicios/educacion.service';
import { IdiomasService } from 'src/app/servicios/idiomas.service';
import { TokenService } from 'src/app/servicios/token.service';

@Component({
  selector: 'app-idiomas',
  templateUrl: './idiomas.component.html',
  styleUrls: ['./idiomas.component.css']
})
export class IdiomasComponent implements OnInit {
  idioma: Idioma[] = [];
  idiList: any;
  isLogged = false;

  lenguaje:string='';
  nivel:string='';

  constructor(private idiomaService:IdiomasService, private educacionService: EducacionService,private tokenService: TokenService,private router: Router) { }

  ngOnInit(): void {
    this.obtenerIdioma();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    };

}

obtenerIdioma(): void {
  this.idiomaService.obtenerIdioma().subscribe((data) => {
    this.idiList = data;
  });
}

  onCreateI(): void {
  const idi = new Idioma(
    this.lenguaje,
    this.nivel
  );
  this.idiomaService.agregarDatosIdioma(idi).subscribe(
    (data) => {
      alert('Se añadió correctamente la educación');
      this.router.navigate(['']);
    },
    (err) => {
      alert('No se pudieron guardar los datos');
    }
  );
  }

  deleteI(id?:number){
  if(id !=undefined){
  this.idiomaService.borrarDatosIdioma(id).subscribe(
    data=>{
      this.obtenerIdioma();
      }, err=>{
      alert("No se pudo eliminar la educacion");    
      }
      )
   }
 }
}
