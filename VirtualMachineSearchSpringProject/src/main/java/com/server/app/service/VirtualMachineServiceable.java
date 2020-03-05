package com.server.app.service;

import java.util.List;
import java.util.UUID;

import com.server.app.model.VirtualMachine;

public interface  VirtualMachineServiceable {
    public VirtualMachine getVirtualMachineByIp(String ip);
	public List<VirtualMachine> getVirtualMachineByUsername(String username);
	public List<VirtualMachine> getVitualMachines();
	public void addVirtualMachine(UUID userId, String ip, String username, String password);
	public void deleteVirtualMachineByIp(String ip);
	public String scanVirtualMachineByIp(String ip);
}
