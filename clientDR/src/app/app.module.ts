import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HTTP_INTERCEPTORS,  HttpClientModule } from "@angular/common/http";
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { ReactiveFormsModule } from "@angular/forms";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
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
import { TokenInterceptor } from "./core/interceptor";
import { UserService } from "./service/user.service";
import { VirtualMachineService } from './service/virtual-machine.service';
import { FileService } from './service/file.service';
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
     ReactiveFormsModule,
     BrowserAnimationsModule,
     HttpClientModule,
     MatInputModule,
     MatRadioModule,
     MatSelectModule,
     MatNativeDateModule,
     MatDatepickerModule,
  ],
    providers: [UserService, FileService, VirtualMachineService, {
        provide: HTTP_INTERCEPTORS,
        useClass: TokenInterceptor,
        multi: true
    },
        { provide: DateAdapter, useClass: MomentDateAdapter, deps: [MAT_DATE_LOCALE] },
        { provide: MAT_DATE_FORMATS, useValue: DateFormats }
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA],
    bootstrap: [AppComponent]
})

export class AppModule { }
