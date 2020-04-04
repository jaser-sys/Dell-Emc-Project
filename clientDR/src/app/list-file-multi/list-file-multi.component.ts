import { Component, OnInit } from '@angular/core';
import { file } from '../model/file';
import { FileService } from '../service/file.service';
import { HttpClient, HttpResponse, HttpEventType } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-file-multi',
  templateUrl: './list-file-multi.component.html',
  styleUrls: ['./list-file-multi.component.css']
})
export class ListFileMultiComponent implements OnInit {

    files: File[];
    type: string;

    constructor(private router: Router, private fileService: FileService) { }

    ngOnInit(): void {
        if (!window.localStorage.getItem('token') || !window.localStorage.getItem('username') ||
            !window.localStorage.getItem('scanVM')) {

            this.router.navigate(['user/login']);
            return;
        } else {
            this.type = window.localStorage.getItem('typeAll') + "";
            if (this.type == 'all') {
                this.fileService.getListPerUser()
                    .subscribe((data) => {

                        this.files = data.result as File[];
                        
                    });
            } else {
                console.log("not found");
            }
        }
  }

}
