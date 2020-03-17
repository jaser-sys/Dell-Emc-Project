import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { HttpClient, HttpResponse, HttpEventType } from '@angular/common/http';
import { Router } from '@angular/router';
import Swal from 'sweetalert2'

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
        this.userService.userLogin(this.user).subscribe(data => {
          
            if (data.status === 200) {
                window.localStorage.setItem('token', data.result.token);
                   let timerInterval
                Swal.fire({
                    title: 'You just signed in!',
                    icon: 'success',
                    html: 'Welcome <b></b>',
                    showCancelButton: false,
                    showConfirmButton: false,
                    footer: '<a </a>',
                    timer: 2500,
                    onBeforeOpen: () => {
                        Swal.showLoading()
                        timerInterval = setInterval(() => {
                            const content = Swal.getContent()
                            if (content) {
                                const b = content.querySelector('b')
                                if (b) {
                                    b.textContent = this.user.username
                                }
                            }
                        }, 100)
                    },
                    onClose: () => {
                        clearInterval(timerInterval)
                        this.gotoList()
                    }
                }).then((result) => {
                   
                    if (result.dismiss === Swal.DismissReason.timer) {
                        console.log('I was closed by the timer')
                    
                    }
                })
       
            } else {
               console.log("false");
                Swal.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: data.message,
                  
                });
            }
        });
    }


    onSubmit() {
        this.submitted = true;
        this.save();
    }

    gotoList() {
        this.router.navigate(['/vms']);
    }
}
