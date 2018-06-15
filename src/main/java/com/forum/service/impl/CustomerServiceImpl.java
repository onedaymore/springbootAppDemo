package com.forum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.dal.CustomerRepostity;
import com.forum.entity.Customer;
import com.forum.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepostity customerRepostity;
	
	@Override
	public List<Customer> save() {
		Customer c = new Customer();
		c.setLoginName("demo");
		c.setPassword("password");
		List<Customer> list = (List<Customer>) customerRepostity.findAll();
		return list;
	}

}
