/*package com.server.app.config.authentication;

import javax.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = CustomAuthenticationProvider.class)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
 
	    @Autowired
	    CustomAuthenticationProvider customAuthenticationProvider;
	
	    @Autowired
	    private JwtAuthenticationEntryPoint unauthorizedHandler;
	   
	    @Bean
	    public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
	    	
	        return new JwtAuthenticationFilter(authenticationManager(), unauthorizedHandler);
	    }
	    
	    @Bean
	    public JwtAuthenticationEntryPoint jwtAuthenticationFilterBean() throws Exception {
	    	
	        return new JwtAuthenticationEntryPoint();
	    }
	    
	 
	    @Override
	    @Bean
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	    	
	       return super.authenticationManagerBean();
	    }
	   
	   
	    @Override
	    protected void configure(HttpSecurity http) throws Exception{	 
		    http.cors().and().csrf().disable().
            authorizeRequests()
            .antMatchers("/token/*","/user/*").permitAll()
            .anyRequest().authenticated()
            .and()
            .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	    }
	
	    
	    @Bean
	    protected CustomAuthenticationProvider customuthenticationProviderBean() {
	    	
	    return new CustomAuthenticationProvider();
	    }
	 
	    
	    @Autowired
	    public void configure(AuthenticationManagerBuilder auth) throws Exception{
		 
           auth.authenticationProvider(customAuthenticationProvider);
	    }
	    
	    @Bean
	    public BCryptPasswordEncoder encoder(){
	    	
	        return new BCryptPasswordEncoder();
	    }

}
*/