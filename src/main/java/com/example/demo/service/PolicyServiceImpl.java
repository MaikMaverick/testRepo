package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PolicyDao;
import com.example.demo.entity.PolicyHolders;

@Service
public class PolicyServiceImpl implements PolicyService{
	@Autowired
	private PolicyDao PD;
	
	//List<PolicyHolders> list=new ArrayList<>();
	
//	public PolicyServiceImpl()
//	{
//		System.out.println("Service Layer");
//		list.add(new PolicyHolders(1,"Manoj","Monthly"));
//		list.add(new PolicyHolders(2,"Krishnan","Quaterly"));
//		list.add(new PolicyHolders(3,"Ravi","Yearly"));
//		
//	}

	@Override
	public List<PolicyHolders> getAll() {
		// TODO Auto-generated method stub
		List<PolicyHolders> PolicyHolderList=new ArrayList<>();
		PD.findAll().forEach(PolicyHolderList::add);
		return PolicyHolderList;
	}

	@Override
	public PolicyHolders getPolicyHolder(int id) {
		// TODO Auto-generated method stub
//		for(PolicyHolders p : list)
//		{
//		if(p.getId() == id)
//			return p;
//		}
//		return null;
		Optional<PolicyHolders> optionalPH = PD.findById(id);
		if(optionalPH.isPresent())
			return optionalPH.get();
		
		return null;
	}

	@Override
	public void savePolicyHolder(PolicyHolders PolicyHolder) {
		// TODO Auto-generated method stub
		//this.list.add(PolicyHolder);
		PD.save(PolicyHolder); 
		
	}

	@Override
	public void updatePolicyHolder(PolicyHolders PolicyHolder) {
		// TODO Auto-generated method stub
//		for(PolicyHolders p : list)
//		{
//			if(p.getId() == PolicyHolder.getId())
//			{
//				p.setPolicyHolderName(PolicyHolder.getPolicyHolderName());
//				p.setPolicyType(PolicyHolder.getPolicyType());
//			}
//		}
		PD.save(PolicyHolder); 
		
	}

	@Override
	public void deletePolicyHolder(int id) {
		// TODO Auto-generated method stub
		//list.remove(id-1);
		PD.deleteById(id);
		
	}
	
	

}
