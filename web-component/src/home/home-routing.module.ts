

import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { UserProfileHomeComponent } from './user-profile/user-profile-home/user-profile-home.component';
import { DashboardComponent } from './dashboard/dashboard.component';

const routes: Route[] = [
  {
    path: '',
    component: HomeComponent,
    children: [
      {
        path: '',
        redirectTo: 'dashboard',
        pathMatch: 'full',
      },
      {
        path: 'dashboard',
        component: DashboardComponent,
      },
      {
        path: 'user',
        loadChildren: () => import('../home/user-profile/user-profile.module').then((module) => module.UserProfileModule)
      },
      {
        path: 'customer',
        loadChildren: () => import('../home/customer/customer.module').then((module) => module.CustomerModule)
      },
      {
        path: 'credit-card-request',
        loadChildren: () => import('../home/request-credit-card/request-credit-card.module').then((module) => module.RequestCreditCardModule)
      },
    ],
  },



];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class HomeRoutingModule { }
