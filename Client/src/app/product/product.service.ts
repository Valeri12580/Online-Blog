import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Constants} from '../constants';
import {IProduct} from './IProduct';
import {Observable} from 'rxjs';
import {Router} from '@angular/router';

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
}
