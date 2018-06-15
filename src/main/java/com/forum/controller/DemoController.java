package com.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forum.entity.Customer;
import com.forum.service.CustomerService;

@Controller
public class DemoController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/demo")
	public @ResponseBody List<Customer> index() {
		
		return customerService.save();
	}
}