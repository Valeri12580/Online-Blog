import {Component, OnInit} from '@angular/core';
import {IProductAdd} from './IProductAdd';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent implements OnInit {

  public product: IProductAdd = null;

  constructor() {
  }

  ngOnInit(): void {
  }

  publishForm(productForm: NgForm) {
    console.log(productForm);
  }

}
