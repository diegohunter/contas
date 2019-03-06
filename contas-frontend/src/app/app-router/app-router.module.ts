import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Router, Routes } from '@angular/router';


const routes: Routes = [
  /**

   {
     path: '', component: LojaLayoutComponent, children: [
       { path: '', component: VitrineComponent, pathMatch: 'full' },
       { path: 'login', component: LoginComponent },
       { path: 'carrinho', component: CarrinhoComponent }
      ]
    },
   */
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
