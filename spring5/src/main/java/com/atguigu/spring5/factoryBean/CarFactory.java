package com.atguigu.spring5.factoryBean;

import org.springframework.beans.factory.FactoryBean;

public class CarFactory implements FactoryBean<Benz> {

	public Benz getObject() throws Exception {
		// TODO Auto-generated method stub
		Benz b = new Benz();
		b.setType("c300");
		return b;
	}

	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return null;
	}
}
