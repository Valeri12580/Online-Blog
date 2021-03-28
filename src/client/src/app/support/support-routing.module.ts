import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {ContactUsComponent} from './contact-us/contact-us.component';

const routes: Routes = [
  {
    path: 'contact-us',
    component: ContactUsComponent,
    pathMatch: 'full'
  }
]; // sets up routes constant where you define your routes

// configures NgModule imports and exports
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SupportRoutingModule {

}
