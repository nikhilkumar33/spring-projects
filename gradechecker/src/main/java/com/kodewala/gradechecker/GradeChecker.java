package com.kodewala.gradechecker;

public class GradeChecker 
{
   public char checkGrade(int percentage)
   {
	   if(percentage >=90)
	   {
		   return 'A';
	   }
	   else if(percentage >=70 && percentage <90)
	   {
		   return 'B';
	   }
	   else if(percentage >=50 && percentage < 70)
	   {
		   return 'C';
	   }
	   else
	   {
		   return 'F';
	   }
   }
}
