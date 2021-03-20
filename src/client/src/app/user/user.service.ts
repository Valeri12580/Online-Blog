import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {IUser} from '../shared/IUser';
import {Constants} from '../constants';

@Injectable()
export class UserService {
  public static USER_SERVICE_API = `${Constants.SERVER_API}/users`;

  constructor(public httpClient: HttpClient) {

  }

  findUserByUsername(username: string): Observable<IUser> {
    return this.httpClient.get<IUser>(`${UserService.USER_SERVICE_API}/profile/${username}`);
  }


}
