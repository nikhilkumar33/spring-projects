package com.kodewala.wordverifier;

public class ValidateWord
{
	public boolean validateWord(String word)
	{
		if(word==null || word.isEmpty() || word.length()<3)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public int calculateLength(String word)
	{
		return word.length();
	}
}
