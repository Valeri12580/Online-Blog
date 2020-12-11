import {Component, OnInit} from '@angular/core';
import {IAddArticle} from './IAddArticle';
import {ArticleService} from '../../article/article.service';
import {NgForm} from '@angular/forms';
import {AdminService} from '../admin.service';

@Component({
  selector: 'app-article-add',
  templateUrl: './article-add.component.html',
  styleUrls: ['./article-add.component.css']
})
export class ArticleAddComponent implements OnInit {
  public article = new IAddArticle();

  constructor(public adminService: AdminService) {
  }

  ngOnInit(): void {
  }

  publishArticle(form: NgForm) {
    this.adminService.postArticle(this.article);
  }

}
