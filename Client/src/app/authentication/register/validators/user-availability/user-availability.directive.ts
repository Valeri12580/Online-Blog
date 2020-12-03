import {Directive} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AbstractControl, FormGroup, NG_VALIDATORS, ValidationErrors, Validator, ValidatorFn} from '@angular/forms';
import {Constants} from '../../../../constants';


@Directive({
  selector: '[appUserAvailability]',
  providers: [{provide: NG_VALIDATORS, useExisting: UserAvailabilityDirective, multi: true}]
})
export class UserAvailabilityDirective implements Validator {
  public result: { email: boolean, username: boolean };

  constructor(public httpClient: HttpClient) {
  }

  userAvailabilityChecker: ValidatorFn = (control: FormGroup): ValidationErrors | null => {
    const username = control.get('username');
    const email = control.get('email');


    if (username === null || email === null) {
      return null;
    }

    this.httpClient.get<{ email: boolean, username: boolean }>(`${Constants.SERVER_API}/users/availability?username=${username.value}&email=${email.value}`).subscribe(response => {
      console.log(response);
      this.result = response;
    });

    let boolResult: boolean = this.result.email && this.result.username;
    let resultToReturn = boolResult ? null : {usernameNotFree: !this.result.username, emailNotFree: !this.result.email};
    return resultToReturn;
  };

  validate(control: AbstractControl): ValidationErrors | null {
    return this.userAvailabilityChecker(control);
  }

}
