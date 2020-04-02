package com.server.app.dao;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.server.app.model.VirtualMachine;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface VirtualMachineDaoable extends CrudRepository<VirtualMachine, Long> {
    public Connection connect();
    public VirtualMachine getVirtualMachineByIP(String ip);
	public List<VirtualMachine> getVirtualMachineByUsername(String username);
	public List<String> getVirtualMachinesIPS(UUID userId);
	public void addVirtualMachine(VirtualMachine vm);
	public void deleteVirtualMachineByIP(String ip);
	public void deleteVirtualMachineByUsername(String username);
	
}
