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

    constructor(private router: Router, private fileService: FileService) { }

    ngOnInit(): void {
        if (!window.localStorage.getItem('token') || !window.localStorage.getItem('username') ||
            !window.localStorage.getItem('scanVM')) {

            this.router.navigate(['user/login']);
            return;
        } 
  }

}
