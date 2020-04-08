package com.server.app.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class VirtualMachineTest {
	protected VirtualMachine vm;
	protected final UUID userId = UUID.randomUUID();
	protected final String ip = "12.36.69.35";
	protected final String username = "zozo";
	protected final String password = "zozo123";
	protected final String path="c:";
	
	@BeforeEach
	void setUp() throws Exception {
		vm = new VirtualMachine(userId,ip,username,password,path);
	}

	@Test
	void test() {
		assertEquals(vm.getUserId(),userId);
		assertEquals(vm.getIP(),ip);
		assertEquals(vm.getUserName(),username);
		assertEquals(vm.getPassword(),password);
	}
	@Test
	void testSetters() {
		final UUID newVmId=UUID.randomUUID();
		final UUID newUserId = UUID.randomUUID();
		final String newIp = "12.36.69.35";
		final String newUsername = "zozo";
		final String newPassword = "zozo123";
		final String newPath = "d:";
		vm.setID(newVmId);
		assertEquals(vm.getID(), newVmId);
		vm.setUserId(newUserId);
		assertEquals(vm.getUserId(), newUserId);
		vm.setIP(newIp);
		assertEquals(vm.getIP(), newIp);
		vm.setUserName(newUsername);;
		assertEquals(vm.getIP(), newIp);
		vm.setPassword(newPassword);
		assertEquals(vm.getPassword(), newPassword);
		vm.setPath(newPath);
		assertEquals(vm.getPath(), newPath);
	}

}
