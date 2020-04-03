import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserLoginComponent } from './user-login/user-login.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { CreateVmComponent } from './create-vm/create-vm.component';
import { SearchFileComponent } from './search-file/search-file.component';
import { ListFileComponent } from './list-file/list-file.component';
import { ListVmComponent } from './list-vm/list-vm.component';
import { ListFileMultiComponent } from './list-file-multi/list-file-multi.component';

const routes: Routes = [
    { path: '', redirectTo: 'user/login', pathMatch: 'full' },
    { path: 'user/login', component: UserLoginComponent },
    { path: 'user/register', component: CreateUserComponent },
    { path: 'addVM', component: CreateVmComponent },
    { path: 'listVM', component: ListVmComponent },
    { path: 'file/listfile', component: ListFileComponent },
    { path: 'file/filter', component: SearchFileComponent },
    { path: 'file/listfilemulti', component: ListFileMultiComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
