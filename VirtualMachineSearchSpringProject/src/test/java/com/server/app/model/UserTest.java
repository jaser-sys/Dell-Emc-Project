package com.server.app.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.server.app.VirtualMachineSearchSpringProjectApplication;
import com.server.app.model.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=VirtualMachineSearchSpringProjectApplication.class)
class UserTest {
	
	UUID random=UUID.randomUUID();
	User test1=new User(random,"jaser","999");
	@Test
	public void UserConstractorTest() {
				assertTrue((test1.getId_()==random)&&(test1.getUsername_()=="jaser")&&(test1.getPassword_()=="999"));	
	}

	
	
	@Test
	public void SetIDTest(){
		UUID ran=UUID.randomUUID();
		test1.setId_(ran);
		assertTrue(test1.getId_()==ran);
		
	}
	
	@Test
	public void setUsernameTest(){
		String ra_name="alaa";
		test1.setUsername_(ra_name);
		assertTrue(test1.getUsername_()=="alaa");
		
	}
	
	@Test
	public void setUserpass_Test(){
		String ra_pass="8888";
		test1.setPassword_(ra_pass);
		assertTrue(test1.getPassword_()=="8888");
		
	}
}
