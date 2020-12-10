import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminNavigationComponent } from './admin-navigation/admin-navigation.component';
import { ArticleAddComponent } from './article-add/article-add.component';
import {AdminRoutingModule} from './admin-routing.module';



@NgModule({
  declarations: [AdminNavigationComponent, ArticleAddComponent],
  imports: [
    CommonModule,
    AdminRoutingModule
  ]
})
export class AdminModule { }
