package com.kodewala.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class PositiveNegativeCheckerTest 
{
	static PositiveNegativeChecker checker;
	@BeforeClass
	public static void setup()
	{
		System.out.println("Creating object..");
		checker = new PositiveNegativeChecker();
	}
	@AfterClass
	public static void cleaning()
	{
		System.out.println("Destroing object..");
		checker = null;
	}
	@Test
	public void testCheckPosOrNegWithPos()
	{
		System.out.println("Inside testCheckPosOrNegWithPos()");
		int expect = 1;
		int actual = checker.checkPosOrNeg(2);
		assertEquals(expect,actual);
	}
	@Test
	public void testCheckPosOrNegWithZero()
	{
		System.out.println("Inside testCheckPosOrNegWithZero()");
		int expect = 0;
		int actual = checker.checkPosOrNeg(0);
		assertEquals(expect,actual); 
	}
	@Test
	public void testCheckPosOrNegWithNeg()
	{
		System.out.println("Inside testCheckPosOrNegWithNeg()");
		int expect = -1;
		int actual = checker.checkPosOrNeg(-56);
		assertEquals(expect,actual);
	}
}
