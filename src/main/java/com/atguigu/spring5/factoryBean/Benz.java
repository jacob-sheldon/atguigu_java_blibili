package com.atguigu.spring5.factoryBean;

public class Benz {
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Benz [type=" + type + "]";
	}
}
