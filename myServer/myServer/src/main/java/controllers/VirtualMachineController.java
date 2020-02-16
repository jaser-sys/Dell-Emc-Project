package controllers;

import java.util.List;

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
	
	SqliteDB dbinstance=new VirtualMachineQuery();
	
	@RequestMapping(method = RequestMethod.POST, value =  "/add")
	public void addData(@RequestParam int id,String host,String user,String pass){
		VirtualMachine vm=new VirtualMachine(id,host,user,pass);
		dbinstance.addNewEntry(vm);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Object> getAllVirtualMachines(){
		return dbinstance.getAllEntries();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteVirtualMachineByID(@RequestParam int id){
		((VirtualMachineQuery)dbinstance).deleteEntryByID(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void updatePasswordByID(@RequestParam int id,String newPassword){
		((VirtualMachineQuery)dbinstance).updatePasswordByID(id,newPassword);
	}

}
