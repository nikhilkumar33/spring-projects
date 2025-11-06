package com.kodewala.employeeverification;

import com.kodewala.employeeverification.entity.Employee;

public class App {

	public static void main(String[] args) 
	{
		Employee emp =new Employee("Cherry",22,45000.00);
		
		EmployeeVerifier employeeVerifier = new EmployeeVerifier();
		
		boolean result1 = employeeVerifier.verifyEmployeeName(emp);
		System.out.println("Valid Name: "+ result1);
		boolean result2 = employeeVerifier.verifyEmployeeAge(emp);
		System.out.println("Valid Age: "+result2);
		boolean result3 = employeeVerifier.verifyEmployeeSalary(emp);
		System.out.println("Valid salary: "+result3);
	}

}
