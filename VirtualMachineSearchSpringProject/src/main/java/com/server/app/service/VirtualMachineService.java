package com.server.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.app.dao.VirtualMachineDao;
import com.server.app.model.VirtualMachine;

@Service
public class VirtualMachineService implements  VirtualMachineServiceable{
	@Autowired
	private VirtualMachineDao vmDao;
	@Override
	public VirtualMachine getVirtualMachineByIp(String ip) {
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
		//get vm from database by ip
		
		//ssh
		return null;
	}

}
