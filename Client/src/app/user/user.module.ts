import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RegisterComponent} from './register/register.component';
import {LoginComponent} from './login/login.component';
import {UserRoutingModule} from './user-routing.module';
import {FormsModule} from '@angular/forms';
import { EqualPasswordValidatorDirective } from './register/validators/equal-passwords/equal-password-validator.directive';
import { UserAvailabilityDirective } from './register/validators/user-availability/user-availability.directive';
import { UserProfileComponent } from './user-profile/user-profile.component';


@NgModule({
  declarations: [RegisterComponent, LoginComponent, EqualPasswordValidatorDirective, UserAvailabilityDirective, UserProfileComponent],
    imports: [
        CommonModule,
        UserRoutingModule,
        FormsModule
    ]
})
export class UserModule {
}
