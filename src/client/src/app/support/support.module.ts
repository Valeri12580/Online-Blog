import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ContactUsComponent } from './contact-us/contact-us.component';
import {SupportRoutingModule} from './support-routing.module';
import {FormsModule} from '@angular/forms';


@NgModule({
  declarations: [ContactUsComponent],
  imports: [
    CommonModule,
    SupportRoutingModule,
    FormsModule
  ]
})
export class SupportModule { }
