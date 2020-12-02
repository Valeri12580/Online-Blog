import {Component, OnInit} from '@angular/core';
import {FormGroup, NgForm} from '@angular/forms';
import {UserRegisterModel} from './UserRegisterModel';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css', './forms-validations.css']
})
export class RegisterComponent implements OnInit {
  public userModel = new UserRegisterModel();

  constructor() {
  }

  ngOnInit(): void {
  }


  loginHandler(formData: NgForm) {
    console.log(formData);
    console.log(formData.form.value.email);
  }


}
