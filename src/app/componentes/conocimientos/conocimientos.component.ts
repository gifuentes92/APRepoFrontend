import { Component, OnInit } from '@angular/core';
import { ConocimientosService } from 'src/app/servicios/conocimientos.service';
import { Skill } from 'src/app/entidades/conocimientos';
import { TokenService } from 'src/app/servicios/token.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-conocimientos',
  templateUrl: './conocimientos.component.html',
  styleUrls: ['./conocimientos.component.css']
})
export class ConocimientosComponent implements OnInit {
  isLogged = false;

  skills: Skill[] = [];
  skilList: any;
  skill: string;


  userAuntenticado: boolean = true; //debería ser false
  constructor(private skillService: ConocimientosService, private tokenService: TokenService, private router: Router) {

  }



  ngOnInit(): void {
    this.obtenerConocimientos();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }



  }

  obtenerConocimientos(): void {
    this.skillService.obtenerDatosConocimientos().subscribe((data) => {
      this.skilList = data;
    });
  }

  onCreateS(): void {
    const nSkill = new Skill(
      this.skill);
    this.skillService.agregarDatosConocimientos(nSkill).subscribe(
      (data) => {
        alert('Se añadió correctamente la habilidad');
        this.router.navigate(['']);
      },
      (err) => {
        alert('No se pudieron guardar los datos');
      }
    );
  }

  deleteS(id?: number) {
    if (id != undefined) {
      this.skillService.borrarDatosConocimientos(id).subscribe(
        data => {
          this.obtenerConocimientos();
        }, err => {
          alert("No se pudo eliminar");
        }
      )
    }
  }


}


