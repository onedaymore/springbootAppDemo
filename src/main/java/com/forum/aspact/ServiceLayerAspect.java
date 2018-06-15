package com.forum.aspact;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLayerAspect {
	
	@Before("com.forum.aspact.SystemArchitecture.businessService()")
	public void log() throws Throwable {
		System.out.println("well");
	}


}
