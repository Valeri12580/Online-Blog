import {Component, Input, OnInit} from '@angular/core';
import {IArticle} from '../IArticle';
import {ArticleService} from '../article.service';
import {AuthenticationService} from '../../core/services/authentication.service';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {
  @Input()
  public article: IArticle;

  constructor(private articleService: ArticleService, public authenticationService: AuthenticationService) {

  }

  ngOnInit(): void {
    this.article.publishedOn = this.formatDate(this.article.publishedOn);
  }

  formatDate(date: string): string {
    let result = '';
    const dateObj: Date = new Date(date);
    result = `${dateObj.getHours()}:${dateObj.getMinutes()}  ${dateObj.getDate()}/${dateObj.getMonth()}/${dateObj.getFullYear()}`;
    return result;
  }

  deleteArticle(id: string) {
    this.articleService.deleteArticleById(id);
  }
}
