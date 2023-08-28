import { ChangeDetectionStrategy, Component, OnInit, ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'Amaze-login-area',
  templateUrl: './login-area.component.html',
  styleUrls: ['./login-area.component.scss'],
  encapsulation: ViewEncapsulation.None,
  changeDetection: ChangeDetectionStrategy.Default
})
export class LoginAreaComponent implements OnInit {
  loginForm!: FormGroup;
  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.initializeLoginForm()
  }

  initializeLoginForm(): void {
    this.loginForm = this.formBuilder.group({
      userName: ['', Validators.required],
      password: ['', Validators.required],
    });
  }
}
