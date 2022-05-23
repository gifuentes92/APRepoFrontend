import { Component, OnInit } from '@angular/core';
import { NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { EducacionService } from 'src/app/servicios/educacion.service';

@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent implements OnInit {
  educacion:any;
  usuarioAutenticado:boolean=true; //deberia estar en false hasta login de usuario

  
  constructor(private miServicio:EducacionService, private modalService:NgbModal) { }

  ngOnInit(): void {
    this.miServicio.obtenerDatosEducacion().subscribe(data =>{
      this.educacion=data["educacion"];
    })

    

  }

  
}
