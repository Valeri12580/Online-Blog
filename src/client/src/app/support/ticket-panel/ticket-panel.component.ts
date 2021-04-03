import {Component, OnInit} from '@angular/core';
import {ITicket} from '../ITicket';
import {SupportService} from '../support.service';


@Component({
  selector: 'app-ticket-panel',
  templateUrl: './ticket-panel.component.html',
  styleUrls: ['./ticket-panel.component.css']
})
export class TicketPanelComponent implements OnInit {
  public tickets: ITicket[] = [];

  constructor(private supportService: SupportService) {
  }

  ngOnInit(): void {
    this.supportService.getAllTickets().subscribe(e => {
      this.tickets = e;
      console.log(e);
    });
  }

}
