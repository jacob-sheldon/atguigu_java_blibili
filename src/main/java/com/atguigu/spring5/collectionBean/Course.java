package com.atguigu.spring5.collectionBean;

public class Course {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + "]";
	}
}
