package com.atguigu.spring5.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.spring5.service.UserService;

public class TestRefBean {
	@Test
	public void testAdd() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
		UserService us = context.getBean("userService", UserService.class);
		us.add();
	}
}
