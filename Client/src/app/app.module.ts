import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {NavigationComponent} from './navigation/navigation.component';
import {FooterComponent} from './footer/footer.component';
import {HomeUnauthenticatedComponent} from './home-unauthenticated/home-unauthenticated.component';
import {RegisterComponent} from './register/register.component';
import {LoginComponent} from './login/login.component';
import {ArticlesListComponent} from './articles-list/articles-list.component';
import {ArticleComponent} from './article/article.component';
import {RouterModule} from '@angular/router';
import {AboutComponent} from './about/about.component';
import {ShopComponent} from './shop/shop.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    FooterComponent,
    HomeUnauthenticatedComponent,
    RegisterComponent,
    LoginComponent,
    ArticlesListComponent,
    ArticleComponent,
    AboutComponent,
    ShopComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      {
        path: '',
        component: HomeUnauthenticatedComponent
      },
      {
        path: 'articles',
        component: ArticlesListComponent
      },
      {
        path: 'users/register',
        component: RegisterComponent
      }, {path: 'users/login', component: LoginComponent},
      {
        path: 'about',
        component: AboutComponent
      },
      {
        path: 'shop',
        component: ShopComponent
      }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
