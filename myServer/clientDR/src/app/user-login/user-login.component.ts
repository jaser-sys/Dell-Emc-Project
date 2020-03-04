import { Component, OnInit } from '@angular/core';
import { User } from '../user';
@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
    user: User = new User();
    submitted = false;
  constructor() { }

  ngOnInit(): void {
  }

}
