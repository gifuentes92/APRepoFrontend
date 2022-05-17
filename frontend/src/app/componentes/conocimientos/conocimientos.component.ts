import { Component, OnInit } from '@angular/core';
import { ConocimientosService } from 'src/app/servicios/conocimientos.service';

@Component({
  selector: 'app-conocimientos',
  templateUrl: './conocimientos.component.html',
  styleUrls: ['./conocimientos.component.css']
})
export class ConocimientosComponent implements OnInit {
  conocimientos:any;

  constructor(private miServicio:ConocimientosService) { }

  ngOnInit(): void {
    this.miServicio.obtenerDatosConocimientos().subscribe(data =>{
      this.conocimientos=data["conocimientos"];
    })
  }

}
