import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ArticleDetailsComponent} from './article-details/article-details.component';
import {ArticlesListComponent} from './articles-list/articles-list.component';
import {ArticleRoutingModule} from './article-routing.module';
import {ArticleService} from './article.service';
import {HttpClientModule} from '@angular/common/http';
import { ArticleComponent } from './article/article.component';


@NgModule({
  declarations: [ArticleDetailsComponent, ArticlesListComponent, ArticleComponent],
  imports: [
    CommonModule,
    ArticleRoutingModule
  ],
  providers: [ArticleService]
})
export class ArticleModule {
}
