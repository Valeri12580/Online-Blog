import {Component, OnInit} from '@angular/core';
import {IProductAdd} from './IProductAdd';
import {NgForm} from '@angular/forms';
import {ProductService} from '../../product/product.service';
import {IProduct} from '../../product/IProduct';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent implements OnInit {

  public product: IProductAdd = new IProduct();

  constructor(public productService: ProductService) {
  }

  ngOnInit(): void {
  }

  publishForm(productForm: NgForm) :void{
    this.productService.publishProduct(this.product);
  }

}
