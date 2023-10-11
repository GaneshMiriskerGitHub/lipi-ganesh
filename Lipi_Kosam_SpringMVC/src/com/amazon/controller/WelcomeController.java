package com.amazon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@RequestMapping("/")
	public ModelAndView sayGreetings()
	{
		String msg="Welcome JSP started";
		return new ModelAndView("WEB-INF/views/welcome.jsp","message",msg);
	}
	
}
