import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {IArticle} from '../IArticle';
import {ArticleService} from '../article.service';

@Component({
  selector: 'app-article-details',
  templateUrl: './article-details.component.html',
  styleUrls: ['./article-details.component.css']
})
export class ArticleDetailsComponent implements OnInit {

  public article: IArticle;

  constructor(public route: ActivatedRoute, public articleService: ArticleService) {
  }

  ngOnInit(): void {
    this.articleService.findArticleById(this.route.snapshot.paramMap.get('id'))
      .subscribe(e => {
        this.article = e;
        this.article.publishedOn = this.formatDate(this.article.publishedOn);
        this.article.comments = this.article.comments.sort((a, b) => b.publishedOn.localeCompare(a.publishedOn));
      });


  }

  formatDate(date: string): string {
    let result = '';
    const dateObj: Date = new Date(date);
    result = `${dateObj.getHours()}:${dateObj.getMinutes()}  ${dateObj.getDate()}/${dateObj.getMonth()}/${dateObj.getFullYear()}`;
    return result;
  }

}
