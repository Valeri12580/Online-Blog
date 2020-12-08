import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Constants} from '../constants';
import {IArticle} from './IArticle';
import {Observable} from 'rxjs';

@Injectable()
export class ArticleService {
  public static ARTICLE_SERVICE_API = `${Constants.SERVER_API}/articles`;
  public static ARTICLE_DELETE_ENDPOINT = "/delete/article";


  constructor(private httpClient: HttpClient) {
  }

  findAllArticles(): Observable<IArticle[]> {

    return this.httpClient.get<IArticle[]>(ArticleService.ARTICLE_SERVICE_API);
  }

  findArticleById(id: string): Observable<IArticle> {
    return this.httpClient.get<IArticle>(ArticleService.ARTICLE_SERVICE_API + `/${id}`);
  }

  deleteArticleById(id:string){

    return this.httpClient.delete(`${ArticleService.ARTICLE_SERVICE_API}`)
  }


}
