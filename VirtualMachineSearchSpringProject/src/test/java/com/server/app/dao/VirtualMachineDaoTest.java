package com.server.app.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.server.app.model.VirtualMachine;


@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
class VirtualMachineDaoTest {
	protected VirtualMachine vm;
	private UUID ririId = UUID.fromString("f65661b3-b4e3-4917-9ca2-c45ef8cc2328");//riri's id - user exists in DB
	
	/*Object under test:*/
	
	
	@Autowired
	VirtualMachineDao vmDao;

	
	@BeforeEach
	void setUp() throws Exception {
		 vm= new VirtualMachine(ririId,"1.2.1.1", "riri","apss342","c:");
	}
	
	
	@Test
	void getVitualMachinesTest() {//user does not exist in the DB
		UUID randomId=UUID.randomUUID();
		List<VirtualMachine> list1 = vmDao.getVitualMachines(randomId);
		assertTrue("\nFailed: There is no VMs for user who does not exist!\n",list1.size()==0);
	}
	
	
	@Test
	void getVitualMachinesForExistingUserTest() {
		List<VirtualMachine> list2 = vmDao.getVitualMachines(ririId);
		assertTrue("\nFailed: There are VMs for user who exists!\n",list2.size()!=0);
	}
	
	
	@Test
	void addVirtualMachineTest() {
		vmDao.addVirtualMachine(vm);
		List<VirtualMachine> list=vmDao.getVirtualMachineByUsername("riri");
		assertTrue("\nFailed: Result of getting VMs must contain the added VM\n", list.contains(vm));
	}
	
	
	@Test
	void deleteVirtualMachineByIPTest() {
		vmDao.deleteVirtualMachineByIP(vm.getIP());
		List<VirtualMachine> list=vmDao.getVirtualMachineByUsername("riri");
		assertFalse("\nFailed: Result of getting VMs must not contain the added VM\n", list.contains(vm));
	}
	
	
	@Test
	void getVirtualMachineByIPTest() {
		vmDao.addVirtualMachine(vm);
		VirtualMachine resVM= vmDao.getVirtualMachineByIP(vm.getIP());
		assertTrue("\nFailed: The inserted VM must be the same we get\n",resVM.equals(vm));
	}
	
	
	@Test 
	void getVirtualMachineByUsernameTest() {
		vmDao.addVirtualMachine(vm);
		List <VirtualMachine> list= vmDao.getVirtualMachineByUsername(vm.getUserName());
		for (VirtualMachine vm : list) {
			assertTrue("\nFailed: The get VM for another user\n",vm.getUserName().equals("riri"));
		}
	}
	
	
	@Test 
	void getVirtualMachinesIPSTest() {
		vmDao.addVirtualMachine(vm);
		List <String> list= vmDao.getVirtualMachineByIP(ririId);
		assertTrue("\nFailed: The added vm must be in the list\n",list.contains(vm.getIP()));
		
	}
	 @Test
	 void existsByIdTest() {	 
		 vmDao.addVirtualMachine(vm);
		 assertTrue(vmDao.existsByIp("1.2.1.1"));
		 
		 vmDao.deleteVirtualMachineByIP("1.2.1.1");
		 assertFalse(vmDao.existsByIp("1.2.1.1"));
	 }
	
	
	@AfterEach
	void tearDown() throws Exception{
		vmDao.deleteVirtualMachineByIP(vm.getIP());
	}

}
