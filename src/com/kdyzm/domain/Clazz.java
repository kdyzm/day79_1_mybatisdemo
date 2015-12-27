package com.kdyzm.domain;

import java.util.List;

public class Clazz {
	private int id;
	private String name;
	private String desc;
	private List<Student> students;
/*************************华丽的分割线************************/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Clazz [id=" + id + ", name=" + name + ", desc=" + desc + "]";
	}	
}

