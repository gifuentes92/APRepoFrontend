import { Component, OnInit } from '@angular/core';
import { throws } from 'assert';
import { IdiomasService } from 'src/app/servicios/idiomas.service';

@Component({
  selector: 'app-idiomas',
  templateUrl: './idiomas.component.html',
  styleUrls: ['./idiomas.component.css']
})
export class IdiomasComponent implements OnInit {
  idioma:any;

  constructor(private miServicio:IdiomasService) { }

  ngOnInit(): void {
    this.miServicio.obtenerIdiomas().subscribe(data =>{
      console.log(data);
      this.idioma=data["idioma"];
    })

}
}
