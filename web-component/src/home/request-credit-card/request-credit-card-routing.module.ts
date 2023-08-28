import { NgModule } from '@angular/core';
import { Route, RouterModule, Routes } from '@angular/router';
import { RequestCreditCardListComponent } from './pages/request-credit-card-list/request-credit-card-list.component';

const routes: Route[] = [
  {
    path: '',
    component: RequestCreditCardListComponent,
    pathMatch: 'full'
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RequestCreditCardRoutingModule { }
