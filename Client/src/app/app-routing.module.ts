import {RouterModule, Routes} from '@angular/router';

import {NgModule} from '@angular/core';
import {HomeUnauthenticatedComponent} from './home-unauthenticated/home-unauthenticated.component';
import {ArticlesListComponent} from './article/articles-list/articles-list.component';
import {AboutComponent} from './about/about.component';
import {ShopComponent} from './shop/shop.component';

const routes: Routes = [
  {
    path: '',
    component: HomeUnauthenticatedComponent
  },
  {
    path: 'about',
    component: AboutComponent
  },
  {
    path: 'shop',
    component: ShopComponent
  }

]; // sets up routes constant where you define your routes

// configures NgModule imports and exports
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
