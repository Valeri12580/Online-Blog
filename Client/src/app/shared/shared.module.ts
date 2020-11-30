import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import { CommentComponent } from './comment/comment.component';
import { CommentFormComponent } from './comment-form/comment-form.component';


@NgModule({
  declarations: [CommentComponent, CommentFormComponent],
  exports: [
    CommentComponent,
    CommentFormComponent
  ],
  imports: [
    CommonModule
  ]
})
export class SharedModule { }
