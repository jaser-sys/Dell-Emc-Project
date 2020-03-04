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
	public void addVirtualMachine(UUID id, UUID userId, String ip, String username, String password) {
		vmDao.addVirtualMachine(id, userId, ip, username, password);
		
	}

	@Override
	public void deleteVirtualMachineByIp(String ip) {
		vmDao.deleteVirtualMachineByIP(ip);
		
	}

}
