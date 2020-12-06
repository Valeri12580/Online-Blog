import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationServiceService {
  authenticated = false;

  constructor(private httpClient: HttpClient) {
  }

  authenticated(credentials, callback) {
    const headers = new HttpHeaders(credentials ? {
      authorization: 'Basic' + btoa(`${credentials.username}:${credentials.password}`)
    } : {});

    this.httpClient.get('user', {headers: headers}).subscribe(response => {
      if (response['name']) {
        this.authenticated = true;
      } else {
        this.authenticated = false;
      }
      return callback && callback();
    });

  }
}
