package com.server.app.service;

import java.util.List;
import com.server.app.model.VirtualMachine;

public interface  VirtualMachineServiceable {
    public VirtualMachine getVirtualMachineByIp(String ip);
	public List<VirtualMachine> getVirtualMachineByUsername(String username);
	public List<VirtualMachine> getVitualMachines();
	public void addVirtualMachine(VirtualMachine vm);
	public void deleteVirtualMachineByIp(String ip);
}
