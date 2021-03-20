import {Component, Input, OnInit} from '@angular/core';
import {IComment} from '../IComment';
import {AuthenticationService} from '../../core/services/authentication.service';
import {ArticleService} from '../../article/article.service';
import {Router} from '@angular/router';
import {ProductService} from '../../product/product.service';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {

  @Input()
  public comment: IComment;

  constructor(public authenticationService: AuthenticationService, public articleService: ArticleService,
              public productService: ProductService, public router: Router) {
  }

  ngOnInit(): void {
    let date = new Date(this.comment.publishedOn);
    this.comment.timePublishedOn = `${date.getHours()}:${date.getMinutes()}:${date.getSeconds()}`;
    this.comment.datePublishedOn = `${date.getDate()}/${date.getMonth()}/${date.getFullYear()}`;

  }

  deleteComment(id: string) {
    const url = this.router.url;
    if (url.includes('/articles')) {
      this.articleService.deleteArticleComment(id);
    } else {
      this.productService.deleteProductComment(id);
    }

  }

}
