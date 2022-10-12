package com.atguigu.spring5.bean;

public class Employee {
	private String name;
	private String gender;
	private Department dept;
	
	public Department getDept() {
		return dept;
	}
	
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", gender=" + gender + ", dept=" + dept + "]";
	}
}
