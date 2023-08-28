import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { AuthenticationModule } from '../authentication/authentication.module';

const routes: Route[] = [
  {
    path: '',
    redirectTo: 'auth',
    pathMatch: 'full'
  },
  {
    path: 'auth',
    loadChildren: () => import('../authentication/authentication.module').then((module) => module.AuthenticationModule)
  },
  {
    path: 'home',
    loadChildren: () => import('../home/home.module').then((module) => module.HomeModule)
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes),AuthenticationModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
