package com.forum.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(generator = "11111")
	@GenericGenerator(name = "11111", strategy = "uuid2")
	private String id;
	private String loginName;
	private String password;

}
