import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {ContactUsComponent} from './contact-us/contact-us.component';
import {TicketPanelComponent} from './ticket-panel/ticket-panel.component';
import {TicketInfoComponent} from './ticket-info/ticket-info.component';

const routes: Routes = [
  {
    path: 'support',
    children: [
      {
        path: 'contact-us',
        component: ContactUsComponent,
      },
      {
        path: 'tickets',
        children: [
          {
            path: '',
            component: TicketPanelComponent
          }
          ,
          {
            path: ':id',
            component: TicketInfoComponent
          }
        ]
      }
    ]
  }

]; // sets up routes constant where you define your routes

// configures NgModule imports and exports
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SupportRoutingModule {

}
