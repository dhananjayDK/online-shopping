package com.dksofts.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dksofts.shoppingbackend.dao.CategotyDAO;
import com.dksofts.shoppingbackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	CategotyDAO categoryDAO;
	
	@RequestMapping({"/","/home","/index.html"})
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome",true);
		List<Category> categories = categoryDAO.list();
		mv.addObject("categories", categories);
		return mv;
	}
	
	@RequestMapping("/about")
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	
	@RequestMapping("/contact")
	public ModelAndView contact(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact",true);
		return mv;
	}
	
	@RequestMapping("/show/all/listOfProduct")
	public ModelAndView viewAllProduct(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Product");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProduct",true);
		return mv;
	}
	
	@RequestMapping("/show/category/{id}/Products")
	public ModelAndView viewCategoryProduct(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView("page");
		Category category = null;
		category = categoryDAO.get(id);
		mv.addObject("title", category.getName());
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProduct",true);
		return mv;
	}
}
