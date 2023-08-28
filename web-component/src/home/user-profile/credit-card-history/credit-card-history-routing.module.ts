import { NgModule } from '@angular/core';
import { Route, RouterModule, Routes } from '@angular/router';
import { CreditListComponent } from './pages/credit-list/credit-list.component';

const routes: Route[] = [
  {
    path: '',
    pathMatch: 'full',
    component: CreditListComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CreditCardHistoryRoutingModule { }
