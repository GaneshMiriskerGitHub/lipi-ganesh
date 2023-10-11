package com.amazon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	

	@RequestMapping("/hello")
	public ModelAndView sayGreetings()
	{
		String msg="jsp is working";
		return new ModelAndView("WEB-INF/views/hello.jsp","helloms",msg);
	}

}
