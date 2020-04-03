import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from "@angular/common/http";
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MatNativeDateModule, DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE } from '@angular/material/core';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MomentDateModule, MomentDateAdapter } from '@angular/material-moment-adapter';
import { UserLoginComponent } from './user-login/user-login.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { CreateVmComponent } from './create-vm/create-vm.component';
import { SearchFileComponent } from './search-file/search-file.component';
import { ListFileComponent } from './list-file/list-file.component';
import { ListVmComponent } from './list-vm/list-vm.component';
import { ListFileMultiComponent } from './list-file-multi/list-file-multi.component';
import * as moment from 'moment';



export const DateFormats = {
    parse: {
        dateInput: ['YYYY-MM-DD']
    },
    display: {
        dateInput: 'YYYY-MM-DD',
        monthYearLabel: 'MMM YYYY',
        dateA11yLabel: 'LL',
        monthYearA11yLabel: 'MMMM YYYY',
    },
};

@NgModule({
  declarations: [
    AppComponent,
    UserLoginComponent,
    CreateUserComponent,
    CreateVmComponent,
    SearchFileComponent,
    ListFileComponent,
    ListVmComponent,
    ListFileMultiComponent
  ],
  imports: [
    BrowserModule,
      AppRoutingModule,
      FormsModule,
      HttpClientModule,
      MatInputModule,
      MatRadioModule,
      MatSelectModule,
      MatNativeDateModule,
      MatDatepickerModule,
  ],
    providers: [ 
        { provide: DateAdapter, useClass: MomentDateAdapter, deps: [MAT_DATE_LOCALE] },
        { provide: MAT_DATE_FORMATS, useValue: DateFormats }
    ],
  
    bootstrap: [AppComponent]
})

export class AppModule { }
