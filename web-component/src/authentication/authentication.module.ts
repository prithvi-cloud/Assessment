import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthenticationRoutingModule } from './authentication-routing.module';
import { LoginComponent } from './auth-pages/login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginAreaComponent } from './auth-components/login-area/login-area.component';
import { ButtonModule } from 'primeng/button';
import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';


@NgModule({
  declarations: [LoginComponent, LoginAreaComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    AuthenticationRoutingModule,
    ButtonModule,
    PasswordModule,
    InputTextModule
  ],

})
export class AuthenticationModule { }
