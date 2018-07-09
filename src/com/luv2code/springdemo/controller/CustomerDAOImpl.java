package com.luv2code.springdemo.controller;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.CustomerDAO;



public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		return null;
	}
}
