import {RouterModule, Routes} from '@angular/router';
import {ShopListComponent} from './shop-list/shop-list.component';
import {NgModule} from '@angular/core';

const routes: Routes = [
  {
    path: 'shop',
    children: [
      {
        path: '',
        pathMatch: 'full',
        component: ShopListComponent
      },
      // , {
      //   path: ':id'
        // component: null
      // }
    ]

  }

]; // sets up routes constant where you define your routes

// configures NgModule imports and exports
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class ShopRoutingModule {

}
