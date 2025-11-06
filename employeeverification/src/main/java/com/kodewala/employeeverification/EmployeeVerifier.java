package com.kodewala.employeeverification;

import com.kodewala.employeeverification.entity.Employee;

public class EmployeeVerifier 
{
	
	public boolean verifyEmployeeAge(Employee emp)
	{
		if(emp.getAge() <= 20)	{
			throw new UnderAgeException("Age should greater then 20");
		}
		else if(emp.getAge() > 60)	{
			throw new OverAgeException("Age should less then 60");
		}
		else {
			return true;
		}
	}
	public boolean verifyEmployeeName(Employee emp)
	{
		String name = emp.getName();
		for(int i=0;i<name.length();i++)
		{
			if(Character.isDigit(name.charAt(i)))
			{
				throw new InvalidNameException("Name cannot contain digit");
			}
			else if(!Character.isLetter(name.charAt(i)) && !Character.isWhitespace(name.charAt(i)))
			{
				throw new InvalidNameException("Name cannot contain special charactter");
			}
		}
		return true;
	}
	public boolean verifyEmployeeSalary(Employee emp)
	{
		if(emp.getSalary()>50000.00 && emp.getSalary()<100000.00)
		{
			return true;
		}
		else {
			return false;
		}
	}
}

class UnderAgeException extends RuntimeException
{
	public UnderAgeException(String message) 
	{
		super(message);
	}
}
class OverAgeException extends RuntimeException
{
	public OverAgeException(String message) 
	{
		super(message);
	}
}
class InvalidNameException extends RuntimeException
{
	public InvalidNameException(String message)
	{
		super(message);
	}
}
