package com.kodewala.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DivideTwoNumbersTest 
{
	@Test
	public void testDivideTwoNumbers()
	{
		DivideTwoNumbers divideTwoNumbers =new DivideTwoNumbers();
		int expect = 5;
		
		int actual = divideTwoNumbers.divideTwoNumbers(10, 2);
		assertEquals(expect, actual);
	}
	@Test 
	public void testDivideTwoNumbersWithNumeratorZero()
	{
		DivideTwoNumbers divideTwoNumbers =new DivideTwoNumbers();
		int expect = 0;
		
		int actual = divideTwoNumbers.divideTwoNumbers(0, 5);
		assertEquals(expect, actual);
	}
	@Test(expected = ArithmeticException.class)
	public void testDivideTwoNUmbersWithDenominatorZero()
	{
		DivideTwoNumbers divideTwoNumbers =new DivideTwoNumbers();
		divideTwoNumbers.divideTwoNumbers(5, 0);
	}
}
