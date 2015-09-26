package com.ezequiel.repository.customer.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ezequiel.customerweb.customer.CustomerDomain;
import com.ezequiel.repository.CustomerEntity;
import com.ezequiel.repository.customer.CustomerRepository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<CustomerDomain> findAll() {
		List<CustomerDomain> results = new ArrayList<CustomerDomain>();
		List<CustomerEntity> customers = entityManager.createQuery("select c from CustomerEntity c").getResultList();
		for (CustomerEntity customerEntity : customers) {
			results.add(new CustomerDomain(customerEntity.getName(),customerEntity.getLastName(),customerEntity.getId()));
		}
		
		return results;
	}

	public void save(CustomerDomain customer) {
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setName(customer.getName());
		customerEntity.setLastName(customer.getLastName());
		customerEntity.setCode(String.valueOf(customer.getCustId()));
		
		entityManager.persist(customerEntity);
		
	}

}
