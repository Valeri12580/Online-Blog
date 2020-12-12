import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Constants} from '../constants';
import {IProduct} from './IProduct';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  public static PRODUCT_SERVICE_API = `${Constants.SERVER_API}/products`;

  constructor(public httpClient: HttpClient) {
  }

  findAllProducts(): Observable<IProduct[]> {
    return this.httpClient.get<IProduct[]>(ProductService.PRODUCT_SERVICE_API);
  }

  deleteProductById(id: string) {
    
  }
}
