import {Component, OnInit} from '@angular/core';
import {FormGroup, NgForm} from '@angular/forms';
import {UserRegisterModel} from './UserRegisterModel';
import {HttpClient} from '@angular/common/http';
import {Constants} from '../../constants';
import {Router} from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css', './forms-validations.css']
})
export class RegisterComponent implements OnInit {
  public userModel = new UserRegisterModel();
  public static REGISTER_URL = '/users/register';

  constructor(public httpClient: HttpClient, private router: Router) {
  }

  ngOnInit(): void {
  }


  loginHandler(formData: NgForm) {
    this.httpClient.post(`${Constants.SERVER_API + RegisterComponent.REGISTER_URL}`, this.userModel).subscribe(e => {
      console.log(e);
    });
    this.router.navigate(['/users/login']);

  }


}
