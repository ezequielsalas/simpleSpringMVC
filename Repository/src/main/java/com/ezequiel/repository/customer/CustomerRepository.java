package com.ezequiel.repository.customer;

import java.util.List;

import com.ezequiel.customerweb.customer.CustomerDomain;


public interface CustomerRepository {

	public List<CustomerDomain> findAll();

	public CustomerDomain save(CustomerDomain customer);
}
