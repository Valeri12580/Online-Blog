import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ITicket} from './ITicket';
import {Observable} from 'rxjs';
import {Constants} from '../constants';

@Injectable({
  providedIn: 'root'
})
export class SupportService {
  public static SUPPORT_SERVICE_API = `${Constants.SERVER_API}/support/tickets`;

  constructor(private httpClient: HttpClient) {
  }


  getAllTickets(): Observable<ITicket[]> {

    return this.httpClient.get<ITicket[]>(SupportService.SUPPORT_SERVICE_API + '?page=0');
  }
}
