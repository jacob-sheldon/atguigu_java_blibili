package com.atguigu.spring5.autowire;

public class Employee {
	private Department dep;

	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}

	@Override
	public String toString() {
		return "Employee [dep=" + dep + "]";
	}
}
