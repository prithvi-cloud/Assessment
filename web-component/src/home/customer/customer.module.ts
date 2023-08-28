import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomerRoutingModule } from './customer-routing.module';
import { CustomerListComponent } from './pages/customer-list/customer-list.component';
import { CustomerListAreaComponent } from './component/customer-list-area/customer-list-area.component';
import { CreateCustomerComponent } from './component/create-customer/create-customer.component';
import { InputTextModule } from 'primeng/inputtext';
import { PasswordModule } from 'primeng/password';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CalendarModule } from 'primeng/calendar';
import { RadioButtonModule } from 'primeng/radiobutton';
import { DropdownModule } from 'primeng/dropdown';
import { InputTextareaModule } from 'primeng/inputtextarea';


@NgModule({
  declarations: [
    CustomerListComponent,
    CustomerListAreaComponent,
    CreateCustomerComponent
  ],
  imports: [
    CommonModule,
    CustomerRoutingModule,
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
    CustomerListComponent,
    CustomerListAreaComponent,
    CreateCustomerComponent
  ],
})
export class CustomerModule { }
