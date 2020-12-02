import {Directive} from '@angular/core';
import {AbstractControl, FormGroup, NG_VALIDATORS, ValidationErrors, Validator, ValidatorFn} from '@angular/forms';


export const equalPasswordValidator: ValidatorFn = (control: FormGroup): ValidationErrors | null => {
  console.log(control);
  const password = control.get('password');
  const rePassword = control.get('rePassword');
  if (password === null || rePassword === null) {
    return null;
  }


  return password.value === rePassword.value ? null : {notMatch: 'true'};
};

@Directive({
  selector: '[appEqualPasswordValidator]',
  providers: [{provide: NG_VALIDATORS, useExisting: EqualPasswordValidatorDirective, multi: true}]
})
export class EqualPasswordValidatorDirective implements Validator {

  validate(control: AbstractControl): ValidationErrors | null {

    return equalPasswordValidator(control);
  }


}
