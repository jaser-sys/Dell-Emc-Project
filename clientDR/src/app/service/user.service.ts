import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpEvent } from '@angular/common/http';
import { User } from "../model/user";
import { Observable } from "rxjs/index";
import { ApiResponse } from "../model/api.response";

@Injectable({
  providedIn: 'root'
})
export class UserService {


    private baseUrl = 'http://localhost:8080/user';
    constructor(private http: HttpClient) { }


    userLogin(user: Object): Observable<ApiResponse> {
        return this.http.post<ApiResponse>('http://localhost:8080/' + 'token/generate-token', user);
    }

    createUser(user: Object): Observable<object> {
        return this.http.post(`${this.baseUrl}/${'register'}`, user);
    }



}
