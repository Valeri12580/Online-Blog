import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AdminNavigationComponent} from './admin-navigation/admin-navigation.component';
import {ArticleAddComponent} from './article-add/article-add.component';
import {AdminRoutingModule} from './admin-routing.module';
import {AdminHomeComponent} from './admin-home/admin-home.component';
import {ProductAddComponent} from './product-add/product-add.component';
import {FormsModule} from '@angular/forms';


@NgModule({
  declarations: [AdminNavigationComponent, ArticleAddComponent, AdminHomeComponent, ProductAddComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule
  ]
})
export class AdminModule { }
