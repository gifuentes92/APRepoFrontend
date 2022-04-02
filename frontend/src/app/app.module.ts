import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './componentes/header/header.component';
import { ConocimientosComponent } from './componentes/conocimientos/conocimientos.component';
import { EducacionComponent } from './componentes/educacion/educacion.component';
import { ExtraComponent } from './componentes/extra/extra.component';
import { FlechaComponent } from './componentes/flecha/flecha.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ConocimientosComponent,
    EducacionComponent,
    ExtraComponent,
    FlechaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
