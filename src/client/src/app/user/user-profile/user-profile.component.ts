import {Component, OnInit} from '@angular/core';
import {UserService} from '../user.service';
import {IUser} from '../../shared/IUser';
import {AuthenticationService} from '../../core/services/authentication.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  public user: IUser = null;


  constructor(public userService: UserService, public  authenticationService: AuthenticationService, public route: ActivatedRoute) {
  }

  ngOnInit(): void {
    const username = this.route.snapshot.paramMap.get('username');
    this.userService.findUserByUsername(username)
      .subscribe(response => {
        this.user = response;
        this.user.registeredOn = this.formatDate(this.user.registeredOn);
        this.user.roles = localStorage.getItem('roles');
      });
  }


  formatDate(date: string): string {
    let result = '';
    const dateObj: Date = new Date(date);
    result = `${dateObj.getHours()}:${dateObj.getMinutes()}  ${dateObj.getDate()}/${dateObj.getMonth()}/${dateObj.getFullYear()}`;
    return result;
  }


}
