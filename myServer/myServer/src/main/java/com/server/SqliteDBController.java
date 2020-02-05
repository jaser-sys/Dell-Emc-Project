package com.server;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value ="/virtualmachines")
public class SqliteDBController {
	
	SqliteDB dbinstance=new SqliteDB();
	
	@RequestMapping(method = RequestMethod.POST, value =  "/add")
	public void addData(@RequestParam int id,String host,String user,String pass){
		dbinstance.addVirtualMachine(id,host,user,pass);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<VirtualMachine> getAllVirtualMachines(){
		return dbinstance.getAllVirtualMachines();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteVirtualMachineByID(@RequestParam int id){
		dbinstance.deleteVirtualMachineByID(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void updatePasswordByID(@RequestParam int id,String newPassword){
		dbinstance.updatePasswordByID(id,newPassword);
	}

}
