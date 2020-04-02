import { Component, OnInit } from '@angular/core';
import {virtualMachine} from '../model/virtualMachine';
import { VirtualMachineService } from '../service/virtual-machine.service';
import { from } from 'rxjs';
import { Router } from '@angular/router';


@Component({
  selector: 'app-create-vm',
  templateUrl: './create-vm.component.html',
  styleUrls: ['./create-vm.component.css']
})
export class CreateVmComponent implements OnInit {

  vm:virtualMachine = new virtualMachine();
  submitted = false ;
  constructor(private vmService : VirtualMachineService,private router : Router) {}

  ngOnInit(): void {

  }
newVM():void{
  this.submitted = false;
  this.vm = new virtualMachine();
}

save(){
this.vmService.addVM(this.vm);
}

onSubmit(){
  this.submitted = true;
  this.save();
}
}
