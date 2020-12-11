import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Constants} from '../constants';
import {IArticle} from './IArticle';
import {Observable} from 'rxjs';
import {Router} from '@angular/router';
import {ICommentForm} from '../shared/comment-form/ICommentForm';
import {IAddArticle} from '../admin/article-add/IAddArticle';

@Injectable()
export class ArticleService {
  public static ARTICLE_SERVICE_API = `${Constants.SERVER_API}/articles`;
  public static ARTICLE_DELETE_ENDPOINT = '/delete';


  constructor(private httpClient: HttpClient, private router: Router) {
  }

  findAllArticles(): Observable<IArticle[]> {

    return this.httpClient.get<IArticle[]>(ArticleService.ARTICLE_SERVICE_API);
  }

  findArticleById(id: string): Observable<IArticle> {
    return this.httpClient.get<IArticle>(`${ArticleService.ARTICLE_SERVICE_API}/${id}`);
  }

  deleteArticleById(id: string) {

    this.httpClient.delete(`${ArticleService.ARTICLE_SERVICE_API + ArticleService.ARTICLE_DELETE_ENDPOINT}/${id}`)
      .subscribe(response => {
          this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
            this.router.navigate(['/articles']);
          });
        },
        error => {
          alert('error');
        });
  }

  postArticleComment(articleComment: ICommentForm, publishedEntityId: string) {
    this.httpClient.post(`${ArticleService.ARTICLE_SERVICE_API}/${publishedEntityId}/comment`
      , articleComment).subscribe(response => {
      this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
        this.router.navigate(['/articles/', publishedEntityId]);
      });
    });
  }

  deleteArticleComment(commentId: string) {
    const url = this.router.url;
    this.httpClient.post(`${Constants.SERVER_API}${url}/comment/delete/${commentId}`, commentId).subscribe(response => {
      this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
        this.router.navigate([`${url}`]);
      });
    });

  }


}
