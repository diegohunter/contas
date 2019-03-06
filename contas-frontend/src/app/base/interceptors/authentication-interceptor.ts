import { AuthService } from 'src/app/auth/services/auth.service';
import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable()
export class AuthenticationInterceptor implements HttpInterceptor {

  constructor(private auth: AuthService) {}
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<any> {

    const usuario = this.auth.getUser();

    if (usuario && usuario.authData) {

      req = req.clone({
        setHeaders: {
          Authorization: `Basic ${usuario.authData}`
        }
      });
    }

    return next.handle(req);
  }


}
