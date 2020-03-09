import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { CreateVmComponent } from './create-vm/create-vm.component';
import { SearchFileComponent } from './search-file/search-file.component';
import { ListFileComponent } from './list-file/list-file.component';
import { ListVmComponent } from './list-vm/list-vm.component';

@NgModule({
  declarations: [
    AppComponent,
    UserLoginComponent,
    CreateUserComponent,
    CreateVmComponent,
    SearchFileComponent,
    ListFileComponent,
    ListVmComponent
  ],
  imports: [
    BrowserModule,
      AppRoutingModule,
      FormsModule,
      HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
