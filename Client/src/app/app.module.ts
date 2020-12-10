import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HomeComponent} from './home/home.component';
import {AboutComponent} from './about/about.component';
import {CoreModule} from './core/core.module';
import {AuthenticationModule} from './user/authentication.module';
import {AppRoutingModule} from './app-routing.module';
import {ArticleModule} from './article/article.module';
import {ShopModule} from './shop/shop.module';
import {HttpClientModule} from '@angular/common/http';
import { jwtInterceptorProvider} from './core/interceptors/jwt.interceptor';
import { NotFoundComponent } from './not-found/not-found.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    CoreModule,
    AuthenticationModule,
    ArticleModule,
    ShopModule
    , HttpClientModule
    , AppRoutingModule]
  ,
  providers: [jwtInterceptorProvider],
  bootstrap: [AppComponent]
})
export class AppModule {
}
