import {Component, OnInit, ViewEncapsulation} from '@angular/core';

@Component({
  selector: 'app-articles-list',
  templateUrl: './articles-list.component.html',
  styleUrls: ['./articles-list.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ArticlesListComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {
  }

}
