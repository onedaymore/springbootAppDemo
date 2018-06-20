package com.forum.job;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.forum.util.DateUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TestJob {

	private int i = 1;
	public void get() {
		log.info("任务测试开始");
		String currentTime = DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
		log.warn("获取时间成功");
		String s = "第" + (i++) + "次";
		log.error("获取次数成功");
		log.debug( s + currentTime);
	}
}
