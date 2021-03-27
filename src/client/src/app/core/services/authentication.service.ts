import {Injectable, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Constants} from '../../constants';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  public static LOGIN_ENDPOINT = '/users/login';
  public static LOGOUT_ENDPOINT = '/users/logout';

  isAuthenticated = localStorage.getItem('token') !== null;


  constructor(private httpClient: HttpClient) {

  }


  getUsername(): string {
    return localStorage.getItem('username');
  }

  isAdmin(): boolean {
    return localStorage.getItem('roles').includes('ADMIN');
  }


  login(credentials, callback): void {
    const Iresponse: { jwt: '' } = {jwt: ''};
    this.httpClient.post(`${Constants.SERVER_API + AuthenticationService.LOGIN_ENDPOINT}`, credentials, {
      responseType: 'text'
    })
      .subscribe(body => {
          let token = body;

          localStorage.setItem('token', token.toString());
          this.decodeToken(token);
          this.isAuthenticated = true;
          localStorage.getItem('roles').includes('ADMIN');
          localStorage.getItem('username');
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
        this.clearData();
        console.log(response);
      });


    callback();
  }

  clearData(): void {
    localStorage.removeItem('token');
    localStorage.removeItem('username');
    localStorage.removeItem('roles');
    this.isAuthenticated = false;
  }


}
