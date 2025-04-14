import { Injectable } from '@angular/core';
import { HttpErrorResponse,HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable, pipe } from 'rxjs';
import { HttpServiceService } from './http-service.service';
import { catchError } from 'rxjs/operators';
import { Router } from '@angular/router';



@Injectable({
  providedIn: 'root'
})
export class AuthService implements HttpInterceptor {

  constructor(private http: HttpServiceService,public routr:Router) { }
  
  intercept(req: HttpRequest<any>, next: HttpHandler) {

    if (localStorage.getItem('fname') && localStorage.getItem('token')) {
      req = req.clone({
        setHeaders: {
        "withCredentials" : "true",
        "name" : "Amisha",
          
          Authorization: this.http.getToken()
        }
      })
    }
        console.log(req.headers.get("Authorization")+"------------------->>>")
    return next.handle(req).pipe(
      catchError((error:HttpErrorResponse) =>{
        if(error.status===401){
          localStorage.clear();
          this.routr.navigate(['/login'],{queryParams :{errorMessage :'Token is invalidate'}}
          );
        }
        throw(error);
      }

      )
    );

  }

}