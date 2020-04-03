import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpRequest, HttpEvent, HttpParams } from '@angular/common/http';
import { virtualMachine } from '../model/virtualMachine';
import { file } from '../model/file';
import { ApiResponse } from '../model/api.response';

@Injectable({
  providedIn: 'root'
})
export class FileService {

    private baseUrl = 'http://localhost:8080/file';
    private url: string; 
  
    constructor(private http: HttpClient) { }
    private listPerVM: Observable<ApiResponse>;
    private listAllVMSRes: Observable<ApiResponse>;


    getFilesList(ip: string): void {
        this.url = this.baseUrl + '/listfiles';
        this.listPerVM = this.http.get<ApiResponse>(`${this.url}/${ip}`);
    }
    getListPerVM(): Observable<ApiResponse> {
        const type = 'ip';

        return this.listPerVM;
    }
}
