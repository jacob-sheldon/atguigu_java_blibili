package com.atguigu.spring5.collectionBean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
	private String[] courses;

	public void setCourses(String[] courses) {
		this.courses = courses;
	}
	
	private List<String> list;
	
	public void setList(List<String> list) {
		this.list = list;
	}

	private Map<String, String> map;
	
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	private Set<String> set;

	public void setSet(Set<String> set) {
		this.set = set;
	}
	
	private List<Course> courseObjList;

	public void setCourseObjList(List<Course> courseObjList) {
		this.courseObjList = courseObjList;
	}

	@Override
	public String toString() {
		return "Student [courses=" + Arrays.toString(courses) + ", list=" + list + ", map=" + map + ", set=" + set
				+ ", courseObjList=" + courseObjList + "]";
	}
}
