package com.luv2code.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;


@Repository // we need Spring to component scan and get this repository and handle the Exceptions for us.
public class CustomerDAOImpl implements CustomerDAO {

	// need to DI the session factory 
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", 
															   Customer.class);
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer customerDTO) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// save the customerDTO
		currentSession.saveOrUpdate(customerDTO);
	}

	@Override
	public Customer getCustomer(int customerId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// get the customer from the hibernate session
		Customer theCustomer = currentSession.get(Customer.class, customerId);
		
		// return the retrieved customer
		return theCustomer;
	}
	
	
}
