import {Component, Input, OnInit} from '@angular/core';
import {IProduct} from '../IProduct';
import {AuthenticationService} from '../../core/services/authentication.service';
import {ProductService} from '../product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  @Input()
  public product: IProduct;

  constructor(public authenticationService: AuthenticationService, public productService: ProductService) {
  }


  deleteProduct(id: string) {
    this.productService.deleteProductById(id);
  }

  ngOnInit(): void {
  }

}
