import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../user.service';
import { HttpClient, HttpResponse, HttpEventType } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {
    user: User = new User();
    submitted = false;
  constructor(private userService: UserService,
    private router: Router) { }

    ngOnInit(): void {
    }
    save() {
        this.userService.createUser(this.user)
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
