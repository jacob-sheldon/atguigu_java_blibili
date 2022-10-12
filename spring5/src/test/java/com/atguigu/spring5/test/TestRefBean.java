package com.atguigu.spring5.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.spring5.autowire.Employee;
import com.atguigu.spring5.beanLifeCycle.Person;
import com.atguigu.spring5.benScope.Book;
import com.atguigu.spring5.factoryBean.Benz;
import com.atguigu.spring5.factoryBean.CarFactory;
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
	public void test3() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean6.xml");
		Benz cf = context.getBean("carFac", Benz.class);
		System.out.println(cf);
	}
	
	@Test
	public void test4() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean6.xml");
		Book book1 = context.getBean ("book", Book.class);
		System.out.println(book1);
		
		Book book2 = context.getBean("book", Book.class);
		System.out.println(book2);
	}
	
	@Test
	public void testBeanLifeCycle() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean7.xml");
		Person p = context.getBean ("person", Person.class);
		System.out.println("第四步 获取创建的bean实例对象");
		
		context.close();
	}
	
	@Test
	public void testAutowire() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean8.xml");
		Employee emp = context.getBean("employee", Employee.class);
		System.out.println(emp);
	}
}
