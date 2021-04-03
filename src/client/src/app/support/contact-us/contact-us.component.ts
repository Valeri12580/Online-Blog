import {Component, OnInit} from '@angular/core';
import {ContactUsFormBindingModel} from './ContactUsFormBindingModel';
import {HttpClient} from '@angular/common/http';
import {Constants} from '../../constants';

@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.css']
})
export class ContactUsComponent implements OnInit {

  public ticket: ContactUsFormBindingModel = new ContactUsFormBindingModel();

  constructor(private httpClient: HttpClient) {
  }

  ngOnInit(): void {
  }

  submit(): void {
    this.httpClient.post(Constants.SERVER_API + '/support/contact-us', this.ticket).subscribe(e => {

    });
  }

}
