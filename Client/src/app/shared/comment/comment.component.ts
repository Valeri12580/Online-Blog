import {Component, Input, OnInit} from '@angular/core';
import {IComment} from '../IComment';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {

  @Input()
  public comment: IComment;

  constructor() {
  }

  ngOnInit(): void {
    let date = new Date(this.comment.publishedOn);
    this.comment.timePublishedOn = `${date.getHours()}:${date.getMinutes()}:${date.getSeconds()}`;
    this.comment.datePublishedOn = `${date.getDate()}/${date.getMonth()}/${date.getFullYear()}`;

  }

}
