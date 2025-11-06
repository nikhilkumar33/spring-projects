package com.kodewala.calculator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AddTwoNumbersTest 
{
	@Test
	public void testAddTwoNumbers()
	{
		AddTwoNumbers addTwoNumbers =new AddTwoNumbers();
		int expect = 25;
		
		int actual = addTwoNumbers.addTwoNumbers(10, 15);
		assertEquals(expect, actual);
	}
	@Test
	public void testAddTwoNumbersWithNegative()
	{
		AddTwoNumbers addTwoNumbers =new AddTwoNumbers();
		int expect = -5;
		
		int actual = addTwoNumbers.addTwoNumbers(10, -15);
		assertEquals(expect, actual);
	}
	@Test
	public void testAddTwoNumbersBothZero()
	{
		AddTwoNumbers addTwoNumbers =new AddTwoNumbers();
		int expect = 0;
		
		int actual = addTwoNumbers.addTwoNumbers(0, 0);
		assertEquals(expect, actual);
	}
	@Test
	public void testAddTwoNumbersWithFirstZero()
	{
		AddTwoNumbers addTwoNumbers =new AddTwoNumbers();
		int expect = 3;
		
		int actual = addTwoNumbers.addTwoNumbers(0, 3);
		assertEquals(expect, actual);
	}
	@Test
	public void testAddTwoNumbersWithLastZero()
	{
		AddTwoNumbers addTwoNumbers =new AddTwoNumbers();
		int expect = 5;
		
		int actual = addTwoNumbers.addTwoNumbers(5, 0);
		assertEquals(expect, actual);
	}
}
