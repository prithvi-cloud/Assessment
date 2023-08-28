import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserDetailsRoutingModule } from './user-details-routing.module';
import { UserDetailsComponent } from './pages/user-details/user-details.component';
import { UserDetailsAreaComponent } from './components/user-details-area/user-details-area.component';


@NgModule({
  declarations: [
    UserDetailsComponent,
    UserDetailsAreaComponent
  ],
  imports: [
    CommonModule,
    UserDetailsRoutingModule
  ]
})
export class UserDetailsModule { }
