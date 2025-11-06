package com.kodewala.gradechecker;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeCheckerTest 
{
	GradeChecker gradeChecker;
	@Before
	public void setup()
	{
		System.out.println("Inside setup()..");
		gradeChecker = new GradeChecker();
	}
	@After
	public void cleanup()
	{
		System.out.println("Inside cleanup()..");
		gradeChecker = null;
	}
	@Test
	public void testCheckGradeFirstGrade()
	{
		System.out.println("Inside testCheckGrade()..");
		char expect = 'A';
		char actual = gradeChecker.checkGrade(95);
		assertEquals(expect, actual);
	}
	@Test
	public void testCheckGradeSecondGrade()
	{
		System.out.println("Inside testCheckGrade()..");
		char expect = 'B';
		char actual = gradeChecker.checkGrade(88);
		assertEquals(expect, actual);
	}
	@Test
	public void testCheckGradeThirdGrade()
	{
		System.out.println("Inside testCheckGrade()..");
		char expect = 'C';
		char actual = gradeChecker.checkGrade(60);
		assertEquals(expect, actual);
	}@Test
	public void testCheckGradeFail()
	{
		System.out.println("Inside testCheckGrade()..");
		char expect = 'F';
		char actual = gradeChecker.checkGrade(35);
		assertEquals(expect, actual);
	}
}
