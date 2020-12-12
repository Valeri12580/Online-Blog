import {Injectable} from '@angular/core';
import {IAddArticle} from './article-add/IAddArticle';
import {HttpClient} from '@angular/common/http';
import {Constants} from '../constants';
import {IArticle} from '../article/IArticle';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  public static ADMIN_SERVICE_API = `${Constants.SERVER_API}/admin`;
  public static ADD_ARTICLE_ENDPOINT = '/add-article';


  constructor(public httpClient: HttpClient, public router: Router) {
  }


  postArticle(article: IAddArticle) {
    this.httpClient.post<IArticle>(`${AdminService.ADMIN_SERVICE_API + AdminService.ADD_ARTICLE_ENDPOINT}`, article, {observe: 'body'})
      .subscribe(response => {
        this.router.navigate(['/articles', response.id]);
      });
  }
}
