package com.forum.aspact;

import org.aspectj.lang.annotation.Pointcut;

public class SystemArchitecture {

	@Pointcut("execution(* com.forum..service..*(..))")
	public void businessService() {
	}
}
