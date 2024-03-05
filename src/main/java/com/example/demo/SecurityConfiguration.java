 package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.filter.JwtRequestFilter;
import com.example.demo.service.MyUserDetailsService;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// TODO Auto-generated method stub
		/*
		 * auth.inMemoryAuthentication() .withUser("Raj") .password("12345")
		 * .roles("USER") .and() .withUser("Sam") .password("54321") .roles("ADMIN");
		 */
		auth.userDetailsService(myUserDetailsService);
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	  @Override 
	  protected void configure(HttpSecurity http) throws Exception { 
	 // TODO Auto-generated method stub http.authorizeRequests()
	 // .antMatchers("/PolicyHolders/save").hasRole("ADMIN")
	// .antMatchers("/PolicyHolders/get").hasAnyRole("USER","ADMIN")
	  //.antMatchers("/PolicyHolders/save").hasRole("ADMIN")
	 //.antMatchers("/PolicyHolders/get").hasAnyRole("USER","ADMIN")
	 //.antMatchers("/").permitAll() .and().formLogin(); 
		  http.csrf().disable().authorizeRequests().antMatchers("/Authenticate").permitAll()
		  .anyRequest().authenticated()
		  .and().sessionManagement()
		  .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		  http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		  
	  } 
	  @Override
	  @Bean
	  public AuthenticationManager authenticationManagerBean() throws Exception{
		  return super.authenticationManagerBean();
	  }
	  
	 

}
