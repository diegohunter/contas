import { HttpErrorResponse } from '@angular/common/http';
import { TypedResult } from '../models/typed-result';
import { MessageService } from './message.service';
import { Observable, of } from 'rxjs';
import { ActionResult } from '../models/action-result';
import { map, catchError } from 'rxjs/operators';

export abstract class BaseService {

  constructor(public message: MessageService) { }

  getResult<T>(httpObservable: Observable<ActionResult>, entityName: string): Observable<T> {

    return httpObservable.pipe(map(result => {
      if (result) {
        if (result.success) {
          return result.result[entityName] as T;
        }
      }
    }),
    catchError(error => {
     return this.handlerError(error);
     })
    );
  }

  getTypedResult<T>(httpObservable: Observable<ActionResult>, entityName: string): Observable<TypedResult<T>> {

    return httpObservable.pipe(map(result => {
      const paginatedResult = new TypedResult<T>();
      if (result) {

        paginatedResult.result = result.result[entityName] as T;
        paginatedResult.pagina = result.page;
        paginatedResult.message = result.message;
        paginatedResult.success = result.success;

      }
      return paginatedResult;
    }),
      catchError(error => {
        return this.handlerError(error);
      })
    );
  }

  defaultPipe(httpObservable: Observable<ActionResult>): Observable<ActionResult> {

    return httpObservable.pipe(map(result => {

      return result;
    }),
      catchError(error => {
        return this.handlerError(error);
      })
    );
  }

  private handlerError<T>(error: HttpErrorResponse): T {

    if (error.error instanceof ErrorEvent) {

      const errorEvent = error.error as ErrorEvent;
      this.message.fail(errorEvent.message);
    } else
      if (error.status === 400) { // Na web api 400 é erro de validação

        this.message.fail('Ocorreram erros de validação.');
        this.message.addValidationMessages(error.error);
      } else
      if (error.status === 404){

        this.message.fail('Não foi possível se conectar ao servidor. Tente novamente mais tarde.');
      } if (error.status === 500) {

        this.message.fail('Ocorreu um erro interno no servidor.');
      } else
      if (error.status === 401) {

        this.message.fail('Você não tem permissão para acessar esses dados.');
      } else {
        this.message.fail('Ocorreu um erro desconhecido.');
      }
      return {} as T;
  }

}
