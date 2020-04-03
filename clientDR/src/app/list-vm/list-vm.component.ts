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
    public listFiles(VM: virtualMachine): void {
        window.localStorage.setItem('IP', VM.ip);
        this.router.navigate(['file/listfile']);

    };
    public addVM() {
        this.router.navigate(['addVM']);
    };

    public scanAll(): void {
        window.localStorage.removeItem("scanVM");
        window.localStorage.setItem("scanVM", "all");
        this.router.navigate(['file/filter']);
    };

    public scanVM(VM: virtualMachine): void {
        window.localStorage.removeItem("scanVM");
        window.localStorage.setItem("scanVM", VM.ip.toString());
        this.router.navigate(['file/filter']);
    };
    public updateVM(VM: virtualMachine): void {
        window.localStorage.removeItem("updateVM");
        window.localStorage.setItem("updateVM", VM.ip.toString());
        this.router.navigate(['vm/update-vm']);
    };
    public deleteVM(VM: virtualMachine): void {
        this.vmService.deleteVMByIP(VM.ip)
            .subscribe(data => {
                this.vms = this.vms.filter(v => v !== VM);
            })
    };
}
