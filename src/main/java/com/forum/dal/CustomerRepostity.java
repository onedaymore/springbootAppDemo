package com.forum.dal;

import org.springframework.data.repository.CrudRepository;

import com.forum.entity.Customer;

public interface CustomerRepostity extends CrudRepository<Customer, Long> {

	
}
