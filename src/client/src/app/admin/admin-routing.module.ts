import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {ArticleAddComponent} from './article-add/article-add.component';

import {AdminHomeComponent} from './admin-home/admin-home.component';
import {ProductAddComponent} from './product-add/product-add.component';
import {AdminGuard} from './admin.guard';

export const routes: Routes = [
    {
      path: 'admin',
      component: AdminHomeComponent,
      canActivate: [AdminGuard],
      children: [
        {
          path: 'article-add',
          component: ArticleAddComponent,
          outlet: 'admin-outlet'
        }
        , {
          path: 'IAddProduct-add',
          component: ProductAddComponent,
          outlet: 'admin-outlet'
        }
      ]
    }


  ]
; // sets up routes constant where you define your routes

// configures NgModule imports and exports
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule {

}
