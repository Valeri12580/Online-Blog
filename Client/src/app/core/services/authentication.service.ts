import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Constants} from '../../constants';
import {catchError} from 'rxjs/operators';
import {throwError} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  public static LOGIN_ENDPOINT = '/users/login';
  public static LOGOUT_ENDPOINT = '/users/logout';
  isAuthenticated = sessionStorage.getItem('token') !== null;
  isAdmin = null;
  username = null;


  constructor(private httpClient: HttpClient) {

  }

  login(credentials, callback): void {
    const Iresponse: { jwt: '' } = {jwt: ''};
    this.httpClient.post<typeof Iresponse>(`${Constants.SERVER_API + AuthenticationService.LOGIN_ENDPOINT}`, credentials, {observe: 'body'})
      .subscribe(body => {
          let token = body.jwt;
          console.log(token);
          sessionStorage.setItem('token', token.toString());
          this.decodeToken(token);
          this.isAuthenticated = true;
          this.isAdmin = sessionStorage.getItem('roles').includes('ADMIN');
          this.username = sessionStorage.getItem('username');
          callback();


        },
        error => {
          callback();
        });


  }

  decodeToken(token) {
    const decoded: { sub: '', roles: string[], exp: '', iat: '' } = JSON.parse(atob(token.split('.')[1]));
    sessionStorage.setItem('username', decoded.sub);
    sessionStorage.setItem('roles', decoded.roles.join(','));

  }


  logout(callback) {
    this.httpClient.post(`${Constants.SERVER_API + AuthenticationService.LOGOUT_ENDPOINT}`, 'logout')
      .subscribe(response => {
        sessionStorage.removeItem('token');
        sessionStorage.removeItem('username');
        sessionStorage.removeItem('roles');
        this.isAuthenticated = false;
      });


    callback();
  }
}
