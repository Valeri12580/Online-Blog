import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ContactUsComponent } from './contact-us/contact-us.component';
import {SupportRoutingModule} from './support-routing.module';
import {FormsModule} from '@angular/forms';
import { TicketPanelComponent } from './ticket-panel/ticket-panel.component';
import { TicketInfoComponent } from './ticket-info/ticket-info.component';


@NgModule({
  declarations: [ContactUsComponent, TicketPanelComponent, TicketInfoComponent],
  imports: [
    CommonModule,
    SupportRoutingModule,
    FormsModule
  ]
})
export class SupportModule { }
