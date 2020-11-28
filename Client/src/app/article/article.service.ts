import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class ArticleService {

  constructor(private httpClient: HttpClient) {
  }


}
