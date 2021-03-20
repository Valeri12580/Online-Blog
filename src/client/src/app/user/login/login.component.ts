import {Component, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';
import {AuthenticationService} from '../../core/services/authentication.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public credentials: {
    username,
    password
  } = {username: null, password: null};

  constructor(private authenticationService: AuthenticationService, private router: Router) {
  }

  ngOnInit(): void {
  }

  login(loginForm: NgForm): void {

    this.authenticationService.login(this.credentials, () => {
      if (this.authenticationService.isAuthenticated) {
        this.router.navigate(['/']);
      } else {
        loginForm.form.controls['username'].setErrors({'invalid': true});
      }

    });


  }
}
