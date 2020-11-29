import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Constants} from '../constants';
import {IArticle} from './IArticle';
import {Observable} from 'rxjs';

@Injectable()
export class ArticleService {
  private ARTICLE_SERVICE_API = `${Constants.SERVER_API}/articles`;

  constructor(private httpClient: HttpClient) {
  }

  findAllArticles(): Observable<IArticle[]> {

    return this.httpClient.get<IArticle[]>(this.ARTICLE_SERVICE_API);
  }

  findArticleById(id: string): Observable<IArticle> {
    return this.httpClient.get<IArticle>(this.ARTICLE_SERVICE_API + `/${id}`);
  }


}
