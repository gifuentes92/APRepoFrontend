import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Extra } from 'src/app/entidades/extra';
import { ExtraService } from 'src/app/servicios/extra.service';
import { TokenService } from 'src/app/servicios/token.service';

@Component({
  selector: 'app-extra',
  templateUrl: './extra.component.html',
  styleUrls: ['./extra.component.css']
})
export class ExtraComponent implements OnInit {
  extra: Extra[] = [];
  extralist: any;
  isLogged = false;

  skill:string='';
  programa:string='';
 

  constructor(private extraService:ExtraService,private tokenService:TokenService,private router:Router) { }

  ngOnInit(): void {
    this.obtenerExtra();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
    }
    obtenerExtra(): void {
      this.extraService.obtenerExtra().subscribe((data) => {
        this.extralist = data;
      });
    }
   
    onCreateE(): void {
      const ext = new Extra(
        this.skill,
        this.programa);
      this.extraService.agregarDatosExtra(ext).subscribe(
        (data) => {
          alert('Se añadió correctamente la educación');
          this.router.navigate(['']);
        },
        (err) => {
          alert('No se pudieron guardar los datos');
        }
      );
    }

  deleteE(id?:number){
    if(id !=undefined){
      this.extraService.borrarDatosExtra(id).subscribe(
        data=>{
          this.obtenerExtra();
        }, err=>{
          alert("No se pudo eliminar la educacion");    
      }
      )
    }
  }
  }
  
  
