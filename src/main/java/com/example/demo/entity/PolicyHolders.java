package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PolicyHolders")
public class PolicyHolders {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Policy_holders_Id")
	private int id;
	@Column(name="Policy_holders_Name")
	private String policyHolderName;
	@Column(name="Policy_Type")
	private String policyType;
	
	
	public PolicyHolders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PolicyHolders(int id, String policyHolderName, String policyType) {
		super();
		this.id = id;
		this.policyHolderName = policyHolderName;
		this.policyType = policyType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPolicyHolderName() {
		return policyHolderName;
	}
	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	
	
	
	
	
	

}
