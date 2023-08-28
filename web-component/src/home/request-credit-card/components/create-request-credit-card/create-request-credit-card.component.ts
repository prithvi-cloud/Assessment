import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-create-request-credit-card',
  templateUrl: './create-request-credit-card.component.html',
  styleUrls: ['./create-request-credit-card.component.css']
})
export class CreateRequestCreditCardComponent {
  creditCardRequestForm!: FormGroup;
  constructor(private formBuilder: FormBuilder) {

  }
  ngOnInit() {
    this.initializeCustomerForm()
  }

  initializeCustomerForm(): void {
    this.creditCardRequestForm = this.formBuilder.group({
      creditLimit: ['', Validators.required],
      income: ['', Validators.required],
      DOB: ['', Validators.required],
      applyDate: ['', Validators.required],
      status: ['', Validators.required],
    });
  }
}
