
import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { LoginComponent } from './auth-pages/login/login.component';

const routes: Route[] = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'

  },
  {
    path: 'login',
    component: LoginComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthenticationRoutingModule { }
