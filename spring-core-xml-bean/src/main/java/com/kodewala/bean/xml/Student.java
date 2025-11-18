package com.kodewala.bean.xml;

public class Student
{
	private int rollNo;
	private String name;
	private char grade;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int rollNo, String name, char grade) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.grade = grade;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	
}
