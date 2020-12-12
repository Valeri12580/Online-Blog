import {NgModule} from '@angular/core';

import {RouterModule, Routes} from '@angular/router';
import {ProductsListComponent} from './products-list/products-list.component';
import {ProductDetailsComponent} from './product-details/product-details.component';

const routes: Routes = [
  {
    path: 'products',
    children:
      [
        {
          path: '',
          pathMatch: 'full',
          component: ProductsListComponent
        }
        ,
        {
          path: ':id',
          component: ProductDetailsComponent
        }
      ]
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class ProductRoutingModule {
}
