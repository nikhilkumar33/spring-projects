package com.kodewala;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController
{
	@RequestMapping("/viewKodewala")
	public ModelAndView viewPage()
	{
		ModelAndView mv =new ModelAndView();
		mv.setViewName("displayKodewla");
		return mv;
	}

}
