import { NgModule } from '@angular/core';
import { Route, RouterModule, Routes } from '@angular/router';
import { CustomerListComponent } from './pages/customer-list/customer-list.component';

const routes: Route[] = [
  {
    path: '',
    component: CustomerListComponent,
    pathMatch: 'full'
  },
];
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule { }
