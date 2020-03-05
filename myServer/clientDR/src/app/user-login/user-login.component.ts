import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { HttpClient, HttpResponse, HttpEventType } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
    user: User = new User();
    submitted = false;
    constructor(private userService: UserService,
        private router: Router) { }

  ngOnInit(): void {
  }
    save() {
        this.userService.userLogin(this.user)
            .subscribe(event => {
                if (event instanceof HttpResponse) {
                    console.log('user added!')
                }
            });
    }


    onSubmit() {
        this.submitted = true;
        this.save();
    }
}