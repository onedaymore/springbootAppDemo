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
		log.info("������Կ�ʼ");
		String currentTime = DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
		log.warn("��ȡʱ��ɹ�");
		String s = "��" + (i++) + "��";
		log.error("��ȡ�����ɹ�");
		log.debug( s + currentTime);
	}
}
