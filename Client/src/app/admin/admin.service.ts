import {Injectable} from '@angular/core';
import {IAddArticle} from './article-add/IAddArticle';
import {ArticleService} from '../article/article.service';
import {HttpClient} from '@angular/common/http';
import {Constants} from '../constants';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  public static ADMIN_SERVICE_API = `${Constants.SERVER_API}/admin`;
  public static ADD_ARTICLE_ENDPOINT = '/add-article';


  constructor(public httpClient: HttpClient) {
  }


  postArticle(article: IAddArticle) {
    this.httpClient.post(`${AdminService.ADMIN_SERVICE_API + AdminService.ADD_ARTICLE_ENDPOINT}`, article)
      .subscribe(response => {
        console.log('Log');
      });
  }
}
