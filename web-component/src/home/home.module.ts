import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeRoutingModule } from './home-routing.module';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AvatarModule } from 'primeng/avatar';
import { AvatarGroupModule } from 'primeng/avatargroup';
import { ButtonModule } from 'primeng/button';
import { SpeedDialModule } from 'primeng/speeddial';
import { TabViewModule } from 'primeng/tabview';
import { RequestCreditCardModule } from './request-credit-card/request-credit-card.module';
import { CustomerModule } from './customer/customer.module';
import { TooltipModule } from 'primeng/tooltip';
import { DialogModule } from 'primeng/dialog';

@NgModule({
  declarations: [HomeComponent, DashboardComponent],

  imports: [
    RouterModule,
    CommonModule,
    HomeRoutingModule,
    AvatarModule,
    AvatarGroupModule,
    ButtonModule,
    SpeedDialModule,
    TabViewModule,
    RequestCreditCardModule,
    CustomerModule,
    TooltipModule,
    DialogModule
  ],

})
export class HomeModule { }
