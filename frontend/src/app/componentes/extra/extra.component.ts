import { Component, OnInit } from '@angular/core';
import { throws } from 'assert';
import { ExtraService } from 'src/app/servicios/extra.service';

@Component({
  selector: 'app-extra',
  templateUrl: './extra.component.html',
  styleUrls: ['./extra.component.css']
})
export class ExtraComponent implements OnInit {
  extra:any;
 

  constructor(private miServicio:ExtraService) { }

  ngOnInit(): void {
    this.miServicio.obtenerExtraConocimientos().subscribe(data =>{
      console.log(data);
      this.extra=data["extra"];
    })

   

  }

}
