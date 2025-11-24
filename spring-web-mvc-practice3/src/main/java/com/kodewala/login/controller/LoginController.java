package com.kodewala.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController 
{
	public ModelAndView viewLoginPage()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("displayLogin");
		return mv;
	}
}
