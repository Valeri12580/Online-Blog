import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CommentComponent} from './comment/comment.component';
import {CommentFormComponent} from './comment-form/comment-form.component';
import {FormsModule} from '@angular/forms';


@NgModule({
  declarations: [CommentComponent, CommentFormComponent],
  exports: [
    CommentComponent,
    CommentFormComponent
  ],
    imports: [
        CommonModule,
        FormsModule
    ]
})

export class SharedModule { }
