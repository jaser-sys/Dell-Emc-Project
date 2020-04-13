package com.server.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import com.server.app.model.VirtualMachine;

@SpringBootTest
@RunWith(SpringRunner.class)
class VirtualMachineServiceTests {
	
	private UUID ririId = UUID.fromString("f65661b3-b4e3-4917-9ca2-c45ef8cc2328");//riri's id - user exists in DB
	  
	@Autowired
	private VirtualMachineService vmSrvc;
	
	
	@Test 
	void getVitualMachinesTest() {
		VirtualMachine vm1 =new VirtualMachine();
		vm1.setID(UUID.randomUUID());
		vm1.setIP("22.22.36.66");
		vm1.setPassword("123");
		vm1.setPath("c:/");
		vm1.setUserId(ririId);
		vm1.setUserName("soso");
		
		VirtualMachine vm2 =new VirtualMachine();
		vm2.setID(UUID.randomUUID());
		vm2.setIP("22.22.36.67");
		vm2.setPassword("456");
		vm2.setPath("d:/");
		vm2.setUserId(ririId);
		vm2.setUserName("soso");
		
		vmSrvc.addVirtualMachine(vm1);
		vmSrvc.addVirtualMachine(vm2);
		
		List<VirtualMachine> mylist=new ArrayList<VirtualMachine>();
		mylist.add(vm1);
		mylist.add(vm2);
		
		List<VirtualMachine> explist =vmSrvc.getVitualMachines("riri");
		
		for(VirtualMachine vm: mylist)
			assertTrue(explist.contains(vm));
		
		vmSrvc.deleteVirtualMachineByIp("22.22.36.66");
		vmSrvc.deleteVirtualMachineByIp("22.22.36.67");
	}
	
	
	@Test
	void getVirtualMachineByIpTest() {
		VirtualMachine vm =new VirtualMachine();
		vm.setID(UUID.randomUUID());
		vm.setIP("22.22.36.66");
		vm.setPassword("123");
		vm.setPath("c:/");
		vm.setUserId(ririId);
		vm.setUserName("soso");
		
		vmSrvc.addVirtualMachine(vm);
		
		VirtualMachine exp =vmSrvc.getVirtualMachineByIp("22.22.36.66");
		VirtualMachine unexp=vmSrvc.getVirtualMachineByIp("22.22.22.22");
		
		assertEquals(exp, vm);
		assertNotEquals(unexp, vm);
		
		vmSrvc.deleteVirtualMachineByIp("22.22.36.66");
	}
	
	
	@Test 
	void getVirtualMachineByUsernameTest() {
		VirtualMachine vm1 =new VirtualMachine();
		vm1.setID(UUID.randomUUID());
		vm1.setIP("22.22.36.66");
		vm1.setPassword("123");
		vm1.setPath("c:/");
		vm1.setUserId(ririId);
		vm1.setUserName("soso");
		
		VirtualMachine vm2 =new VirtualMachine();
		vm2.setID(UUID.randomUUID());
		vm2.setIP("22.22.36.67");
		vm2.setPassword("456");
		vm2.setPath("d:/");
		vm2.setUserId(ririId);
		vm2.setUserName("soso");
		
		vmSrvc.addVirtualMachine(vm1);
		vmSrvc.addVirtualMachine(vm2);
		
		List<VirtualMachine> mylist=new ArrayList<VirtualMachine>();
		mylist.add(vm1);
		mylist.add(vm2);
		
		List<VirtualMachine> explist =vmSrvc.getVirtualMachineByUsername("soso");

		
		for(VirtualMachine vm: mylist)
			assertTrue(explist.contains(vm));
		
		vmSrvc.deleteVirtualMachineByIp("22.22.36.66");
		vmSrvc.deleteVirtualMachineByIp("22.22.36.67");
	}
	
	
	@Test
	void addVirtualMachineTest() {
		VirtualMachine vm =new VirtualMachine();
		vm.setID(UUID.randomUUID());
		vm.setUserId(ririId);
		vm.setIP("11.33.44.55");
		vm.setUserName("mimi");
		vm.setPassword("drewsg32");
		vm.setPath("d:/");
		
		vmSrvc.addVirtualMachine(vm);
		
		VirtualMachine exp =vmSrvc.getVirtualMachineByIp("11.33.44.55");
		
		assertEquals(exp, vm);
		
		vmSrvc.deleteVirtualMachineByIp("11.33.44.55");
	}
	
	
	@Test
	void deleteVirtualMachineByIpTest() {
		VirtualMachine vm =new VirtualMachine();
		vm.setID(UUID.randomUUID());
		vm.setUserId(ririId);
		vm.setIP("33.33.33.33");
		vm.setUserName("mimi");
		vm.setPassword("drewsg32");
		vm.setPath("d:/");
		
		vmSrvc.addVirtualMachine(vm);
		
		VirtualMachine exp1 =vmSrvc.getVirtualMachineByIp("33.33.33.33");
		assertEquals(exp1, vm);
		
		vmSrvc.deleteVirtualMachineByIp("33.33.33.33");
		
		VirtualMachine exp2 =vmSrvc.getVirtualMachineByIp("33.33.33.33");
		assertNotEquals(exp2, vm);
	}
}
