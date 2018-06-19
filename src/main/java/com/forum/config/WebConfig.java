package com.forum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.forum.interceptor.BasicInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter  {
	

	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new BasicInterceptor());
    }

}
