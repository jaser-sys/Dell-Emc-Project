import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FileService } from '../service/file.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { from } from 'rxjs';
import { FilterBy } from '../model/filter-by';
import { FilterList } from '../model/filter-list';
import { Size } from '../model/size';
import { SizeList } from '../model/size-list';

declare const hide_all:any;
declare const click_name:any;
declare const click_size:any;
declare const click_date:any;
declare const checkInput:any;

const listFilter: FilterBy[] = FilterList.values;
const listSize: Size[] = SizeList.values;

@Component({
  selector: 'app-search-file',
  templateUrl: './search-file.component.html',
  styleUrls: ['./search-file.component.css']
})
export class SearchFileComponent implements OnInit {


    constructor(private router: Router, private fileService: FileService) { }

    ngOnInit(): void {
        if (!window.localStorage.getItem('token') || !window.localStorage.getItem('username')) {
            this.router.navigate(['user/login']);
            return;
        }
  }

  onClickHideAll(){
    hide_all();
  }

  onClickName(){
    click_name();
  }
  onClickSize(){
    click_size();
  }
  onClickDate(){
    click_date();
  }
  onClickSubmit(){
  checkInput();
  }

}
