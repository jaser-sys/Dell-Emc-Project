import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserLoginComponent } from './user-login/user-login.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { CreateVmComponent } from './create-vm/create-vm.component';


const routes: Routes = [
    { path: '', redirectTo: 'login', pathMatch: 'full' },
    { path: 'login', component: UserLoginComponent },
    { path: 'createUser', component: CreateUserComponent },
    { path: 'addVM', component: CreateVmComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
