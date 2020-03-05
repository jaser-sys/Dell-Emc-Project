package com.server.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.app.dao.VirtualMachineDao;
import com.server.app.model.File;
import com.server.app.model.VirtualMachine;

@Service
public class VirtualMachineService implements  VirtualMachineServiceable{
	@Autowired
	private VirtualMachineDao vmDao;
	@Autowired
	FileService fService=new FileService();
	@Override
	public List<VirtualMachine> getVirtualMachineByIp(String ip) {
		return vmDao.getVirtualMachineByIP(ip);
	}

	@Override
	public List<VirtualMachine> getVirtualMachineByUsername(String username) {
		return vmDao.getVirtualMachineByUsername(username);
	}

	@Override
	public List<VirtualMachine> getVitualMachines() {
		return vmDao.getVitualMachines();
	}

	@Override
	public void addVirtualMachine(UUID userId, String ip, String username, String password) {
		VirtualMachine vm=new VirtualMachine(userId, ip, username, password);
		vmDao.addVirtualMachine(vm);
		
	}

	@Override
	public void deleteVirtualMachineByIp(String ip) {
		vmDao.deleteVirtualMachineByIP(ip);
	}

	@Override
	public String scanVirtualMachineByIp(String ip) {
		List<VirtualMachine> vmList=this.getVirtualMachineByIp(ip);
		List<File> fileList=new ArrayList<File>();
		for( VirtualMachine vm: vmList) {
			System.out.println(vm.toString());
			RemoteVirtualMachine rvm=new RemoteVirtualMachine();
			fileList=rvm.getFiles();
			if(fileList==null)
				return "Bad";
			fService.addFiles(fileList);
			for(File f: fileList) {
				System.out.println(f.toString());
				
			}
		}
		return "Good";
	}

}
