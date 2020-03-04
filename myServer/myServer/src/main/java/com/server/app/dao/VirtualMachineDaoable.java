package com.server.app.dao;

import java.sql.Connection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.server.app.model.VirtualMachine;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface VirtualMachineDaoable extends CrudRepository<VirtualMachine, Long> {
    public Connection connect();
    public VirtualMachine getVirtualMachineByIp(String ip);
	public List<VirtualMachine> getVirtualMachineByUsername(String username);
	public List<VirtualMachine> getVitualMachines();
	public void addVirtualMachine(VirtualMachine vm);
	public void deleteVirtualMachineByIp(String ip);
}
