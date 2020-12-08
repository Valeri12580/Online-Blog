import {RouterModule, Routes} from '@angular/router';

import {NgModule} from '@angular/core';
import {HomeUnauthenticatedComponent} from './home-unauthenticated/home-unauthenticated.component';
import {AboutComponent} from './about/about.component';

const routes: Routes = [
  {
    path: '',
    component: HomeUnauthenticatedComponent,
    pathMatch: 'full'
  },
  {
    path: 'about',
    component: AboutComponent
  }
]; // sets up routes constant where you define your routes

// configures NgModule imports and exports
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
