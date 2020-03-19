/*package com.server.app.config.authentication;



import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.server.app.model.User;
import com.server.app.service.UserService;


public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	 @Autowired
	    private UserService userService;
	 
	 @Autowired
	   PasswordEncoder passwordEncoder;
	   
   @Override
   public UsernamePasswordAuthenticationToken authenticate(Authentication authentication) throws AuthenticationException {
     String username = authentication.getName();
     String password = authentication.getCredentials().toString();
     
     User user = userService.loadUserByUsername(username);
     if (user == null || !user.getUsername_().equalsIgnoreCase(username)) {
         throw new BadCredentialsException("Username not found.");
     }

 
	if (!passwordEncoder.matches(password, user.getPassword_())) {
         throw new BadCredentialsException("Wrong password.");
     }

      return new UsernamePasswordAuthenticationToken(username, password, Collections.emptyList());
      
   }
   @Override
   public boolean supports(Class<?>aClass) {
       return aClass.equals(UsernamePasswordAuthenticationToken.class);
   }
}
*/