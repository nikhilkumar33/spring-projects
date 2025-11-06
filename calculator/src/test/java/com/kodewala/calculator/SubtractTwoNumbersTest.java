package com.kodewala.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class SubtractTwoNumbersTest 
{
	static SubtractTwoNumbers subtract;
	@BeforeClass
	public static void setup()
	{
		subtract = new SubtractTwoNumbers();
	}
	@AfterClass
	public static void cleanup()
	{
		subtract = null;
	}
	
	@Test
	public void testSubtractNumbersWithBothPos()
	{
		int expect = 5;
		int actual = subtract.subtractNumbers(10, 5);
		assertEquals(expect, actual);
	}
	@Test
	public void testSubtractNumbersWithBothNeg()
	{
		int expect = -5;
		int actual = subtract.subtractNumbers(-10, -5);
		assertEquals(expect, actual);
	}
	@Test
	public void testSubtractNumbersWithFirstNeg()
	{
		int expect = -15;
		int actual = subtract.subtractNumbers(-10, 5);
		assertEquals(expect, actual);
	}
	@Test
	public void testSubtractNumbersWithFirstPos()
	{
		SubtractTwoNumbers subtract = new SubtractTwoNumbers();
		int expect = 25;
		int actual = subtract.subtractNumbers(10, -15);
		assertEquals(expect, actual);
	}
}
