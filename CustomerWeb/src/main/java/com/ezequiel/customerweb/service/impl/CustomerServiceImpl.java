package com.ezequiel.customerweb.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezequiel.customerweb.customer.CustomerDomain;
import com.ezequiel.customerweb.service.CustomerService;
import com.ezequiel.repository.customer.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	

	@Autowired
	private CustomerRepository customerRepository;
	

	public CustomerRepository getCustomerRepository() {
		return customerRepository;
	}

	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public List<CustomerDomain> getAllCustomer() {
		List<CustomerDomain> customers =  customerRepository.findAll();
//		customers.add(new CustomerDomain("Juan","Martinez",1L));
//		customers.add(new CustomerDomain("Juan","De los palotes",2L));
//		customers.add(new CustomerDomain("Pedro","Perez",3L));
//		customers.add(new CustomerDomain("Maria","Gutierrez",4L));
		
		return customers;
	}

	@Override
	public CustomerDomain register(CustomerDomain customer) {
		return customerRepository.save(customer);
	}
	
	public List<CustomerDomain> filterCustomer(Long code, String name , String lastName) {
		List<CustomerDomain> customers =  customerRepository.findAll();
//		customers.add(new CustomerDomain("Juan","Martinez",1L));
//		customers.add(new CustomerDomain("Juan","De los palotes",2L));
//		customers.add(new CustomerDomain("Pedro","Perez",3L));
//		customers.add(new CustomerDomain("Maria","Gutierrez",4L));
		List<CustomerDomain> filteredList = 	customers.stream().filter(c -> c.getName().equalsIgnoreCase(name) || c.getLastName().equalsIgnoreCase(lastName)  || c.getCustId() == code).collect(Collectors.toList());
		return filteredList;
	}
}
