import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpRequest, HttpEvent } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class UserService {


    private baseUrl = 'http://localhost:8080//user';
    constructor(private http: HttpClient) { }


    userLogin(user: Object): Observable<Object> {
        return this.http.post(`${this.baseUrl}/${'post'}`, user);
    }



}
