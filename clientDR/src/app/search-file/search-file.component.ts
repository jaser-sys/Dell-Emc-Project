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

        this.fileName = null;
        this.toFilterBy = null;
        this.sizeInput = null;


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

        if (this.ip === "all") {
            this.fileService.getFilesByNameMulti(username, name);
            const type = 'all';
            window.localStorage.setItem('typeAll', type);
            this.goToListMulti();

        } else {
            this.fileService.getFilesByName(this.ip, name);
            const type = 'ip';
            window.localStorage.setItem('typeIp', type);
            this.goToList();
        }


    }
    callfilterBySize(username: string, sizeVal: number, unit: string) {
        
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

        if (this.ip === "all") {
            console.log(this.byteSize);
            this.fileService.getFilesBySizeMulti(username, this.byteSize);
            const type = 'all';
            window.localStorage.setItem('typeAll', type);
            this.goToListMulti();

        } else if (!window.localStorage.getItem("scanVM")) {
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
    callfilterByDate(username: string, dateVal: any) {

        this.ip = window.localStorage.getItem("scanVM");
        
        if (this.ip === 'all') {
            this.fileService.getFilesByDateMulti(username, dateVal);
            const type = 'all';
            window.localStorage.setItem('typeAll', type);
            this.goToListMulti();

        } else if (!window.localStorage.getItem("scanVM")) {
            return;

        } else {
            this.fileService.getFilesByDate(this.ip, dateVal);
            const type = 'ip';
            window.localStorage.setItem('typeIp', type);
            this.goToList();
        }

    }


    onSubmit() {

        const username = window.localStorage.getItem('username');
        this.ip = window.localStorage.getItem("scanVM") + "";
    

        if (this.toFilterBy === 'name') {
            this.callfilterByName(username, this.fileName);
        }
        else if (this.toFilterBy === 'size') {

            this.callfilterBySize(username, this.sizeInput, this.selVal);

        } else if (this.toFilterBy === 'date') {
            

            this.callfilterByDate(username, this.apiDate);
        }
    }

    goToList() {

        this.router.navigate(['file/listfile']);
    }

    goToListMulti() {

        this.router.navigate(['file/listfilemulti']);
    }

}
