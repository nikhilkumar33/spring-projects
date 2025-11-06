package com.kodewala.oddevencalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OddEvenCheckerTest 
{
	@Test
	public void testIsOdd()
	{
		OddEvenChecker checker = new OddEvenChecker();
		boolean expect = true;
		boolean actual = checker.isOdd(3);
		assertEquals(expect, actual);
	}
	@Test
	public void testIsOddWithEvenNum()
	{
		OddEvenChecker checker = new OddEvenChecker();
		boolean expect = false;
		boolean actual = checker.isOdd(2);
		assertEquals(expect, actual);
	}
	@Test
	public void testIsOddWithNegativeEvenNum()
	{
		OddEvenChecker checker = new OddEvenChecker();
		boolean expect = false;
		boolean actual = checker.isOdd(-2);
		assertEquals(expect, actual);
	}
	@Test
	public void testIsOddWithNegativeOddNum()
	{
		OddEvenChecker checker = new OddEvenChecker();
		boolean expect = true;
		boolean actual = checker.isOdd(-5);
		assertEquals(expect, actual);
	}
	@Test
	public void testIsOddWithZero()
	{
		OddEvenChecker checker = new OddEvenChecker();
		boolean expect = false;
		boolean actual = checker.isOdd(0);
		assertEquals(expect, actual);
	}
	
	@Test
	public void testIsEven()
	{
		OddEvenChecker checker = new OddEvenChecker();
		boolean expect = true;
		boolean actual = checker.isEven(12);
		assertEquals(expect, actual);
	}
	@Test
	public void testIsEvenWithOddNum()
	{
		OddEvenChecker checker = new OddEvenChecker();
		boolean expect = false;
		boolean actual = checker.isEven(49);
		assertEquals(expect, actual);
	}
	@Test
	public void testIsEvenWithNegativeEvenNum()
	{
		OddEvenChecker checker = new OddEvenChecker();
		boolean expect = true;
		boolean actual = checker.isEven(-2);
		assertEquals(expect, actual);
	}
	@Test
	public void testIsEvenWithNegativeOddNum()
	{
		OddEvenChecker checker = new OddEvenChecker();
		boolean expect = false;
		boolean actual = checker.isEven(-5);
		assertEquals(expect, actual);
	}
	@Test
	public void testIsEvenWithZero()
	{
		OddEvenChecker checker = new OddEvenChecker();
		boolean expect = true;
		boolean actual = checker.isEven(0);
		assertEquals(expect, actual);
	}
}
