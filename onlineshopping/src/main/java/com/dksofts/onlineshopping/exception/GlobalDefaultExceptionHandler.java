package com.dksofts.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException(){
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "The page is not constructed");
		
		mv.addObject("errordescription", "The page which you are looking for is not available");
		
		mv.addObject("title", "404 Error Page");
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException(){
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Product is not available");
		
		mv.addObject("errordescription", "The Product which you are looking for is not available right now");
		
		mv.addObject("title", "Product not Available");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex){
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Contact your Administration!!!");
		
		//only for debuging application
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		mv.addObject("errordescription", sw.toString());
		
		mv.addObject("title", "Error");
		return mv;
	}
}