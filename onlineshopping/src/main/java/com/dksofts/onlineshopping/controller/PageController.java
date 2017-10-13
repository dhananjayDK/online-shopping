package com.dksofts.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping({"/","home.html","index.html"})
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "Welcome to sring Web Mvc");
		return mv;
	}
}
