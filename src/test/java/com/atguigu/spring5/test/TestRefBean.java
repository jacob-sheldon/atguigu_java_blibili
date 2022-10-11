package com.atguigu.spring5.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.spring5.bean.Employee;
import com.atguigu.spring5.service.UserService;

public class TestRefBean {
	@Test
	public void testAdd() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
		UserService us = context.getBean("userService", UserService.class);
		us.add();
	}
	
	@Test
	public void testDept() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
		Employee us = context.getBean("emp", Employee.class);
		System.out.println(us);
	}
	
	@Test
	public void testDept2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
		Employee us = context.getBean("emp", Employee.class);
		System.out.println(us);
	}
	
	@Test
	public void testDept3() {
	}
}
