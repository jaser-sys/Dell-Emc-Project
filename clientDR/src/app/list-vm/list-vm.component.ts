import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { virtualMachine } from '../model/virtualMachine';
import { User } from "../model/user";
import { VirtualMachineService } from '../service/virtual-machine.service';

@Component({
  selector: 'app-list-vm',
  templateUrl: './list-vm.component.html',
  styleUrls: ['./list-vm.component.css']
})
export class ListVmComponent implements OnInit {

    vms: virtualMachine[] = [];
    usename: string;

    constructor(private router: Router, private vmService: VirtualMachineService) { }

    ngOnInit(): void {

        if (!window.localStorage.getItem('token') || !window.localStorage.getItem('username')) {
            this.router.navigate(['login']);
            return;
        }
  }

}
