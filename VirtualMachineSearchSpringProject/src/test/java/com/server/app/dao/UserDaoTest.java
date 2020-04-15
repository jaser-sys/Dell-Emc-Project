package com.server.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.server.app.model.*;
import java.sql.*;
import com.server.app.dao.*;
import com.server.app.VirtualMachineSearchSpringProjectApplication;
import org.junit.Before;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;



@RunWith(SpringRunner.class)
@SpringBootTest(classes=VirtualMachineSearchSpringProjectApplication.class)
public class UserDaoTest{
	
	@Autowired
	UserDaoable userDao;
	
	@Before
	public void setUp() throws Exception {
		UserDao userDao=new UserDao();
	}
	
	@Test
	public void addUserTest() throws Exception{
		UserLogin userValid = new UserLogin("jaser","20304050");
		boolean resValid= userDao.addUser(userValid);
		assertTrue(resValid);
		UserLogin userInvalid = new UserLogin("koko","59656666");
		boolean resInvalid=userDao.addUser(userInvalid);
		assertFalse(resInvalid);
		UserLogin userNull=null;
		userDao.addUser(userNull);
		assertNull(userDao.userExist(userNull));
		UserLogin userEmpty1=new UserLogin();
		userDao.addUser(userEmpty1);
		assertNull(userDao.userExist(userEmpty1));
		UserLogin userEmpty2= new UserLogin(" "," ");
		assertNull(userDao.userExist(userEmpty2));
	}
	
	@Test
	public void userLoginTest() throws Exception{
		UserLogin userValid = new UserLogin("koko","123456");
		boolean resValid= userDao.addUser(userValid);
		assertTrue(resValid);
		UserLogin userInvalid = new UserLogin("sali","59656666");
		boolean resInvalid=userDao.addUser(userInvalid);
		assertFalse(resInvalid);
		UserLogin userNull=null;
		userDao.addUser(userNull);
		assertNull(userDao.userExist(userNull));
		UserLogin userEmpty1=new UserLogin();
		userDao.addUser(userEmpty1);
		assertNull(userDao.userExist(userEmpty1));
		UserLogin userEmpty2= new UserLogin(" "," ");
		assertNull(userDao.userExist(userEmpty2));
	}
	
	
	@Test
	public void loadUserByUsernameTest() throws Exception{
		User validUser= userDao.loadUserByUsername("koko");
		assertNotNull(validUser);
		User invalidUser = userDao.loadUserByUsername("ahmed");
		assertNull(invalidUser);
		User emptyName= userDao.loadUserByUsername(" ");
		assertNull(emptyName);
		User nullUser= userDao.loadUserByUsername(null);
		assertNull(nullUser);
		
	}
	
	@Test
	public void userExistTest() throws Exception{
		UserLogin userValid = new UserLogin("koko","123456");
		User resValid=userDao.userExist(userValid);
		assertNotNull(resValid);
		UserLogin userInvalid = new UserLogin("lama","5987423");
		User resInvalid=userDao.userExist(userInvalid);
		assertNull(resInvalid);
		UserLogin userEmpty= new UserLogin(" "," ");
		User resEmpty=userDao.userExist(userEmpty);
		assertNull(resEmpty);
		User userNull=userDao.userExist(null);
		assertNull(userNull);
	}
	
	@Test
	 public void usernameAvailTest() throws Exception {
		boolean resValid= userDao.usernameAvail("bob");
		assertTrue(resValid);
		boolean resInvalid=userDao.usernameAvail("riri");
		assertFalse(resInvalid);
		boolean resEmpty=userDao.usernameAvail(" ");
		assertFalse(resEmpty);
		boolean resNull=userDao.usernameAvail(null);
		assertFalse(resNull);

    }
	
}
