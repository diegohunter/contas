import { HttpInterceptor, HttpRequest, HttpHandler } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map, catchError, finalize } from 'rxjs/operators';
import { LoaderService } from '../services/loader.service';
import { Injectable } from '@angular/core';

@Injectable()
export class LoaderHttpInterceptor implements HttpInterceptor  {

  constructor(private loader: LoaderService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<any> {

    return next.handle(req).pipe(
      map(result => {

        setTimeout(() => {
          this.loader.showLoader();
        });
        return result;
      }),
      catchError(error => {
        return throwError(error);
      }),
      finalize(() => {

        setTimeout(() => {
          this.loader.hideLoader();
        });
      })
    );
    }


}
