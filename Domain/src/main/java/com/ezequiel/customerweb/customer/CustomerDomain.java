package com.ezequiel.customerweb.customer;

public class CustomerDomain {
	
	private String name;
	private String lastName;
	private Long custId;
	
	public CustomerDomain(){
		
	}
	public CustomerDomain(String name, String lastName, Long custId) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return custId+" "+name +" "+ lastName ;
	}
	


}
