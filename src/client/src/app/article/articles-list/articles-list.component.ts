import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {ArticleService} from '../article.service';
import {IArticle} from '../IArticle';

@Component({
  selector: 'app-articles-list',
  templateUrl: './articles-list.component.html',
  styleUrls: ['./articles-list.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ArticlesListComponent implements OnInit {
  public articles: IArticle[];
  public articleService: ArticleService;

  constructor(articleService: ArticleService) {
    this.articleService = articleService;
  }

  ngOnInit(): void {
    this.articleService.findAllArticles().subscribe(e => this.articles = e.sort((a, b) => b.publishedOn.localeCompare(a.publishedOn)));
  }

}
