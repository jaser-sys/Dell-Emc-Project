package com.server.app.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dao.SqliteDB;
import model.VirtualMachine;
import dao.VirtualMachineQuery;

@RestController
@RequestMapping(value ="/virtualmachines")
public class VirtualMachineController {
	
	SqliteDB dbinstance=new VirtualMachineQuery();//to do: change to service
	
	@RequestMapping(method = RequestMethod.POST, value =  "/add")
	public void addVirtualMachine(@RequestParam String host,String user,String pass){
		VirtualMachine vm=new VirtualMachine(host,user,pass);
		dbinstance.addNewEntry(vm);
	}
	//to do: get virtual machine by id
	@RequestMapping(method = RequestMethod.GET)
	public List<Object> getVirtualMachines(){
		return dbinstance.getEntries();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteVirtualMachineByID(@RequestParam UUID id){
		((VirtualMachineQuery)dbinstance).deleteEntryByID(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void updatePasswordByID(@RequestParam UUID id,String newPassword){
		((VirtualMachineQuery)dbinstance).updatePasswordByID(id,newPassword);
	}

}
