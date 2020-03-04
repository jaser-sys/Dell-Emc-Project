import { Component, OnInit } from '@angular/core';
import { User } from '../user';
@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {
    user: User = new User();
    submitted = false;
  constructor() { }

  ngOnInit(): void {
  }

}
