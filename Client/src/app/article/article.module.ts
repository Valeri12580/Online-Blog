import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ArticleDetailsComponent} from './article-details/article-details.component';
import {ArticlesListComponent} from './articles-list/articles-list.component';
import {ArticleRoutingModule} from './article-routing.module';


@NgModule({
  declarations: [ArticleDetailsComponent, ArticlesListComponent],
  imports: [
    CommonModule,
    ArticleRoutingModule
  ]
})
export class ArticleModule {
}
