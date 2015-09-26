package com.ezequiel.customerweb.service;

import java.util.List;

import com.ezequiel.customerweb.customer.CustomerDomain;

public interface CustomerService {
	
	public List<CustomerDomain> getAllCustomer();
	public void register(CustomerDomain customer);

}
