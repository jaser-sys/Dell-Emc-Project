import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpResponse, HttpEventType } from '@angular/common/http';
import { Router } from '@angular/router';
import { File } from '../model/file';
import { FileService } from '../service/file.service';
@Component({
  selector: 'app-list-file',
  templateUrl: './list-file.component.html',
  styleUrls: ['./list-file.component.css']
})
export class ListFileComponent implements OnInit {

    files: File[];
    ip: string;
    type: string;

    constructor(private router: Router, private fileService: FileService) { }

    ngOnInit(): void {
        if (!window.localStorage.getItem('token') || !window.localStorage.getItem('username') ||
            !window.localStorage.getItem('scanVM')) {

            this.router.navigate(['user/login']);
            return;
        } else {
            const isIp = window.localStorage.getItem('scanVM').toString();
            if (isIp.length > 6 ) {
                
                this.fileService.getListPerVM()
                    .subscribe((data) => {

                        this.files = data.result as File[];
                        
                    });


            } else {
                console.log("not found");
            }
        }
    }
}
