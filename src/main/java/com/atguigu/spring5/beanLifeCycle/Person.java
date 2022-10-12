package com.atguigu.spring5.beanLifeCycle;

public class Person {
	private String name;
	
	public Person() {
		super();
		System.out.println("第一步 调用初始化方法");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("第二步 调用 set 方法，设置属性值");
		this.name = name;
	}
	
	public void initMethod() {
		System.out.println("第三步 调用init-method");
	}
	
	public void destroyMethod() {
		System.out.println("第五步 调用destroy-method");
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
}
