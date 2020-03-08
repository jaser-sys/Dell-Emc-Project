package com.server.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.server.app.service.UserServiceable;
import com.server.app.model.User;
import com.server.app.model.UserLogin;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	
	@Autowired
	UserServiceable userSer;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public boolean Login(UserLogin login) {
		boolean res=userSer.userLogin(login);
		return res;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public User Register(UserLogin user) {
		User added=userSer.addUser(user);
		return added;
	}
	@RequestMapping(value = "/isuser", method = RequestMethod.POST)
	public User getUser(UserLogin isUser) {
		User isUser_=userSer.returnUser(isUser);
		return isUser_;
	}
	
}
