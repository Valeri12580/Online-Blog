import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ArticleDetailsComponent} from './article-details/article-details.component';
import {ArticlesListComponent} from './articles-list/articles-list.component';
import {ArticleRoutingModule} from './article-routing.module';
import {ArticleService} from './article.service';
import {ArticleComponent} from './article/article.component';
import {SharedModule} from '../shared/shared.module';


@NgModule({
  declarations: [ArticleDetailsComponent, ArticlesListComponent, ArticleComponent],
    imports: [
        CommonModule,
        ArticleRoutingModule,
        SharedModule
    ],
  providers: [ArticleService]
})
export class ArticleModule {
}
