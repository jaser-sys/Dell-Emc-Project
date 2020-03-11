package com.server.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.app.dao.UserDao;
import com.server.app.dao.VirtualMachineDao;
import com.server.app.model.File;
import com.server.app.model.VirtualMachine;

@Service
public class VirtualMachineService implements  VirtualMachineServiceable{
	@Autowired
	private VirtualMachineDao vmDao;
	@Autowired
	private UserDao usrDao;
	@Autowired
	FileService fService=new FileService();
	@Override
	public VirtualMachine getVirtualMachineByIp(String ip) {
		return vmDao.getVirtualMachineByIP(ip);
	}

	@Override
	public List<VirtualMachine> getVirtualMachineByUsername(String username) {
		return vmDao.getVirtualMachineByUsername(username);
	}

	@Override
	public List<VirtualMachine> getVitualMachines(String username) {
		UUID userId=usrDao.getUserId(username);
		return vmDao.getVitualMachines(userId);
	}

	@Override
	public void addVirtualMachine(UUID userId, String ip, String username, String password) {
		VirtualMachine vm=new VirtualMachine(userId, ip, username, password);
		vmDao.addVirtualMachine(vm);
		this.scanVirtualMachineByIp(vm);
		
	}

	@Override
	public void deleteVirtualMachineByIp(String ip) {
		vmDao.deleteVirtualMachineByIP(ip);
	}

	@Override
	public String scanVirtualMachineByIp(VirtualMachine vm) {
		List<File> fileList=new ArrayList<File>();
		System.out.println(vm.toString());
		RemoteVirtualMachine rvm=new RemoteVirtualMachine();
		fileList=rvm.getFiles();
		if(fileList==null)
			return "Bad";
		fService.addFiles(vm.getIP(),fileList);
		return "Good";
	}

}
