import { Component, OnInit } from '@angular/core';
import { VirtualMachine} from '../model/virtualMachine';
import { VirtualMachineService } from '../service/virtual-machine.service';
import { from } from 'rxjs';
import { Router } from '@angular/router';


@Component({
  selector: 'app-create-vm',
  templateUrl: './create-vm.component.html',
  styleUrls: ['./create-vm.component.css']
})
export class CreateVmComponent implements OnInit {

  vm:VirtualMachine = new VirtualMachine();
  submitted = false ;
  constructor(private vmService : VirtualMachineService,private router : Router) {}

  ngOnInit(): void {
      if (!window.localStorage.getItem('token') || !window.localStorage.getItem('username')) {
          this.router.navigate(['user/login']);
          return;
      }
  }
newVM():void{
  this.submitted = false;
  this.vm = new VirtualMachine();
}

save(){
this.vmService.addVM(this.vm);
}

onSubmit(){
  this.submitted = true;
  this.save();
}
}
