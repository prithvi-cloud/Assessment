import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CreditCardHistoryRoutingModule } from './credit-card-history-routing.module';
import { CreditListComponent } from './pages/credit-list/credit-list.component';
import { CreditListAreaComponent } from './components/credit-list-area/credit-list-area.component';


@NgModule({
  declarations: [
    CreditListComponent,
    CreditListAreaComponent
  ],
  imports: [
    CommonModule,
    CreditCardHistoryRoutingModule
  ]
})
export class CreditCardHistoryModule { }
