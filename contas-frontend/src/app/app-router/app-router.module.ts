import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Router, Routes } from '@angular/router';
import { LayoutBaseComponent } from '../layouts/layout-base/layout-base.component';
import { DashboardComponent } from '../front/dashboard/dashboard.component';


const routes: Routes = [

   {
     path: '', component: LayoutBaseComponent, children: [
       { path: '', component: DashboardComponent, pathMatch: 'full' },
       { path: 'dashboard', component: DashboardComponent },
      ]
    },
  //{
  //  //path: 'admin', component: FetchDataComponent, children: [
  //  //  { path: '', component: HomeComponent, pathMatch: 'full' },
  //  //  { path: 'counter', component: CounterComponent },
  //  //  { path: 'fetch-data', component: FetchDataComponent },
  //  //  { path: 'pedidos', component: ListPedidoComponent },
  //  //  { path: 'pedido/:id', component: PedidoEdicaoComponent }
  //  //]
  //}
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [ RouterModule ],
  declarations: []
})
export class AppRouterModule { }
