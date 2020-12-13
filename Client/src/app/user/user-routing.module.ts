import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {RegisterComponent} from './register/register.component';
import {LoginComponent} from './login/login.component';
import {UserProfileComponent} from './user-profile/user-profile.component';
import {AnonymousGuard} from './anonymous.guard';
import {AuthenticatedGuard} from './authenticated.guard'; // CLI imports router

const routes: Routes = [
  {
    path: 'users',
    children: [
      {
        path: 'register',
        component: RegisterComponent,
        canActivate: [AnonymousGuard]

      },
      {
        path: 'login',
        component: LoginComponent,
        canActivate: [AnonymousGuard]
      },
      {
        path: 'profile/:username'
        , component: UserProfileComponent,
        canActivate: [AuthenticatedGuard]
      }
    ]
  }
]; // sets up routes constant where you define your routes

// configures NgModule imports and exports
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule {

}
