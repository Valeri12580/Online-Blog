import {Injectable} from '@angular/core';
import {IAddArticle} from './article-add/IAddArticle';
import {HttpClient} from '@angular/common/http';
import {Constants} from '../constants';
import {IArticle} from '../article/IArticle';
import {Router} from '@angular/router';
import {IProduct} from '../product/IProduct';
import {IProductAdd} from './product-add/IProductAdd';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  public static ADMIN_SERVICE_API = `${Constants.SERVER_API}/admin`;
  public static ADD_ARTICLE_ENDPOINT = '/add-article';
  public static ADD_PRODUCT_ENDPOINT = '/add-product';


  constructor(public httpClient: HttpClient, public router: Router) {
  }


  postArticle(article: IAddArticle) {
    this.httpClient.post<IArticle>(`${AdminService.ADMIN_SERVICE_API + AdminService.ADD_ARTICLE_ENDPOINT}`, article, {observe: 'body'})
      .subscribe(response => {
        this.router.navigate(['/articles', response.id]);
      });
  }

  postProduct(product: IProductAdd): void {
    this.httpClient.post<IProduct>(`${AdminService.ADMIN_SERVICE_API+AdminService.ADD_PRODUCT_ENDPOINT}`, product)
      .subscribe(response => {
        this.router.navigate(['/products', response.id]);
      });

  }
}
