package com.kodewala.register.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController 
{
	@RequestMapping("/register")
	public ModelAndView viewRegister()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("displayRegister");
		return modelAndView;
	}

}
