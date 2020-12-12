import {Component, OnInit} from '@angular/core';
import {ProductService} from '../product.service';
import {IProduct} from '../IProduct';

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.css']
})
export class ProductsListComponent implements OnInit {
  public products: IProduct[] = null;

  constructor(public productService: ProductService) {
  }

  ngOnInit(): void {
    this.productService.findAllProducts().subscribe(response => {
      this.products = response;
    });
  }

}
