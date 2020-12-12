import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ProductComponent} from './product/product.component';
import {ProductDetailsComponent} from './product-details/product-details.component';
import {ProductsListComponent} from './products-list/products-list.component';

import {ProductService} from './product.service';
import {ProductRoutingModule} from './product-routing.module';


@NgModule({
  declarations: [ProductComponent, ProductDetailsComponent, ProductsListComponent],
  imports: [
    CommonModule,
    ProductRoutingModule
  ]
  , providers: [ProductService]
})
export class ProductModule {
}
