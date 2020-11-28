import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {NavigationComponent} from './core/navigation/navigation.component';
import {FooterComponent} from './core/footer/footer.component';
import {HomeUnauthenticatedComponent} from './home-unauthenticated/home-unauthenticated.component';
import {RegisterComponent} from './authentication/register/register.component';
import {LoginComponent} from './authentication/login/login.component';
import {ArticlesListComponent} from './article/articles-list/articles-list.component';
import {ArticleDetailsComponent} from './article/article-details/article-details.component';
import {RouterModule} from '@angular/router';
import {AboutComponent} from './about/about.component';
import {ShopComponent} from './shop/shop.component';
import {CoreModule} from './core/core.module';
import {AuthenticationModule} from './authentication/authentication.module';
import {AppRoutingModule} from './app-routing.module';
import {ArticleModule} from './article/article.module';

@NgModule({
  declarations: [
    AppComponent,
    HomeUnauthenticatedComponent,
    AboutComponent,
    ShopComponent
  ],
  imports: [
    BrowserModule,
    CoreModule,
    AuthenticationModule, ArticleModule, AppRoutingModule]
  ,
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
