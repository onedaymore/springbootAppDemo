package com.forum.job;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.forum.util.DateUtils;

@Component
public class TestJob {

	private int i = 1;
	public void get() {
		System.out.println("开始测试");
		String currentTime = DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
		String s = "第" + (i++) + "次";
		System.out.println( s + currentTime);
	}
	
	
	public static void main(String[] args) {
		int i=2;
		System.out.println("di" + ++i +"s" );
	}
}
