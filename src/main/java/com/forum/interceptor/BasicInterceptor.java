package com.forum.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BasicInterceptor extends HandlerInterceptorAdapter {
	
	public BasicInterceptor() {
		System.out.println("BasicInterceptor===");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
//		String service = request.getHeader("service");
//		// ����ʱ�� new Date()).getTime()
//		String serviceTime = request.getHeader("serviceTime");
//
//		// ǩ��
//		String sign = request.getHeader("sign");
//		// ��Դ
//		String appSource = request.getHeader("appSource");
//		
//		long diff = (new Date()).getTime() - Long.valueOf(serviceTime);
//		
//		long mm = diff / (1000 * 60);
		
		
		System.out.println("Interf===============");
		return false;
		
		
	}
}
