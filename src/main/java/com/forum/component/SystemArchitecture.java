package com.forum.component;

import org.aspectj.lang.annotation.Pointcut;

public class SystemArchitecture {

	@Pointcut("execution(* com.forum..service..*(..))")
	public void businessService() {
	}
}
