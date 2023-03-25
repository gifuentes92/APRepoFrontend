import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactoComponent } from './componentes/contacto/contacto.component';
import { LoginComponent } from './componentes/login/login.component';
import { PortfolioComponent } from './componentes/portfolio/portfolio.component';
import { EditarEducacionComponent } from './componentes/educacion/editar-educacion/editar-educacion.component';
import { EditConocimientosComponent } from './componentes/conocimientos/edit-conocimientos/edit-conocimientos.component';
import { EditExtraComponent } from './componentes/extra/edit-extra/edit-extra.component';
import { EditHeaderComponent } from './componentes/header/edit-header/edit-header.component';
import { EditIdiomasComponent } from './componentes/idiomas/edit-idiomas/edit-idiomas.component';

const routes: Routes = [
  {path:'portfolio', component:PortfolioComponent},
  {path:'login', component:LoginComponent},
  {path:'contacto',component:ContactoComponent},
  {path:'editedu/:id',component:EditarEducacionComponent},
  {path:'editskill/:id',component:EditConocimientosComponent},
  {path:'editextra/:id',component:EditExtraComponent},
  {path:'editheader/:id',component:EditHeaderComponent},
  {path:'editidiomas/:id',component:EditIdiomasComponent},
  {path: '',redirectTo:'portfolio',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
