package com.kodewala.wordverifier;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ValidateWordTest 
{
	@Test
	public void testValidateWord()
	{
		ValidateWord validateWord = new ValidateWord();
		boolean expect = true;
		boolean actual = validateWord.validateWord("Nikhil");
		assertEquals(expect, actual);
	}
	@Test
	public void testValidateWordWithNull()
	{
		ValidateWord validateWord = new ValidateWord();
		boolean expect = false;
		boolean actual = validateWord.validateWord(null);
		assertEquals(expect, actual);
	}
	@Test
	public void testValidateWordWithEmpty()
	{
		ValidateWord validateWord = new ValidateWord();
		boolean expect = false;
		boolean actual = validateWord.validateWord("");
		assertEquals(expect, actual);
	}
	@Test
	public void testValidateWordWithSmallWord()
	{
		ValidateWord validateWord = new ValidateWord();
		boolean expect = false;
		boolean actual = validateWord.validateWord("Mo");
		assertEquals(expect, actual);
	}
	
	@Test
	public void testCalculateLength()
	{
		ValidateWord validateWord = new ValidateWord();
		int expect = 6;
		
		int actual = validateWord.calculateLength("Nikhil");
		assertEquals(expect, actual);
	}
	@Test
	public void testCalculateLengthWithEmpty()
	{
		ValidateWord validateWord = new ValidateWord();
		int expect = 0;
		
		int actual = validateWord.calculateLength("");
		assertEquals(expect, actual);
	}
	@Test
	public void testCalculateLengthWithSpace()
	{
		ValidateWord validateWord = new ValidateWord();
		int expect = 1;
		
		int actual = validateWord.calculateLength(" ");
		assertEquals(expect, actual);
	}
	@Test(expected = NullPointerException.class)
	public void testCalculateLengthWithNull()
	{
		ValidateWord validateWord = new ValidateWord();
		validateWord.calculateLength(null);
	}
}
