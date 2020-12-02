import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RegisterComponent} from './register/register.component';
import {LoginComponent} from './login/login.component';
import {AuthenticationRoutingModule} from './authentication-routing.module';
import {FormsModule} from '@angular/forms';
import { EqualPasswordValidatorDirective } from './register/validators/equal-passwords/equal-password-validator.directive';


@NgModule({
  declarations: [RegisterComponent, LoginComponent, EqualPasswordValidatorDirective],
    imports: [
        CommonModule,
        AuthenticationRoutingModule,
        FormsModule
    ]
})
export class AuthenticationModule {
}
