import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HomeUnauthenticatedComponent} from './home-unauthenticated/home-unauthenticated.component';
import {AboutComponent} from './about/about.component';
import {CoreModule} from './core/core.module';
import {AuthenticationModule} from './authentication/authentication.module';
import {AppRoutingModule} from './app-routing.module';
import {ArticleModule} from './article/article.module';
import {ShopModule} from './shop/shop.module';

@NgModule({
  declarations: [
    AppComponent,
    HomeUnauthenticatedComponent,
    AboutComponent
  ],
  imports: [
    BrowserModule,
    CoreModule,
    AuthenticationModule, ArticleModule,
    ShopModule, AppRoutingModule]
  ,
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
