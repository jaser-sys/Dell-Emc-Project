import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserLoginComponent } from './user-login/user-login.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { CreateVmComponent } from './create-vm/create-vm.component';
import { SearchFileComponent } from './search-file/search-file.component';
import { ListFileComponent } from './list-file/list-file.component';
import { ListVmComponent } from './list-vm/list-vm.component';

const routes: Routes = [
    { path: '', redirectTo: 'user/login', pathMatch: 'full' },
    { path: 'user/login', component: UserLoginComponent },
    { path: 'user/createUser', component: CreateUserComponent },
    { path: 'addVM', component: CreateVmComponent },
    { path: 'vms', component: ListVmComponent },
    { path: 'files', component: ListFileComponent },
    { path: 'filter', component: SearchFileComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
