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
    toggleDisplay() {
        this.isShow = !this.isShow;
    }

    callfilterByName(username: string, name: string) {

        this.ip = window.localStorage.getItem("scanVM");
        if (!window.localStorage.getItem("scanVM")) {
            console.log("no scan vm");
            return;
        }
         else {
            this.fileService.getFilesByName(this.ip, name);
            const type = 'ip';
            console.log("ip name")
            window.localStorage.setItem('typeIp', type);
            this.goToList();
        }


    }
    callfilterBySize(username: string, sizeVal: number, unit: string) {
        console.table(toFilter)
        this.ip = window.localStorage.getItem("scanVM");
        if (unit === 'KB') {
            if (sizeVal === 0) {
                this.byteSize = toFilter[0];

            }
            this.byteSize = sizeVal * toFilter[0];
        } else if (unit === 'MB') {
            this.byteSize = sizeVal * toFilter[1];
        } else if (unit === 'GB') {
            this.byteSize = sizeVal * toFilter[2];
        } else {
            return;
        }

        if (!window.localStorage.getItem("scanVM")) {
            return;
        } else {
            console.log(this.byteSize);
            this.fileService.getFilesBySize(this.ip, this.byteSize);
            const type = 'ip';
            console.log("ip name")
            window.localStorage.setItem('typeIp', type);
            this.goToList();
        }


    }
    callfilterByDate(username: string, ip_: string, dateVal: any) {
        this.ip = window.localStorage.getItem("scanVM");
        console.log(ip_);
        if (!window.localStorage.getItem("scanVM")) {
            return;
        } else {
            console.log("D5")
            this.fileService.getFilesByDate(this.ip, dateVal);
            const type = 'ip';
            window.localStorage.setItem('typeIp', type);
            this.goToList();
        }

    }

    onSubmit() {

        const username = window.localStorage.getItem('username');
        this.ip = window.localStorage.getItem("scanVM") + "";
        console.log(this.ip);
        console.log(username);
        if (this.toFilterBy === 'name') {
            this.callfilterByName(username, this.fileName);
        }
        else if (this.toFilterBy === 'size') {

            this.callfilterBySize(username, this.sizeInput, this.selVal);

        } else if (this.toFilterBy === 'date') {
            

            this.callfilterByDate(username, this.ip, this.apiDate);
        }
    }

    goToList() {
        this.router.navigate(['file/listfile']);
    }


}
