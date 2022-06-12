import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './componentes/header/header.component';
import { ConocimientosComponent } from './componentes/conocimientos/conocimientos.component';
import { EducacionComponent } from './componentes/educacion/educacion.component';
import { ExtraComponent } from './componentes/extra/extra.component';
import { FlechaComponent } from './componentes/flecha/flecha.component';
import { ContactoComponent } from './componentes/contacto/contacto.component';
import { HttpClientModule} from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { IdiomasComponent } from './componentes/idiomas/idiomas.component';
import { ReactiveFormsModule } from '@angular/forms';




@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ConocimientosComponent,
    EducacionComponent,
    ExtraComponent,
    FlechaComponent,
    ContactoComponent,
    IdiomasComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
