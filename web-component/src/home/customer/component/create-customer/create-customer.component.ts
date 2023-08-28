import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent {
  userForm!: FormGroup;
  constructor(private formBuilder: FormBuilder) {

  }

  ngOnInit() {
    this.initializeCustomerForm()
  }

  initializeCustomerForm(): void {
    this.userForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      DOB: ['', Validators.required],
      email: ['', Validators.required, Validators.email],
      phoneNumber: ['', Validators.required],
      gender: ['male', Validators.required],
      userType: ['user', Validators.required],
      address: ['', Validators.required],
      nationality: ['', Validators.required],
      password: ['', Validators.required]
    });
  }
}
