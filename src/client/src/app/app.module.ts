import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HomeComponent} from './home/home.component';
import {AboutComponent} from './about/about.component';
import {CoreModule} from './core/core.module';
import {UserModule} from './user/user.module';
import {AppRoutingModule} from './app-routing.module';
import {ArticleModule} from './article/article.module';
import {HttpClientModule} from '@angular/common/http';
import {jwtInterceptorProvider} from './core/interceptors/jwt.interceptor';
import {NotFoundComponent} from './not-found/not-found.component';
import {AdminModule} from './admin/admin.module';
import {ProductModule} from './product/product.module';
import { SupportComponent } from './support/support.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    NotFoundComponent,
    SupportComponent
  ],
  imports: [
    BrowserModule,
    CoreModule,
    UserModule,
    ArticleModule,
    ProductModule,
    AdminModule
    , HttpClientModule
    , AppRoutingModule]
  ,
  providers: [jwtInterceptorProvider],
  bootstrap: [AppComponent]
})
export class AppModule {
}
