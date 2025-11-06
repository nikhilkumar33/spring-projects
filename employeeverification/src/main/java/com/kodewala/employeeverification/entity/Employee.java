package com.kodewala.employeeverification.entity;

public class Employee 
{
	private String name;
	private int age;
	private double salary;	
	
	public Employee(String _name, int _age,double _salary)
	{
		this.name = _name;
		this.age = _age;
		this.salary = _salary;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public double getSalary() {
		return salary;
	}
}
