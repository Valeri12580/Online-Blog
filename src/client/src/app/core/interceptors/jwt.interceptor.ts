import {Injectable} from '@angular/core';
import {HTTP_INTERCEPTORS, HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError, tap} from 'rxjs/operators';
import {Router} from '@angular/router';
import {AuthenticationService} from '../services/authentication.service';


@Injectable()
export class JwtInterceptor implements HttpInterceptor {
  url = '';

  constructor(private router: Router, private authenticationService: AuthenticationService) {
    this.url = router.url;
  }


  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {

    let token = localStorage.getItem('token');
    if (token !== null) {
      token = `Bearer ${token}`;
      request = request.clone({
        setHeaders: {
          Authorization: token
        }
      });
    }
    return next.handle(request).pipe(catchError((error: HttpErrorResponse) => {

      if (error.status === 401) {
        console.log('Auth error');
        this.router.navigateByUrl('/', {skipLocationChange: true}).then(() => {
          this.authenticationService.clearData();
          this.router.navigate([this.url]);
        });
      }
      return throwError(error.status);
    }));
  }
}

export const jwtInterceptorProvider = {
  provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true
};
