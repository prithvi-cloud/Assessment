import { NgModule } from '@angular/core';
import { Route, RouterModule, Routes } from '@angular/router';
import { UserDetailsComponent } from './pages/user-details/user-details.component';


const routes: Route[] = [
  {
    path: '',
    pathMatch: 'full',
    component: UserDetailsComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserDetailsRoutingModule { }
