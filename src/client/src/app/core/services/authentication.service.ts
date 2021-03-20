import {Injectable, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Constants} from '../../constants';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService implements OnInit {
  public static LOGIN_ENDPOINT = '/users/login';
  public static LOGOUT_ENDPOINT = '/users/logout';
  isAuthenticated = localStorage.getItem('token') !== null;
  isAdmin = null;
  username = null;


  constructor(private httpClient: HttpClient) {


  }

  ngOnInit(): void {
    if (localStorage.getItem('roles') !== null && localStorage.getItem('username') !== null) {
      this.isAdmin = localStorage.getItem('roles').includes('ADMIN');
      this.username = localStorage.getItem('username');
    }
  }

  login(credentials, callback): void {
    const Iresponse: { jwt: '' } = {jwt: ''};
    this.httpClient.post(`${Constants.SERVER_API + AuthenticationService.LOGIN_ENDPOINT}`, credentials, {
      responseType: 'text'
    })
      .subscribe(body => {
          let token = body;
          console.log(token);
          localStorage.setItem('token', token.toString());
          this.decodeToken(token);
          this.isAuthenticated = true;
          this.isAdmin = localStorage.getItem('roles').includes('ADMIN');
          this.username = localStorage.getItem('username');
          callback();


        },
        error => {
          callback();
        });


  }

  decodeToken(token) {
    const decoded: { sub: '', roles: string, exp: '', iat: '' } = JSON.parse(atob(token.split('.')[1]));
    localStorage.setItem('username', decoded.sub);
    localStorage.setItem('roles', decoded.roles);

  }


  logout(callback) {
    this.httpClient.post(`${Constants.SERVER_API + AuthenticationService.LOGOUT_ENDPOINT}`, '')
      .subscribe(response => {
        localStorage.removeItem('token');
        localStorage.removeItem('username');
        localStorage.removeItem('roles');
        this.isAuthenticated = false;
      });


    callback();
  }


}
