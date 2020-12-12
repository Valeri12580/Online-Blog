import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Constants} from '../constants';
import {IProduct} from './IProduct';
import {Observable} from 'rxjs';
import {Router} from '@angular/router';
import {ICommentForm} from '../shared/comment-form/ICommentForm';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  public static PRODUCT_SERVICE_API = `${Constants.SERVER_API}/products`;

  constructor(public httpClient: HttpClient, private router: Router) {
  }

  findAllProducts(): Observable<IProduct[]> {
    return this.httpClient.get<IProduct[]>(ProductService.PRODUCT_SERVICE_API);
  }

  findProductById(id: string): Observable<IProduct> {
    return this.httpClient.get<IProduct>(`${ProductService.PRODUCT_SERVICE_API}/${id}`);
  }

  postProductComment(comment: ICommentForm, productId: string) {
    const url = this.router.url;
    this.httpClient.post(`${ProductService.PRODUCT_SERVICE_API}/${productId}/comment`
      , comment).subscribe(response => {
      this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
        this.router.navigate([url]);
      });
    });
  }

  deleteProductById(id: string) {
    this.httpClient.delete(`${ProductService.PRODUCT_SERVICE_API}/delete/${id}`)
      .subscribe(response => {
          this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
            this.router.navigate(['/products']);
          });
        }
        , error => {
          console.log('errorrr');
        });
  }

  deleteProductComment(commentId: string) {
    const url = this.router.url;
    this.httpClient.delete(`${Constants.SERVER_API}${url}/comment/delete/${commentId}`)
      .subscribe(response => {
        this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
          this.router.navigate([`${url}`]);
        });
      });
  }
}
