import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpRequest, HttpEvent } from '@angular/common/http';
import { virtualMachine } from './virtualMachine';
}
@Injectable({
  providedIn: 'root'
})
export class VirtualMachineService {

  private baseUrl = 'http://localhost:8080/vm';
  constructor(private http: HttpClient) { }


  addVM(VirtualMachine: Object): Observable<Object> {
      return this.http.post(`${this.baseUrl}/${'post'}`, virtualMachine);
  }

}