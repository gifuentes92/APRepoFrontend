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
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './componentes/login/login.component';
import { PortfolioComponent } from './componentes/portfolio/portfolio.component';
import { EditarEducacionComponent } from './componentes/educacion/editar-educacion/editar-educacion.component';
import { EditConocimientosComponent } from './componentes/conocimientos/edit-conocimientos/edit-conocimientos.component';
import { EditExtraComponent } from './componentes/extra/edit-extra/edit-extra.component';
import { EditHeaderComponent } from './componentes/header/edit-header/edit-header.component';
import { EditIdiomasComponent } from './componentes/idiomas/edit-idiomas/edit-idiomas.component';





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
    LoginComponent,
    PortfolioComponent,
    EditarEducacionComponent,
    EditConocimientosComponent,
    EditExtraComponent,
    EditHeaderComponent,
    EditIdiomasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
