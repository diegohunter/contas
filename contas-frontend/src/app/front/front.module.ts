import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppRouterModule } from '../app-router/app-router.module';
import { LayoutBaseComponent } from '../layouts/layout-base/layout-base.component';
import { SidebarMenuComponent } from '../layouts/sidebar-menu/sidebar-menu.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { TopNavComponent } from '../layouts/top-nav/top-nav.component';

@NgModule({
  imports: [
    CommonModule,
    AppRouterModule
  ],
  declarations: [
    LayoutBaseComponent,
    SidebarMenuComponent,
    DashboardComponent,
    TopNavComponent
  ]
})
export class FrontModule { }
