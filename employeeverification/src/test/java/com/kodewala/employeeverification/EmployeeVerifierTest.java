package com.kodewala.employeeverification;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.kodewala.employeeverification.entity.Employee;

public class EmployeeVerifierTest 
{
	@Test
	public void testVerifyEmployeeAge()
	{
		Employee emp= new Employee("Nikhil",25,55120.65);
		EmployeeVerifier employeeVerifier = new EmployeeVerifier();
		
		boolean expect = true;
		boolean actual = employeeVerifier.verifyEmployeeAge(emp);
		assertEquals(expect, actual);
	}
	@Test(expected = UnderAgeException.class)
	public void testVerifyEmployeeAgeWithUnderAge()
	{
		Employee emp= new Employee("Nikhil",15,55120.65);
		EmployeeVerifier employeeVerifier = new EmployeeVerifier();
		
		employeeVerifier.verifyEmployeeAge(emp);
	}
	@Test(expected = OverAgeException.class)
	public void testVerifyEmployeeAgeWithOverAge()
	{
		Employee emp= new Employee("Nikhil",74,55120.65);
		EmployeeVerifier employeeVerifier = new EmployeeVerifier();
		
		employeeVerifier.verifyEmployeeAge(emp);
	}

	@Test
	public void testVerifyEmployeeName()
	{
		Employee emp= new Employee("Nikhil",24,55120.65);
		EmployeeVerifier employeeVerifier = new EmployeeVerifier();
		
		boolean expect = true;
		boolean actual = employeeVerifier.verifyEmployeeName(emp);
		assertEquals(expect,actual);
	}
	@Test(expected  = InvalidNameException.class)
	public void testVerifyEmployeeNameWithDigit()
	{
		Employee emp= new Employee("Nik45hil98",24,55120.65);
		EmployeeVerifier employeeVerifier = new EmployeeVerifier();
		
		employeeVerifier.verifyEmployeeName(emp);
	}
	@Test(expected  = InvalidNameException.class)
	public void testVerifyEmployeeNameWithSpecialChar()
	{
		Employee emp= new Employee("Nik@hil#",23,55120.65);
		EmployeeVerifier employeeVerifier = new EmployeeVerifier();
		
		employeeVerifier.verifyEmployeeName(emp);
	}

	@Test
	public void testVerifyEmployeeSalary()
	{
		Employee emp= new Employee("Nikhil",25,55120.65);
		EmployeeVerifier employeeVerifier = new EmployeeVerifier();

		boolean expect = true;
		boolean actual = employeeVerifier.verifyEmployeeSalary(emp);
		assertEquals(expect, actual);
	}
	@Test
	public void testVerifyEmployeeSalaryWithNegative()
	{
		Employee emp= new Employee("Nikhil",25,-55120.65);
		EmployeeVerifier employeeVerifier = new EmployeeVerifier();

		boolean expect = false;
		boolean actual = employeeVerifier.verifyEmployeeSalary(emp);
		assertEquals(expect, actual);
	}
	@Test
	public void testVerifyEmployeeSalaryWithMinimum()
	{
		Employee emp= new Employee("Nikhil",25,1120.65);
		EmployeeVerifier employeeVerifier = new EmployeeVerifier();

		boolean expect = false;
		boolean actual = employeeVerifier.verifyEmployeeSalary(emp);
		assertEquals(expect, actual);
	}
	@Test
	public void testVerifyEmployeeSalaryWithMax()
	{
		Employee emp= new Employee("Nikhil",25,155120.65);
		EmployeeVerifier employeeVerifier = new EmployeeVerifier();

		boolean expect = false;
		boolean actual = employeeVerifier.verifyEmployeeSalary(emp);
		assertEquals(expect, actual);
	}
	@Test
	public void testVerifyEmployeeSalaryWithZero()
	{
		Employee emp= new Employee("Nikhil",25,0);
		EmployeeVerifier employeeVerifier = new EmployeeVerifier();

		boolean expect = false;
		boolean actual = employeeVerifier.verifyEmployeeSalary(emp);
		assertEquals(expect, actual);
	}
}
