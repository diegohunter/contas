import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarMenuComponent } from 'src/app/layouts/sidebar-menu/sidebar-menu.component';
import { LayoutBaseComponent } from 'src/app/layouts/layout-base/layout-base.component';
import { DashboardComponent } from '../dashboard/dashboard.component';
import { AppRouterModule } from 'src/app/app-router/app-router.module';

@NgModule({
  imports: [
    CommonModule,
    AppRouterModule
  ],
  declarations: [
    LayoutBaseComponent,
    SidebarMenuComponent,
    DashboardComponent
  ]
})
export class FrontModule { }
