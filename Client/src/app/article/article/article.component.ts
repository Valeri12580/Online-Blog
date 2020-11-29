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
  }

}
