package com.server.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import com.server.app.beans.VirtualMachineDTO;
import com.server.app.model.ApiResponse;
import com.server.app.model.VirtualMachine;
import com.server.app.service.VirtualMachineService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/vm")
public class VirtualMachineController {
	
	@Autowired
	VirtualMachineService vmService;
	@Autowired
    private ModelMapper modelMapper;
	
	
	@RequestMapping(method = RequestMethod.POST, value =  "/add")
	public void addVirtualMachine(@RequestParam String userId_, String ip, String username, String password, String path){
		UUID userId=UUID.fromString(userId_);
		vmService.addVirtualMachine(userId, ip, username, password, path);
	}
	
	
	@GetMapping(value="/listVM/{username}")
	public ApiResponse<List<VirtualMachine>> getVirtualMachines(@PathVariable String username){
		List<VirtualMachine> vms=vmService.getVitualMachines(username);
		List<VirtualMachineDTO> vmsDTO=convertlist(vms);
		return new ApiResponse<>(HttpStatus.OK.value(), "vm list fetched successfully.",vmsDTO);
	}
	
	public List<VirtualMachineDTO> convertlist(List<VirtualMachine> vmlist){
		
		List<VirtualMachineDTO> vmsDTO=new ArrayList<VirtualMachineDTO>();
		VirtualMachineDTO vm=new VirtualMachineDTO();
		for(int i=0; i<vmlist.size(); i++) {
			vm=convertToDto(vmlist.get(i));
			vmsDTO.add(vm);
		}
		return vmsDTO;
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value= "/delete")
	public void deleteVirtualMachineByID(@RequestParam String ip){
		vmService.deleteVirtualMachineByIp(ip);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/updatePassword")
	public void updatePasswordByID(@RequestParam UUID id,String newPassword){
		//dbService.updatePasswordByID(id,newPassword);
	}
	public VirtualMachineDTO convertToDto(VirtualMachine vm) {
		VirtualMachineDTO vmDTO = modelMapper.map(vm, VirtualMachineDTO.class);
		
		return vmDTO;
	}
	
	public VirtualMachine convertToEntity(VirtualMachineDTO vmDTO) {
	
		VirtualMachine vm = modelMapper.map(vmDTO, VirtualMachine.class);
		return vm;
	}
}
