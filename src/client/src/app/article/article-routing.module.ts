import {RouterModule, Routes} from '@angular/router';

import {NgModule} from '@angular/core';
import {ArticlesListComponent} from './articles-list/articles-list.component';
import {ArticleDetailsComponent} from './article-details/article-details.component';

const routes: Routes = [
  {
    path: 'articles',
    children:
      [
        {
          path: '',
          pathMatch: 'full',
          component: ArticlesListComponent
        }
        ,
        {
          path: ':id',
          component: ArticleDetailsComponent
        }
      ]
  }
]; // sets up routes constant where you define your routes

// configures NgModule imports and exports
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ArticleRoutingModule {

}
