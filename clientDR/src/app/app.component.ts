import { Component } from '@angular/core';

declare const hide_all:any;
declare const click_name:any;
declare const click_size:any;
declare const click_date:any;
declare const submit:any;
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Virtual Machine';
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
   submit();
}
}
