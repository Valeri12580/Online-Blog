import {RouterModule, Routes} from '@angular/router';
import {RegisterComponent} from '../user/register/register.component';
import {LoginComponent} from '../user/login/login.component';
import {UserProfileComponent} from '../user/user-profile/user-profile.component';
import {NgModule} from '@angular/core';
import {ArticleAddComponent} from './article-add/article-add.component';

const routes: Routes = [
  {
    path: 'admin',
    children: [
      {
        path: 'article-add',
        component: ArticleAddComponent
      }
    ]
  }
]; // sets up routes constant where you define your routes

// configures NgModule imports and exports
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule {

}
