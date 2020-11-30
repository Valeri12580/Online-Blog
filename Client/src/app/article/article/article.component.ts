import {Component, Input, OnInit} from '@angular/core';
import {IArticle} from '../IArticle';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {
  @Input()
  public article: IArticle;

  constructor() {

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

}
