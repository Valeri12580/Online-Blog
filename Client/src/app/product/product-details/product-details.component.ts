import {Component, OnInit} from '@angular/core';
import {IProduct} from '../IProduct';
import {ProductService} from '../product.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {
  public product: IProduct;

  constructor(public productService: ProductService, public route: ActivatedRoute) {
  }

  ngOnInit(): void {
    const id = this.route.snapshot.params['id'];
    this.productService.findProductById(id).subscribe(response => {
      this.product = response;
    });
  }

}
