package com.server.app.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.server.app.VirtualMachineSearchSpringProjectApplication;
import com.server.app.model.*;


import org.junit.jupiter.api.Test;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=VirtualMachineSearchSpringProjectApplication.class)
class UserLoginTest {

	
	UserLogin user1=new UserLogin("jaser","00900");

	@Test
	public void UserLogintest() {
				
		assertTrue((user1.getUsername()=="jaser")&&(user1.getPassword()=="00900"));
		
	}
	
	@Test
	public void SetUserNameTest() {
		String usernamet="kally";
		user1.setUsername(usernamet);
		assertTrue(user1.getUsername()=="kally");
		
	}
	
	@Test
	public void SetUserPassTest() {
		String userpasst="989798";
		user1.setPassword(userpasst);
		assertTrue(user1.getPassword()=="989798");
		
	}
}
