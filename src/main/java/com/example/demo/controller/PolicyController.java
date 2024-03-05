package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PolicyHolders;
import com.example.demo.service.MyUserDetailsService;
import com.example.demo.service.PolicyServiceImpl;
import com.example.demo.util.AuthenticationRequest;
import com.example.demo.util.AuthenticationResponse;
import com.example.demo.util.JwtUtil;

@RestController
public class PolicyController {
	@Autowired
	private PolicyServiceImpl PSI;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MyUserDetailsService userDetailService;
	@Autowired
	private JwtUtil jwtTokenutil;
	
	@RequestMapping(value = "/Authenticate",method = RequestMethod.POST)
	public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception
	{
		try
		{
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
		}
		catch(BadCredentialsException e)
		{
			throw new Exception("Incorrect Username or Password",e);
		}
		final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenutil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	
	@RequestMapping(value = "/PolicyHolders/get",method = RequestMethod.GET )
	public List<PolicyHolders> getAll()
	{
		return PSI.getAll();
	}
	
	@RequestMapping(value = "/PolicyHolders/get/{id}",method = RequestMethod.GET)
	public PolicyHolders getbyId(@PathVariable int id)
	{
		return PSI.getPolicyHolder(id);
	}
	
	@RequestMapping(value = "/PolicyHolders/save",method = RequestMethod.POST)
	public void savePolicyHolder( @RequestBody PolicyHolders PolicyHolder)
	{
		PSI.savePolicyHolder(PolicyHolder);
	}
	@RequestMapping(value = "/PolicyHolders/update",method = RequestMethod.PUT)
    public void updatePolicyHolder(@RequestBody PolicyHolders PolicyHolder)
    {
    	PSI.updatePolicyHolder(PolicyHolder);
    	
    }
	@RequestMapping(value = "/PolicyHolders/delete/{id}",method = RequestMethod.DELETE)
	public void deletePolicyHolder(@PathVariable int id)
	{
		PSI.deletePolicyHolder(id);
	}

	

}
