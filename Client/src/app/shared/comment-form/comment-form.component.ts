import {Component, Input, OnInit} from '@angular/core';
import {ICommentForm} from './ICommentForm';
import {ArticleService} from '../../article/article.service';
import {NgForm} from '@angular/forms';
import {AuthenticationService} from '../../core/services/authentication.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-comment-form',
  templateUrl: './comment-form.component.html',
  styleUrls: ['./comment-form.component.css']
})
export class CommentFormComponent implements OnInit {
  //id -article or product
  @Input()
  publishedEntityId: string;

  public iCommentForm = new ICommentForm();

  constructor(public articleService: ArticleService, public router: Router,public authenticationService:AuthenticationService) {
  }

  ngOnInit(): void {
  }

  postComment(commentForm: NgForm) {
    const url = this.router.url;
    console.log(url);
    console.log(this.publishedEntityId);

    if (url.includes('/articles')) {
      this.articleService.postArticleComment(this.iCommentForm, this.publishedEntityId);
    } else {
      console.log('product!');
    }


  }
}
