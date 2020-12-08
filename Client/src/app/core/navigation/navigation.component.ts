import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from '../services/authentication.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  constructor(public authenticationService: AuthenticationService, public router: Router) {
  }

  ngOnInit(): void {
  }

  logout() {
    this.authenticationService.logout(() => {
      this.router.navigate(['/']);
    });
  }

}
