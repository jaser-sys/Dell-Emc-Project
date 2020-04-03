import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FileService } from '../service/file.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { from } from 'rxjs';
import { FilterBy } from '../model/filter-by';
import { FilterList } from '../model/filter-list';
import { Size } from '../model/size';
import { SizeList } from '../model/size-list';




const toFilter: number[] = [Math.pow(2, 10), Math.pow(2, 20), Math.pow(2, 30)];

@Component({
  selector: 'app-search-file',
  templateUrl: './search-file.component.html',
  styleUrls: ['./search-file.component.css']
})
export class SearchFileComponent implements OnInit {


    listFilter: FilterBy[] = FilterList.values;
    listSize: Size[] = SizeList.values;
    ip: string;
    selVal: string;
    fileName: string;
    isShow = false;
    sizeInput: number;
    dateInput: any;
    toFilterBy: string;
    byteSize: number;
    apiDate: any;
    username: string;

    constructor(private router: Router, private fileService: FileService) {

        

    }

    ngOnInit(): void {
        if (!window.localStorage.getItem('token') || !window.localStorage.getItem('username')) {
            this.router.navigate(['user/login']);
            return;
        }
  }






}
