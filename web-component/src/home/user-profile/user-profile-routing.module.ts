import { NgModule } from '@angular/core';
import { Route, RouterModule, Routes } from '@angular/router';
import { UserProfileHomeComponent } from './user-profile-home/user-profile-home.component';

const routes: Route[] = [
  {
    path: '',
    component: UserProfileHomeComponent,
    children: [
      {
        path: '',
        redirectTo: 'user-details',
        pathMatch: 'full',
      },
      {
        path: 'user-details',
        loadChildren: () =>
          import('../user-profile/user-details/user-details.module').then(
            (module) => module.UserDetailsModule
          )
      },
      {
        path: 'credit-card-list',
        loadChildren: () =>
          import('../user-profile/credit-card-history/credit-card-history.module').then(
            (module) => module.CreditCardHistoryModule
          )
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserProfileRoutingModule { }
