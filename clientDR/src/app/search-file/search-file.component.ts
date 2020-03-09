import { Component, OnInit } from '@angular/core';

declare const hide_all:any;
declare const click_name:any;
declare const click_size:any;
declare const click_date:any;
declare const checkInput:any;

@Component({
  selector: 'app-search-file',
  templateUrl: './search-file.component.html',
  styleUrls: ['./search-file.component.css']
})
export class SearchFileComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
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
