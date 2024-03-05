package com.example.demo.service;

import java.util.List;


import com.example.demo.entity.PolicyHolders;

public interface PolicyService {
	public List<PolicyHolders> getAll();
	public PolicyHolders getPolicyHolder(int id);
	public void savePolicyHolder(PolicyHolders P);
	public void updatePolicyHolder(PolicyHolders P);
	public void deletePolicyHolder(int id);
 
}
