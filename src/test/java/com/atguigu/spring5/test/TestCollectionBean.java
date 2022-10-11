package com.atguigu.spring5.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.spring5.collectionBean.Student;

public class TestCollectionBean {
	@Test
	public void test1() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
		Student s = context.getBean("stu", Student.class);
		System.out.println(s);
	}
	
	@Test
	public void test2() {
		
	}
	
	@Test
	public void test3() {
		
	}
}
