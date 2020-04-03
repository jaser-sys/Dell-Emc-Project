import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpRequest, HttpEvent } from '@angular/common/http';
import { virtualMachine } from '../model/virtualMachine';
import { ApiResponse } from '../model/api.response';

@Injectable({
  providedIn: 'root'
})
export class VirtualMachineService {

    private baseUrl = 'http://localhost:8080/vm';
    private url: string;
  constructor(private http: HttpClient) { }


  addVM(VirtualMachine: Object): Observable<Object> {
      return this.http.post(`${this.baseUrl}/${'post'}`, virtualMachine);
  }
    getListVms(username: string): Observable<ApiResponse> {
        this.url = this.baseUrl + '/listVM';
        return this.http.get<ApiResponse>(`${this.url}/${username}`);
    }

    updateVMs(username: string, vm: virtualMachine): Observable<ApiResponse> {
        this.url = this.baseUrl + '/updateVM';
        return this.http.put<ApiResponse>(`${this.url}/${username}`, vm);
    }
    deleteVMByIP(ip: string): Observable<ApiResponse> {
        this.url = this.baseUrl + '/deleteVM';
        return this.http.delete<ApiResponse>(`${this.url}/${ip}`);
    }
}
