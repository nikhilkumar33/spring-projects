package com.kodewala.DivideCalculator;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class DivisionCalculatorTest
{
	static DivisionCalculator divisionCalculator;
	@BeforeClass
	public static void setup()
	{
		System.out.println("From setup()..");
		divisionCalculator = new DivisionCalculator();
	}
	@AfterClass
	public static  void cleanup()
	{
		System.out.println("From cleanup()..");
		divisionCalculator = null;
	}
	@Test
	public void testDivision()
	{
		int expect = 5;
		System.out.println("from testDivision()..");
		int actual = divisionCalculator.division(10, 2);
		assertEquals(expect, actual);
	}
	@Test
	public void testDivisionWithNumeratorZero()
	{
		int expect = 0;
		System.out.println("from testDivisionWithNumeratorZero()..");
		int actual = divisionCalculator.division(0, 2);
		assertEquals(expect, actual);
	}
//	@Test(expected = ArithmeticException.class)
//	public void testDivisionWithDenominatorZero()
//	{
//		System.out.println("from testDivisionWithDenominatorZero()..");
//		divisionCalculator.division(10, 0);
//	}


}
