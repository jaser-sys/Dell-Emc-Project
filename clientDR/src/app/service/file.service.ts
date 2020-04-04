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
    private listPerUser: Observable<ApiResponse>;
    sizeIs: string;

    getFilesList(ip: string): void {
        this.url = this.baseUrl + '/listfiles';
        this.listPerVM = this.http.get<ApiResponse>(`${this.url}/${ip}`);
    }


    getFilesByName(ip: string, name: string) {
        let params = new HttpParams();
        params = params.append('name', name);

        this.url = this.baseUrl + '/filesByName';
        this.listPerVM  = this.http.get<ApiResponse>(`${this.url}/${ip}`, { params });
    }

    getFilesBySize(ip: string, size: number) {
        
        let params = new HttpParams();
        this.sizeIs = size + "";
        params.append('size', this.sizeIs);
        console.log(size.toString());
        this.url = this.baseUrl + '/filesBySize';
        this.listPerVM  = this.http.get<ApiResponse>(`${this.url}/${ip}`, { params });
    }

    getFilesByDate(ip: string, date: string) {
        let params = new HttpParams();
        params = params.append('date', date);

        this.url = this.baseUrl + '/filesByDate';
        this.listPerVM  = this.http.get<ApiResponse>(`${this.url}/${ip}`, { params });
    }


    getFilesByNameMulti(username: string, name: string) {
        let params = new HttpParams();
        params = params.append('name', name);
        console.log(username);
        this.url = this.baseUrl + '/listfilesNameUser';
        this.listPerUser = this.http.get<ApiResponse>(`${this.url}/${username}`, { params });
     
    }

    getFilesBySizeMulti(username: string, size: number) {
        this.sizeIs = size + "";
        let params = new HttpParams();
        params = params.append('size', this.sizeIs);
        this.url = this.baseUrl + '/listfilesBySizeUser';
        this.listPerUser = this.http.get<ApiResponse>(`${this.url}/${username}`, { params });
    }

    getFilesByDateMulti(username: string, date: string) {
        
        let params = new HttpParams();
        params = params.append('date', date);
        this.url = this.baseUrl + '/listfilesByDateUser';
        this.listPerUser = this.http.get<ApiResponse>(`${this.url}/${username}`, { params });
    }

    getListPerVM(): Observable<ApiResponse> {
     
        return this.listPerVM;
    }

    getListPerUser(): Observable<ApiResponse> {

        return this.listPerUser
    }
}
