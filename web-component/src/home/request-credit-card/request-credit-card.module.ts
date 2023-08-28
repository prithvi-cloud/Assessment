import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RequestCreditCardRoutingModule } from './request-credit-card-routing.module';
import { RequestCreditCardListComponent } from './pages/request-credit-card-list/request-credit-card-list.component';
import { RequestCreditCardListAreaComponent } from './components/request-credit-card-list-area/request-credit-card-list-area.component';
import { CreateRequestCreditCardComponent } from './components/create-request-credit-card/create-request-credit-card.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { CalendarModule } from 'primeng/calendar';
import { DropdownModule } from 'primeng/dropdown';
import { InputTextModule } from 'primeng/inputtext';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { PasswordModule } from 'primeng/password';
import { RadioButtonModule } from 'primeng/radiobutton';


@NgModule({
  declarations: [
    RequestCreditCardListComponent,
    RequestCreditCardListAreaComponent,
    CreateRequestCreditCardComponent
  ],
  imports: [
    CommonModule,
    RequestCreditCardRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    PasswordModule,
    InputTextModule,
    CalendarModule,
    RadioButtonModule,
    DropdownModule,
    InputTextareaModule
  ],
  exports: [
    RequestCreditCardListComponent,
    RequestCreditCardListAreaComponent,
    CreateRequestCreditCardComponent
  ],
})
export class RequestCreditCardModule { }
